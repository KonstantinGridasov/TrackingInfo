package com.example.ghome.trackinginfo.base;

/**
 * Created by GHome on 18.08.2017.
 */

public abstract class BaseItemViewModel<Model> implements BaseViewModel {

    public abstract void setItem(Model item, int position);

    @Override
    public void init() {
    }

    @Override
    public void release() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {
    }


}