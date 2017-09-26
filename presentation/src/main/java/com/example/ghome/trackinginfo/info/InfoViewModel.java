package com.example.ghome.trackinginfo.info;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

import com.example.domain.entity.ProductModel;
import com.example.domain.interaction.base.ClearOnIdRealm;
import com.example.domain.interaction.base.GetProductOnIdUseCase;
import com.example.ghome.trackinginfo.TrackingInfo;
import com.example.ghome.trackinginfo.base.BaseViewModel;
import com.example.ghome.trackinginfo.main.MainActivity;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

import static com.example.ghome.trackinginfo.main.ItemMain.KEY_INFO;

/**
 * Created by GHome on 22.09.2017.
 */

public class InfoViewModel implements BaseViewModel {
    Activity activity;
    private String Object_id;

    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> track = new ObservableField<>("");
    public ObservableField<String> country = new ObservableField<>("");

    ProductModel productModel = new ProductModel();


    @Inject
    GetProductOnIdUseCase getCountry;

    @Inject
    ClearOnIdRealm clearOnIdRealm;

    public InfoViewModel(Activity activity) {
        this.activity = activity;
        TrackingInfo.appComponent.inject(this);


    }

    @Override

    public void init() {
        Intent intent = activity.getIntent();
        Object_id = intent.getStringExtra(KEY_INFO);
        Log.e("InfoViewModel ", "init=" + Object_id);
    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {

        getCountry.execute(Object_id, new DisposableObserver<ProductModel>() {
            @Override
            public void onNext(@NonNull ProductModel productModel) {
                Log.e("getCountry ", "onNext=" + productModel.getName());
                Log.e("getCountry ", "onNext=" + productModel.getCountry());

                name.set(productModel.getName());
                track.set(productModel.getTrack());
                country.set(productModel.getCountry());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void pause() {

    }

    public void ClearOnRealm(View v) {
        clearOnIdRealm.execute(Object_id, new DisposableObserver<Boolean>() {
            @Override
            public void onNext(@NonNull Boolean b) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        activity.startActivity(new Intent(activity, MainActivity.class));
        activity.finish();
    }
}
