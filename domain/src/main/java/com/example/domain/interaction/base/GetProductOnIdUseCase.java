package com.example.domain.interaction.base;

import android.util.Log;

import com.example.data.entity.Product;
import com.example.data.net.RestService;
import com.example.domain.entity.ProductModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by GHome on 22.09.2017.
 */

public class GetProductOnIdUseCase extends UseCase<String, ProductModel> {


    @Inject
    RestService restService;

    public GetProductOnIdUseCase(RestService restService) {
        this.restService = restService;
    }
    @Override
    protected Observable<ProductModel> buildUseCase(String id) {

        return restService.getProfilesOnId(id)
                .map(new Function<List<Product>, ProductModel>() {
                    @Override
                    public ProductModel apply(@NonNull List<Product> products) throws Exception {
                        Log.e(" GetProfileOnIdUseCase", "buildUseCase ");
                        ProductModel productModel = new ProductModel();
                        Product product = products.get(0);
                        productModel.setName(product.getName());
                        productModel.setCountry(product.getCounrty());
                        productModel.setTrack(product.getTrack());
                        return productModel;
                    }
                });

    }
}



