package com.example.ghome.trackinginfo.service;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.example.ghome.trackinginfo.base.BaseViewModel;
import com.example.ghome.trackinginfo.main.MainActivity;

/**
 * Created by GHome on 24.09.2017.
 */

public class NetIsChangeViewModel implements BaseViewModel {
    public static int MY_KEY_NETWORK = 0;
    private Activity activity;

    public NetIsChangeViewModel(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    public void OnNetwork(View v) {
        MY_KEY_NETWORK = 0;
        activity.startActivity(new Intent(activity, MainActivity.class));
        activity.finish();
    }
}
