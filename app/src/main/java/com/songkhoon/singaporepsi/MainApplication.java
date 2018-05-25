package com.songkhoon.singaporepsi;

import android.app.Activity;
import android.app.Application;

import com.songkhoon.singaporepsi.di.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class MainApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        initComponent();
    }

    private void initComponent() {
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this);
    }

}
