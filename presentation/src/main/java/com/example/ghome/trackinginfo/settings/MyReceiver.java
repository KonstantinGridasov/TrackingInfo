package com.example.ghome.trackinginfo.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

import com.example.ghome.trackinginfo.service.NetIsChangeActivity;
import com.example.ghome.trackinginfo.service.NetIsChangeViewModel;


public class MyReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            NetIsChangeViewModel.MY_KEY_NETWORK = 1;
            Toast.makeText(context,
                    " TRUE", Toast.LENGTH_SHORT).show();

            FragmentActivity activity = (FragmentActivity) context;
            FragmentManager manager = activity.getSupportFragmentManager();
            NetIsChangeActivity myDialogFragment = new NetIsChangeActivity();

            myDialogFragment.show(manager, "dialog");

        } else {
            Toast.makeText(context,
                    " Проверьте интернет", Toast.LENGTH_SHORT).show();

        }
    }
}

