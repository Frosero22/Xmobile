package com.mobile.polux.activities.recaudaciones;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;


import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.mobile.polux.R;
import com.mobile.polux.activities.AbstractActivity;
import com.mobile.polux.activities.MainActivity;
import com.mobile.polux.adapters.GuideAdapter;
import com.mobile.polux.app.App;
import com.mobile.polux.models.CashingGuideDetail;
import com.mobile.polux.models.DetalleCobro;
import com.mobile.polux.models.GuiaDeCobro;
import com.mobile.polux.models.GuideResponse;
import com.mobile.polux.models.InfoGuia;
import com.mobile.polux.models.Invoice;
import com.mobile.polux.utils.Dialog;
import com.mobile.polux.utils.UtilDB;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GuideListActivity extends AbstractActivity implements View.OnClickListener {

    private Dialog dialogUtil;

    private ListView lvGuides;

    private Realm realm;

    private RealmResults<InfoGuia> guides;

    private GuideAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_list);

        getSupportActionBar().setTitle("Guías de cobro");

        bindUI();
    }

    private void bindUI() {
        if (realm == null || realm.isClosed()) {
            realm = Realm.getDefaultInstance();
        }
        dialogUtil = new Dialog();

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR, -7);
        ini = c.getTime();
        end = new Date();

        lvGuides = (ListView) findViewById(R.id.lv_guides);

        findGuides();

        setGuidesView();

        lvGuides.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GuideActivity.guide = guides.get(position).getCodigoGuiasCobro();
                goToGuideActivity();
            }
        });
    }

    private void goToGuideActivity(){
        Intent intent = new Intent(this, GuideActivity.class);
        startActivity(intent);
    }

    private void findGuides(){
        if (guides == null || guides.isEmpty()) {
            guides = UtilDB.guides(realm);
        }
    }

    private void setGuidesView() {
        adapter = new GuideAdapter(this, R.layout.item_guide, guides);
        lvGuides.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.guide, menu);
        menu.findItem(R.id.item_status).setVisible(false);
        menu.findItem(R.id.item_send).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_download:
                long c = UtilDB.guidesCount(realm);
                if (c > 0){
                    showDialogConfirm();
                } else {
                    deleteGuide();
                    showDialogDate();
                }
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void deleteGuide(){
        UtilDB.deleteGuides(realm);
        adapter.notifyDataSetChanged();
    }


    List<CashingGuideDetail> guideDetail;

    private void buildGuide(GuideResponse guideResponse) {

        for (GuiaDeCobro guide : guideResponse.getGuiasDeCobros()) {
            guideDetail = new ArrayList<>();
            if (guide.getDetalleCobros() != null) {
                documentsGuide(guide.getDetalleCobros(), guide.getGuiaDeCobro().getFechaIngreso(), guide.getGuiaDeCobro().getCodigoGuiasCobro());
            }

            saveGuideInfo(guide.getGuiaDeCobro(), guideDetail);
        }

        /*if (guideResponse.getDocPaymentClient() != null) {
            documentsGuide(guideResponse.getDocPaymentClient(), date);
        }*/

        findGuides();
        setGuidesView();
    }

    private void documentsGuide(List<DetalleCobro> details, String date, long guide ) {
        CashingGuideDetail cashingGuideDetail;
        Invoice invoice;
        for (DetalleCobro detail : details) {
            cashingGuideDetail = existGuideClient(detail.getClientId());
            if (cashingGuideDetail == null) {
                cashingGuideDetail = new CashingGuideDetail(
                        detail.getClientId(), detail.getNombreCliente(),
                        detail.getAddress(), "PEN", 0.0,
                        detail.getTotalDoc() - detail.getTotalCanceled(),
                        detail.getDue()
                );
                cashingGuideDetail.setDate(date);
                cashingGuideDetail.setId(App.guideDetailId.incrementAndGet());
                guideDetail.add(cashingGuideDetail);
            } else {
                cashingGuideDetail.setTotalDue(cashingGuideDetail.getTotalDue() + detail.getDue());
            }

            invoice = new Invoice(detail.getSeqDoc(), detail.getDocId(), detail.getTotalDoc(), detail.getDue(), "PEN", stringDate(detail.getDate()), detail.getProducts());
            invoice.setPk(App.invoiceId.incrementAndGet());
            invoice.setGuide(guide);
            invoice.setFechaVencimiento(stringDate(detail.getDatePay(), 10));
            invoice.setOrder(detail.getOrder());
            invoice.setIva(detail.getIva());
            invoice.setDiscount(detail.getDiscount());
            invoice.setSubTotal(detail.getSubtotal());
            cashingGuideDetail.getDocXcobrar().add(invoice);
        }
    }

    private String stringDate(String date){
        if (date == null || date.trim().isEmpty()) {
            return date;
        } else if (date.length()>15){
            return date.substring(0, 16);
        } else {
            return date;
        }
    }

    private String stringDate(String date, int size){
        if (date == null || date.trim().isEmpty()) {
            return date;
        } else if (date.length()>=size){
            return date.substring(0, size);
        } else {
            return date;
        }
    }

    private void saveGuideInfo(InfoGuia info, List<CashingGuideDetail> details) {
        //Realm realm = Realm.getDefaultInstance();
        try {
            if (!realm.isInTransaction()) {
                realm.beginTransaction();
            }
            info.setCodigoPersonal(App.userSequence);
            info.setFechaIngreso(stringDate(info.getFechaIngreso()));
            info.setDetails(new RealmList<CashingGuideDetail>());
            info.getDetails().addAll(details);

            realm.copyToRealmOrUpdate(info);
            realm.commitTransaction();
        } catch (Exception e) {
            try {
                realm.cancelTransaction();
            } catch (Exception e1) {
            }
        }
    }

    private CashingGuideDetail existGuideClient(int clientId) {
        for (int i = 0; i < guideDetail.size(); i++) {
            if (guideDetail.get(i).getClientId() == clientId) {
                return guideDetail.get(i);
            }
        }
        return null;
    }

    private void callGuide(String ini, String end) {

        showProgressDialog("Descargando guías de cobro, por favor espere...");

        Call<GuideResponse> response = App.services.guide(App.companyCode, App.subCompanyCode, App.getValueOfPreferencesUser(App.KEY_USER_SEQUENCE, 0), ini , end, "", "");

        try {
            response.enqueue(new Callback<GuideResponse>() {
                @Override
                public void onResponse(Call<GuideResponse> call, Response<GuideResponse> response) {
                    closeProgressDialog();

                    GuideResponse guideResponse = response.body();

                    if (guideResponse == null) {
                        Gson gson = new Gson();
                        TypeAdapter<GuideResponse> adapter = gson.getAdapter(GuideResponse.class);
                        try {
                            if (response.errorBody() != null)
                                guideResponse = adapter.fromJson(response.errorBody().string());
                        } catch (IOException e) {
                        }
                    }
                    if (guideResponse == null) {
                        showToast("Ocurrió un error, No se obtuvo respuesta del servicio para descargar guía de cobro");
                        return;
                    }

                    if ("OK".equals(guideResponse.getMessage())) {
                        buildGuide(guideResponse);
                    } else {
                        dialogUtil.showDialog("Aviso", guideResponse.getMessage()
                                + "" , GuideListActivity.this);
                    }
                }

                @Override
                public void onFailure(Call<GuideResponse> call, Throwable t) {
                    showToast("Fallo el servicio para la descarga de guía de cobro, problema para conectar con el servicio");
                    closeProgressDialog();
                }
            });
        } catch (Exception e) {
            closeProgressDialog();
        }
    }

    private Date ini;
    private Date end;

    private EditText etDateIni;
    private EditText etDateEnd;

    private void showDialogDate() {

        final View view = getLayoutInflater().inflate(R.layout.conten_search, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(GuideListActivity.this).create();
        alertDialog.setTitle("Nueva búsqueda");
        alertDialog.setCancelable(false);

        etDateIni = (EditText) view.findViewById(R.id.et_date_ini);
        etDateEnd = (EditText) view.findViewById(R.id.et_date_end);

        etDateIni.setText(App.DATE_FORMAT.format(ini));
        etDateEnd.setText(App.DATE_FORMAT.format(end));

        etDateIni.setOnClickListener(GuideListActivity.this);
        etDateEnd.setOnClickListener(GuideListActivity.this);

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();

                try {
                    //ini = dateFormatView.parse(etDateIni.getText().toString());
                    //end = dateFormatView.parse(etDateEnd.getText().toString());
                    callGuide(
                            etDateIni.getText().toString(),
                            etDateEnd.getText().toString()
                    );
                } catch (Exception e) {
                }
            }
        });

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });


        alertDialog.setView(view);
        alertDialog.show();
    }

    private void showDialogSelectDate(final boolean isDateIni, String date) {
        int month, day, year;
        if (date.isEmpty()) {
            day = 1;
            month = 1;
            year = 2018;
        } else {
            day = Integer.valueOf(date.substring(0, 2));
            month = Integer.valueOf(date.substring(3, 5));
            year = Integer.valueOf(date.substring(6, 10));
            month--;
        }

        DatePickerDialog.OnDateSetListener datePickerListener =
                new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                        selectedMonth++;
                        String month = selectedMonth < 10 ? "0" + selectedMonth : "" + selectedMonth;
                        String day = selectedDay < 10 ? "0" + selectedDay : "" + selectedDay;

                        if (isDateIni) {
                            etDateIni.setText(day + "/" + month + "/" + selectedYear);
                        } else {
                            etDateEnd.setText(day + "/" + month + "/" + selectedYear);
                        }
                    }
                };
        DatePickerDialog d = new DatePickerDialog(GuideListActivity.this, datePickerListener, year, month, day);
        d.show();
    }

    private void showDialogConfirm() {
        android.support.v7.app.AlertDialog alertDialog = new android.support.v7.app.AlertDialog.Builder(GuideListActivity.this).create();
        alertDialog.setTitle("Confirmar");
        alertDialog.setMessage("Al descargar una nueva guía perderás todos los datos de guías no enviadas. ¿Deseas continuar?");
        alertDialog.setButton(android.support.v7.app.AlertDialog.BUTTON_POSITIVE, "SI",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        deleteGuide();
                        showDialogDate();
                    }
                });
        alertDialog.setButton(android.support.v7.app.AlertDialog.BUTTON_NEGATIVE, "NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.et_date_ini:
                showDialogSelectDate(true, "" + etDateIni.getText());
                break;
            case R.id.et_date_end:
                showDialogSelectDate(false, "" + etDateEnd.getText());
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(GuideListActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }

   /* @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            realm.close();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        realm.close();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }*/
}
