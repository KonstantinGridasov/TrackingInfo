package com.example.data.net;

import com.example.data.entity.Product;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by GHome on 16.08.2017.
 */

public interface RestApi {
    @POST("data/product")
    Observable<Void> createProduct(@Body Product product);

    @GET("data/product")
    Observable<List<Product>> getProfilesOnId(@Query("where") String track);

}
