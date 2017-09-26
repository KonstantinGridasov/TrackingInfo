package com.example.data.dbtrack;

import android.util.Log;

import com.example.data.entity.Product;
import com.example.data.net.RestService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmModel;
import io.realm.RealmResults;

/**
 * Created by GHome on 19.09.2017.
 */

public class DbOnRealm {

    private DbTrack dbTrack;
    private Realm realm;

    @Inject
    RestService restService;

    @Inject
    public DbOnRealm(RestService restService) {
        this.restService = restService;
    }


    public Observable<List<DbTrack>> getProducts() {
        //Выгрузка все базы Realm
        realm = Realm.getDefaultInstance();
        List<DbTrack> dbTrackList = realm.copyFromRealm(
                realm.where(DbTrack.class).findAll());
        realm.close();

        return Observable.fromArray(dbTrackList);
    }


    public Observable<Void> createProduct(Product product) {
        DbTrack dbTrack = new DbTrack(product);
        realm = Realm.getDefaultInstance();
        if (dbTrack == null) {
            dbTrack = realm.createObject(DbTrack.class);
            dbTrack = new DbTrack(product);
            dbTrack.setTrack(product.getTrack());
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(dbTrack);
            realm.commitTransaction();
        }                                                       // Запись в базу Realm
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(dbTrack);
        realm.commitTransaction();
        realm.beginTransaction();
        dbTrack.setName(product.getName());
        realm.commitTransaction();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(dbTrack);
        realm.commitTransaction();
        realm.beginTransaction();
        dbTrack.setCountry("Track not found!");
        realm.commitTransaction();


        realm.close();
        return restService.createProduct(product);                  //параллелльно создание объекта в бэкендлесе
    }

    public Observable<Product> getProfilesOnId(String track) {
        final Product product = new Product();
        realm = Realm.getDefaultInstance();
        dbTrack = realm.where(DbTrack.class)                        //Поиск в базе по track(т.е по ID)
                .equalTo("track", track)
                .findFirst();

        if (dbTrack != null) {
            product.setTrack(dbTrack.getTrack());
            dbTrack.addChangeListener(new RealmChangeListener<RealmModel>() {    //Подписка на изменения
                @Override
                public void onChange(RealmModel realmModel) {

                    Log.e("loadData", "  ChangeListener");
                    product.setTrack(dbTrack.getTrack());
                }
            });

        }
        realm.close();
        return Observable.just(product);
    }

    public Observable<Boolean> clearRealm() {
        realm.beginTransaction();
        RealmResults<DbTrack> dbTrackResults = realm.where(DbTrack.class).findAll();
        if (!dbTrackResults.isEmpty()) {
            for (int i = dbTrackResults.size() - 1; i >= 0; i--) {
                dbTrackResults.get(i).deleteFromRealm();
            }
        }
        realm.commitTransaction();

        return Observable.just(true);
    }


    public Observable<Boolean> clearRealmOnId(String track) {

        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        dbTrack = realm.where(DbTrack.class)                        //Поиск в базе по track(т.е по ID)
                .equalTo("track", track)
                .findFirst();

        if (dbTrack!=null) {
                dbTrack.deleteFromRealm();
          }
        realm.commitTransaction();

        return Observable.just(true);
    }
}