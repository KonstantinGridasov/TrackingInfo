package com.example.ghome.trackinginfo.add;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

import com.example.domain.entity.ProductModel;
import com.example.domain.interaction.base.CreateOnRealm;
import com.example.ghome.trackinginfo.TrackingInfo;
import com.example.ghome.trackinginfo.base.BaseViewModel;
import com.example.ghome.trackinginfo.main.MainActivity;
import com.example.ghome.trackinginfo.main.MainViewModel;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by GHome on 16.09.2017.
 */

public class AddFragmentViewModel implements BaseViewModel {
    Activity activity;


    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> id = new ObservableField<>("");
    ProductModel productModel = new ProductModel();

    @Inject
    CreateOnRealm createProduct;

    AddFragmentViewModel(Activity activity) {
        this.activity = activity;
        TrackingInfo.appComponent.inject(this);
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

    public void buttonOK(View v) {
        MainViewModel.key_open = 0;
        Log.e("buttonOK", " name=" + name.get());

        productModel.setName(name.get());
        productModel.setTrack(id.get());
        createProduct.execute(productModel, new DisposableObserver<Void>() {
            @Override
            public void onNext(@NonNull Void aVoid) {
                Log.e("buttonOK", " onNext=" + name.get());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("buttonOK", " onError=" + e);
            }

            @Override
            public void onComplete() {
                Log.e("buttonOK", " onComplete=" + name.get());
            }
        });
        activity.startActivity(new Intent(activity, MainActivity.class));
        activity.finish();

    }

    public void onLayout(View v) {

    }
}
