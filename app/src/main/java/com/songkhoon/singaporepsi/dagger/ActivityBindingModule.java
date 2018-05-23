package com.songkhoon.singaporepsi.dagger;

import com.songkhoon.singaporepsi.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainActivity();

}
