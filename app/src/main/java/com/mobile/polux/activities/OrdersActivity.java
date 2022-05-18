package com.mobile.polux.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.mobile.polux.R;
import com.mobile.polux.adapters.OrderAdapter;
import com.mobile.polux.app.App;
import com.mobile.polux.fragments.FullScreenDialog;
import com.mobile.polux.models.GetOrderResponse;
import com.mobile.polux.models.Order;
import com.mobile.polux.models.OrderResponse;
import com.mobile.polux.models.OrdersResponse;
import com.mobile.polux.models.Product;
import com.mobile.polux.models.ProductOrder;
import com.mobile.polux.utils.Dialog;
import com.mobile.polux.utils.Synchronize;
import com.mobile.polux.utils.Util;
import com.mobile.polux.utils.UtilDB;

import org.w3c.dom.Text;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmList;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrdersActivity extends AppCompatActivity implements RealmChangeListener<RealmResults<Order>> {

    FloatingActionButton fBtnNewOrder;

    private Realm realm;

    private RealmResults<Order> orders;
    private ListView lvOrders;
    private OrderAdapter adapter;

    private Util util;
    private View mProgressView;
    private int shortAnimTime;

    private Order order;

    private TextView tvTotalCount;
    private TextView tvTotal;
    private TextView tvApprovedCount;
    private TextView tvApproved;
    private TextView tvRetainedCount;
    private TextView tvRetained;


    private final DecimalFormat df = new DecimalFormat("####,###,##0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        getSupportActionBar().setTitle("Pedidos");

        if (realm == null || realm.isClosed()) {
            realm = Realm.getDefaultInstance();
        }

        mProgressView = findViewById(R.id.progress);
        if (util == null) {
            util = new Util();
        }
        shortAnimTime = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
        }

        bindUI();

        callOrdersDB();
    }

    private void bindUI() {

        lvOrders = (ListView) findViewById(R.id.lv_orders);
        tvTotalCount = (TextView) findViewById(R.id.tv_total_count);
        tvTotal = (TextView) findViewById(R.id.tv_total);
        tvApprovedCount = (TextView) findViewById(R.id.tv_approved_count);
        tvApproved = (TextView) findViewById(R.id.tv_approved);
        tvRetainedCount = (TextView) findViewById(R.id.tv_retained_count);
        tvRetained = (TextView) findViewById(R.id.tv_retained);
        registerForContextMenu(lvOrders);
        fBtnNewOrder = (FloatingActionButton) findViewById(R.id.fb_new_order);
        fBtnNewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToOrderClient();
            }
        });
    }

    private void goToOrderClient() {
        Intent intent = new Intent(this, OrderClientActivity.class);
        OrderProductsActivity.initialize();
        OrderClientActivity.account = null;
        OrderClientActivity.client = null;
        OrderClientActivity.codigoLocalidad = -1;
        OrderProductsActivity.isEdit = false;
        OrderProductsActivity.isOff = false;
        startActivity(intent);
    }

    private void goToNewOrders(int clientId, int accountId, Integer codigoLocalidad) {
        Intent intent = new Intent(this, OrderClientActivity.class);
        intent.putExtra("id", clientId);
        intent.putExtra("accountId", accountId);
        OrderClientActivity.codigoLocalidad = codigoLocalidad;
        startActivity(intent);
    }

    private void callOrdersDB() {
        try {



            orders = realm.where(Order.class).equalTo("state", "ON").findAll();
            long approvedCount = realm.where(Order.class).equalTo("state", "ON").equalTo("approved", true).count();
            long retainedCount = realm.where(Order.class).equalTo("state", "ON").equalTo("approved", false).count();
            double total = realm.where(Order.class).equalTo("state", "ON").sum("total").doubleValue();
            double approved = realm.where(Order.class).equalTo("state", "ON").equalTo("approved", true).sum("total").doubleValue();
            double retained = realm.where(Order.class).equalTo("state", "ON").equalTo("approved", false).sum("total").doubleValue();

            tvTotalCount.setText(""+orders.size());
            tvTotal.setText("$ "+df.format(total));
            tvApprovedCount.setText(""+approvedCount);
            tvApproved.setText("$ "+df.format(approved));
            tvRetainedCount.setText(""+retainedCount);
            tvRetained.setText("$ "+df.format(retained));

            adapter = null;
            lvOrders.setAdapter(adapter);
            adapter = new OrderAdapter(this, R.layout.item_order, orders, true, false);
            lvOrders.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            orders.addChangeListener(this);
        } catch (Exception e) {
        }
    }

    private void showDialogConfirm(final Order orderSelect, final boolean isCancel) {
        AlertDialog alertDialog = new AlertDialog.Builder(OrdersActivity.this).create();
        alertDialog.setTitle("Confirmar");
        if (isCancel) {
            alertDialog.setMessage("¿Esta seguro que desea anular esta orden?");
        } else {
            alertDialog.setMessage("¿Esta seguro que desea editar esta orden?");
        }
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "SI",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (isCancel) {
                            dialog.dismiss();
                            callUpdateOrderWS(orderSelect.toUnManaged(realm));
                        } else {
                            order = orderSelect.toUnManaged(realm);
                            callGetOrder();
                        }
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    private void callUpdateOrderWS(final Order order) {

        //realm.beginTransaction();

        Call<OrderResponse> response;
        try {
            order.setCodigoEstado("ANU");
            response = App.servicesOrder.updateOrder(order);

            util.showProgress(true, mProgressView, shortAnimTime);


            response.enqueue(new Callback<OrderResponse>() {
                @Override
                public void onResponse(Call<OrderResponse> call, Response<OrderResponse> response) {

                    OrderResponse orderResponse = response.body();

                    if (orderResponse == null) {
                        Gson gson = new Gson();
                        TypeAdapter<OrderResponse> adapter = gson.getAdapter(OrderResponse.class);
                        try {
                            if (response.errorBody() != null)
                                orderResponse =
                                        adapter.fromJson(
                                                response.errorBody().string());
                        } catch (IOException e) {
                        }
                    }
                    if (orderResponse != null && "OK".equals(orderResponse.getMensaje())) {
                        showToastL("Se anuló la orden " + order.getNumeroOrden());
                        removeOrder(order.getId());
                        callOrdersDB();
                    } else {
                        showToastL("El servicio no está disponible, por favor intente mas tarde");
                    }

                    util.showProgress(false, mProgressView, shortAnimTime);

                }

                @Override
                public void onFailure(Call<OrderResponse> call, Throwable t) {
                    util.showProgress(false, mProgressView, shortAnimTime);
                    showToastL("El servicio no está disponible o no es posible comunicarse con el, revise su conexión internet");
                }
            });

        } catch (Exception e) {
            realm.cancelTransaction();
        }
    }

    private void removeOrder(int id) {
        try {
            if (!realm.isInTransaction()) {
                realm.beginTransaction();
            }
            Order o = realm.where(Order.class).equalTo("id", id).findFirst();
            o.deleteFromRealm();
            adapter.notifyDataSetChanged();
            realm.commitTransaction();
        } catch (Exception e) {
            try {
                realm.cancelTransaction();
            } catch (Exception e1) {
            }
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_on, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.item_update:
                showDialogConfirm(orders.get(info.position), false);
                return true;
            case R.id.item_cancel:
                showDialogConfirm(orders.get(info.position), true);
                return true;
            case R.id.item_view:
                showDialogOrder(orders.get(info.position).toUnManaged(realm));
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_update, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_update:
                showDialogConfirm();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public void onChange(RealmResults<Order> orders) {
        adapter.notifyDataSetChanged();
    }

    private void showToastL(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (realm != null) {
            realm.close();
        }
    }
    ProgressDialog progress;
    private void callOrders() {

        progress = new ProgressDialog(this);
        progress.setMessage("Actualizando ordenes, por favor espere...");
        progress.setCancelable(false);

        Call<OrdersResponse> response = App.servicesOrder.orders(App.companyCode, App.userSequence);
        progress.show();
        response.enqueue(new Callback<OrdersResponse>() {
            @Override
            public void onResponse(Call<OrdersResponse> call, Response<OrdersResponse> response) {
                progress.dismiss();
                if (response.body() != null) {

                    if ("OK".equals(response.body().getMensaje())) {
                        if (response.body().getOrdenes() != null && !response.body().getOrdenes().isEmpty()) {
                            try {
                                UtilDB.removeOrder(realm, response.body().getOrdenes());
                            } catch (Exception e) {
                                showToastL("Error eliminando ordenes antiguas");
                            }
                            Synchronize.orders(realm, response.body().getOrdenes(), false);
                            callOrdersDB();
                        } else {
                            showToastL("No se encontraron ordenes");
                        }
                    }
                } else {
                    showToastL("El servicio Ordenes retorno un error, No se encontraron ordenes del usuario");
                }
            }

            @Override
            public void onFailure(Call<OrdersResponse> call, Throwable t) {
                progress.dismiss();
                showToastL("Ocurrió un error, por favor verifique su acceso a internet");
            }

        });
    }

    private void callGetOrder(){
        util.showProgress(true, mProgressView, shortAnimTime);
        Call<GetOrderResponse> response = App.servicesOrder.getOrder(App.companyCode, order.getNumeroOrden());

        response.enqueue(new Callback<GetOrderResponse>() {
            @Override
            public void onResponse(Call<GetOrderResponse> call, Response<GetOrderResponse> response) {
                util.showProgress(false, mProgressView, shortAnimTime);
                GetOrderResponse orderResponse = response.body();

                if (orderResponse == null) {
                    Gson gson = new Gson();
                    TypeAdapter<GetOrderResponse> adapter = gson.getAdapter(GetOrderResponse.class);
                    try {
                        if (response.errorBody() != null)
                            orderResponse =
                                    adapter.fromJson(
                                            response.errorBody().string());
                    } catch (IOException e) {
                    }
                }
            try {
                if (orderResponse != null && "OK".equals(orderResponse.getMensaje())) {
                    setLineDetail(orderResponse.getOrdenes().getLsDafDetallesOrdens(), orderResponse.getOrdenes().getCodigoTipoOrden());
                } else {
                    showToastL("Ocurrió un problema al intentar obtener información de esta orden " + order.getNumeroOrden());
                }
            }catch (Exception e){
                Dialog.dialogo("Servicio de Ordenes","Ocurrio un Problema al intentar obtener informacion en la orden " +order.getNumeroOrden() + "Excepcion Controlada : "+e,OrdersActivity.this);
            }
            }

            @Override
            public void onFailure(Call<GetOrderResponse> call, Throwable t) {
                util.showProgress(false, mProgressView, shortAnimTime);
                showToastL("Ocurrió un problema al intentar obtener información de esta orden, verifique su conexión internet");
            }
        });
    }

    private void showDialogConfirm() {
        AlertDialog alertDialog = new AlertDialog.Builder(OrdersActivity.this).create();
        alertDialog.setTitle("Confirmar");
        alertDialog.setMessage("¿Desea actualizar las ordenes?");

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "SI",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        callOrders();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    private void showDialogOrder(Order orderSelect) {
        final View view = getLayoutInflater().inflate(R.layout.view_order, null);
        final android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(OrdersActivity.this, R.style.FullScreenDialogStyle).create();
        alertDialog.setTitle("Orden "+orderSelect.getNumeroOrden());
        alertDialog.setCancelable(false);
        alertDialog.getWindow().setBackgroundDrawable(null);
        Button btnFinalize = (Button) view.findViewById(R.id.btn_finalize);
        btnFinalize.setVisibility(View.GONE);

        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "ACEPTAR",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        WindowManager manager = (WindowManager) getSystemService(Activity.WINDOW_SERVICE);
        int width, height;
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.FROYO) {
            width = manager.getDefaultDisplay().getWidth();
            height = manager.getDefaultDisplay().getHeight();
        } else {
            Point point = new Point();
            manager.getDefaultDisplay().getSize(point);
            width = point.x;
            height = point.y;
        }
        params.width = width;
        params.height = height;

        FullScreenDialog dialog = new FullScreenDialog();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        FullScreenDialog.ORDER = orderSelect;
        dialog.show(ft, FullScreenDialog.TAG);
    }

    private void setLineDetail(List<ProductOrder> productOrder, String tipoOrden){
        double subtotal = 0;
        double discount = 0;
        double iva = 0;
        double total = 0;

        for (ProductOrder p : productOrder){
            p.setName(getProductName(p.getCodigoPrestacion()));
            p.setUnits(p.getCantidad());
            subtotal += p.getSubtotalVenta();
            iva += p.getValorIva();
            discount += p.getValorDescuento();
            total += p.getValorTotal();

            for (ProductOrder promo : p.getLstDafDetallesOrden()) {
                promo.setName(getProductName(promo.getCodigoPrestacion()));
                promo.setUnits(promo.getCantidad());
            }

        }
        order.setTotal(total);
        order.setSubtotal(subtotal);
        order.setIva(iva);
        order.setDiscount(discount);

        OrderProductsActivity.initialize();
        OrderClientActivity.account = null;
        OrderClientActivity.client = null;
        OrderProductsActivity.isEdit = true;
        OrderProductsActivity.isOff = false;
        OrderProductsActivity.type = tipoOrden;
        OrderProductsActivity.setOrderUpdate(order, productOrder);
        goToNewOrders(order.getCodigoCliente(), order.getCodigoCuentaCliente() , order.getCodigoLocalidad());
    }

    public String getProductName(int id) {
        try {
            return realm.where(Product.class).equalTo("id", id)
                    .findFirst().getName();
        } catch (Exception e) {
            return "";
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        overridePendingTransition(R.animator.left_to_right, R.animator.right_to_left);
    }
}
