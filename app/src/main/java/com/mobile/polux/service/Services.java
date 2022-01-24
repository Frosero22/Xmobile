package com.mobile.polux.service;

import com.mobile.polux.models.AccountsResponse;
import com.mobile.polux.models.AplicaDescuentoResponse;
import com.mobile.polux.models.BankResponse;
import com.mobile.polux.models.ClientsResponse;
import com.mobile.polux.models.CreditHistoryResponse;
import com.mobile.polux.models.FinalizeResponse;
import com.mobile.polux.models.GeolocationResponse;
import com.mobile.polux.models.GetOrderResponse;
import com.mobile.polux.models.GuideLiquidation;
import com.mobile.polux.models.GuideResponse;
import com.mobile.polux.models.LiquidationResponse;
import com.mobile.polux.models.LocalitiesResponse;
import com.mobile.polux.models.LoginResponse;
import com.mobile.polux.models.Order;
import com.mobile.polux.models.OrderMassiveResponse;
import com.mobile.polux.models.OrderResponse;
import com.mobile.polux.models.OrdersResponse;
import com.mobile.polux.models.ProductsResponse;
import com.mobile.polux.models.PromotionRequest;
import com.mobile.polux.models.PromotionResponse;
import com.mobile.polux.models.SubCompaniesResponse;
import com.mobile.polux.models.UpdateResponse;
import com.mobile.polux.models.VisitResponse;

import java.util.Date;
import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;

/**
 * Created by laptoplenovo on 10/5/2018.
 */

public interface Services {

    @GET("AccesosPolux/obtenerEmpresaMovil")
    Call<FinalizeResponse> finalizeInstall(@Query("arg0") String ruc);

    @GET("AccesosPolux/autenticacionUsuario")
    Call<LoginResponse> login(@Query("arg0") String user, @Query("arg1") String password);

    @GET("AccesosPolux/datosSucursalXUsuario")
    Call<SubCompaniesResponse> subCompanies(@Query("arg0") String user, @Query("arg1") int companyCode);

    @GET("Clientes/obtenerClientesXVendedor")
    Call<ClientsResponse> allClients(@Query("arg0") int companyCode, @Query("arg1") int personalSequence, @Query("arg2") String filterType, @Query("arg3") String value);

    @GET("Clientes/obtenerClientesXVendedor")
    Call<ClientsResponse> clients(@Query("arg0") int companyCode, @Query("arg1") int personalSequence, @Query("arg2") String filterType, @Query("arg3") String value, @Query("arg4") int ini, @Query("arg5") int end);

    @GET("Productos/obtenerProductos")
    Call<ProductsResponse> allProducts(@Query("arg0") int companyCode, @Query("arg1") int subCompany);

    @GET("Productos/obtenerProductos")
    Call<ProductsResponse> products(@Query("arg0") int companyCode, @Query("arg1") int subCompany, @Query("arg2") int clientId, @Query("arg3") String filterType, @Query("arg4") String value, @Query("arg5") int ini, @Query("arg6") int end, @Query("arg7") int divisionCode);

    @GET("Clientes/obtenerLocalidadesContactosCliente")
    Call<LocalitiesResponse> localities(@Query("arg0") int clientId, @Query("arg1") int companyCode);

    @GET("Clientes/obtenerHistCrediticioCliente")
    Call<CreditHistoryResponse> creditHistory(@Query("arg0") int companyCode,@Query("arg1") int clientId);

    @GET("Clientes/obtenerCuentasCliente")
    Call<AccountsResponse> accounts(@Query("arg0") int companyCode,@Query("arg1") int clientId);

    @PUT("Clientes/actualizarLongitudLatitud")
    Call<UpdateResponse> updateLocation(@Query("arg0") int clientId, @Query("arg1") int locationId, @Query("arg2") String longitude, @Query("arg3") String latitude, @Query("arg4") int companyId, @Query("arg5") String user);

   // @Multipart
   // @PUT("Clientes/actualizarLongitudLatitudImagen")//, @Part RequestBody img
  // Call<UpdateResponse> updateLocationImage(@Query("arg0") int clientId, @Query("arg1") int locationId, @Query("arg2") String longitude, @Query("arg3") String latitude, @Query("arg4") int companyId, @Query("arg5") String user, @Body MultipartBody.Part image, @Body RequestBody img);

    @Multipart
    @PUT("Clientes/actualizarLongitudLatitudImagen")//, @Part RequestBody img
    Call<UpdateResponse> updateLocationImage(@Query("arg0") int clientId, @Query("arg1") int locationId, @Query("arg2") String longitude, @Query("arg3") String latitude, @Query("arg4") int companyId, @Query("arg5") String user, @PartMap Map<String, RequestBody> params);

    @POST("DiasVisitas/registrarVisitas")
    Call<VisitResponse> visit(@Query("arg0")Integer location, @Query("arg1") Integer clientId, @Query("arg2") Integer companyCode, @Query("arg3") String fecha, @Query("arg4") String usuario, @Query("arg5") String latitud, @Query("arg6") String longitud );


    @POST("Pedidos/crearPedidos")
    Call<OrderResponse> sendOrder(@Body Order order);

    @PUT("Pedidos/actualizarPedidos")
    Call<OrderResponse> updateOrder(@Body Order order);

    @GET("Pedidos/obtenerPedidos")
    Call<GetOrderResponse> getOrder(@Query("arg0") int companyCode, @Query("arg1") long numberOrder);

    @GET("DiasVisitas/obtenerDiasVisitas")
    Call<GeolocationResponse> geolocationDays(@Query("arg0") int companyCode, @Query("arg1") int personalSequence, @Query("arg2") String dateIni, @Query("arg3") String dateEnd);

    @POST("Promociones/promocionesSurtitodo")
    Call<PromotionResponse> promotionsSurtitodo(@Body PromotionRequest promotionRequest);

    @POST("Promociones/promocionesComidesa")
    Call<PromotionResponse> promotionsComidesa(@Body PromotionRequest promotionRequest);

    @GET("Cobros/obtenerCobros")
    Call<GuideResponse> guide(@Query("arg0") int companyCode, @Query("arg1") int subCompanyCode, @Query("arg2") int personalSequence, @Query("arg3") String dateIni, @Query("arg4") String dateEnd, @Query("arg5") String filter, @Query("arg6") String value);

    @GET("Pedidos/obtenerPedidosXVendedor")
    Call<OrdersResponse> orders(@Query("arg0") int companyCode, @Query("arg1") int personalSequence);

    @PUT("Liquidacion/insertarGuia")
    Call<LiquidationResponse> liquidation(@Body GuideLiquidation liquidation);

    @GET("Bancos/obtenerBancos")
    Call<BankResponse> banks(@Query("arg0") int companyCode);

    @POST("Pedidos/crearPedidosMasivo")
    Call<OrderMassiveResponse> sendMassiveOrder(@Body List<Order> orders);

    @GET("AccesosPolux/obtenerAplicaDescuento")
    Call<AplicaDescuentoResponse> consultaAplicaDescuento(@Query("arg0") int companyCode);
}
