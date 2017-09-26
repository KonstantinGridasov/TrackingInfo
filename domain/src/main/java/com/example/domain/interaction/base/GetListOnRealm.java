package com.example.domain.interaction.base;

import com.example.data.dbtrack.DbOnRealm;
import com.example.data.dbtrack.DbTrack;
import com.example.data.entity.Product;
import com.example.data.net.RestService;
import com.example.domain.entity.ProductModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class GetListOnRealm extends UseCase<Void, List<ProductModel>> {

    @Inject
    DbOnRealm dbOnRealm;


    public GetListOnRealm(DbOnRealm dbOnRealm) {
        this.dbOnRealm = dbOnRealm;
    }


    @Override
    protected Observable<List<ProductModel>> buildUseCase(Void v) {

        return dbOnRealm.getProducts().map(new Function<List<DbTrack>, List<ProductModel>>() {
            @Override
            public List<ProductModel> apply(@NonNull List<DbTrack> dbTracks) throws Exception {
                List<ProductModel> list = new ArrayList<>();
                for (DbTrack product : dbTracks) {
                    list.add(convert(product));
                }
                return list;
            }
        });

    }

    private ProductModel convert(DbTrack dbTrack) {
        ProductModel productModel = new ProductModel();
        productModel.setName(dbTrack.getName());
        productModel.setTrack(dbTrack.getTrack());
        return productModel;
    }



}
