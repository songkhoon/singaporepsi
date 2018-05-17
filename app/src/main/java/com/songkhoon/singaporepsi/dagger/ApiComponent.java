package com.songkhoon.singaporepsi.dagger;

import com.songkhoon.singaporepsi.model.PSIModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface ApiComponent {
    void inject(PSIModel psiModel);
}
