package com.example.domain.interaction.base;

import android.util.Log;

import com.example.data.dbtrack.DbOnRealm;
import com.example.data.entity.Product;
import com.example.domain.entity.ProductModel;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by GHome on 26.09.2017.
 */

public class ClearOnIdRealm extends UseCase<String, Boolean> {
    @Inject
    DbOnRealm dbOnRealm;

    @Inject
    public ClearOnIdRealm(DbOnRealm dbOnRealm) {
        this.dbOnRealm = dbOnRealm;
    }


    @Override
    protected Observable<Boolean> buildUseCase(String track) {
       return dbOnRealm.clearRealmOnId(track);
    }
}

