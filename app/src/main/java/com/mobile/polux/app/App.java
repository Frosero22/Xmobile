package com.mobile.polux.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.multidex.MultiDexApplication;
import android.support.v7.app.AppCompatDelegate;

import com.google.gson.GsonBuilder;
import com.mobile.polux.models.CashingGuideDetail;
import com.mobile.polux.models.Invoice;
import com.mobile.polux.models.Order;
import com.mobile.polux.service.Services;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by laptoplenovo on 15/5/2018.
 */

public class App extends MultiDexApplication {

    public static Services services;
    //public static Services servicesPromotion;
    public static Services servicesOrder;

    private static SharedPreferences preferencesUser;

    public static final String KEY_USER_CODE = "userCode";
    public static final String KEY_USER_SEQUENCE = "userSequence";
    public static final String KEY_USER_NAME = "userName";
    public static final String KEY_USER_MAIL = "userMail";

    public static final String KEY_COMPANY_CODE = "companyCode";
    public static final String KEY_COMPANY_NAME = "companyName";
    public static final String KEY_SUB_COMPANY_CODE = "subCompanyCode";
    public static final String KEY_SUB_COMPANY_NAME = "subCompanyName";

    public static final String KEY_DIAS_PEDIDO = "permiteModificarDiasPedido";
    public static final String KEY_API_RULES = "apiKeyRules";
    public static final String KEY_APLICA_EDICION_XRULES = "usaXRulesAlHacerPedido";
    public static final String KEY_ELIM_PROM_AUTO = "elimPromAutOrdenPedido";
    public static final String KEY_MOSTRAR_VAL_DESC_MANUAL_VEND = "mostrarValorDescuentoManual";
    public static final String KEY_MOSTRAR_VAL_XRULES_ORD_PED = "mostrarValoresXRulesOrdenesPedidos";
    public static final String KEY_MOST_CHECK_APL_XRULES_ORD_PED = "mostrarCheckAplicaRulesOrdenesPedido";

    public static final String KEY_USE_EQUIV = "useEquivalencias";
    public static final String KEY_USE_PROMOTION = "usePromotion";
    public static final String KEY_DAYS_ORDER = "cantDaysOrder";
    public static final String KEY_TYPE_ORDER = "UniqueTypeOrder";
    public static final String KEY_TYPE_ORDER_TYPE_PAYMENT = "UniqueTypeOrderTypePayment";
    public static final String KEY_PROMOTION_ID = "promotionId";

    public static final String KEY_PROMOTION_GROUP = "KEY_PROMOTION_GROUP";
    public static final String KEY_PROMOTION_SUBGROUP = "KEY_PROMOTION_SUBGROUP";
    public static final String KEY_PROMOTION_ARTICLE = "KEY_PROMOTION_ARTICLE";

    public static final String KEY_WS_COMPANY = "wsCompany";
    public static final String KEY_WS_BRMS_IP = "wsBrmsCompanyIp";
    public static final String KEY_WS_BRMS_NAME = "wsBrmsCompanyName";

    public static final String KEY_lAST_UPDATE = "LastUpdate";

    public static final String KEY_lAST_UPDATE_DAY = "LastUpdateDay";

    public static final String KEY_DISCOUNT = "KEY_DISCOUNT";
    public static final String KEY_DISCOUNT_VALUE = "KEY_DISCOUNT_VALUE";
    public static final String KEY_DISCOUNT_PERCENT = "KEY_DISCOUNT_PERCENT";

    public static String userCode;
    public static int userSequence;
    public static String userName;

    public static String companyName;
    public static String subCompanyName;
    public static int companyCode;
    public static int subCompanyCode;
    public static String permiteModificarDiasPedido;

    public static AtomicInteger orderId = new AtomicInteger();
    public static AtomicInteger guideDetailId = new AtomicInteger();
    public static AtomicInteger invoiceId = new AtomicInteger();

    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("####,###,##0.00");
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void onCreate() {

        super.onCreate();
            preferencesUser = getSharedPreferences("PreferencesUser", Context.MODE_PRIVATE);
        configRealm();
        Realm realm = Realm.getDefaultInstance();
        orderId = getId(realm, Order.class);
        guideDetailId = getId(realm, CashingGuideDetail.class);
        invoiceId = getId(realm, Invoice.class);
        realm.close();
    }

    public static void prepareCallService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
                .connectTimeout(240, TimeUnit.SECONDS)
                .readTimeout(240, TimeUnit.SECONDS)
                .writeTimeout(240, TimeUnit.SECONDS).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://" + getValueOfPreferencesUser(KEY_WS_COMPANY) + "/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        services = retrofit.create(Services.class);

    }

    public static void prepareCallServiceOrder() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
                .connectTimeout(240, TimeUnit.SECONDS)
                .readTimeout(240, TimeUnit.SECONDS)
                .writeTimeout(240, TimeUnit.SECONDS).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://" + getValueOfPreferencesUser(KEY_WS_COMPANY) + "/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()))
                .build();
        servicesOrder = retrofit.create(Services.class);

    }

    private void configRealm() {
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }

    private <T extends RealmObject> AtomicInteger getId(Realm realm, Class<T> anyClass) {
        RealmResults<T> results = realm.where(anyClass).findAll();
        return (results.size() > 0) ? new AtomicInteger(results.max("id").intValue()) : new AtomicInteger();
    }

    public static void prepareCompanyData() {
        companyCode = getValueOfPreferencesUser(KEY_COMPANY_CODE, 0);
        subCompanyCode = getValueOfPreferencesUser(KEY_SUB_COMPANY_CODE, 0);
        companyName = getValueOfPreferencesUser(KEY_COMPANY_NAME, "");
        subCompanyName = getValueOfPreferencesUser(KEY_SUB_COMPANY_NAME, "");
        permiteModificarDiasPedido = getValueOfPreferencesUser(KEY_DIAS_PEDIDO,"");
    }

    public static void prepareUserData() {
        userSequence = getValueOfPreferencesUser(KEY_USER_SEQUENCE, 0);
        userCode = getValueOfPreferencesUser(KEY_USER_CODE, "");
        userName = getValueOfPreferencesUser(KEY_USER_NAME, "");
    }

    public static String getValueOfPreferencesUser(String key) {
        return preferencesUser.getString(key, "");
    }

    public static String getValueOfPreferencesUser(String key, String _default) {
        return preferencesUser.getString(key, _default);
    }

    public static int getValueOfPreferencesUser(String key, int _default) {
        return preferencesUser.getInt(key, _default);
    }

    public static void saveValueOnPreferencesUser(String key, String value) {
        SharedPreferences.Editor editor = preferencesUser.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void saveValueOnPreferencesUser(String key, int value) {
        SharedPreferences.Editor editor = preferencesUser.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static void removeAllSharedPreferences() {
        preferencesUser.edit().clear().apply();
    }
}
