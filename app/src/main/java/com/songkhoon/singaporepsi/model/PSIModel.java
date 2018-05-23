package com.songkhoon.singaporepsi.model;

import com.songkhoon.singaporepsi.model.data.PSIData;

import java.io.IOException;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class PSIModel {

    private final OkHttpClient okHttpClient;
    private final Retrofit client;

    private final IServiceEndpoint serviceEndpoint;

    public PSIModel(OkHttpClient okHttpClient, Retrofit retrofit) {
        this.okHttpClient = okHttpClient;
        this.client = retrofit;
        serviceEndpoint = client.create(IServiceEndpoint.class);
    }

    private void getPSIData(String dateTime, String date, final IDataCallback<PSIData> callback) {
        serviceEndpoint.getPSIData(dateTime, date).enqueue(new Callback<PSIData>() {
            @Override
            public void onResponse(Call<PSIData> call, retrofit2.Response<PSIData> response) {
                if (response.isSuccessful()) {
                    callback.success(response.body());
                } else {
                    try {
                        callback.error(new Exception(response.errorBody().string()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<PSIData> call, Throwable t) {
                callback.error(new Exception(t.getMessage()));
            }
        });
    }

    public void getPSI(final IDataCallback<PSIData> callback) {
        getPSIData(null, null, callback);
    }

    public void getPSIByDateTime(String dateTime, final IDataCallback<PSIData> callback) {
        getPSIData(dateTime, null, callback);
    }

    public void getPSIByDate(String date, final IDataCallback<PSIData> callback) {
        getPSIData(null, date, callback);
    }

}
