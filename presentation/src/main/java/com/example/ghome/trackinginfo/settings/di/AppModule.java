package com.example.ghome.trackinginfo.settings.di;

import android.content.Context;

import com.example.data.dbtrack.DbOnRealm;
import com.example.data.net.RestService;
import com.example.domain.interaction.base.CreateOnRealm;
import com.example.domain.interaction.base.GetListOnRealm;
import com.example.domain.interaction.base.GetProductOnIdUseCase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by GHome on 11.09.2017.
 */
@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public RestService provideRestService(Retrofit retrofit) {
        return new RestService(retrofit);
    }

    @Provides
    public Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("https://api.backendless.com/843CB2B3-5438-080A-FF44-E1231C897A00/CB5B7122-760F-4A52-FF58-71154A8C6000/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient).build();
    }

    @Provides
    public Gson provideGson() {
        return new GsonBuilder().create();

    }

    @Provides
    public OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BASIC))
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
    }


    @Provides
    public GetProductOnIdUseCase provideGetProductOnIdUseCase(RestService restService) {
        return new GetProductOnIdUseCase(restService);
    }

    @Provides
    public DbOnRealm provideDbOnRealm(RestService restService) {
        return new DbOnRealm(restService);
    }

    @Provides
    public GetListOnRealm provideGetListOnRealm(DbOnRealm dbOnRealm) {
        return new GetListOnRealm(dbOnRealm);
    }

    @Provides
    public CreateOnRealm provideCreateOnRealm(DbOnRealm dbOnRealm) {
        return new CreateOnRealm(dbOnRealm);
    }

}
