package com.example.data.net;

import android.util.Log;

import com.example.data.entity.Product;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Created by GHome on 16.08.2017.
 */

public class RestService {

    private RestApi restApi;

    public RestService(Retrofit retrofit) {
        restApi = retrofit.create(RestApi.class);
    }


    public Observable<Void> createProduct(Product product) {
        Log.e("RestService", "createProduct- " + product.getName());
        return restApi.createProduct(product);
    }

    public Observable<List<Product>> getProfilesOnId(String track) {
        Log.e("RestService", "getProfilesOnId=" + "track=".concat("'").concat(track).concat("'"));
        return restApi.getProfilesOnId("track=".concat("'").concat(track).concat("'"));
    }


}

