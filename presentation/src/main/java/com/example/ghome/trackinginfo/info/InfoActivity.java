package com.example.ghome.trackinginfo.info;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.ghome.trackinginfo.R;
import com.example.ghome.trackinginfo.base.BaseActivity;
import com.example.ghome.trackinginfo.databinding.ActivityInfoBinding;

/**
 * Created by GHome on 22.09.2017.
 */

public class InfoActivity extends BaseActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        Log.e("InfoActivity ", "onCreate");
        InfoViewModel viewmodel = new InfoViewModel(this);
        viewModel = viewmodel;

        ActivityInfoBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_info);
        binding.setViewINFO(viewmodel);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.pause();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.release();
    }
}
