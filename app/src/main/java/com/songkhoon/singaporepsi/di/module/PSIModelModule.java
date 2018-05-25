package com.songkhoon.singaporepsi.di.module;

import com.songkhoon.singaporepsi.model.PSIModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Module
public class PSIModelModule {

    @Provides
    @Singleton
    PSIModel providePSIModel(OkHttpClient okHttpClient, Retrofit retrofit) {
        return new PSIModel(okHttpClient, retrofit);
    }

}
