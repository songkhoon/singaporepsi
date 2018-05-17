package com.songkhoon.singaporepsi;

import android.app.Application;

import com.songkhoon.singaporepsi.dagger.ApiComponent;
import com.songkhoon.singaporepsi.dagger.ApiModule;
import com.songkhoon.singaporepsi.dagger.AppModule;
import com.songkhoon.singaporepsi.dagger.DaggerApiComponent;

public class MainApplication extends Application {
    private static MainApplication app;
    private ApiComponent apiComponent;

    public static MainApplication getApp() {
        return app;
    }

    public ApiComponent getApiComponent() {
        return apiComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        initComponent();
    }

    private void initComponent() {
        apiComponent = DaggerApiComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule("https://api.data.gov.sg/v1/"))
                .build();
    }
}
