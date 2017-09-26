package com.example.ghome.trackinginfo.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.domain.entity.ProductModel;
import com.example.ghome.trackinginfo.base.BaseItemViewHolder;
import com.example.ghome.trackinginfo.databinding.ItemRecyclerViewMainBinding;

/**
 * Created by GHome on 16.09.2017.
 */

public class HolderMain extends BaseItemViewHolder<ProductModel,
        ItemMain, ItemRecyclerViewMainBinding> {

    public HolderMain(ItemRecyclerViewMainBinding dataBinding,
                      ItemMain itemViewModel) {
        super(dataBinding, itemViewModel);
        dataBinding.setItemView(itemViewModel);

    }


    public static HolderMain create(LayoutInflater inflater, ViewGroup parent,
                                    ItemMain itemViewModel) {

        ItemRecyclerViewMainBinding binding = ItemRecyclerViewMainBinding.inflate(inflater, parent, false);
        return new HolderMain(binding, itemViewModel);
    }
}
