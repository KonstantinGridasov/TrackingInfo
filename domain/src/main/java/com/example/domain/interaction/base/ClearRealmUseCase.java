package com.example.domain.interaction.base;

import com.example.data.dbtrack.DbOnRealm;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by GHome on 30.08.2017.
 */

public class ClearRealmUseCase extends UseCase<Boolean, Boolean> {

    @Inject
    DbOnRealm dbOnRealm;

    @Inject
    public ClearRealmUseCase(DbOnRealm dbOnRealm) {
        this.dbOnRealm = dbOnRealm;
    }

    @Override
    protected Observable<Boolean> buildUseCase(Boolean v) {
        return dbOnRealm.clearRealm();
    }


}

