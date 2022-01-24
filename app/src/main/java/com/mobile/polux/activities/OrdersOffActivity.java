package com.mobile.polux.activities;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.mobile.polux.R;
import com.mobile.polux.adapters.OrderAdapter;
import com.mobile.polux.app.App;
import com.mobile.polux.models.Order;
import com.mobile.polux.models.OrderMassiveResponse;
import com.mobile.polux.models.OrderResponse;
import com.mobile.polux.models.PromotionRequest;
import com.mobile.polux.models.PromotionResponse;
import com.mobile.polux.utils.Dialog;
import com.mobile.polux.utils.Promotions;
import com.mobile.polux.utils.Synchronize;
import com.mobile.polux.utils.Util;
import com.mobile.polux.utils.UtilDB;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmObject;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.mobile.polux.activities.ClientActivity.account;
import static com.mobile.polux.activities.ClientActivity.client;
import static com.mobile.polux.app.App.getValueOfPreferencesUser;

/**
 * Created by laptoplenovo on 15/6/2018.
 */

public class OrdersOffActivity extends AppCompatActivity implements RealmChangeListener<RealmResults<Order>> {

    //private TextView tvMessage;
    private FloatingActionButton fBtnNewOrder;

    private Realm realm;

    private List<Order> orders;
    private ListView lvOrders;
    private OrderAdapter adapter;

    private View mProgressView;
    private int shortAnimTime;
    private Util util;
    private LinearLayout llInfoOrders;
    private ProgressDialog progressDialog;

    private Promotions promotions;

    private Dialog dialogUtil;

    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        getSupportActionBar().setTitle("Pedidos pendientes");

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

        callOrdersOff(false);

    }

    private void bindUI() {
        dialogUtil = new Dialog();
        llInfoOrders = (LinearLayout) findViewById(R.id.ll_info_orders);
        llInfoOrders.setVisibility(View.GONE);
        promotions = new Promotions(realm);
        fBtnNewOrder = (FloatingActionButton) findViewById(R.id.fb_new_order);
        fBtnNewOrder.setVisibility(View.GONE);
        lvOrders = (ListView) findViewById(R.id.lv_orders);
        progress = new ProgressDialog(this);
        registerForContextMenu(lvOrders);
    }

    private void showProgressDialog(String message){
        progress.setMessage(message);
        progress.setCancelable(false);
        progress.show();
    }

    private void callOrdersOff(boolean multiSelect) {
        RealmResults<Order> orderList = UtilDB.getOrdersState(realm, "OFF");//realm.where(Order.class).equalTo("state", "OFF").findAll();
        orders = toUnManagedList(orderList);
        adapter = new OrderAdapter(this, R.layout.item_order, orders, false, multiSelect);
        lvOrders.setAdapter(adapter);

        try {
        //    orders.addChangeListener(this);
        } catch (Exception e) {
        }
    }

    private List<Order> toUnManagedList(RealmResults<Order> orderList){
        List<Order> orders = new ArrayList<>();
        for (Order o : orderList) {
            orders.add(o.toUnManaged(realm));
        }
        return orders;
    }

    private void goToNewOrders(int clientId, int accountId, Integer codigoLocalidad) {
        Intent intent = new Intent(this, OrderClientActivity.class);
        intent.putExtra("id", clientId);
        intent.putExtra("accountId", accountId);
        intent.putExtra("codigoLocalidad", codigoLocalidad);
        startActivity(intent);
    }

    private void showDialogConfirm(final Order order, final String action) {
        AlertDialog alertDialog = new AlertDialog.Builder(OrdersOffActivity.this).create();
        alertDialog.setTitle("Confirmar");
        switch (action) {
            case "S":
                alertDialog.setMessage("¿Esta seguro que desea enviar esta orden?");
                break;
            case "E":
                alertDialog.setMessage("¿Esta seguro que desea editar esta orden?");
                break;
            case "SM_S":
                alertDialog.setMessage("¿Esta seguro que desea enviar los pedidos?");
                break;
            case "SM_S_ALL":
                alertDialog.setMessage("¿Esta seguro que desea enviar todos los pedidos?");
                break;
            default:
                alertDialog.setMessage("¿Esta seguro que desea eliminar esta orden?");
                break;
        }

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "SI",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        switch (action) {
                            case "S":
                                //Enviar pedido
                                if(App.KEY_USE_PROMOTION == "S") {
                                    if (util.existInternet(OrdersOffActivity.this)) {
                                        callPromotions(order);
                                    } else {
                                        showToast("Necesitas Internet para enviar la orden");
                                    }
                                }else{
                                    if (util.existInternet(OrdersOffActivity.this)) {
                                        callSendOrderWS(order);
                                    } else {
                                        showToast("Necesitas Internet para enviar la orden");
                                    }
                                }
                                break;
                            case "E":
                                edit(order);
                                break;
                            case "SM_S":
                                //seleccionados();
                                //normalMenu();
                                callSendOrderMassiveWS(seleccionados());
                                break;
                            case "SM_S_ALL":
                                //seleccionados();
                                //normalMenu();
                                for (Order o : orders) {


                                    o.setNumeroOrdenAuxiliar(o.getId());
                                }
                                callSendOrderMassiveWS(orders);
                                break;
                            default:
                                //eliminar
                                removeOrder(order);
                                break;
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

    private void edit(Order order) {
        OrderProductsActivity.initialize();
        OrderClientActivity.account = null;
        OrderClientActivity.client = null;
        OrderProductsActivity.isEdit = false;
        OrderProductsActivity.isOff = true;
        OrderProductsActivity.setOrderUpdate(order, order.getLsDafDetallesOrdens());
        goToNewOrders(order.getCodigoCliente(), order.getCodigoCuentaCliente(), order.getCodigoLocalidad());
    }

    private void removeOrder(Order order) {
        try {
            if (!realm.isInTransaction()) {
                realm.beginTransaction();
            }
            Order orderD = realm.where(Order.class).equalTo("id",order.getId()).findFirst();
            orderD.deleteFromRealm();
            adapter.notifyDataSetChanged();
            realm.commitTransaction();
            callOrdersOff(false);
        } catch (Exception e) {
            showToast("No se pudo eliminar pedido, intente más tarde "+e);
            Log.e("ERROR","---> " +e);
            try {
                realm.cancelTransaction();
            } catch (Exception e1) {
            }
        }
    }

    private Menu optionsMenu;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.order_off, menu);
        optionsMenu = menu;
        optionsMenu.findItem(R.id.item_multi_select_send).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_multi_select:
                callOrdersOff(true);
                getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_dialog_close_dark);// set drawable icon
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                optionsMenu.findItem(R.id.item_multi_select).setVisible(false);
                optionsMenu.findItem(R.id.item_send_all).setVisible(false);
                optionsMenu.findItem(R.id.item_multi_select_send).setVisible(true);
                return true;
            case R.id.item_send_all:
                /*
                 * Aqui llamar al servicio multi ordenes
                 * */
                showDialogConfirm(null, "SM_S_ALL");
                //normalMenu();
                return true;
            case R.id.item_multi_select_send:
                /*
                 * Aqui llamar al servicio multi ordenes
                 * */
                showDialogConfirm(null, "SM_S");
                //normalMenu();
                return true;
            case android.R.id.home:
                normalMenu();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void normalMenu(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        callOrdersOff(false);
        optionsMenu.findItem(R.id.item_multi_select_send).setVisible(false);
        optionsMenu.findItem(R.id.item_multi_select).setVisible(true);
        optionsMenu.findItem(R.id.item_send_all).setVisible(true);
    }

    private List<Order> seleccionados(){
        List<Order> selected = new ArrayList<>();

        for (Order o : orders) {
            if (o.isChecked()) {


                o.setNumeroOrdenAuxiliar(o.getId());
                selected.add(o);
            }
        }
        return selected;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_off, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.item_send:
                showDialogConfirm(orders.get(info.position), "S");
                return true;
            case R.id.item_edit:
                showDialogConfirm(orders.get(info.position), "E");
                return true;
            case R.id.item_delete:
                showDialogConfirm(orders.get(info.position), "D");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public void onChange(RealmResults<Order> orders) {
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (realm != null) {
            realm.close();
        }
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    private long numOrder;
    private String messageOrder;
    boolean error = true;


    private void callSendOrderWS(final Order order) {
        if (order.getCodigoLocalidad() == -1) {
            order.setCodigoLocalidad(null);
        }
        Call<OrderResponse> response = App.servicesOrder.sendOrder(order);
        progressDialog = Util.barraCargando(this,"Enviando Orden...");

        response.enqueue(new Callback<OrderResponse>() {
            @Override
            public void onResponse(Call<OrderResponse> call, Response<OrderResponse> response) {
                numOrder = 0;

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

                if (orderResponse == null) {
                   progressDialog.dismiss();
                    showToast("Ocurrió un error, No se obtuvo respuesta del servicio de ordenes");
                    return;
                }

                String message = orderResponse.getMensaje();
                if ("OK".equals(message)) {


                    if (orderResponse.getNumeroOrden() == null) {
                        dialogUtil.showDialog("Fallo el envío del pedido, no se obtuvo el numero de orden", "mensaje obtenido: " + orderResponse.getMensaje()
                                + "\ncausa: " + orderResponse.getObservaciones(), OrdersOffActivity.this);
                        return;
                    }
                    order.setNumeroOrden(orderResponse.getNumeroOrden());
                    numOrder = order.getNumeroOrden();

                    if ("S".equals(orderResponse.getAprobada())) {
                        order.setApproved(true);
                        messageOrder = "Pedido Aprobado y enviado de manera exitosa";
                    } else {
                        progressDialog.dismiss();
                        order.setApproved(false);
                        messageOrder = "El pedido se envió pero no fue aprobado por incumplir las siguientes políticas:\n" + orderResponse.getObservaciones();
                    }
                    error = false;
                    saveOrder(order, false);
                    callOrdersOff(false);
                } else {
                    progressDialog.dismiss();
                    dialogUtil.showDialog("Fallo el envío del pedido", "mensaje obtenido: " + orderResponse.getMensaje()
                            + "\ncausa: " + orderResponse.getCausa(), OrdersOffActivity.this);
                }

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<OrderResponse> call, Throwable t) {
                numOrder = 0;
                progressDialog.dismiss();
                messageOrder = "El pedido no pudo ser enviado por problemas de conexión, intente mas tarde";
                showToast("Ocurrió un error, por favor verifique su acceso a internet");
            }
        });
    }

    private void callSendOrderMassiveWS(final List<Order> orders) {

        Call<OrderMassiveResponse> response = App.servicesOrder.sendMassiveOrder(orders);
        showProgressDialog("Enviando pedidos, por favor espere");
        response.enqueue(new Callback<OrderMassiveResponse>() {
            @Override
            public void onResponse(Call<OrderMassiveResponse> call, Response<OrderMassiveResponse> response) {
                progress.dismiss();
                OrderMassiveResponse orderResponse = response.body();
                if (orderResponse == null) {
                    Gson gson = new Gson();
                    TypeAdapter<OrderMassiveResponse> adapter = gson.getAdapter(OrderMassiveResponse.class);
                    try {
                        if (response.errorBody() != null) {
                            orderResponse =
                                    adapter.fromJson(
                                            response.errorBody().string());
                        }

                    } catch (Exception e) {}
                }
                if (orderResponse == null) {
                    showToast("Ocurrió un error, No se obtuvo respuesta del servicio de ordenes");
                    return;
                }

                String message = orderResponse.getMensaje();
                if ("OK".equals(message)) {
                    int count = 0;
                    String ordersError = "";
                    showToast("Los pedidos se enviaron con éxito");
                    for (Order order : orderResponse.getLstDafOrdenesAuxiliar()) {
                        //if (order.getError()!= null && !order.getError().isEmpty()) {
                        error = (order.getError()!= null && !order.getError().isEmpty());
                            //UtilDB.editOrderError(realm, order.getNumeroOrdenAuxiliar(), order.getObservaciones(), order.getError());
                            saveOrder(order, true);
                        //}
                        if (error) {
                            ordersError += "OFF-"+order.getNumeroOrdenAuxiliar()+"  ";
                            count++;
                        }

                    }
                    //Synchronize.orders(realm, orderResponse.getLstDafOrdenesAuxiliar(), true);
                    if (count > 0) {
                        AlertDialog alertDialog = new AlertDialog.Builder(OrdersOffActivity.this).create();
                        alertDialog.setTitle("Se detectaron errores");
                        String pre = "";
                        if (count == 1) {

                            pre ="Falló 1 orden "+error;
                        } else {

                            pre ="Fallaron " +count+ " ordenes.\n" +error;

                        }

                        alertDialog.setMessage(pre+" : "+ordersError);
                        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "ACEPTAR",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                        Dialog.dialogo("Ocurrio un Problema","Fallo en el Envio de las Ordenes  " +error,OrdersOffActivity.this);
                                    }
                                });
                        alertDialog.show();
                    }
                    normalMenu();
                }
            }

            @Override
            public void onFailure(Call<OrderMassiveResponse> call, Throwable t) {
                progress.dismiss();
                showToast("Ocurrió un error, por favor verifique su acceso a internet");
            }
        });
    }

    private void callPromotions(final Order order) {

        if ("N".equals(App.getValueOfPreferencesUser(App.KEY_USE_PROMOTION, "N")))  {
            callSendOrderWS(order);
            return;
        }
        promotions.setClient(UtilDB.geAccount(realm, order.getCodigoCuentaCliente()).getnDivision(), UtilDB.geClientVersion(realm, order.getCodigoCliente()));
        PromotionRequest promotionRequest = promotions.preparePromotionRequest(order);

        Call<PromotionResponse> response = App.services.promotionsSurtitodo(promotionRequest);
        progressDialog = Util.barraCargando(this,"Validando Promociones...");

        response.enqueue(new Callback<PromotionResponse>() {
            @Override
            public void onResponse(Call<PromotionResponse> call, Response<PromotionResponse> response) {
                Order orderPromotion = order;
                PromotionResponse promotionResponse = response.body();

                if (promotionResponse == null) {
                    Gson gson = new Gson();
                    TypeAdapter<PromotionResponse> adapter = gson.getAdapter(PromotionResponse.class);
                    try {
                        if (response.errorBody() != null)
                            promotionResponse =
                                    adapter.fromJson(
                                            response.errorBody().string());
                    } catch (IOException e) {
                    }
                }

                if (promotionResponse == null) {
                    progressDialog.dismiss();
                    showToast("Ocurrió un error, No se obtuvo respuesta del servicio de promociones, se envía orden sin promociones");
                    callSendOrderWS(orderPromotion);
                    return;
                }

                if ("OK".equals(promotionResponse.getMensaje())) {
                    progressDialog.dismiss();
                    orderPromotion = promotions.setPromotionOrder(order, promotionResponse);
                } else {
                    progressDialog.dismiss();
                    dialogUtil.showDialog("Fallo el servicio de promociones", "mensaje obtenido: " + promotionResponse.getMensaje()
                            + "\ncausa: " + promotionResponse.getCausa(), OrdersOffActivity.this);
                }
                callSendOrderWS(orderPromotion);
            }

            @Override
            public void onFailure(Call<PromotionResponse> call, Throwable t) {
                progressDialog.dismiss();
                callSendOrderWS(order);
                showToast("Ocurrió un error, intentando obtener promociones");
            }
        });
    }

    private void saveOrder(Order order, boolean isMassive) {

        try {
            realm.beginTransaction();
            if (isMassive) {
                Long num = order.getNumeroOrden();
                String aprobada = order.getAprobada();
                String obs = order.getObservaciones();
                String err = order.getError();
                order = UtilDB.getOrder(realm, order.getNumeroOrdenAuxiliar());
                if ("S".equals(aprobada)) {
                    order.setApproved(true);
                }
                order.setNumeroOrden(num);
                order.setObservaciones(obs);
                order.setError(err);
            }
            if (error) {
                order.setState("OFF");
            } else {
                order.setState("ON");
            }

            realm.copyToRealmOrUpdate(order);
            realm.commitTransaction();

            if (!isMassive) {
                showDialogOrder(numOrder, messageOrder, promotions.getMessage());
            }

            if (!error){
                UtilDB.updateNumOrders(realm, order.getCodigoCliente());
            }

        } catch (Exception e) {
        }
    }

    private void showDialogOrder(long order, String message, String promotions) {
        final View view = getLayoutInflater().inflate(R.layout.order, null);
        final android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(OrdersOffActivity.this).create();
        alertDialog.setTitle("Información");
        alertDialog.setCancelable(false);
        TextView tvOrder = (TextView) view.findViewById(R.id.tv_order);
        TextView tvMessage = (TextView) view.findViewById(R.id.tv_message);

        LinearLayout llPromotion = (LinearLayout) view.findViewById(R.id.ll_promotion);
        TextView tvPromotions = (TextView) view.findViewById(R.id.tv_promotions);

        tvOrder.setText("" + order);
        tvMessage.setText("" + message);
        llPromotion.setVisibility(View.VISIBLE);
        tvPromotions.setText("" + promotions);

        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "ACEPTAR",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        alertDialog.setView(view);
        alertDialog.show();
    }





    }












