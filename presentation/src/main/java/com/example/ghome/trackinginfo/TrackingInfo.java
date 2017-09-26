package com.example.ghome.trackinginfo;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.ndk.CrashlyticsNdk;
import com.example.ghome.trackinginfo.settings.di.AppComponent;
import com.example.ghome.trackinginfo.settings.di.AppModule;
import com.example.ghome.trackinginfo.settings.di.DaggerAppComponent;
import com.squareup.leakcanary.LeakCanary;

import io.fabric.sdk.android.Fabric;
import io.realm.Realm;

/**
 * Created by GHome on 12.09.2017.
 */

public class TrackingInfo extends Application {
    public  static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
//        Fabric.with(this, new Crashlytics(), new CrashlyticsNdk());
        Realm.init(this);
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }
}