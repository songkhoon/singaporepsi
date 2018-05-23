package com.songkhoon.singaporepsi.dagger;

import android.app.Application;

import com.songkhoon.singaporepsi.MainApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ApiModule.class,
        ActivityBindingModule.class,
        PSIModelModule.class
})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance Builder application(Application application);
        AppComponent build();
    }

    void inject(MainApplication application);
}