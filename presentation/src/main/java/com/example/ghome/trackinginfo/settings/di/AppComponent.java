package com.example.ghome.trackinginfo.settings.di;

import com.example.ghome.trackinginfo.add.AddFragmentViewModel;
import com.example.ghome.trackinginfo.info.InfoViewModel;
import com.example.ghome.trackinginfo.main.MainViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by GHome on 11.09.2017.
 */
@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    void inject(AddFragmentViewModel viewModel);

    void inject(MainViewModel viewModel);

    void inject(InfoViewModel infoViewModel);

}
