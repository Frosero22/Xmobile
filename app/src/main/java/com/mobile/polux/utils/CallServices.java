package com.mobile.polux.utils;

import android.util.Log;

import com.mobile.polux.R;
import com.mobile.polux.adapters.ClientAdapter;
import com.mobile.polux.app.App;
import com.mobile.polux.models.ClientsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by laptoplenovo on 7/6/2018.
 */

public class CallServices {
/*
    private void callClients(String text) {

        Call<ClientsResponse> response = App.services.clients(App.companyCode, App.userSequence, "NOMBRE_CLIENTE", text, 0, 15);


        response.enqueue(new Callback<ClientsResponse>() {
            @Override
            public void onResponse(Call<ClientsResponse> call, Response<ClientsResponse> response) {

                if (response.body() != null) {

                    String message = response.body().getMessage();

                    if ("OK".equals(message) && response.body().getClients() !=null) {

                        adapter = null;
                        adapter = new ClientAdapter(getApplicationContext(), R.layout.item_client, response.body().getClients());
                        lvClients.setAdapter(adapter);

                        //syncClients(response.body().getClients());

                        //adapter.addAll(_products);
                        //adapter.notifyDataSetChanged();

                    } else {
                        //showToastL("No se encontraron clientes");
                    }
                }
            }

            @Override
            public void onFailure(Call<ClientsResponse> call, Throwable t) {

                Log.e("SearchProd", "failure " + t);
                //showToastL("Ocurrió un error, por favor verifique su acceso a internet");
            }
        });
    }
    */
}
