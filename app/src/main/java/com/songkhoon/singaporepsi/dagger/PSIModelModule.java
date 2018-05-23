package com.songkhoon.singaporepsi.dagger;

import com.songkhoon.singaporepsi.model.PSIModel;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Module
public class PSIModelModule {

    @Provides
    PSIModel providePSIModel(OkHttpClient okHttpClient, Retrofit retrofit) {
        return new PSIModel(okHttpClient, retrofit);
    }

}
