package com.example.ghome.trackinginfo.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.domain.entity.ProductModel;
import com.example.domain.interaction.base.GetListOnRealm;
import com.example.ghome.trackinginfo.R;
import com.example.ghome.trackinginfo.TrackingInfo;
import com.example.ghome.trackinginfo.add.AddFragmentActivity;
import com.example.ghome.trackinginfo.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by GHome on 12.09.2017.
 */

public class MainViewModel implements BaseViewModel {

    public static int key_open = 0;



    public enum STATE {SAVE, ADD}

    public ObservableField<STATE> state = new ObservableField<>(STATE.ADD);
    Activity activity;
    FragmentManager fragmentManager;

    @Inject
    GetListOnRealm getList;

    AdapterMain adapter = new AdapterMain();

    public MainViewModel(Activity activity, FragmentManager fragmentManager) {
        this.activity = activity;
        TrackingInfo.appComponent.inject(this);
        this.fragmentManager = fragmentManager;
    }

    @Override
    public void init() {
        if (key_open == 0) {
            state.set(STATE.SAVE);

            getList.execute(null, new DisposableObserver<List<ProductModel>>() {
                @Override
                public void onNext(@NonNull List<ProductModel> productModels) {

                    adapter.setItems(productModels);
                }

                @Override
                public void onError(@NonNull Throwable e) {

                }

                @Override
                public void onComplete() {
                }
            });
        }
    }

    @Override
    public void release() {
        key_open = 0;
    }

    @Override
    public void resume() {


    }

    @Override
    public void pause() {
        key_open = 0;
    }

    public void onButtonCreate(View view) {
        key_open = 1;
        state.set(STATE.ADD);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, AddFragmentActivity.newInstance(fragmentManager));
        fragmentTransaction.commit();
    }

    public void onViewClick(View view) {
        key_open = 0;
        state.set(STATE.SAVE);
        Context context = view.getContext();
        context.startActivity(new Intent(context, MainActivity.class));
        activity.finish();
    }

}

