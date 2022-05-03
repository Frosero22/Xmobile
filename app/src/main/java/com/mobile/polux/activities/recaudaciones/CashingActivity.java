package com.mobile.polux.activities.recaudaciones;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mobile.polux.R;
import com.mobile.polux.adapters.PaymentAdapter;
import com.mobile.polux.app.App;
import com.mobile.polux.models.Bank;
import com.mobile.polux.models.CashingGuideDetail;
import com.mobile.polux.models.InfoGuia;
import com.mobile.polux.models.Payment;
import com.mobile.polux.utils.MoneyTextWatcher;
import com.mobile.polux.utils.UtilDB;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class CashingActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvClient;
    private TextView tvTotal;

    private static List<Payment> payments;
    private static int news;
    private PaymentAdapter adapter;
    private ListView lvCollections;

    private Button btnAddPayment;
    private Button btnSave;

    private ArrayAdapter arrayAdapter;

    private EditText etDate;

    private CashingGuideDetail cashingGuideDetail;

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashing);

        getSupportActionBar().setTitle("Registro de Cobro");

        try {
            if (realm == null || realm.isClosed()) {
                realm = Realm.getDefaultInstance();
            }

            if (payments == null) {
                findPayments();
            }

            if (payments == null) {
                payments = new ArrayList<>();
            }

            if (cashingGuideDetail == null) {
                findCashingGuide();
            }

            bindUI();
        } catch (Exception e) {
        }
    }

    private void findCashingGuide() {
        try {
            cashingGuideDetail = realm.where(InfoGuia.class).equalTo("codigoGuiasCobro", GuideActivity.guide).findFirst().getDetails()
                    .where().equalTo("clientId", GuideActivity.guideClientId).findFirst();
            realm.close();
        } catch (Exception e) {
        }
    }

    private void findPayments() {
        try {
            payments = new ArrayList<>();
            RealmResults<Payment> pl = UtilDB.paymentsByClientId(realm, GuideActivity.guide, GuideActivity.guideClientId);
            for (Payment p : pl) {
                payments.add(p.toUnManaged(realm));
            }
        } catch (Exception e) {}
    }

    private void initArray() {
        banks = UtilDB.banks(realm);
        spinnerArrayBanks = new Bank[banks.size()+1];
        spinnerArrayBanks[0] = new Bank(0, " - Selecciona - ");
        for (int i = 1; i <= banks.size(); i++) {
            spinnerArrayBanks[i] = banks.get(i-1);
        }
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayBanks);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

    private void bindUI() {

        banks = new ArrayList<>();
        initArray();
        tvClient = (TextView) findViewById(R.id.tv_client);
        tvTotal = (TextView) findViewById(R.id.tv_total);
        tvClient.setText(cashingGuideDetail.getClientId() + " - " + cashingGuideDetail.getName());
        tvTotal.setText("$ " + App.DECIMAL_FORMAT.format(cashingGuideDetail.getTotalDue()));
        lvCollections = (ListView) findViewById(R.id.lv_collections);
        registerForContextMenu(lvCollections);

        btnAddPayment = (Button) findViewById(R.id.btn_add);
        btnAddPayment.setOnClickListener(this);

        btnSave = (Button) findViewById(R.id.btn_save);
        btnSave.setOnClickListener(this);

        adapter = new PaymentAdapter(CashingActivity.this, R.layout.item_payment, payments);
        lvCollections.setAdapter(adapter);


    }

    public static List<Payment> getPayments() {
        return payments;
    }

    public static void setPayments(List<Payment> payments) {
        CashingActivity.payments = payments;
    }

    public static void setNews(int news) {
        CashingActivity.news = news;
    }

    public static int getNews(){
        return news;
    }

    private void goToCashings() {
        Intent intent = new Intent(this, GuideActivity.class);
        startActivity(intent);
    }

    private void goToCashingRegister() {
        Intent intent = new Intent(this, CashingRegisterActivity.class);
        startActivity(intent);
    }

    private Bank[] spinnerArrayBanks;
    private List<Bank> banks;

    private void showDialogPayment(final boolean edit, final int position) {

        final View view = getLayoutInflater().inflate(R.layout.payment, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(CashingActivity.this)
                .setTitle("Cobro")
                .setCancelable(false)
                .setPositiveButton("ACEPTAR", null)
                .setNegativeButton("CANCELAR", null)
                .setView(view)
                .show();
        alertDialog.setTitle("Cobro");
        alertDialog.setCancelable(false);

        final EditText etValue = (EditText) view.findViewById(R.id.et_value);
        final RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.rb_group);

        final LinearLayout llInfoCheque = (LinearLayout) view.findViewById(R.id.ll_info_cheque);
        etDate = view.findViewById(R.id.et_date_ini);
        etDate.setText(App.DATE_FORMAT.format(new Date()));
        etDate.setOnClickListener(CashingActivity.this);
        final EditText etCheque = (EditText) view.findViewById(R.id.et_num_cheque);
        final EditText etDate = (EditText) view.findViewById(R.id.et_date_ini);

        etValue.addTextChangedListener(new MoneyTextWatcher(etValue));

        final Spinner spinner = view.findViewById(R.id.sp_bank);

        spinner.setAdapter(arrayAdapter);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.cash) {
                    llInfoCheque.setVisibility(View.GONE);
                } else if (checkedId == R.id.check) {
                    llInfoCheque.setVisibility(View.VISIBLE);
                }
            }

        });

        etValue.setText("0");
        if (edit) {
            Payment payment = payments.get(position);
            if (payment.getCodigo() != null && UtilDB.countPayment(realm, payment.getCodigo())>0) {
                showToast("Este cobro no se puede editar");
                alertDialog.dismiss();
                return;
            }
            try {
                etValue.setText("" +App.DECIMAL_FORMAT.format(payment.getValor()));
            }catch (Exception e){etValue.setText("0");}
            if ("E".equals(payment.getTipo())) {
                radioGroup.check(R.id.cash);
            } else {
                etCheque.setText(payment.getNumCuenta());
                radioGroup.check(R.id.check);
                etDate.setText(payment.getFecha());
                int positionB = 0;
                for (int i = 1; i < spinnerArrayBanks.length; i++) {
                    if (spinnerArrayBanks[i].getId() == payment.getBanco()) {
                        positionB = i;
                    }
                }
                spinner.setSelection(positionB);
            }

        }
        Button possitive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        possitive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                String type = "";

                if (selectedId == R.id.cash) {
                    type = "E";
                } else if (selectedId == R.id.check) {
                    type = "C";
                } else {
                    showToast("Selecciona el tipo de cobro");
                    return;
                }

                double value = 0;
                try {

                    String _value = etValue.getText().toString();

                    String cleanString = _value.replaceAll("[$,.]", "");
                    BigDecimal parsed = new BigDecimal(cleanString).setScale(2, BigDecimal.ROUND_FLOOR).divide(new BigDecimal(100), BigDecimal.ROUND_FLOOR);

                    value = parsed.doubleValue();

                    if(value > cashingGuideDetail.getTotalDue()){
                        showToast("El valor no puede ser mayor a la deuda total");
                        return;
                    }

                    if(payments != null && payments.size() >= 1 && payments.get(position) != null){

                        double dou = 0.0;

                        if(edit){
                            payments.get(position).setValor(0.00);
                        }

                        for(Payment payment : payments){
                            if(String.valueOf(payment.getValor()) != null || payment.getValor() > 0){
                                dou = dou + payment.getValor();
                            }
                        }

                        dou = dou + value;

                        if(dou > cashingGuideDetail.getTotalDue()){
                            showToast("El valor no puede ser mayor a la deuda total");
                            return;
                        }
                    }

                    if (value <= 0) {
                        showToast("Ingresa el monto");
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    showToast("Ingresa el monto");
                    return;
                }
                Payment payment;
                if (edit) {
                    payment = payments.get(position);
                    payment.setTipo(type);
                    payment.setValor(value);
                    payment.setResiduary(value);
                } else {
                    payment = new Payment(type, value);
                    payment.setGuide(GuideActivity.guide);
                    payment.setClientId(GuideActivity.guideClientId);
                }

                if ("C".equals(type)) {
                    Bank bank = (Bank) spinner.getSelectedItem();
                    if (bank.getId() == 0 ) {
                        showToast("Selecciona el banco");
                        return;
                    }
                    payment.setBanco(bank.getId());

                    Log.e("BANCO","BANCO ESCOGIDO "+payment.getBanco());

                    if (etCheque.getText() != null && etCheque.getText().toString() != null && !etCheque.getText().toString().isEmpty()) {
                        payment.setNumCuenta(etCheque.getText().toString());
                    } else {
                        showToast("Ingresa el número del Cheque");
                        return;
                    }
                    payment.setFecha(etDate.getText().toString());
                }
                if (!edit) {
                    payments.add(payment);
                }
                news ++;
                alertDialog.dismiss();
                adapter.notifyDataSetChanged();
            }
        });

    }

    private void showDialogSave() {

        final View view = getLayoutInflater().inflate(R.layout.save_payments, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(CashingActivity.this).create();
        alertDialog.setTitle("Guardar");
        alertDialog.setCancelable(false);

        //final EditText etComment = (EditText) view.findViewById(R.id.tv_comment);
        double cash = 0;
        double cheque = 0;
        double value = 0;
        for (Payment p : payments) {

            if ("E".equals(p.getTipo())) {
                cash += p.getValor();
                //value += p.getResiduary();
            } else {
                cheque += p.getValor();
                //value += p.getResiduary();
            }
            if (p.getCodigo() == null || UtilDB.countPayment(realm, p.getCodigo()) == 0) {
                value += p.getValor();
            }
        }

        final TextView tvCash = (TextView) view.findViewById(R.id.tv_cash);
        final TextView tvCheque = (TextView) view.findViewById(R.id.tv_cheque);
        final TextView tvTotal = (TextView) view.findViewById(R.id.tv_total);


        CashingRegisterActivity.credit = value;
        CashingRegisterActivity.collected  = cash + cheque;

        tvCash.setText("$ " + App.DECIMAL_FORMAT.format(cash));
        tvCheque.setText("$ " + App.DECIMAL_FORMAT.format(cheque));
        tvTotal.setText("$ " + App.DECIMAL_FORMAT.format(cash + cheque));


        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "ACEPTAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //goToCashings();
                goToCashingRegister();
            }
        });

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "CANCELAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });

        alertDialog.setView(view);
        alertDialog.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.simple, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.item_edit:
                showDialogPayment(true, info.position);
                return true;
            /*case R.id.item_delete:
                payments.remove(info.position);
                adapter.notifyDataSetChanged();
                return true;*/
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                showDialogPayment(false, 0);
                break;
            case R.id.btn_save:
                showDialogSave();
                break;
            case R.id.et_date_ini:
                showDialogDate(true, "" + etDate.getText());

                break;
            case R.id.et_date_end:
                //showDialogDate(false, "" + etDateEnd.getText());
                break;
        }
    }

    private void showDialogDate(final boolean isDateIni, String date) {
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
                            etDate.setText(day + "/" + month + "/" + selectedYear);
                        } else {
                            //etDateEnd.setText(day + "/" + month + "/" + selectedYear);
                        }
                    }
                };
        DatePickerDialog d = new DatePickerDialog(this, datePickerListener, year, month, day);
        d.show();
    }



    private void showToast(String message) {
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }

   /*  @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            realm.close();
            Intent intent = new Intent(this,GuideListActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        realm.close();
        Intent intent = new Intent(this,GuideListActivity.class);
        startActivity(intent);
        finish();
    } */
}