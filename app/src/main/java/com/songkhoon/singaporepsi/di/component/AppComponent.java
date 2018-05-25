package com.songkhoon.singaporepsi.di.component;

import android.app.Application;

import com.songkhoon.singaporepsi.MainApplication;
import com.songkhoon.singaporepsi.di.module.ActivityBindingModule;
import com.songkhoon.singaporepsi.di.module.AppModule;
import com.songkhoon.singaporepsi.di.module.NetworkModule;
import com.songkhoon.singaporepsi.di.module.PSIModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityBindingModule.class,
        NetworkModule.class,
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
