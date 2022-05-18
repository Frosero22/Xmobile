package com.mobile.polux.activities;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.mobile.polux.R;
import com.mobile.polux.adapters.ProductOrderAdapter;
import com.mobile.polux.app.App;
import com.mobile.polux.models.DiscountManualResponse;
import com.mobile.polux.models.Order;
import com.mobile.polux.models.OrderResponse;
import com.mobile.polux.models.Product;
import com.mobile.polux.models.ProductOrder;
import com.mobile.polux.models.PromotionBodyRequest;
import com.mobile.polux.models.PromotionBodyResponse;
import com.mobile.polux.models.PromotionRequest;
import com.mobile.polux.models.PromotionResponse;
import com.mobile.polux.models.PromotionRuleResponse;
import com.mobile.polux.utils.Dialog;
import com.mobile.polux.utils.Promotions;
import com.mobile.polux.utils.Util;
import com.mobile.polux.utils.UtilDB;

import org.w3c.dom.Text;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.mobile.polux.app.App.KEY_DIAS_PEDIDO;
import static com.mobile.polux.app.App.KEY_PROMOTION_ID;
import static com.mobile.polux.app.App.companyCode;
import static com.mobile.polux.app.App.getValueOfPreferencesUser;

public class OrderProductsActivity extends AbstractActivity implements View.OnClickListener {


    public static RealmList<ProductOrder> productsOrder;
    private static Order orderAux;

    public static boolean isEdit;
    public static boolean isOff;
    public static boolean boo = false;
    public static String type = "CRE";
    private static ProgressDialog progressDialog;
    private static double total;
    private static double subtotal;
    private static double iva;
    private static double discount;
    private static int items;
    private static Double discountForProduct = 0.00;
    private static Order orderUpdate;
    private static List<ProductOrder> productOrderOriginal;
    String PermiteDias;
    String EmpresaPermiseDias;
    DecimalFormat df = new DecimalFormat("####,###,##0.00");
    String[] spinnerArrayTypes = new String[2];
    private LinearLayout llSearch;
    private ListView lvProductsOrder;
    private ProductOrderAdapter adapter;
    private Button btnFinalize;
    private int boxes;
    private int units;
    private int ruleId;
    private TextView tvSubtotal;
    private TextView tvIva;
    private TextView tvDiscount;
    private TextView tvTotal;
    private TextView totalItems;
    private View mProgressView;
    private int shortAnimTime;
    private Realm realm;
    private Util util;
    private Promotions promotions;
    private Dialog dialogUtil;
    private Long numOrder;
    private Integer codigoHttp;
    private String messageOrder;
    private EditText etDeliverDate;
    private EditText etPayDate;
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'-05:00'");

    private LinearLayout lnlValidaXRules;
    private String strValidaXRules;

    private String strElimPromAutomatica;

    private String mostrarValorDescuentoManual;
    private String mostrarValoresXRulesOrdenesPedidos;
    private String mostrarCheckAplicaRulesOrdenesPedido;

    public static void initialize() {
        orderUpdate = null;
        productsOrder = new RealmList<>();
        total = 0;
        subtotal = 0;
        iva = 0;
        discount = 0;
        items = 0;
        productOrderOriginal = null;
    }

    private double format(double value, int decimals){
        BigDecimal decimal = new BigDecimal(String.valueOf(value));
        BigDecimal newDecimal = decimal.setScale(decimals, RoundingMode.HALF_UP);
        return newDecimal.doubleValue();
    }

    private double formatv2(double value, int decimals){
        BigDecimal decimal = new BigDecimal(String.valueOf(value));
        BigDecimal newDecimal = decimal.setScale(decimals, RoundingMode.HALF_EVEN);
        return newDecimal.doubleValue();
    }

    public static void setOrderUpdate(Order order, List<ProductOrder> list) {
        orderUpdate = order;
        productsOrder = new RealmList<>();
        for (ProductOrder p : list) {
            productsOrder.add(p);
            if (p.getLstDafDetallesOrden() != null) {
                for (ProductOrder promo : p.getLstDafDetallesOrden()) {
                    promo.setProductRelation(p.getCodigoPrestacion());

                    productsOrder.add(promo);
                }
            }
        }
        total = orderUpdate.getTotal();
        subtotal = orderUpdate.getSubtotal();
        iva = orderUpdate.getIva();
        discount = orderUpdate.getDiscount();

        if (isEdit) {
            productOrderOriginal = list;
        }
    }

    private static String getName(String name) {
        int length = name.length();
        if (length > 30) {
            return name.substring(0, 30);
        } else {
            return name;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_products);
        Log.e("MENSAJE","TIPO DE ORDEN RECIBIDA ---> "+OrderClientActivity.client.getVersion());
        Log.e("MENSAJE","TIPO DE ORDEN RECIBIDA ---> "+OrderClientActivity.client.getPaymentType());

        if (isEdit) {
            getSupportActionBar().setTitle("Modificar Pedido - Productos");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        } else {
            getSupportActionBar().setTitle("Nuevo Pedido - Productos");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }



        //getSupportActionBar().setTitle("Pedido - Productos");
        //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // getSupportActionBar().setDisplayShowHomeEnabled(true);

        EmpresaPermiseDias = getValueOfPreferencesUser(KEY_DIAS_PEDIDO, "N");


        PermiteDias = OrderClientActivity.account.getPermiteModificarDiasPedido();
        Log.e(" LO QUE DEVUELVE ", " LOS DIAS QUE DEVUELVE " + PermiteDias);


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

        if (productsOrder == null) {
            productsOrder = new RealmList<>();
            subtotal = 0;
            iva = 0;
            total = 0;
            discount = 0;
            items = 0;
        }

        bindUI();
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            int id = bundle.getInt("productId", 0);
            //Product product = getProduct(id);
            boxes = bundle.getInt("boxes", 0);
            units = bundle.getInt("units", 0);
            int cant = bundle.getInt("cant", 0);
            double price = bundle.getDouble("price", 0);
            double discountP = bundle.getDouble("discountP", 0);
            //double percentIva = bundle.getDouble("percentIva", 0);

            if(strElimPromAutomatica.equalsIgnoreCase("S")){
                int bandera;
                bandera = searchPromotions();
                if(bandera > 0){
                    validaQuitarXRules(id, cant, price, discountP);

                }else{
                    addProduct(id, cant, price, discountP);
                }
            }else{
                addProduct(id, cant, price, discountP);
            }


        }

        setValuesToView();
    }


    public void validaQuitarXRules(final int id, final int cant, final double price, final double discountP){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(OrderProductsActivity.this);
        alertDialogBuilder.setTitle("Ordén");
        alertDialogBuilder.setIcon(R.drawable.error);
        alertDialogBuilder.setMessage("La Orden de Pedido tiene Promociones Automáticas que se quitarán y tendrán que ser evaluadas nuevamente. ¿Desea continuar?");
        alertDialogBuilder.setPositiveButton("Aceptar",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        removeFree();
                        removePromotions();
                        addProduct(id, cant, price, discountP);
                        adapter.notifyDataSetChanged();
                    }
                }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        alertDialog.setCancelable(true);

    }

    private void bindUI() {
        spinnerArrayTypes[0] = "CREDITO";
        spinnerArrayTypes[1] = "CONTADO";
        dialogUtil = new Dialog();
        llSearch = (LinearLayout) findViewById(R.id.ll_search);
        llSearch.setOnClickListener(this);
        lvProductsOrder = (ListView) findViewById(R.id.lv_products);
        registerForContextMenu(lvProductsOrder);
        adapter = new ProductOrderAdapter(this, R.layout.item_product_order, productsOrder);
        lvProductsOrder.setAdapter(adapter);
        // adapter.clear();
        tvSubtotal = (TextView) findViewById(R.id.tv_subtotal);
        tvIva = (TextView) findViewById(R.id.tv_iva);
        tvDiscount = (TextView) findViewById(R.id.tv_discount);
        tvTotal = (TextView) findViewById(R.id.tv_total);
        totalItems = (TextView) findViewById(R.id.tv_total_items);
        btnFinalize = (Button) findViewById(R.id.btn_finalize);

        lnlValidaXRules = (LinearLayout) findViewById(R.id.lnlValidaXRules);

        lnlValidaXRules.setVisibility(View.GONE);

        strValidaXRules = App.getValueOfPreferencesUser(App.KEY_APLICA_EDICION_XRULES);
        strElimPromAutomatica = App.getValueOfPreferencesUser(App.KEY_ELIM_PROM_AUTO);

        mostrarValorDescuentoManual = App.getValueOfPreferencesUser(App.KEY_MOSTRAR_VAL_DESC_MANUAL_VEND);
        mostrarCheckAplicaRulesOrdenesPedido = App.getValueOfPreferencesUser(App.KEY_MOST_CHECK_APL_XRULES_ORD_PED);
        mostrarValoresXRulesOrdenesPedidos = App.getValueOfPreferencesUser(App.KEY_MOSTRAR_VAL_XRULES_ORD_PED);

        Log.e("XRULES","APLICA EDICION XRULES "+strValidaXRules);
        Log.e("ELIMINA","ELIMINA PROMOCIONES DE FORMA AUTO "+strElimPromAutomatica);

        if(strValidaXRules.equalsIgnoreCase("S")){
            lnlValidaXRules.setVisibility(View.VISIBLE);
        }

        lnlValidaXRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callPromotionsV2();
            }
        });


        if (isEdit) {
            btnFinalize.setText("Enviar Pedido Editado");
        } else {
            btnFinalize.setText("Enviar Pedido");
        }

        btnFinalize.setOnClickListener(this);


        lvProductsOrder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ProductOrder p = productsOrder.get(position);
                if (p.getProductRelation() == null) {
                    units = p.getUnits();
                    boxes = p.getBoxes();
                    showDialogProduct(UtilDB.getProduct(realm, p.getCodigoPrestacion(), OrderClientActivity.account.getnDivision(), OrderClientActivity.client.getVersion()), position);
                }
            }
        });

        if (promotions == null) {
            promotions = new Promotions(realm, OrderClientActivity.account.getnDivision(), OrderClientActivity.client.getVersion(),strValidaXRules);
        }
    }

    private void addProduct(int productId, int cant, double price, double customPercent) {
        Product p = UtilDB.getProduct(realm, productId, OrderClientActivity.account.getnDivision(), OrderClientActivity.client.getVersion());
        if (p.getCodigoExistencia() == null) {
            add(productId, cant, p, customPercent);
            return;
        }
        if (util.existInternet(this) && "S".equals(getValueOfPreferencesUser(App.KEY_USE_PROMOTION, "N"))) {
            add(productId, cant, p, customPercent);
            // llamar promociones
            //callPromotions(productId, cant, price, p.getPorcentajeIva(), p.getGroup(), p.getSubGroup(), p.getProvider(), p.getArticle(), customPercent);
        } else if (!isEdit) {
            add(productId, cant, p, customPercent);
        } else {
            showToast("Necesitas internet para continuar editando esta orden");
        }
    }

    private void add(int productId, int cant, Product p, double customPercent) {
        ProductOrder productOrder = prepareAddProduct(
                productId,
                p.getName(),
                p.getPrice(),
                cant, boxes, units,
                p.getAplicaIva(),
                p.getPorcentajeIva(),
                p.getServiceCode(),
                p.getVersion(),
                p.getCost(),
                customPercent,
                false, false,
                p.getGroup(), p.getSubGroup(), p.getArticle(), p.getProvider());
        productOrder.setArticle(p.getArticle());
        productOrder.setSubGroup(p.getSubGroup());
        productOrder.setGroup(p.getGroup());
        addProductToOrder(productOrder, false, 0);
    }

    private ProductOrder prepareAddProduct(int code, String name, double price,
                                           int cant, int boxes, int units,
                                           String applyIva, double percentIva, int serviceCode, int version, double unitCost,
                                           double percentDiscount,
                                           boolean isPromotion,
                                           boolean isFree, int group, int subGroup, int article, int provider) {

        ProductOrder productOrder = promotions.prepareAddProduct(code, name, price,
                cant, boxes, units,
                applyIva, percentIva, serviceCode, version, unitCost,
                percentDiscount,
                isPromotion,
                isFree,
                0,
                0,
                0,
                0);

        Log.e("code","CODE DE PRODUCTO "+code);

        if (!isFree) {
            this.iva += productOrder.getValorIva();
            this.discount += productOrder.getValorDescuento();
            this.total += productOrder.getValorTotal();
            this.subtotal += productOrder.getSubtotalVenta();

        }
        productOrder.setGroup(group);
        productOrder.setSubGroup(subGroup);
        productOrder.setArticle(article);
        productOrder.setProvider(provider);
        return productOrder;
    }

    private void addProductToOrder(ProductOrder productOrder, boolean isFree, int productFather) {

        if (isEdit) {

            if (isFree) {
                productOrder.setLineaDetalle(getLineDetailFree(productFather, productOrder.getCodigoPrestacion()));
            } else {
                productOrder.setLineaDetalle(getLineDetail(productOrder.getCodigoPrestacion()));

            }

        }

        adapter.add(productOrder);

        if(strValidaXRules.equalsIgnoreCase("S")){
            orderAux = prepareOrder();
            adapter.clear();

            RealmList<ProductOrder> lsProductsOrderAux = new RealmList<>();

            for (ProductOrder p1 : orderAux.getLsDafDetallesOrdens()) {
                lsProductsOrderAux.add(p1);
                if (p1.getLstDafDetallesOrden() != null) {
                    for (ProductOrder promo : p1.getLstDafDetallesOrden()) {
                        promo.setProductRelation(p1.getCodigoPrestacion());
                        promo.setName(getProductName(promo.getCodigoPrestacion()));
                        lsProductsOrderAux.add(promo);
                    }
                }
            }


            adapter.addAll(lsProductsOrderAux);


        }
        adapter.notifyDataSetChanged();
        setValuesToView();


    }

    private Integer getLineDetail(int productId) {
        for (ProductOrder p : productOrderOriginal) {
            if (productId == p.getCodigoPrestacion()) {
                return p.getLineaDetalle();
            }
        }
        return null;
    }

    private Integer getLineDetailFree(int productFather, int productId) {
        for (ProductOrder p : productOrderOriginal) {
            if (productFather == p.getCodigoPrestacion()) {
                for (ProductOrder promo : p.getLstDafDetallesOrden()) {
                    if (productId == promo.getCodigoPrestacion()) {
                        return promo.getLineaDetalle();
                    }
                }
            }
        }
        return null;
    }

    private void setValuesToView() {


        tvTotal.setText("" + df.format(this.total));
        tvIva.setText("" + df.format(this.iva));
        tvSubtotal.setText("" + df.format(this.subtotal));
        tvDiscount.setText("" + df.format(this.discount));

        if (productsOrder == null) {
            totalItems.setText("0");
        } else {

            for (items = productsOrder.size(); items <= productsOrder.size(); items++) {
                totalItems.setText("" + productsOrder.size());

            }
        }

    }

    private void goToSearch() {
        Intent intent = new Intent(this, SearchProductActivity.class);
        startActivity(intent);
    }

    private void goToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        intent.putExtra("numOrder", numOrder);
        if (messageOrder != null && !messageOrder.isEmpty()) {
            intent.putExtra("messageOrder", messageOrder);
        }
        if (promotions.getMessage() != null && !promotions.getMessage().isEmpty()) {
            intent.putExtra("messagePromotion", promotions.getMessage());
        }

        intent.putExtra("codigoHttp",codigoHttp);




        startActivity(intent);
    }

    private void sendOrder(String deliverDate, String payDate, String observation, int location) throws ParseException {
        Log.e("FECHA NUMERO ", " UNO --> " + deliverDate);
        Log.e("FECHA NUMERO ", " UNO --> " + payDate);

        final Order order = prepareOrder();
        order.setState("OFF");
        order.setCodigoLocalidad(location);
        try {
            order.setFechaOrden(dateFormat2.format(new Date()));
            order.setFechaEntrega(dateFormat2.format(dateFormat.parse(payDate)));
        } catch (ParseException e) {
            order.setFechaEntrega(dateFormat2.format(new Date()));
            Log.e("EXCEPCION --> ", "POR ACA " + e);
        }
        try {
            order.setFechaCompromisoPago(dateFormat2.format(dateFormat.parse(deliverDate)));
        } catch (ParseException e) {
            order.setFechaCompromisoPago(dateFormat2.format(new Date()));
            Log.e("EXCEPCION --> ", "POR ACA " + e);
        }
        order.setObservacion(observation);

        if(strValidaXRules.equalsIgnoreCase("N")){

            if (App.getValueOfPreferencesUser(App.KEY_USE_PROMOTION).equalsIgnoreCase("S")) {
                if (isEdit && orderUpdate != null && orderUpdate.getNumeroOrden() != null) {
                    //  ********************* Actualizar orden ya enviada
                    if (util.existInternet(this)) {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(OrderProductsActivity.this);
                        alertDialogBuilder.setTitle("Validar X-RULES");
                        alertDialogBuilder.setIcon(R.drawable.correcto);
                        alertDialogBuilder.setMessage("¿Desea Validar Promociones para esta Orden?");
                        alertDialogBuilder.setPositiveButton("Validar X-RULES",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        order.setNumeroOrden(orderUpdate.getNumeroOrden());
                                        callPromotions(order);
                                    }
                                }).setNegativeButton("No Validar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                order.setNumeroOrden(orderUpdate.getNumeroOrden());
                                callUpdateOrderWS(order);

                            }
                        });

                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();


                        //   order.setNumeroOrden(orderUpdate.getNumeroOrden());
                        // callPromotions(order);

                    } else {
                        messageOrder = "Necesitas internet para actualizar este pedido";
                    }
                } else {
                    // ********************** Se envia orden nueva o que permanecia en estado pendiente
                    order.setNumeroOrden(null);
                    if (util.existInternet(this)) {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(OrderProductsActivity.this);
                        alertDialogBuilder.setTitle("Validar X-RULES");
                        alertDialogBuilder.setIcon(R.drawable.correcto);
                        alertDialogBuilder.setMessage("¿Desea Validar Promociones para esta Orden?");
                        alertDialogBuilder.setPositiveButton("Validar X-RULES",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // order.setNumeroOrden(orderUpdate.getNumeroOrden());
                                        callPromotions(order);
                                    }
                                }).setNegativeButton("No Validar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                callSendOrderWS(order);

                            }
                        });

                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();

                        //  callPromotions(order);
                        //callSendOrderWS(order);
                    } else {
                        order.setState("OFF");
                        messageOrder = "El pedido se almaceno en el dispositivo para ser enviado mas tarde";
                        saveOrder(order);
                    }
                }
            } else {
                if (isEdit && orderUpdate != null && orderUpdate.getNumeroOrden() != null) {
                    //  ********************* Actualizar orden ya enviada
                    if (util.existInternet(this)) {
                        order.setNumeroOrden(orderUpdate.getNumeroOrden());
                        callUpdateOrderWS(order);
                    } else {
                        messageOrder = "Necesitas internet para actualizar este pedido";
                    }
                } else {
                    order.setNumeroOrden(null);
                    if (util.existInternet(this)) {
                        callSendOrderWS(order);
                    } else {
                        order.setState("OFF");
                        messageOrder = "El pedido se almaceno en el dispositivo para ser enviado mas tarde";
                        saveOrder(order);
                    }
                }
            }

        }else{

            if (isEdit && orderUpdate != null && orderUpdate.getNumeroOrden() != null) {
                //  ********************* Actualizar orden ya enviada
                if (util.existInternet(this)) {
                    order.setNumeroOrden(orderUpdate.getNumeroOrden());
                    this.promotions.setPromotions(order);
                    callUpdateOrderWS(order);
                } else {
                    messageOrder = "Necesitas internet para actualizar este pedido";
                }
            } else {
                order.setNumeroOrden(null);
                if (util.existInternet(this)) {
                    this.promotions.setPromotions(order);
                    callSendOrderWS(order);
                } else {
                    order.setState("OFF");
                    messageOrder = "El pedido se almaceno en el dispositivo para ser enviado mas tarde";
                    this.promotions.setPromotions(order);
                    saveOrder(order);
                }
            }

        }


    }

    private Order prepareOrder() {
        Order order = new Order();
        order.setCodigoEmpresa(App.companyCode);
        order.setCodigoSucursal(App.subCompanyCode);
        order.setUsuarioIngreso(App.userCode);
        if (isOff && orderUpdate != null) {
            order.setId(orderUpdate.getId());
        } else {
            order.setId(App.orderId.incrementAndGet());
        }
        order.setCodigoCliente(OrderClientActivity.client.getId());
        order.setName(OrderClientActivity.client.getName());
        order.setCodigoCuentaCliente(OrderClientActivity.account.getId());
        order.setCodigoDivision(OrderClientActivity.account.getDivisionCode());

        // order.setDiasPlazo(OrderClientActivity.account.getDiasPlazo());
        // Log.e("RECIBO DIAS","  DIAS PLAZO "+OrderClientActivity.account.getDiasPlazo());

        order.setCodigoTipoOrden(OrderClientActivity.client.getPaymentType());
        Log.e("RECIBO TIPO PAGO", "TIPO DE PAGO---> " + OrderClientActivity.client.getPaymentType());


        order.setAplicaConsignacion("N");
        order.setCodigoTipoVenta(OrderClientActivity.account.getSaleTypeCode());
        order.setCodigoCuentaXDZV(OrderClientActivity.account.getXDZVCode());
        order.setTotal(total);
        order.setSubtotal(subtotal);
        order.setIva(iva);
        order.setDiscount(discount);

        order.setLsDafDetallesOrdens(promotions.prepareOrderProducts(productsOrder));

        return order;
    }

    private void saveOrder(Order order) {

        try {
            if (!realm.isInTransaction()) {
                realm.beginTransaction();
            }
            if (isEdit && orderUpdate != null) {
                int id = orderUpdate.getId();
                orderUpdate = null;
                orderUpdate = order;
                orderUpdate.setId(id);

                realm.copyToRealmOrUpdate(orderUpdate);
            } else {
                realm.copyToRealmOrUpdate(order);
            }
            realm.commitTransaction();
            if (!isEdit) {
                UtilDB.updateNumOrders(realm, OrderClientActivity.client.getId());
            }

            isEdit = false;
            initialize();
            OrderClientActivity.account = null;
            OrderClientActivity.client = null;

            goToMain();
        } catch (Exception e) {
            try {
                realm.cancelTransaction();
            } catch (Exception e1) {
            }
        }
    }

    private void callSendOrderWS(final Order order) {

        if (order.getCodigoLocalidad() == -1) {
            order.setCodigoLocalidad(null);
        }

        Call<OrderResponse> response = App.servicesOrder.sendOrder(order);

        progressDialog = Util.barraCargando(this, "Enviando Orden...");
        response.enqueue(new Callback<OrderResponse>() {
            @Override
            public void onResponse(Call<OrderResponse> call, Response<OrderResponse> response) {
                numOrder = 0L;
                codigoHttp = response.code();
                boolean error = true;

                OrderResponse orderResponse = response.body();
                if (orderResponse == null) {
                    Gson gson = new Gson();
                    TypeAdapter<OrderResponse> adapter = gson.getAdapter(OrderResponse.class);
                    try {
                        if (response.errorBody() != null) {
                            orderResponse =
                                    adapter.fromJson(
                                            response.errorBody().string());
                        }

                    } catch (Exception e) {
                    }
                }
                if (orderResponse == null) {
                    progressDialog.dismiss();
                    showToast("Ocurrió un error, No se obtuvo respuesta del servicio de órdenes");
                    return;
                }

                String message = orderResponse.getMensaje();
                if ("OK".equals(message)) {
                    order.setNumeroOrden(orderResponse.getNumeroOrden());
                    numOrder = order.getNumeroOrden();

                    if ("S".equals(orderResponse.getAprobada())) {
                        order.setApproved(true);
                        messageOrder = "Pedido Aprobado y enviado de manera exitosa";
                    } else {
                        order.setApproved(false);
                        messageOrder = "El pedido se envió pero no fue aprobado por incumplir las siguientes políticas:\n" + orderResponse.getObservaciones();
                    }
                    error = false;
                } else {
                    messageOrder = "Fallo el envío del pedido, se almacenó en el dispositivo para intentar más tarde mensaje obtenido: " + message;
                    error = true;
                }
                if (error) {
                    order.setState("OFF");
                } else {
                    order.setState("ON");
                }
                saveOrder(order);

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<OrderResponse> call, Throwable t) {
                numOrder = 0L;
                order.setState("OFF");
                progressDialog.dismiss();
                messageOrder = "El pedido no pudo ser enviado por problemas de conexión, se almaceno en el dispositivo para intentar mas tarde";
                showToast("Ocurrió un error, por favor verifique su acceso a internet");
                saveOrder(order);
            }
        });
    }



    private void callPromotions(final Order order) {
        progressDialog = Util.barraCargando(this, "Validando Promociones...");


        String strIDPromotion = App.getValueOfPreferencesUser(App.KEY_PROMOTION_ID,"");
        PromotionRequest promotionRequest = new PromotionRequest();
        Call<PromotionResponse> res = null;

        if(strIDPromotion.equalsIgnoreCase("PROMOCIONES_SURTITODO")){

            promotionRequest = promotions.preparePromotionRequestSurtitodo(order);

        }else{

            promotionRequest = promotions.preparePromotionRequest(order);

        }


        switch (strIDPromotion) {
            case "PROMOCIONES_SURTITODO":
                res = App.services.promotionsSurtitodo(promotionRequest);
                break;
            case "PROMOCIONES_COMIDESA":
                res = App.services.promotionsComidesa(promotionRequest);
                break;
            case "PROMOCIONES_PRODUVENTAS":
                res = App.services.promotionsProduventas(promotionRequest);
                break;
        }


        assert res != null;
        res.enqueue(new Callback<PromotionResponse>() {
            @Override
            public void onResponse(Call<PromotionResponse> call, Response<PromotionResponse> response) {
                Order orderPromotion = order;

                Log.e("MENSAJE GENERADO", "---> " + response);
                progressDialog.dismiss();
                PromotionResponse promotionResponse = response.body();

                if (promotionResponse == null) {
                    Gson gson = new Gson();
                    TypeAdapter<PromotionResponse> adapter = gson.getAdapter(PromotionResponse.class);
                    try {
                        if (response.errorBody() != null)
                            promotionResponse =
                                    adapter.fromJson(
                                            response.errorBody().string());
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e(String.valueOf(this), "ERROR GENERADO ---> " + e);
                    }
                }

                if (promotionResponse == null) {
                    Dialog.dialogo("Servicio de Promociones", "No se obtuvo Respuesta por parte del Servicio de X-uit BRMS " + promotionResponse.getMensaje(), OrderProductsActivity.this);
                    return;
                }

                if(promotionResponse.getResponse_body() != null){
                    try {


                        if(strValidaXRules.equalsIgnoreCase("S")){

                            removeFree();
                            for(ProductOrder productOrder : order.getLsDafDetallesOrdens()){
                                promotions(promotionResponse.getResponse_body(),productOrder.getCodigoPrestacion(),productOrder.getCantidad());
                            }





                        }else{

                            orderPromotion = promotions.setPromotionOrder(order, promotionResponse);

                            if (isEdit) {


                                callUpdateOrderWS(orderPromotion);

                            } else {

                                callSendOrderWS(orderPromotion);

                            }

                        }




                    } catch (Exception e) {
                        e.printStackTrace();
                        Dialog.dialogo("Servicio de Pedidos", "Fallo en el Envio del Pedido ,Por favor vuelva a Enviar el Pedido, si el error persiste contacte al administrador " + e, OrderProductsActivity.this);
                        Log.e("Error --> ", " Generado ---> " + e);
                    }
                }else{

                    final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(OrderProductsActivity.this);
                    alertDialogBuilder.setTitle("Servicio de Promociones");
                    alertDialogBuilder.setIcon(R.drawable.error);
                    alertDialogBuilder.setMessage("No se obtuvo Respuesta por parte del Servicio de X-uit BRMS , MENSAJE OBTENIDO: " + promotionResponse.getMensaje() + " causa: " + promotionResponse.getCausa());

                    final Order finalOrderPromotion = orderPromotion;

                    alertDialogBuilder.setPositiveButton("Enviar Sin Promociones",

                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    if (isEdit) {

                                        callUpdateOrderWS(finalOrderPromotion);
                                    } else {
                                        callSendOrderWS(finalOrderPromotion);
                                    }


                                }
                            }).setNegativeButton("Seguir Editando", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();

                        }
                    });


                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();

                }

            /*    if ("OK".equals(promotionResponse.getMensaje())) {
                    try {
                        orderPromotion = promotions.setPromotionOrder(order, promotionResponse);

                        if (isEdit) {


                            callUpdateOrderWS(orderPromotion);

                        } else {

                            callSendOrderWS(orderPromotion);

                        }


                    } catch (Exception e) {

                        Dialog.dialogo("Servicio de Pedidos", "Fallo en el Envio del Pedido ,Por favor vuelva a Enviar el Pedido, si el error persiste contacte al administrador " + e, OrderProductsActivity.this);
                        Log.e("Error --> ", " Generado ---> " + e);
                    }

                } else {

                    final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(OrderProductsActivity.this);
                    alertDialogBuilder.setTitle("Servicio de Promociones");
                    alertDialogBuilder.setIcon(R.drawable.error);
                    alertDialogBuilder.setMessage("No se obtuvo Respuesta por parte del Servicio de X-uit BRMS , MENSAJE OBTENIDO: " + promotionResponse.getMensaje() + " causa: " + promotionResponse.getCausa());

                    final Order finalOrderPromotion = orderPromotion;

                    alertDialogBuilder.setPositiveButton("Enviar Sin Promociones",

                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    if (isEdit) {

                                        callUpdateOrderWS(finalOrderPromotion);
                                    } else {
                                        callSendOrderWS(finalOrderPromotion);
                                    }


                                }
                            }).setNegativeButton("Seguir Editando", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();

                        }
                    });


                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();


                } */


            }

            @Override
            public void onFailure(Call<PromotionResponse> call, Throwable t) {
                progressDialog.dismiss();
                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(OrderProductsActivity.this);
                alertDialogBuilder.setTitle("Servicio de Promociones");
                alertDialogBuilder.setIcon(R.drawable.error);
                alertDialogBuilder.setMessage("No se obtuvo Respuesta por parte del Servicio de X-uit BRMS debido a problemas con el consumo de informacion " + t);

                alertDialogBuilder.setPositiveButton("Enviar Sin Promociones",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                callSendOrderWS(order);

                            }
                        }).setNegativeButton("Seguir Editando", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();

                    }
                });


                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();


            }


            // promotions(null, productId, cant, customPercent);


        });

    }




    private void promotions(List<PromotionBodyResponse> response, int productId, int cant) {
        try {
            List<String> promotions = new ArrayList<>();
            double discountPromotion = 0;

            List<PromotionRuleResponse> free = new ArrayList<>();
            if (response != null) {
                for (PromotionBodyResponse body : response) {
                    for (PromotionRuleResponse rule : body.getResponse_rule()) {

                        Integer mensajeBody = body.getResponse_detail_id();

                        if (rule.getPorcentaje_descuento() != null && body.getResponse_detail_id() == productId) {
                            discountPromotion = rule.getPorcentaje_descuento();
                            ruleId = rule.getRule_id();
                            Log.e(String.valueOf(this), "RULE ID OBTENIDO " + ruleId);
                            promotions.add(discountPromotion + " % de descuento en el producto");
                        }


                        if (rule.getItem_regalo() != null) {


                            if (rule.getCantidad_item_regalo() == null) {

                                Dialog.dialogo("Servicio Reglas de Negocio", "La Regla de Negocio Numero " + ruleId + " para el item " + mensajeBody + " no tiene una cantidad definida, por favor notificar", OrderProductsActivity.this);


                            } else {

                                rule.setProductId(body.getResponse_detail_id());
                                free.add(rule);

                            }

                        }


                    }
                }
            }

            double discountPercent = discountPromotion;
            if (discountPromotion == 0) {
                discountPercent = discountPromotion;
            }


            if(strValidaXRules.equalsIgnoreCase("S")){

                List<String> lsErrores = new ArrayList<>();

                for(ProductOrder productOrder : productsOrder){
                    if(productOrder.getCodigoPrestacion() == productId){



                        if (discountPromotion > 0) {
                            //   if(productOrder.getCodigoReglaNegocio() == null){

                            productOrder.setCodigoReglaNegocio(ruleId);
                            productOrder.setAplicaXRules("S");

                            productOrder.setValorDescuento(null);
                            productOrder.setPorcentajeDescuento(null);



                            Product p = UtilDB.getProduct(realm, productId, OrderClientActivity.account.getnDivision(), OrderClientActivity.client.getVersion());
                            ProductOrder proO = this.promotions.prepareAddProduct(productId,
                                    p.getName(),
                                    p.getPrice(),
                                    cant, boxes, units,
                                    p.getAplicaIva(),
                                    p.getPorcentajeIva(),
                                    p.getServiceCode(),
                                    p.getVersion(),
                                    p.getCost(),
                                    discountPercent,
                                    false,
                                    false,
                                    discountPercent,
                                    0,
                                    0,0);




                            //  productOrder.setLineaDetalle(null);


                            double descuentoTotal = 0.00;
                            double porcentajeDescuentoTotal = 0.00;


                            String strErrorProducto = "";


                            if(productOrder.getPorcentajeDescuentoManual() != null){

                                if(productOrder.getPorcentajeDescuentoManual() > 0){

                                    porcentajeDescuentoTotal = discountPercent + productOrder.getPorcentajeDescuentoManual();
                                    descuentoTotal = proO.getValorDescuento() + productOrder.getValorDescuentoManual();

                                    if(porcentajeDescuentoTotal < 100){

                                        productOrder.setPorcentajeDescuento(porcentajeDescuentoTotal);
                                        productOrder.setValorDescuento(descuentoTotal);

                                        productOrder.setPorcentajeDescuentoXRules(discountPercent);
                                        productOrder.setValorDescuentoXRules(proO.getValorDescuento());

                                    }else{
                                        strErrorProducto = productOrder.getName()+" - %X-Rules: "+proO.getPorcentajeDescuentoXRules()+" y Descuento Manual: "+productOrder.getPorcentajeDescuentoManual()+" es igual a "+porcentajeDescuentoTotal+"\n";
                                        lsErrores.add(strErrorProducto);

                                        productOrder.setPorcentajeDescuento(discountPercent);
                                        productOrder.setValorDescuento(proO.getValorDescuento());

                                        productOrder.setPorcentajeDescuentoXRules(discountPercent);
                                        productOrder.setValorDescuentoXRules(proO.getValorDescuento());

                                        productOrder.setPorcentajeDescuentoManual(0.00);
                                        productOrder.setValorDescuentoManual(0.00);

                                    }
                                }else{

                                    productOrder.setPorcentajeDescuento(discountPercent);
                                    productOrder.setValorDescuento(proO.getValorDescuento());

                                    productOrder.setPorcentajeDescuentoXRules(discountPercent);
                                    productOrder.setValorDescuentoXRules(proO.getValorDescuento());

                                }
                            }else{

                                productOrder.setPorcentajeDescuento(discountPercent);
                                productOrder.setValorDescuento(proO.getValorDescuento());

                                productOrder.setPorcentajeDescuentoXRules(discountPercent);
                                productOrder.setValorDescuentoXRules(proO.getValorDescuento());


                            }

                            double subTotal = 0;
                            double subTotalBase = 0;
                            double total = 0;

                            subTotal = proO.getPrecioUnitarioVenta() * proO.getCantidad();
                            subTotalBase = subTotal - productOrder.getValorDescuento();




                            productOrder.setValorIva(proO.getValorIva());
                            productOrder.setSubtotalVenta(subTotal);
                            productOrder.setSubtotalBaseImponible(subTotalBase);



                            total = subTotalBase + proO.getValorIva();



                            productOrder.setValorTotal(total);

                            discount = 0;
                            //discount += productOrder.getValorDescuento();


                            subtotal = 0;

                            this.total = 0;
                            iva = 0;

                            double subBaseImponible = 0;

                            for(ProductOrder productOrder1: productsOrder){
                                iva += productOrder1.getValorIva();
                                subBaseImponible += productOrder1.getSubtotalBaseImponible();

                                if(!productOrder1.getEsPromocion().equalsIgnoreCase("S")){
                                    subtotal += productOrder1.getSubtotalVenta();
                                    if(productOrder1.getValorDescuento() != null){
                                        if(productOrder1.getValorDescuento() > 0){
                                            discount += productOrder1.getValorDescuento();
                                        }
                                    }
                                }



                            }


                            this.total = subBaseImponible + iva;





                            StringBuilder strM = new StringBuilder("El total de descuento por producto no puede ser igual o sobrepasar el 100%: \n\n");
                            if(lsErrores != null){
                                if(lsErrores.size() > 0){
                                    for(String index: lsErrores){
                                        strM.append(index.trim());
                                    }

                                    productosConProblemas(strM.toString());

                                }
                            }






                            setValuesToView();

                            //}




                        }
                    }
                }

                Product p = UtilDB.getProduct(realm, productId, OrderClientActivity.account.getnDivision(), OrderClientActivity.client.getVersion());

                ProductOrder productOrderFree;



                for (PromotionRuleResponse rule : free) {

                    if(productId == rule.getProductId()){
                        Product pFree = UtilDB.getProductFree(realm, rule.getItem_regalo(),
                                rule.getCantidad_item_regalo(), OrderClientActivity.account.getnDivision(),
                                OrderClientActivity.client.getVersion());




                        if (pFree != null) {
                            int cantProduct = getCantProduct(rule.getProductId());
                            rule.setCantidad_item_regalo(getCantidadRegalo(cantProduct, rule.getCantidad_base_multiplo(), rule.getCantidad_item_regalo()));
                            if (rule.getCantidad_item_regalo() > 0) {
                                promotions.add("GRATIS " + rule.getCantidad_item_regalo() + " " + getName(pFree.getName())+"\n");
                                productOrderFree = prepareAddProduct(
                                        pFree.getId(),
                                        pFree.getName(),
                                        pFree.getPrice(),
                                        rule.getCantidad_item_regalo(), 0, rule.getCantidad_item_regalo(),
                                        "N",
                                        pFree.getPorcentajeIva(),
                                        pFree.getServiceCode(),
                                        pFree.getVersion(),
                                        pFree.getCost(),
                                        100,
                                        true, true,
                                        p.getGroup(), p.getSubGroup(), p.getArticle(), p.getProvider());
                                productOrderFree.setCodigoReglaNegocio(rule.getRule_id());
                                productOrderFree.setProductRelation(rule.getProductId());

                                addProductToOrder(productOrderFree, true, rule.getProductId());







                            }


                        }
                    }



                }






            }else{


                Product p = UtilDB.getProduct(realm, productId, OrderClientActivity.account.getnDivision(), OrderClientActivity.client.getVersion());
                ProductOrder productOrder = prepareAddProduct(
                        productId,
                        p.getName(),
                        p.getPrice(),
                        cant, boxes, units,
                        p.getAplicaIva(),
                        p.getPorcentajeIva(),
                        p.getServiceCode(),
                        p.getVersion(),
                        p.getCost(),
                        discountPercent,
                        false,
                        false,
                        p.getGroup(), p.getSubGroup(), p.getArticle(), p.getProvider()
                );

                if (discountPromotion > 0) {
                    productOrder.setCodigoReglaNegocio(ruleId);
                    productOrder.setEsPromocionAutomatica("S");
                }

                addProductToOrder(productOrder, false, 0);
                ProductOrder productOrderFree;
                for (PromotionRuleResponse rule : free) {


                    Product pFree = UtilDB.getProductFree(realm, rule.getItem_regalo(),
                            rule.getCantidad_item_regalo(), OrderClientActivity.account.getnDivision(),
                            OrderClientActivity.client.getVersion());


                    if (pFree != null) {
                        int cantProduct = getCantProduct(rule.getProductId());
                        rule.setCantidad_item_regalo(getCantidadRegalo(cantProduct, rule.getCantidad_base_multiplo(), rule.getCantidad_item_regalo()));
                        if (rule.getCantidad_item_regalo() > 0) {
                            promotions.add("GRATIS " + rule.getCantidad_item_regalo() + " " + getName(pFree.getName())+"\n");
                            productOrderFree = prepareAddProduct(
                                    rule.getItem_regalo(),
                                    pFree.getName(),
                                    pFree.getPrice(),
                                    rule.getCantidad_item_regalo(), 0, rule.getCantidad_item_regalo(),
                                    "N",
                                    pFree.getPorcentajeIva(),
                                    pFree.getServiceCode(),
                                    pFree.getVersion(),
                                    pFree.getCost(),
                                    100,
                                    true, true,
                                    p.getGroup(), p.getSubGroup(), p.getArticle(), p.getProvider());
                            productOrderFree.setCodigoReglaNegocio(rule.getRule_id());
                            productOrderFree.setProductRelation(rule.getProductId());
                            addProductToOrder(productOrderFree, true, rule.getProductId());
                        }


                    }
                }


            }



            adapter.notifyDataSetChanged();
        } catch (Exception e) {

            e.printStackTrace();
            Log.e(String.valueOf(this), "Error Generado ---> " + e);


        }
    }

    private int getCantProduct(int productId) {
        for (ProductOrder p : productsOrder) {
            if (!"S".equals(p.getEsPromocion()) && p.getCodigoPrestacion() == productId) {
                return p.getCantidad();
            }
        }
        return 1;
    }

    private int getCantidadRegalo(int cantOrden, Integer multiplo, int cantRegalo) {
        if (multiplo == null || multiplo == 0) {
            return cantRegalo;
        } else {
            double r = cantOrden / multiplo;
            int cant = (int) r;
            return cantRegalo * cant;
        }
    }

    private void showPromotion(List<String> promotions, String productName) {
        final View view = getLayoutInflater().inflate(R.layout.promotion, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(OrderProductsActivity.this).create();
        alertDialog.setTitle("Promoción");
        alertDialog.setCancelable(false);

        ListView lbPromotions = (ListView) view.findViewById(R.id.lv_promotions);

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, promotions);

        lbPromotions.setAdapter(itemsAdapter);

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });

        alertDialog.setView(view);
        alertDialog.show();
    }

    private List<ProductOrder> getProductsInactive(List<ProductOrder> original, List<ProductOrder> products) {
        List<ProductOrder> productsInactive = new ArrayList<>();
        boolean exist = false;
        for (ProductOrder p : original) {

            for (ProductOrder pr : products) {
                if (p.getCodigoPrestacion() == pr.getCodigoPrestacion()) {
                    exist = true;
                }
            }
            if (!exist) {
                p.setEsActivo("N");
                for (ProductOrder free : p.getLstDafDetallesOrden()) {
                    free.setEsActivo("N");
                }
                productsInactive.add(p);
            }
        }

        return productsInactive;
    }

    private List<ProductOrder> getFreeProductsInactive(int productId, List<ProductOrder> products) {
        List<ProductOrder> productsInactive = new ArrayList<>();
        for (ProductOrder f : productOrderOriginal) {
            if (productId == f.getCodigoPrestacion()) {
                productsInactive = getProductsInactive(f.getLstDafDetallesOrden(), products);
                break;
            }
        }
        return productsInactive;
    }

    private void callUpdateOrderWS(final Order order) {
        Order orderU = order;

        if (isEdit) {
            for (ProductOrder pr : orderU.getLsDafDetallesOrdens()) {
                pr.setLineaDetalle(null);
            }
        }



        numOrder = orderU.getNumeroOrden();
        Call<OrderResponse> response = App.servicesOrder.updateOrder(orderU);
        progressDialog = Util.barraCargando(this, "Enviando Orden Editada...");


        response.enqueue(new Callback<OrderResponse>() {
            @Override
            public void onResponse(Call<OrderResponse> call, Response<OrderResponse> response) {
                progressDialog.dismiss();
                OrderResponse orderResponse = response.body();
                codigoHttp = response.code();
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
                    showToast("Ocurrió un error, No se obtuvo respuesta del servicio de ordenes");
                    goToMain();
                    return;
                }
                String message = orderResponse.getMensaje();

                if ("OK".equals(message)) {

                    if ("S".equals(orderResponse.getAprobada())) {
                        order.setApproved(true);
                        numOrder = order.getNumeroOrden();
                        messageOrder = "El pedido " + order.getNumeroOrden() + " fue actualizado y aprobado de manera exitosa";
                    } else {
                        order.setApproved(false);
                        numOrder = order.getNumeroOrden();
                        messageOrder = "Se actualizo el pedido " + order.getNumeroOrden() + " , sin embargo no fue aprobado por incumplir las siguientes políticas:\n" + orderResponse.getObservaciones();
                    }
                    order.setState("ON");
                    saveOrder(order);
                } else {
                    messageOrder = "Falló la actualización del pedido, inténtelo mas tarde. mensaje obtenido: " + message;
                    goToMain();
                }


            }

            @Override
            public void onFailure(Call<OrderResponse> call, Throwable t) {
                order.setState("OFF");
                progressDialog.dismiss();
                messageOrder = "El pedido no pudo ser editado por problemas de conexión, intente mas tarde";
                showToast("Ocurrió un error, por favor verifique su acceso a internet");
                goToMain();
            }
        });
    }

    private void showDialogFinalize() {
        Order order = new Order();

        final View view = getLayoutInflater().inflate(R.layout.finalize_order, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(OrderProductsActivity.this).create();
        alertDialog.setTitle("Finalizar Orden");
        alertDialog.setIcon(R.drawable.finall);
        alertDialog.setCancelable(false);

        etDeliverDate = (EditText) view.findViewById(R.id.et_deliver_date);
        etPayDate = (EditText) view.findViewById(R.id.et_pay_date);
        final EditText etObservations = (EditText) view.findViewById(R.id.et_observations);


        Log.e("RECIBO", "EMPRESA EN DIAS ---> " + getValueOfPreferencesUser(App.KEY_DIAS_PEDIDO));
        Log.e("RECIBO", "EMPRESA EN DIAS ---> " + EmpresaPermiseDias);


        Calendar calendarCRE = Calendar.getInstance();
        calendarCRE.add(Calendar.DAY_OF_YEAR, OrderClientActivity.account.getDiasPlazo());

        Calendar calendarCON = Calendar.getInstance();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, getValueOfPreferencesUser(App.KEY_DAYS_ORDER, 2));


        order.setCodigoTipoOrden(OrderClientActivity.client.getPaymentType());

        Log.e("RECIBO TIPO PAGO", "TIPO DE PAGO POR ACA---> " + OrderClientActivity.client.getPaymentType());


        if (OrderClientActivity.client.getPaymentType().equals("CON")) {


            if (EmpresaPermiseDias.equals("N") || (EmpresaPermiseDias.equals("S") && PermiteDias.equals("N"))) {

                Log.e("PERMITE DIAS", " PERMITE DIAS " + PermiteDias);
                Log.e("RECIBO TIPO PAGO", "TIPO DE PAGO POR ACA DE TIPO CON !!---> " + OrderClientActivity.client.getPaymentType());

                etPayDate.setText(dateFormat.format(calendar.getTime()));
                etDeliverDate.setText(dateFormat.format(calendarCON.getTime()));

                etDeliverDate.setEnabled(false);


            } else if (EmpresaPermiseDias.equals("S") && PermiteDias.equals("S")) {

                etPayDate.setText(dateFormat.format(calendar.getTime()));
                etDeliverDate.setText(dateFormat.format(calendarCON.getTime()));


            }
        }


        if (OrderClientActivity.client.getPaymentType().equals("CRE")) {

            if (EmpresaPermiseDias.equals("N") || (EmpresaPermiseDias.equals("S") && PermiteDias.equals("N"))) {


                etPayDate.setText(dateFormat.format(calendar.getTime()));
                etDeliverDate.setText(dateFormat.format(calendarCRE.getTime()));
                etDeliverDate.setEnabled(false);


            } else if (EmpresaPermiseDias.equals("S") && PermiteDias.equals("S")) {

                etPayDate.setText(dateFormat.format(calendar.getTime()));
                etDeliverDate.setText(dateFormat.format(calendarCRE.getTime()));


            }


        }


        etDeliverDate.setOnClickListener(OrderProductsActivity.this);
        etPayDate.setOnClickListener(OrderProductsActivity.this);

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
                try {
                    sendOrder(etDeliverDate.getText().toString(), etPayDate.getText().toString(), etObservations.getText().toString(), OrderClientActivity.codigoLocalidad);
                } catch (Exception e) {
                    Dialog.dialogo("Servicio de Pedidos", "Problema al intentar enviar pedido, contacte al administrador. \nError: " + e.getMessage() + "", OrderProductsActivity.this);
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

    private void showDialogDate(final boolean isDateDeliver, String date) {
        int month, day, year;

        if (date.isEmpty()) {
            day = 1;
            month = 0;
            year = 1999;
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

                        if (isDateDeliver) {
                            etDeliverDate.setText(day + "/" + month + "/" + selectedYear);
                        } else {
                            etPayDate.setText(day + "/" + month + "/" + selectedYear);
                        }
                    }
                };
        DatePickerDialog d = new DatePickerDialog(OrderProductsActivity.this, datePickerListener, year, month, day);
        d.show();
    }

    private void showDialogProductDiscounts(final Product productSelect,final ProductOrder productOrderSelect, final int positionProduct){

        final View view = getLayoutInflater().inflate(R.layout.product_discounts, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(OrderProductsActivity.this).create();
        alertDialog.setCancelable(false);



        final TextView txvNombreProducto = (TextView) view.findViewById(R.id.txvNombreProducto);
        txvNombreProducto.setText(productSelect.getName());

        final LinearLayout llCheckRules = (LinearLayout) view.findViewById(R.id.ll_check_rules);
        final CheckBox checkApplyRules = (CheckBox) view.findViewById(R.id.ch_apply_rules);

        if(mostrarCheckAplicaRulesOrdenesPedido.equalsIgnoreCase("S")){
            checkApplyRules.setVisibility(View.VISIBLE);
        }else{
            checkApplyRules.setVisibility(View.GONE);
        }


        Integer prom = searchPromotions();
        if(prom < 1){
            checkApplyRules.setEnabled(false);
        }


        final LinearLayout llRulesId = (LinearLayout) view.findViewById(R.id.ll_rules_id);
        final TextView txvRuleId = (TextView) view.findViewById(R.id.tv_rule_id);

        final LinearLayout llDiscountsRules = (LinearLayout) view.findViewById(R.id.ll_discounts_xrules);
        final EditText edtRulesDiscount = (EditText) view.findViewById(R.id.edt_rules_discount);

        final LinearLayout llValueRules = (LinearLayout) view.findViewById(R.id.ll_value_xrules);
        final EditText edtValueRules = (EditText) view.findViewById(R.id.edt_rules_values);

        final LinearLayout llDiscountsManual = (LinearLayout) view.findViewById(R.id.ll_discounts_manual);
        final EditText edtDiscountsManual = (EditText) view.findViewById(R.id.edt_manual_discounts);

        final LinearLayout llValueManual = (LinearLayout) view.findViewById(R.id.ll_value_manual);
        final EditText edtValueManual = (EditText) view.findViewById(R.id.edt_manual_value);

        final LinearLayout llTotalDiscounts = (LinearLayout) view.findViewById(R.id.ll_total_discount);
        final EditText edtTotalPercent = (EditText) view.findViewById(R.id.edt_total_discounts_percent);
        final EditText edtTotalDiscounts = (EditText) view.findViewById(R.id.edt_total_discounts);


        calculateManualDiscout(productOrderSelect, edtDiscountsManual);


        if(!mostrarValoresXRulesOrdenesPedidos.equalsIgnoreCase("S")){
            llDiscountsRules.setVisibility(View.GONE);
            llValueRules.setVisibility(View.GONE);
            llRulesId.setVisibility(View.GONE);
        }




        edtRulesDiscount.setEnabled(false);
        edtValueRules.setEnabled(false);

        Log.e("APLICA","CONFIRMA LA CONFIRMACION PARA CONFIRMAR PARA VER SI APLICA "+productSelect.getAplicaDescuentoManual());
        Log.e("RULES","CONFIRMA LA CONFIRMACION PARA CONFIRMAR PARA VER SI APLICA "+productOrderSelect.getAplicaXRules());

        if(productSelect.getAplicaDescuentoManual().equalsIgnoreCase("N")){
            edtDiscountsManual.setEnabled(false);
            edtValueManual.setEnabled(false);
        }


        if(productOrderSelect.getAplicaXRules().equalsIgnoreCase("S") && productOrderSelect.getValorDescuentoManual() != null){



            checkApplyRules.setChecked(true);
            boo = true;
            txvRuleId.setText(String.valueOf(productOrderSelect.getCodigoReglaNegocio()));
            edtRulesDiscount.setText(String.valueOf(format(productOrderSelect.getPorcentajeDescuentoXRules(),6)));
            edtValueRules.setText(String.valueOf(format(productOrderSelect.getValorDescuentoXRules(),2)));
            edtValueManual.setText(String.valueOf(format(productOrderSelect.getValorDescuentoManual(),6)));
            edtDiscountsManual.setText(String.valueOf(format(productOrderSelect.getPorcentajeDescuentoManual(),6)));

        }else if(productOrderSelect.getAplicaXRules().equalsIgnoreCase("S")){

            checkApplyRules.setChecked(true);
            boo = true;
            txvRuleId.setText(String.valueOf(productOrderSelect.getCodigoReglaNegocio()));
            edtRulesDiscount.setText(String.valueOf(format(productOrderSelect.getPorcentajeDescuentoXRules(),6)));
            edtValueRules.setText(String.valueOf(format(productOrderSelect.getValorDescuentoXRules(),2)));

        }else if(productOrderSelect.getValorDescuentoManual() != null && productOrderSelect.getValorDescuentoManual() != 0){

            edtValueManual.setText(String.valueOf(format(productOrderSelect.getValorDescuentoManual(),6)));
            edtDiscountsManual.setText(String.valueOf(format(productOrderSelect.getPorcentajeDescuentoManual(),6)));

        }else{

            txvRuleId.setText("0");


        }

        if(productOrderSelect.getValorDescuento() != null && productOrderSelect.getValorDescuento() != 0.0){
            edtTotalPercent.setText(String.valueOf(productOrderSelect.getPorcentajeDescuento()));
            edtTotalDiscounts.setText(String.valueOf(productOrderSelect.getValorDescuento()));
        }else{
            edtTotalPercent.setText("");
            edtTotalDiscounts.setText("");
        }

        if(productOrderSelect.getCodigoReglaNegocio() != null){
            checkApplyRules.setEnabled(true);
        }else{
            checkApplyRules.setEnabled(false);
        }


        edtDiscountsManual.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                double douTotal = 0;
                double douTotalDiscount = 0;

                if(edtDiscountsManual.getText() != null && !edtDiscountsManual.getText().toString().equalsIgnoreCase("") && !edtDiscountsManual.getText().toString().equalsIgnoreCase("0.00")){
                    if(Double.parseDouble(edtDiscountsManual.getText().toString()) > discountForProduct){
                        errorMessage(discountForProduct);

                        edtDiscountsManual.setText("");
                        edtValueManual.setText("");

                        if(edtValueRules.getText() != null && !edtValueRules.getText().toString().equalsIgnoreCase("")){
                            douTotal = douTotal + Double.parseDouble(edtValueRules.getText().toString());
                            douTotalDiscount = Double.parseDouble(edtRulesDiscount.getText().toString());

                            edtTotalDiscounts.setText(String.valueOf(douTotal));
                            edtTotalPercent.setText(String.valueOf(format(douTotalDiscount,6)));
                        }else{

                            edtTotalDiscounts.setText("");
                            edtTotalPercent.setText("");

                        }



                    }else{
                        double douDisc;
                        double douSubTotal = productOrderSelect.getCantidad() * productSelect.getPrice();

                        douDisc = douSubTotal * (Double.parseDouble(edtDiscountsManual.getText().toString()) / 100);
                        edtValueManual.setText(String.valueOf(format(douDisc,2)));


                        if(edtValueRules.getText() == null || edtValueRules.getText().toString().equalsIgnoreCase("") || !boo){
                            douTotal = douTotal + douDisc;
                            douTotalDiscount = douTotalDiscount + Double.parseDouble(edtDiscountsManual.getText().toString());
                        }else{
                            douTotal = douDisc + Double.parseDouble(edtValueRules.getText().toString());
                            douTotalDiscount = Double.parseDouble(edtDiscountsManual.getText().toString()) + Double.parseDouble(edtRulesDiscount.getText().toString());
                        }
                        edtTotalDiscounts.setText(String.valueOf(douTotal));
                        edtTotalPercent.setText(String.valueOf(format(douTotalDiscount,6)));

                    }
                }else{
                    edtValueManual.setText("");
                    if(edtValueRules.getText() != null && !edtValueRules.getText().toString().equalsIgnoreCase("")){
                        douTotal = douTotal + Double.parseDouble(edtValueRules.getText().toString());
                        douTotalDiscount = Double.parseDouble(edtRulesDiscount.getText().toString());

                        edtTotalDiscounts.setText(String.valueOf(douTotal));
                        edtTotalPercent.setText(String.valueOf(format(douTotalDiscount,6)));
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        checkApplyRules.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {



                double douTotal = 0;
                double douTotalDiscount = 0;

                if(!isChecked){

                    boo = false;

                    if(edtDiscountsManual.getText() != null && !edtDiscountsManual.getText().toString().equalsIgnoreCase("")){


                        douTotal = douTotal + Double.parseDouble(edtValueManual.getText().toString());
                        douTotalDiscount = douTotalDiscount + Double.parseDouble(edtDiscountsManual.getText().toString());

                        edtTotalDiscounts.setText(String.valueOf(douTotal));
                        edtTotalPercent.setText(String.valueOf(format(douTotalDiscount,6)));


                    }else{

                        edtTotalDiscounts.setText("0");
                        edtTotalPercent.setText("0");

                    }

                }else{

                    boo = true;


                    edtRulesDiscount.setText(String.valueOf(productOrderSelect.getPorcentajeDescuentoXRules()));
                    edtValueRules.setText(String.valueOf(productOrderSelect.getValorDescuentoXRules()));
                    txvRuleId.setText(String.valueOf(productOrderSelect.getCodigoReglaNegocio()));

                    if((edtValueManual.getText().toString() != null && !edtValueManual.getText().toString().equalsIgnoreCase("") && !edtValueManual.getText().toString().equalsIgnoreCase("0.00")) && (edtValueRules.getText().toString() != null && !edtValueRules.getText().toString().equalsIgnoreCase(""))){
                        douTotal = Double.parseDouble(edtValueManual.getText().toString()) + Double.parseDouble(edtValueRules.getText().toString());
                        douTotalDiscount = Double.parseDouble(edtDiscountsManual.getText().toString()) + Double.parseDouble(edtRulesDiscount.getText().toString());


                    }else if(edtValueManual.getText().toString() != null && !edtValueManual.getText().toString().equalsIgnoreCase("") && !edtValueManual.getText().toString().equalsIgnoreCase("0.00")){

                        douTotal = douTotal + Double.parseDouble(edtValueManual.getText().toString());
                        douTotalDiscount = douTotalDiscount + Double.parseDouble(edtDiscountsManual.getText().toString());

                    }else if(edtValueRules.getText().toString() != null && !edtValueRules.getText().toString().equalsIgnoreCase("") && !edtValueRules.getText().toString().equalsIgnoreCase("0.00")){

                        douTotal = douTotal + Double.parseDouble(edtValueRules.getText().toString());
                        douTotalDiscount = douTotalDiscount + Double.parseDouble(edtRulesDiscount.getText().toString());

                    }

                    edtTotalDiscounts.setText(String.valueOf(douTotal));
                    edtTotalPercent.setText(String.valueOf(format(douTotalDiscount,6)));



                }
            }
        });





        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (edtTotalDiscounts.getText() != null && !edtTotalDiscounts.getText().toString().equalsIgnoreCase("")) {
                    if(edtDiscountsManual.getText() != null && !edtDiscountsManual.getText().toString().equalsIgnoreCase("")){
                        if (Double.parseDouble(edtTotalDiscounts.getText().toString()) > 100) {
                            errorMessage(discountForProduct);
                        } else if (Double.parseDouble(edtDiscountsManual.getText().toString()) > discountForProduct && productSelect.getAplicaDescuentoManual().equalsIgnoreCase("S")) {
                            errorMessage(discountForProduct);
                        } else {
                            productsOrder.get(positionProduct).setPorcentajeDescuento(Double.parseDouble(edtTotalPercent.getText().toString()));
                            productsOrder.get(positionProduct).setValorDescuento(Double.parseDouble(edtTotalDiscounts.getText().toString()));

                            if (edtRulesDiscount.getText() != null && !edtRulesDiscount.getText().toString().equalsIgnoreCase("")) {
                                productsOrder.get(positionProduct).setPorcentajeDescuentoXRules(Double.parseDouble(edtRulesDiscount.getText().toString()));
                            }

                            if (edtValueRules.getText() != null && !edtValueRules.getText().toString().equalsIgnoreCase("")) {
                                productsOrder.get(positionProduct).setValorDescuentoXRules(Double.parseDouble(edtValueRules.getText().toString()));
                            }

                            if (edtDiscountsManual.getText() != null && !edtDiscountsManual.getText().toString().equalsIgnoreCase("")) {
                                productsOrder.get(positionProduct).setPorcentajeDescuentoManual(Double.parseDouble(edtDiscountsManual.getText().toString()));
                            }

                            if (edtValueManual.getText() != null && !edtValueManual.getText().toString().equalsIgnoreCase("")) {
                                productsOrder.get(positionProduct).setValorDescuentoManual(Double.parseDouble(edtValueManual.getText().toString()));
                            }


                            double subTotalProduct = productOrderSelect.getCantidad() * productSelect.getPrice();

                            double subtotalDiscount = subTotalProduct - productsOrder.get(positionProduct).getValorDescuento();
                            double ivaXProducto = 0;
                            double totalXProduct;


                            if ("S".equals(productSelect.getAplicaIva())) {

                                ivaXProducto = subtotalDiscount * productOrderSelect.getPorcentajeIva();
                            }


                            totalXProduct = subtotalDiscount + ivaXProducto;

                            productsOrder.get(positionProduct).setValorIva(ivaXProducto);
                            productsOrder.get(positionProduct).setSubtotalVenta(subTotalProduct);
                            productsOrder.get(positionProduct).setSubtotalBaseImponible(subtotalDiscount);
                            productsOrder.get(positionProduct).setValorTotal(totalXProduct);

                            if (!boo) {
                                productsOrder.get(positionProduct).setAplicaXRules("N");
                            } else {
                                productsOrder.get(positionProduct).setAplicaXRules("S");
                            }


                            discount = 0;

                            subtotal = 0;

                            total = 0;

                            iva = 0;

                            double subBaseImponible = 0;

                            for (ProductOrder productOrder1 : productsOrder) {
                                iva += productOrder1.getValorIva();
                                if(productOrder1.getValorDescuento() != null && !productOrder1.getEsPromocion().equalsIgnoreCase("S")){
                                    discount += productOrder1.getValorDescuento();
                                }

                                subBaseImponible += productOrder1.getSubtotalBaseImponible();
                                if (!productOrder1.getEsPromocion().equalsIgnoreCase("S")) {
                                    subtotal += productOrder1.getSubtotalVenta();
                                }
                            }


                            total = subBaseImponible + iva;


                            setValuesToView();

                            adapter.notifyDataSetChanged();
                        }
                    }

                }


            }
        });



        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });

        alertDialog.setView(view);
        alertDialog.show();

    }


    private void errorMessage(Double douDescuento){



        new AlertDialog.Builder(OrderProductsActivity.this)
                .setTitle("Atención")

                .setMessage("El porcentaje Descuento manual no puede superar el limite del "+douDescuento+"%.")
                .setIcon(R.drawable.error)
                .setPositiveButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).show();
    }

    private void calculateManualDiscout(ProductOrder productOrder, final EditText edtDiscountsManual){

        Call<DiscountManualResponse> response = App.servicesOrder.discountResponse(companyCode,productOrder.getCodigoPrestacion(),OrderClientActivity.client.getId(),App.userSequence);
        progressDialog = Util.barraCargando(this, "Calculando...");
        final DiscountManualResponse discountManual = new DiscountManualResponse();

        response.enqueue(new Callback<DiscountManualResponse>() {
            @Override
            public void onResponse(Call<DiscountManualResponse> call, Response<DiscountManualResponse> response) {
                progressDialog.dismiss();
                DiscountManualResponse discountManualResponse = response.body();
                if (discountManualResponse == null) {
                    Gson gson = new Gson();
                    TypeAdapter<DiscountManualResponse> adapter = gson.getAdapter(DiscountManualResponse.class);
                    try {
                        if (response.errorBody() != null)
                            discountManualResponse =
                                    adapter.fromJson(
                                            response.errorBody().string());
                    } catch (IOException e) {
                    }
                }

                assert discountManualResponse != null;
                discountManual.setValorDescuento(discountManualResponse.getValorDescuento());
                discountManual.setMensaje(discountManualResponse.getMensaje());

                discountForProduct = discountManual.getValorDescuento();

                Log.e("APLICA","CONFIRMA LA CONFIRMACION PARA CONFIRMAR PARA VER EL VALOR "+discountForProduct);

            }

            @Override
            public void onFailure(Call<DiscountManualResponse> call, Throwable t) {
                progressDialog.dismiss();
                showToast("Ocurrió un error, por favor verifique su acceso a internet");
            }
        });


    }


    private void showDialogProduct(final Product productSelect, final int positionProduct) {

        final View view = getLayoutInflater().inflate(R.layout.product_select, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(OrderProductsActivity.this).create();
        alertDialog.setTitle(productSelect.getName());
        alertDialog.setCancelable(false);

        final LinearLayout llBoxes = (LinearLayout) view.findViewById(R.id.ll_boxes);

        final EditText etUnits = (EditText) view.findViewById(R.id.et_units);
        final EditText etBoxes = (EditText) view.findViewById(R.id.et_boxes);

        final TextView tvStock = (TextView) view.findViewById(R.id.tv_stock);
        final TextView tvPrice = (TextView) view.findViewById(R.id.tv_price);
        final Button btnLessC = (Button) view.findViewById(R.id.btn_less_c);
        final Button btnMoreC = (Button) view.findViewById(R.id.btn_more_c);
        final Button btnLessU = (Button) view.findViewById(R.id.btn_less_u);
        final Button btnMoreU = (Button) view.findViewById(R.id.btn_more_u);
        LinearLayout llStock = (LinearLayout) findViewById(R.id.ll_stock);

        getValueOfPreferencesUser(App.KEY_DISCOUNT, "N");
        if ("S".equals(getValueOfPreferencesUser(App.KEY_DISCOUNT, "N"))) {

            boolean value = false;
            boolean percent = false;
            if ("S".equals(getValueOfPreferencesUser(App.KEY_DISCOUNT_VALUE, "N"))) {
                RadioButton rb = view.findViewById(R.id.dollar);
                rb.setVisibility(View.VISIBLE);
                value = true;
            }
            if ("S".equals(getValueOfPreferencesUser(App.KEY_DISCOUNT_PERCENT, "N"))) {
                RadioButton rb = view.findViewById(R.id.percent);
                rb.setVisibility(View.VISIBLE);
                percent = true;
            }

            if (value || percent) {
                LinearLayout llDiscount = (LinearLayout) view.findViewById(R.id.ll_discounts);
                llDiscount.setVisibility(View.VISIBLE);
                RadioGroup rg = view.findViewById(R.id.rg_discount);
                if (value) {
                    rg.check(R.id.dollar);
                } else if (percent) {
                    rg.check(R.id.percent);
                }
            }
        }

        final EditText etValueDiscount = (EditText) view.findViewById(R.id.et_value);
        final RadioGroup groupDiscount = view.findViewById(R.id.rg_discount);
        if (productSelect.getCodigoExistencia() == null) {
            llStock.setVisibility(View.GONE);
        }

        Log.e("EXISTENCIA","CODIGO EXISTENCIA "+productSelect.getCodigoExistencia());

        Log.e("KEY_USE_EQUIV","KEY_USE_EQUIV "+getValueOfPreferencesUser(App.KEY_USE_EQUIV, ""));


        boolean isBoxes = productSelect.getUnidadesXCajas() != null && productSelect.getUnidadesXCajas() > 0;

        if (productSelect.getCodigoExistencia() == null || getValueOfPreferencesUser(App.KEY_USE_EQUIV, "").equals("N")) {
            isBoxes = false;
        }

        Log.e("CAJAS","CAJAS "+productSelect.getUnidadesXCajas());

        //units = 0;
        //boxes = 1;
        etUnits.setText("" + units);
        etBoxes.setText("" + boxes);
        double iva = 0;
        double price = 0;

        Log.e("BOXES","BOXES "+isBoxes);

        if (isBoxes) {
            llBoxes.setVisibility(View.VISIBLE);
        }
        if ("S".equals(productSelect.getAplicaIva())) {
            iva = productSelect.getPrice() * productSelect.getPorcentajeIva();
        }
        price = productSelect.getPrice() + iva;

        tvStock.setText("" + productSelect.getStock());
        tvPrice.setText("" + df.format(price));
        final boolean isBoxesF = isBoxes;
        btnLessU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (units > 0) {
                    units--;
                    etUnits.setText("" + units);
                }
            }
        });
        btnMoreU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                units++;
                etUnits.setText("" + units);
            }
        });

        btnLessC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boxes > 0) {
                    boxes--;
                    etBoxes.setText("" + boxes);
                }
            }
        });
        btnMoreC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boxes++;
                etBoxes.setText("" + boxes);

            }
        });

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if(strElimPromAutomatica.equalsIgnoreCase("S")){

                    int bandera = searchPromotions();
                    if(bandera > 0){


                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(OrderProductsActivity.this);
                        alertDialogBuilder.setTitle("Ordén");
                        alertDialogBuilder.setIcon(R.drawable.error);
                        alertDialogBuilder.setMessage("La Orden de Pedido tiene Promociones Automáticas que se quitarán y tendrán que ser evaluadas nuevamente. ¿Desea continuar?");
                        alertDialogBuilder.setPositiveButton("Aceptar",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {


                                        units = getIntString(etUnits.getText().toString());

                                        int cant = 0;
                                        if (isBoxesF) {
                                            boxes = getIntString(etBoxes.getText().toString());
                                            cant = boxes * productSelect.getUnidadesXCajas();
                                        }
                                        cant = cant + units;


                                        if (cant < 1) {
                                            showToast(" Ingresa la cantidad de productos que quieres agregar ");
                                        } else {

                                            double percent = 0;
                                            double value = getDoubleString(etValueDiscount.getText().toString());
                                            if (value != 0) {
                                                if (groupDiscount.getCheckedRadioButtonId() == R.id.dollar) {
                                                    percent = (100 * value) / (cant * productSelect.getPrice());
                                                } else if (groupDiscount.getCheckedRadioButtonId() == R.id.percent) {
                                                    percent = value;
                                                }
                                            }

                                            double subtotal = cant * productSelect.getPrice();
                                            double discount = 0;
                                            double subtotalDiscount = 0;
                                            double iva = 0;
                                            double total = 0;

                                            if (percent > 0) {
                                                discount = (subtotal * percent) / 100;
                                            }


                                            subtotalDiscount = subtotal - discount;



                                            if ("S".equals(productSelect.getAplicaIva())) {
                                                iva = subtotalDiscount * productSelect.getPorcentajeIva();
                                            }


                                            total = subtotalDiscount + iva;

                                            productsOrder.get(positionProduct).setValorDescuento(discount);
                                            productsOrder.get(positionProduct).setSubtotalBaseImponible(subtotalDiscount);
                                            productsOrder.get(positionProduct).setValorIva(iva);
                                            productsOrder.get(positionProduct).setValorTotal(total);
                                            productsOrder.get(positionProduct).setCantidad(cant);
                                            productsOrder.get(positionProduct).setUnits(units);
                                            productsOrder.get(positionProduct).setBoxes(boxes);

                                            removePromotions();
                                            removeFree();

                                            adapter = new ProductOrderAdapter(OrderProductsActivity.this, R.layout.item_product_order, productsOrder);
                                            lvProductsOrder.setAdapter(adapter);

                                            recalculate();
                                            setValuesToView();

                                            adapter.notifyDataSetChanged();


                                        }
                                    }
                                }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });

                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                        alertDialog.setCancelable(true);


                    }else{


                        units = getIntString(etUnits.getText().toString());

                        int cant = 0;
                        if (isBoxesF) {
                            boxes = getIntString(etBoxes.getText().toString());
                            cant = boxes * productSelect.getUnidadesXCajas();
                        }
                        cant = cant + units;


                        if (cant < 1) {
                            showToast(" Ingresa la cantidad de productos que quieres agregar ");
                        } else {

                            double percent = 0;
                            double value = getDoubleString(etValueDiscount.getText().toString());
                            if (value != 0) {
                                if (groupDiscount.getCheckedRadioButtonId() == R.id.dollar) {
                                    percent = (100 * value) / (cant * productSelect.getPrice());
                                } else if (groupDiscount.getCheckedRadioButtonId() == R.id.percent) {
                                    percent = value;
                                }
                            }

                            double subtotal = cant * productSelect.getPrice();
                            double discount = 0;
                            double subtotalDiscount = 0;
                            double iva = 0;
                            double total = 0;

                            if (percent > 0) {
                                discount = (subtotal * percent) / 100;
                            }else{
                                if(productsOrder.get(positionProduct).getValorDescuento() != null){
                                    if(productsOrder.get(positionProduct).getValorDescuento() > 0){
                                        discount = productsOrder.get(positionProduct).getValorDescuento();
                                    }
                                }
                            }


                            subtotalDiscount = subtotal - discount;



                            if ("S".equals(productSelect.getAplicaIva())) {
                                iva = subtotalDiscount * productSelect.getPorcentajeIva();
                            }


                            total = subtotalDiscount + iva;

                            productsOrder.get(positionProduct).setValorDescuento(discount);
                            productsOrder.get(positionProduct).setSubtotalBaseImponible(subtotalDiscount);
                            productsOrder.get(positionProduct).setValorIva(iva);
                            productsOrder.get(positionProduct).setValorTotal(total);
                            productsOrder.get(positionProduct).setCantidad(cant);
                            productsOrder.get(positionProduct).setUnits(units);
                            productsOrder.get(positionProduct).setBoxes(boxes);

                            adapter = new ProductOrderAdapter(OrderProductsActivity.this, R.layout.item_product_order, productsOrder);
                            lvProductsOrder.setAdapter(adapter);



                            recalculate();
                            setValuesToView();

                            adapter.notifyDataSetChanged();

                        }

                    }

                }else{
                    units = getIntString(etUnits.getText().toString());

                    int cant = 0;
                    if (isBoxesF) {
                        boxes = getIntString(etBoxes.getText().toString());
                        cant = boxes * productSelect.getUnidadesXCajas();
                    }
                    cant = cant + units;

                /*if (cant > productSelect.getStock()) {
                    showToastL(" Stock insuficiente ");
                } else */
                    if (cant < 1) {
                        showToast(" Ingresa la cantidad de productos que quieres agregar ");
                    } else {

                        double percent = 0;
                        double value = getDoubleString(etValueDiscount.getText().toString());
                        if (value != 0) {
                            if (groupDiscount.getCheckedRadioButtonId() == R.id.dollar) {
                                percent = (100 * value) / (cant * productSelect.getPrice());
                            } else if (groupDiscount.getCheckedRadioButtonId() == R.id.percent) {
                                percent = value;
                            }
                        }

                        double subtotal = cant * productSelect.getPrice();
                        double discount = 0;
                        double subtotalDiscount = 0;
                        double iva = 0;
                        double total = 0;

                        if (percent > 0) {
                            discount = (subtotal * percent) / 100;
                        }else if(productsOrder.get(positionProduct).getValorDescuento() > 0){
                            discount = (subtotal * (productsOrder.get(positionProduct).getPorcentajeDescuento() / 100));
                        }


                        subtotalDiscount = subtotal - discount;



                        if ("S".equals(productSelect.getAplicaIva())) {
                            iva = subtotalDiscount * productSelect.getPorcentajeIva();
                        }


                        total = subtotalDiscount + iva;

                        productsOrder.get(positionProduct).setSubtotalVenta(subtotal);
                        productsOrder.get(positionProduct).setValorDescuento(discount);
                        productsOrder.get(positionProduct).setSubtotalBaseImponible(subtotalDiscount);
                        productsOrder.get(positionProduct).setValorIva(iva);
                        productsOrder.get(positionProduct).setValorTotal(total);
                        productsOrder.get(positionProduct).setCantidad(cant);
                        productsOrder.get(positionProduct).setUnits(units);
                        productsOrder.get(positionProduct).setBoxes(boxes);
                        productsOrder.get(positionProduct).setCantidadEnUnidades(units);
                        productsOrder.get(positionProduct).setCantidadEnCajas(boxes);

                        adapter = new ProductOrderAdapter(OrderProductsActivity.this, R.layout.item_product_order, productsOrder);
                        lvProductsOrder.setAdapter(adapter);



                        recalculate();
                        setValuesToView();

                        adapter.notifyDataSetChanged();


                    }
                }



            }
        });

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });

        alertDialog.setView(view);
        alertDialog.show();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_search:
                goToSearch();
                break;
            case R.id.ll_client:
                break;
            case R.id.btn_finalize:
                if (adapter.getCount() == 0) {
                    showToast("Ingresa los productos para este pedido");
                } else {
                    showDialogFinalize();
                }
                break;
            case R.id.et_deliver_date:
                showDialogDate(true, "" + etDeliverDate.getText());

                break;
            case R.id.et_pay_date:
                showDialogDate(false, "" + etPayDate.getText());
                break;
            default:
                break;
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_product, menu);


        if(mostrarValorDescuentoManual.equalsIgnoreCase("N")){
            menu.getItem(0).setVisible(false);
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();




        switch (item.getItemId()) {
            case R.id.item_remove:
                ProductOrder po = productsOrder.get(info.position);
                if (!"S".equals(po.getEsPromocion())) {

                    removeProduct(po, info.position);

                    removeFree();
                    adapter.notifyDataSetChanged();
                    /*if(strValidaXRules.equalsIgnoreCase("S")){
                        int pos = productsOrder.size() - 1;
                           po = productsOrder.get(pos);
                          removeProduct(po, pos);
                          adapter.notifyDataSetChanged();
                    /*    promo(po.getCodigoPrestacion(), po.getCantidad(), po.getPrecioUnitarioVenta(),
                                po.getPorcentajeIva(), po.getGroup(), po.getSubGroup(),
                                po.getProvider(), po.getArticle(), 0); */
                  /*   if (!productsOrder.isEmpty()) {

                    } */
                    //int pos = productsOrder.size() -1;
                    // po = productsOrder.get(pos);
                    // removeProduct(po, pos);
                   /*     callPromotions(po.getCodigoPrestacion(), po.getCantidad(), po.getPrecioUnitarioVenta(),
                                po.getPorcentajeIva(), po.getGroup(), po.getSubGroup(),
                                po.getProvider(), po.getArticle(), 0); */
                    // }
                 /*   }else{

                    }*/




                }
                return true;
            case R.id.item_discounts:
                ProductOrder poo = productsOrder.get(info.position);
                showDialogProductDiscounts(UtilDB.getProduct(realm, poo.getCodigoPrestacion(), OrderClientActivity.account.getnDivision(), OrderClientActivity.client.getVersion()),poo,info.position);
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void removeProduct(ProductOrder po, int position) {
        if (!"S".equals(po.getEsPromocion())) {
            subtotal = subtotal - po.getSubtotalVenta();
            iva = iva - po.getValorIva();
            total = total - po.getValorTotal();
            if(po.getValorDescuento() != null && po.getValorDescuento() > 0){
                discount = discount - po.getValorDescuento();
            }
        }


        int id = po.getCodigoPrestacion();
        productsOrder.remove(position);
        po.setEsActivo("S");
        removeProductsRelation(id);
        setValuesToView();
    }

    private void removeProductsRelation(int id) {
        List<Integer> index = new ArrayList<>();

        for (int i = 0; i < productsOrder.size(); i++) {
            if (productsOrder.get(i).getProductRelation() != null && productsOrder.get(i).getProductRelation() == id) {
                index.add(i);
            }
        }
        for (int position : index) {
            try {
                productsOrder.remove(position);
            } catch (Exception e) {
                showToast("El Pedido No se Enviara sin Productos");
            }
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if(!isEdit){
                    if(productsOrder.size() == 0){
                        Intent intent = new Intent(this, OrderClientActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        overridePendingTransition(R.animator.left_to_right, R.animator.right_to_left);
                    }else{
                        validaLimpiarLista();
                    }
                }else{
                    Intent intent = new Intent(this, OrderClientActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    overridePendingTransition(R.animator.left_to_right, R.animator.right_to_left);
                }



            default:
                return super.onOptionsItemSelected(item);
        }
    }





    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (realm != null) {
            realm.close();
        }
        util = null;
    }


    public void recalculate(){
        discount = 0;

        subtotal = 0;

        total = 0;

        iva = 0;

        double subBaseImponible = 0;

        for(ProductOrder productOrder1: productsOrder){
            iva += productOrder1.getValorIva();

            subBaseImponible += productOrder1.getSubtotalBaseImponible();
            if(!productOrder1.getEsPromocion().equalsIgnoreCase("S")){
                subtotal += productOrder1.getSubtotalVenta();
                if(productOrder1.getValorDescuento() != null && productOrder1.getValorDescuento() > 0){
                    discount += productOrder1.getValorDescuento();
                }

            }
        }


        total = subBaseImponible + iva;
    }


    private void removeFree() {
        try {
            List<Integer> positions = new ArrayList<>();
            for (int i = 0; i < productsOrder.size(); i++) {
                if ("S".equals(productsOrder.get(i).getEsPromocion())) {
                    positions.add(i);
                }
            }
            Collections.reverse(positions);
            for (Integer pos : positions) {
                ProductOrder po = productsOrder.get(pos);
                removeProduct(po, pos);
            }


            adapter.notifyDataSetChanged();
        } catch (Exception e) {
        }
    }

    @Override
    public void onBackPressed() {

        if(!isEdit){
            if(productsOrder.size() == 0){
                Intent intent = new Intent(this, OrderClientActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                overridePendingTransition(R.animator.left_to_right, R.animator.right_to_left);
            }else{
                validaLimpiarLista();
            }
        }else{
            Intent intent = new Intent(this, OrderClientActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            overridePendingTransition(R.animator.left_to_right, R.animator.right_to_left);
        }

    }



    public void validaLimpiarLista(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(OrderProductsActivity.this);
        alertDialogBuilder.setTitle("Ordén");
        alertDialogBuilder.setIcon(R.drawable.error);
        alertDialogBuilder.setMessage("¿Está seguro de salir de la Ordén? Los items agregados se perderan");
        alertDialogBuilder.setPositiveButton("Aceptar",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        productsOrder.clear();
                        iva = 0;
                        total = 0;
                        subtotal = 0;
                        startActivity(new Intent(getBaseContext(),OrderClientActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                    }
                }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        alertDialog.setCancelable(true);
    }


    public void productosConProblemas(String strMensaje){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(OrderProductsActivity.this);
        alertDialogBuilder.setTitle("Promociónes");
        alertDialogBuilder.setIcon(R.drawable.error);
        alertDialogBuilder.setMessage(strMensaje);
        alertDialogBuilder.setPositiveButton("Aceptar",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        alertDialog.setCancelable(true);
    }


    public void callPromotionsV2(){
        Order order = prepareOrder();

        if(strValidaXRules.equalsIgnoreCase("S")){
            for(ProductOrder productOrder : order.getLsDafDetallesOrdens()){
                productOrder.setLineaDetalle(null);
            }
        }



        callPromotions(order);

    }

    public String getProductName(int id) {
        try {
            return realm.where(Product.class).equalTo("id", id)
                    .findFirst().getName();
        } catch (Exception e) {
            return "";
        }
    }


    public Integer searchPromotions(){

        int bandera = 0;

        for(ProductOrder productOrder: productsOrder){
            if((productOrder.getEsPromocion() != null)){
                if(productOrder.getValorDescuento() != null){
                    if(productOrder.getEsPromocion().equalsIgnoreCase("S") || productOrder.getValorDescuento() > 0){
                        bandera++;
                    }
                }else if(productOrder.getEsPromocion().equalsIgnoreCase("S")){
                    bandera++;
                }


            }
        }
        return bandera;
    }



    public void removePromotions(){




        discount = 0;
        total = 0;
        subtotal = 0;
        iva = 0;

        for(ProductOrder productOrder : productsOrder){

            if(!productOrder.getEsPromocion().equalsIgnoreCase("S")){

                productOrder.setCodigoReglaNegocio(null);
                productOrder.setPorcentajeDescuentoXRules(0.00);
                productOrder.setValorDescuentoXRules(0);

                if(productOrder.getValorDescuentoManual() != 0.0){
                    productOrder.setValorDescuento(productOrder.getValorDescuentoManual());
                    productOrder.setPorcentajeDescuento(productOrder.getPorcentajeDescuentoManual());
                }else{
                    productOrder.setPorcentajeDescuentoManual(0.00);
                    productOrder.setValorDescuentoManual(0.00);
                }




                productOrder.setAplicaXRules("N");

                double total = 0;
                double subtotal = 0;
                double iva = 0;
                double subtotalDiscount = 0;



                subtotal = productOrder.getCantidad() * productOrder.getPrecioUnitarioVenta();
                if(productOrder.getPorcentajeDescuentoManual() != 0){
                    subtotalDiscount = subtotal - productOrder.getValorDescuentoManual();
                    iva = subtotalDiscount * productOrder.getPorcentajeIva();
                    total = subtotalDiscount + iva;
                    productOrder.setValorIva(iva);
                    productOrder.setSubtotalBaseImponible(subtotalDiscount);
                    productOrder.setValorTotal(total);
                }else{
                    iva = subtotal * productOrder.getPorcentajeIva();
                    total = subtotal + iva;
                    productOrder.setValorIva(iva);
                    productOrder.setSubtotalBaseImponible(subtotal);
                    productOrder.setValorTotal(total);
                }




            }





        }

        for(ProductOrder productOrder : productsOrder){

            subtotal += productOrder.getSubtotalBaseImponible();
            iva += productOrder.getValorIva();

        }

        total = subtotal + iva;

        // adapter.notifyDataSetChanged();
    }




}
