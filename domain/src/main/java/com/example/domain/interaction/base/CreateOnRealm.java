package com.example.domain.interaction.base;

import android.util.Log;

import com.example.data.dbtrack.DbOnRealm;
import com.example.data.dbtrack.DbTrack;
import com.example.data.entity.Product;
import com.example.data.net.RestService;
import com.example.domain.entity.ProductModel;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.realm.Realm;

/**
 * Created by GHome on 30.08.2017.
 */

public class CreateOnRealm extends UseCase<ProductModel, Void> {
    @Inject
    DbOnRealm dbOnRealm;

    @Inject
    public CreateOnRealm(DbOnRealm dbOnRealm) {
        this.dbOnRealm = dbOnRealm;
    }

    @Override                                                           //Получение объекта и отправка дальше
    protected Observable<Void> buildUseCase(ProductModel productModel) {

        Product product = new Product();
        product.setName(productModel.getName());
        product.setTrack(productModel.getTrack());
        Log.e("CreateProductUseCase ", "buildUseCase NAME= " + product.getName());
        return dbOnRealm.createProduct(product);
    }


}

