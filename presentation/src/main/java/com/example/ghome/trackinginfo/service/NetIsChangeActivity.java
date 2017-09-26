package com.example.ghome.trackinginfo.service;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import com.example.ghome.trackinginfo.R;

/**
 * Created by GHome on 24.09.2017.
 */

public class NetIsChangeActivity extends DialogFragment {

    NetIsChangeViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        NetIsChangeViewModel viewModel = new NetIsChangeViewModel(getActivity());
        this.viewModel = viewModel;
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Internet Manager")
                .setView(R.layout.fragment_network)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        return builder.create();
    }
}
