package com.example.ghome.trackinginfo.main;

import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.ghome.trackinginfo.R;
import com.example.ghome.trackinginfo.base.BaseActivity;
import com.example.ghome.trackinginfo.databinding.ActivityMainBinding;
import com.example.ghome.trackinginfo.settings.MyReceiver;

public class MainActivity extends BaseActivity {

    private MyReceiver myReceiver = new MyReceiver();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        MainViewModel viewModel = new MainViewModel(this, fragmentManager);
        this.viewModel = viewModel;

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(viewModel);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(viewModel.adapter);

        super.onCreate(savedInstanceState);
        StatusInternet();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarMy);
        setSupportActionBar(toolbar);

    }

    public void StatusInternet() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(myReceiver, intentFilter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        StatusInternet();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(myReceiver);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

}

