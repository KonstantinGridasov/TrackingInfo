package com.example.ghome.trackinginfo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by GHome on 02.09.2017.
 */

public abstract class BaseFragmentActivity extends Fragment {
    protected BaseViewModel viewModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
        viewModel.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.resume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        viewModel.release();
    }
}

