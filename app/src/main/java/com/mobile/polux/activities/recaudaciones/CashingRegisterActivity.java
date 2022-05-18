package com.mobile.polux.activities.recaudaciones;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mobile.polux.R;
import com.mobile.polux.activities.MainActivity;
import com.mobile.polux.adapters.InvoiceAdapter;
import com.mobile.polux.app.App;
import com.mobile.polux.models.CashingGuideDetail;
import com.mobile.polux.models.InfoGuia;
import com.mobile.polux.models.Invoice;
import com.mobile.polux.models.Payment;
import com.mobile.polux.models.PaymentDoc;
import com.mobile.polux.utils.MoneyTextWatcher;
import com.mobile.polux.utils.UtilDB;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

import static com.mobile.polux.activities.recaudaciones.CashingActivity.getPayments;
import static com.mobile.polux.activities.recaudaciones.CashingActivity.setPayments;

public class CashingRegisterActivity extends AppCompatActivity {

    private TextView tvClient;
    private TextView tvTotal;
    private TextView tvSelect;
    private TextView tvCredit;
    private ListView lvInvoices;

    private InvoiceAdapter adapter;
    private List<Invoice> invoices;

    public static double credit;
    public static double collected;
    private double creditTotal;

    private static int asignados;

    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private CashingGuideDetail cashingGuideDetail;

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashing_register);

        getSupportActionBar().setTitle("Registro de cobro");

        try {
            if (realm == null || realm.isClosed()) {
                realm = Realm.getDefaultInstance();
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
            cashingGuideDetail = cashingGuideDetail.toUnManaged(realm);
            creditTotal = credit + cashingGuideDetail.getCredit();
            preparePayments();
        } catch (Exception e) {
        }
    }

    private void bindUI() {
        tvClient = (TextView) findViewById(R.id.tv_client);
        tvTotal = (TextView) findViewById(R.id.tv_total);
        tvCredit = (TextView) findViewById(R.id.tv_credit);
        tvCredit.setText("$ " + App.DECIMAL_FORMAT.format(creditTotal));
        tvSelect = (TextView) findViewById(R.id.tv_select);
        lvInvoices = (ListView) findViewById(R.id.lv_invoices);
        lvInvoices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showDialogPaymentInvoice(position, invoices.get(position).getCodigoComprobante(), invoices.get(position).getDue());
            }
        });

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        params.setMargins(0, 0, 0, 0);
        lvInvoices.setLayoutParams(params);
        tvSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogInvoice();
            }
        });

        tvClient.setText(cashingGuideDetail.getClientId() + " - " + cashingGuideDetail.getName());
        tvTotal.setText("$ " + App.DECIMAL_FORMAT.format(cashingGuideDetail.getTotalDue()));

        if (invoices == null) {
            invoices = cashingGuideDetail.getDocXcobrar();
        }

        if (invoices == null) {
            invoices = new ArrayList<>();
        }

        adapter = new InvoiceAdapter(this, R.layout.item_invoice, invoices);
        lvInvoices.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_check, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.check:

                save();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void save() {
        try {
            if (CashingActivity.getNews()>0 && getAsignados()==0) {
                showToast("No has asignado los cobros a ninguna factura, selecciona una factura para realizar el pago");
                return;
            }
            if(creditTotal > 0){
                showToast("Asigna todos los credítos para poder avanzar");
                return;
            }
            cashingGuideDetail.setState("REC");
            if (!realm.isInTransaction()) {
                realm.beginTransaction();
            }

            cashingGuideDetail.setCredit(creditTotal);
            cashingGuideDetail.setCollected(collected);
            realm.copyToRealmOrUpdate(cashingGuideDetail);
            realm.commitTransaction();
            savePayments();
            //goToCashings();
            showToast("Se registraron los pagos con éxito");
        } catch (Exception e) {
            try {
                realm.cancelTransaction();
            } catch (Exception e1) {}
        }

    }

    private void preparePayments(){
        Number currentIdNum = realm.where(Payment.class).max("codigo");
        int nextId;
        if (currentIdNum == null) {
            nextId = 1;
        } else {
            nextId = currentIdNum.intValue() + 1;
        }
        for (Payment p : getPayments()) {
            if (p.getCodigo() == null) {
                p.setCodigo(nextId);
                nextId ++;
            }
        }
    }

    private void savePayments() {
        try {

            realm.beginTransaction();
            RealmResults<Payment> pl = UtilDB.paymentsByClientId(realm, GuideActivity.guide, GuideActivity.guideClientId);
            pl.deleteAllFromRealm();
            for (Payment p : getPayments()) {
                //  p.setId(nextId);
                realm.copyToRealmOrUpdate(p);
                //nextId++;
            }
            realm.commitTransaction();
            goToCashings();
            creditTotal = 0;
            credit = 0;
        } catch (Exception e) {
        }
    }


    private void goToCashings() {
        Intent intent = new Intent(this, GuideActivity.class);
        //intent.putExtra("client", client);
        setPayments(null);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private Invoice invoice;

    private void showDialogInvoice() {

        final View view = getLayoutInflater().inflate(R.layout.invoice_info, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(CashingRegisterActivity.this).create();
        alertDialog.setTitle("Buscar Factura");
        alertDialog.setCancelable(false);

        final EditText etInvoice = (EditText) view.findViewById(R.id.et_invoice);
        Button btSearch = (Button) view.findViewById(R.id.btn_search);

        final TextView tvClient = (TextView) view.findViewById(R.id.tv_client);
        final TextView tvTotal = (TextView) view.findViewById(R.id.tv_total);

        final LinearLayout llInfo = (LinearLayout) view.findViewById(R.id.ll_info);
        llInfo.setVisibility(View.GONE);
        invoice = null;
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etInvoice.getText().toString().isEmpty()) {
                    invoice = new Invoice();
                    invoice.setCodigoComprobante(etInvoice.getText().toString());
                    tvClient.setText("Messi");
                    invoice.setTotal(150.00);
                    invoice.setDue(150.00);
                    tvTotal.setText("$ " + invoice.getTotal());
                    llInfo.setVisibility(View.VISIBLE);

                } else {
                    llInfo.setVisibility(View.GONE);
                    showToast("Ingresa el número de factura");
                }
            }
        });

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "ACEPTAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (invoice != null) {
                    invoices.add(invoice);
                }
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

    private void showDialogPaymentInvoice(final int position, final String invoice, final double due) {

        final View view = getLayoutInflater().inflate(R.layout.invoice_payment, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(CashingRegisterActivity.this)
                .setTitle("Pago de factura")
                .setCancelable(false)
                .setPositiveButton("ACEPTAR", null)
                .setNegativeButton("CANCELAR", null)
                .setView(view)
                .show();

        final EditText etPayment = (EditText) view.findViewById(R.id.et_payment);
        final TextView tvInvoice = (TextView) view.findViewById(R.id.tv_invoice);
        final TextView tvValue = (TextView) view.findViewById(R.id.tv_value);
        final TextView tvBalance = (TextView) view.findViewById(R.id.tv_balance);
        final TextView tvCredit = (TextView) view.findViewById(R.id.tv_credit);

        double add = 0;
        if (invoices.get(position).getPay() != 0) {
            add = invoices.get(position).getPay();
        }

        final double creditPay = creditTotal+add;
        tvCredit.setText("$ " + App.DECIMAL_FORMAT.format(creditPay));

        tvInvoice.setText(invoice);
        tvValue.setText("$ " + App.DECIMAL_FORMAT.format(due));

        if (creditPay <= due) {
            etPayment.setText("$"+ App.DECIMAL_FORMAT.format(creditPay));
            tvBalance.setText("$ " + App.DECIMAL_FORMAT.format(due - creditPay));
        } else {
            etPayment.setText("$" + App.DECIMAL_FORMAT.format(due));
            tvBalance.setText("$ 0,00");
        }
        etPayment.addTextChangedListener(new MoneyTextWatcher(etPayment));

        Button possitive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        possitive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double pay = 0;
                String day = dateFormat.format(new Date());
                try {
                    String _value = etPayment.getText().toString();

                    String cleanString = _value.replaceAll("[$,.]", "");
                    BigDecimal parsed = new BigDecimal(cleanString).setScale(2, BigDecimal.ROUND_FLOOR).divide(new BigDecimal(100), BigDecimal.ROUND_FLOOR);

                    pay = parsed.doubleValue();

                    if (pay <= 0) {
                        showToast("Ingresa el monto que deseas abonar");
                        return;
                    }
                } catch (Exception e) {
                    showToast("Ingresa el monto que deseas abonar");
                    return;
                }
                if (pay > redondearDecimales(creditPay)) {
                    showToast(" Créditos insuficientes ");
                    return;
                }
                if (pay > due) {
                    showToast("El monto que intenta abonar es mayor al valor de la factura");
                    return;
                }
                double payC = pay;
                double payInvoice = 0;
                if (invoices.get(position).getPago() != null) {
                    for (PaymentDoc doc : invoices.get(position).getPago()) {
                        for (Payment payment : getPayments()) {
                            if (doc.getId() == payment.getCodigo()) {
                                payment.setResiduary(payment.getResiduary() + doc.getValue());
                            }
                        }
                    }
                }

                RealmList<PaymentDoc> paymentsDoc = new RealmList<PaymentDoc>();
                PaymentDoc payDoc = new PaymentDoc();
                for (Payment payment : getPayments()) {
                    if (payment.getResiduary() > 0) {

                        if (payment.getResiduary()>= payC) {
                            payInvoice = payC;
                            payment.setResiduary(payment.getResiduary() - payC);
                            payC = payC - payInvoice;
                            payDoc = new PaymentDoc();
                            payDoc.setId(payment.getCodigo());
                            payDoc.setValue(payInvoice);
                            payDoc.setDate(day);
                            payDoc.setTipo(payment.getTipo());
                            if(payment.getTipo().equalsIgnoreCase("C")){
                                payDoc.setNumCuenta(payment.getNumCuenta());
                                payDoc.setBanco(payment.getBanco());
                            }
                        } else {
                            payInvoice = payment.getResiduary();
                            payment.setResiduary(0);
                            payC = payC - payInvoice;
                            payDoc = new PaymentDoc();
                            payDoc.setId(payment.getCodigo());
                            payDoc.setValue(payInvoice);
                            payDoc.setDate(day);
                            payDoc.setTipo(payment.getTipo());
                            if(payment.getTipo().equalsIgnoreCase("C")){
                                payDoc.setNumCuenta(payment.getNumCuenta());
                                payDoc.setBanco(payment.getBanco());
                            }
                        }

                        paymentsDoc.add(payDoc);
                    }
                    if (payC == 0) {
                        break;
                    }
                }


              //  invoices.get(position).setPay(pay);
                invoices.get(position).setPago(paymentsDoc);
                adapter.notifyDataSetChanged();
                creditTotal = creditPay - pay;
                updateCredit();
                asignados++;
                alertDialog.dismiss();
            }
        });

    }

    private void updateCredit() {
        tvCredit.setText("$ " + App.DECIMAL_FORMAT.format(creditTotal));
    }

    public static int getAsignados() {
        return asignados;
    }

    public static void setAsignados(int asignados) {
        CashingRegisterActivity.asignados = asignados;
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    private Double redondearDecimales(Double douValorDecimal)
    {
        BigDecimal objBigDecimal = new BigDecimal(String.valueOf(douValorDecimal));
        BigDecimal objBigDecimalRedondeado = objBigDecimal.setScale(2, RoundingMode.HALF_UP);
        return objBigDecimalRedondeado.doubleValue();
    }



   /* @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            realm.close();
            Intent intent = new Intent(this,GuideActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        realm.close();
        Intent intent = new Intent(this,GuideActivity.class);
        startActivity(intent);
        finish();
    } */
}
