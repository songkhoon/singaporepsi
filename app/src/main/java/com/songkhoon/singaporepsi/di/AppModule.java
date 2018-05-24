package com.songkhoon.singaporepsi.di;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Named("baseURL")
    static String provideBaseURL() {
        return "https://api.data.gov.sg/v1/";
    }

}
