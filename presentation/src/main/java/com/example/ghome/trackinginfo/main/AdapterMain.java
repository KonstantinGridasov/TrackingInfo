package com.example.ghome.trackinginfo.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.domain.entity.ProductModel;
import com.example.ghome.trackinginfo.base.BaseAdapter;

/**
 * Created by GHome on 16.09.2017.
 */

public class AdapterMain extends BaseAdapter<ProductModel, ItemMain> {


    @Override
    public HolderMain onCreateViewHolder(ViewGroup parent, int viewType) {
        final ItemMain itemViewModel = new ItemMain();

        final HolderMain holder = HolderMain.create(LayoutInflater.from(parent.getContext())
                , parent, itemViewModel);

        return holder;
    }
}
