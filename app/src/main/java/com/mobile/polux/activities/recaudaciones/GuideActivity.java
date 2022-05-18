package com.mobile.polux.activities.recaudaciones;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.mobile.polux.R;
import com.mobile.polux.activities.AbstractActivity;
import com.mobile.polux.adapters.CashingAdapter;
import com.mobile.polux.app.App;
import com.mobile.polux.models.CashingGuideDetail;
import com.mobile.polux.models.GuideLiquidation;
import com.mobile.polux.models.InfoGuia;
import com.mobile.polux.models.Invoice;
import com.mobile.polux.models.LiquidationResponse;
import com.mobile.polux.models.Payment;
import com.mobile.polux.utils.Dialog;
import com.mobile.polux.utils.UtilDB;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.mobile.polux.activities.recaudaciones.CashingActivity.setPayments;

public class GuideActivity extends AbstractActivity {

    private ListView lvCashing;
    private CashingAdapter adapter;
    private TextView tvGuide;
    private TextView tvDate;
    private TextView tvTotalRecaudar;
    private TextView tvRecaudado;
    private TextView tvPendiente;

    private EditText etSearch;
    private Button btnSearch;

    public static int guideClientId;

    public static long guide;
    public String guideDate;
    public List<CashingGuideDetail> guideDetail;
    private Dialog dialogUtil;

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        getSupportActionBar().setTitle("Guía de cobro");

        if (realm == null || realm.isClosed()) {
            realm = Realm.getDefaultInstance();
        }

        bindUI();

        if (guideDetail == null || guideDetail.isEmpty()) {
            try {
                findGuide();
                setGuideView();
            } catch (Exception e) {
                System.out.println("Errror "+e);
            }
        }
    }

    private void bindUI() {
        dialogUtil = new Dialog();
        tvGuide = (TextView) findViewById(R.id.tv_guide);
        tvDate = (TextView) findViewById(R.id.tv_date);
        tvTotalRecaudar = (TextView) findViewById(R.id.tv_total_rc);
        tvRecaudado = (TextView) findViewById(R.id.tv_total_recaudado);
        tvPendiente = (TextView) findViewById(R.id.tv_total_pendiente);

        detalleRecaudacion();

        etSearch = (EditText) findViewById(R.id.et_search);
        btnSearch = (Button) findViewById(R.id.btn_search);
        //tvMessage = (TextView) findViewById(R.id.message);
        lvCashing = (ListView) findViewById(R.id.lv_cashing);
        lvCashing.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                guideClientId = guideDetail.get(position).getClientId();
                setPayments(null);
                CashingActivity.setNews(0);
                CashingRegisterActivity.setAsignados(0);
                goToViewCashing();
            }
        });
        registerForContextMenu(lvCashing);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });
    }

    private void setGuideView() {
        adapter = new CashingAdapter(this, R.layout.item_cashing, guideDetail);
        lvCashing.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        tvGuide.setText(""+guide);
        tvDate.setText(""+ guideDate );
    }

    private void detalleRecaudacion(){
        try {
            double recaudar = UtilDB.totalInvoiceDueByGuide(realm, guide);
            double recaudado =  UtilDB.totalCollectedByGuide(realm, guide);
            double pendiente = recaudar - recaudado;
            tvTotalRecaudar.setText("$ "+App.DECIMAL_FORMAT.format(recaudar));
            tvRecaudado.setText("$ "+App.DECIMAL_FORMAT.format(recaudado));
            tvPendiente.setText("$ "+App.DECIMAL_FORMAT.format(pendiente));
        }catch (Exception e){ showToast("Ocurrió un error al intentar obtener datos de recaudaciones");}

    }

    private String text;

    private void search(){
        if (!etSearch.getText().toString().isEmpty()) {

            text = etSearch.getText().toString();
            InfoGuia infoGuia = UtilDB.guideById(realm, guide);
            guideDetail = infoGuia.getDetails().where().contains("name", text, Case.INSENSITIVE).findAll();
            adapter = new CashingAdapter(this, R.layout.item_cashing, guideDetail);
            lvCashing.setAdapter(adapter);
            adapter.notifyDataSetChanged();


        } else  {
            text = "";
            findGuide();
        }

    }

    private void findGuide(){
        InfoGuia infoGuia = UtilDB.guideById(realm, guide);
        guideDate = infoGuia.getFechaIngreso();
        guideDetail = infoGuia.getDetails().where().findAllSorted("name", Sort.ASCENDING);
        adapter = new CashingAdapter(this, R.layout.item_cashing, guideDetail);
        lvCashing.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void removePayments(int clientId) {
        try {
            CashingGuideDetail cashingGuideDetail = UtilDB.guideById(realm, guide).getDetails().where().equalTo("clientId", clientId).findFirst();
            realm.beginTransaction();
            cashingGuideDetail.setState("PEN");
            cashingGuideDetail.setCollected(.0);
            cashingGuideDetail.setCredit(.0);

            for (Invoice iv : cashingGuideDetail.getDocXcobrar()) {
                iv.setPago(null);
                iv.setPay(0);
                iv.setState("PEN");
            }
            RealmResults<Payment> payments = realm.where(Payment.class).equalTo("guide", guide).equalTo("clientId", clientId).findAll();
            payments.deleteAllFromRealm();
            realm.commitTransaction();
            adapter.notifyDataSetChanged();
        } catch (Exception e) {
            try {
                realm.cancelTransaction();
            } catch (Exception e1) {
            }
        }
    }

    private void goToViewCashing() {
        Intent intent = new Intent(this, ViewCashingActivity.class);
        startActivity(intent);
    }

    private void callSendGuide() {
        try {
            GuideLiquidation liquidation = new GuideLiquidation();
            liquidation.setClients(new ArrayList<CashingGuideDetail>());

            for (CashingGuideDetail g : guideDetail) {
                liquidation.getClients().add(g.toUnManaged(realm));
            }
            List<Payment> payments = new ArrayList<>();
            RealmResults<Payment> pl = UtilDB.paymentsByGuide(realm, guide);
            for (Payment p : pl) {
                payments.add(p.toUnManaged(realm));
            }

            for(Payment p : payments){
                Log.e("METODO"," PAGO "+p.getBanco());
            }

            liquidation.setPayments(payments);
            liquidation.setCodigoEmpresa(App.companyCode);
            liquidation.setUsuarioIngreso(App.userCode);
            InfoGuia info = UtilDB.guideById(realm, guide);
            if (info != null) {
                liquidation.setGuiaCobro(info.toUnManaged(realm));
                liquidation.getGuiaCobro().setCodigo(liquidation.getGuiaCobro().getCodigoGuiasCobro());
                liquidation.getGuiaCobro().setNombreCompletoVendedor(info.getNombreCompletoVendedor());
            } else {
                showToast("No se encontró información de guías de cobro");
            }

            showProgressDialog("Sincronizando Cobros , por favor espere...");


            Call<LiquidationResponse> response = App.servicesOrder.liquidation(liquidation);
            response.enqueue(new Callback<LiquidationResponse>() {
                @Override
                public void onResponse(Call<LiquidationResponse> call, Response<LiquidationResponse> response) {
                    closeProgressDialog();

                    LiquidationResponse liquidationResponse = response.body();

                    if (liquidationResponse == null) {
                        Gson gson = new Gson();
                        TypeAdapter<LiquidationResponse> adapter = gson.getAdapter(LiquidationResponse.class);
                        try {
                            if (response.errorBody() != null)
                                liquidationResponse = adapter.fromJson(response.errorBody().string());
                        } catch (IOException e) {
                        }
                    }
                    if (liquidationResponse == null) {
                        showToast("Ocurrió un error, No se obtuvo respuesta del servicio liquidaciones");
                        return;
                    }

                    if ("OK".equals(liquidationResponse.getMensaje())) {
                        dialogUtil.showDialog("Transacción Exitosa",liquidationResponse.getResult(),GuideActivity.this);
                    } else {
                        dialogUtil.showDialog("Fallo el servicio liquidaciones", "Mensaje obtenido: " + liquidationResponse.getMensaje()
                                + "\ncausa: " + liquidationResponse.getCausa(), GuideActivity.this);
                    }
                }

                @Override
                public void onFailure(Call<LiquidationResponse> call, Throwable t) {
                    showToast("Fallo el servicio liquidaciones, problema para conectar con el servicio " + t);
                    closeProgressDialog();
                }
            });
        } catch (Exception e) {
            closeProgressDialog();
        }

    }

    private void prepareSummary(String title, String type){
        int cant = 0;
        int cantInv = 0;
        double totalD = 0;
        try {
            cant = guideDetail.size();
        } catch (Exception e) {
            cant = 0;
        }
        try {
            cantInv = UtilDB.countInvoiceByGuide(realm, guide);
        } catch (Exception e) {
            cantInv = 0;
        }

        totalD = UtilDB.totalInvoiceDueByGuide(realm, guide);

        //Activity activity; activity.getLayoutInflater()
        showDialogSummary(title, cant, cantInv, totalD, this, type);
    }

    public void showDialogSummary(String title, int cant, int cantInvoice, double total, Activity activity, String type){


        final View view = activity.getLayoutInflater().inflate(R.layout.summary_guide, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(GuideActivity.this).create();
        alertDialog.setTitle(title);
        alertDialog.setCancelable(false);

        //OrderClientActivity.client
        TextView tvCant = (TextView) view.findViewById(R.id.tv_cant);

        TextView tvCantInvoice = (TextView) view.findViewById(R.id.tv_cant_invoice);
        TextView tvTotal = (TextView) view.findViewById(R.id.tv_total);

        LinearLayout llCantClientC =  view.findViewById(R.id.ll_total);
        LinearLayout llCantRec =  view.findViewById(R.id.ll_total_c);

        tvCant.setText(""+cant);
        tvCantInvoice.setText(""+cantInvoice);
        tvTotal.setText("$ "+App.DECIMAL_FORMAT.format(total));

        if (!"R".equals(type)) {
            try {
                TextView tvTotalPending = (TextView) view.findViewById(R.id.tv_pending);
                TextView tvTotalCollected = (TextView) view.findViewById(R.id.tv_total_c);
                double recaudado =  UtilDB.totalCollectedByGuide(realm, guide);
                int count = UtilDB.countCollectedByGuide(realm, guide);
                int v = guideDetail.size() - count;
                tvTotalPending.setText("" + v);
                tvTotalCollected.setText("$ " + App.DECIMAL_FORMAT.format(recaudado));
            } catch (Exception e) {
            }
        } else {
            llCantClientC.setVisibility(View.GONE);
            llCantRec.setVisibility(View.GONE);
        }

        if ("F".equals(type)) {
            TextView tvF = (TextView) view.findViewById(R.id.tv_m_final);
            tvF.setVisibility(View.VISIBLE);
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "SI", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    callSendGuide();

                }
            });
            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    alertDialog.dismiss();

                }
            });

        } else {
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "ACEPTAR", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    alertDialog.dismiss();

                }
            });
        }

        alertDialog.setView(view);
        alertDialog.show();
    }

    private void showDialogConfirm(final int clientId) {
        android.support.v7.app.AlertDialog alertDialog = new android.support.v7.app.AlertDialog.Builder(GuideActivity.this).create();
        alertDialog.setTitle("Confirmar");

        alertDialog.setMessage("¿Esta seguro que desea anular los movimientos para este cliente?");


        alertDialog.setButton(android.support.v7.app.AlertDialog.BUTTON_POSITIVE, "SI",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        removePayments(clientId);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.guide, menu);
        menu.findItem(R.id.item_download).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            /*case R.id.item_download:
                if (guideDetail != null && !guideDetail.isEmpty()){
                    for (CashingGuideDetail g : guideDetail) {
                        if (g.getState() != null && !("PEN".equals(g.getState()))) {
                            showToast("No es posible descargar Guía de cobro, para descargar la guía, todos los movimientos deben ser anulados");
                            return true;
                        }
                    }
                }
                callGuide();
                return true;*/
            case R.id.item_send:
                prepareSummary("Resumen de Guía", "F");
                //callSendGuide();
                return true;
            case R.id.item_status:
                prepareSummary("Status de Guía", "S");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_guide, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.item_cancel:
                if (guideDetail.get(info.position) == null || "PEN".equals(guideDetail.get(info.position).getState())){
                    showToast("No se pueden anular los movimientos para este cliente");
                } else {
                    showDialogConfirm(guideDetail.get(info.position).getClientId());
                }

                //
                // removePayments();
                return true;
            /*case R.id.item_edit:
                //showDialogConfirm(orders.get(info.position), "E");
                return true;
            case R.id.item_delete:
                //showDialogConfirm(orders.get(info.position), "D");
                return true;*/
            default:
                return super.onContextItemSelected(item);
        }
    }

    /*@Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            realm.close();
        } catch (Exception e) {
        }
    }*/


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(GuideActivity.this,GuideListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}