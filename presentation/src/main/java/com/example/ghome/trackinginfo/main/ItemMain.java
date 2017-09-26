package com.example.ghome.trackinginfo.main;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

import com.example.domain.entity.ProductModel;
import com.example.ghome.trackinginfo.base.BaseItemViewModel;
import com.example.ghome.trackinginfo.info.InfoActivity;

/**
 * Created by GHome on 16.09.2017.
 */

public class ItemMain extends BaseItemViewModel<ProductModel> {
    public static final String KEY_INFO = "com.example.ghome.projectdz.Dz.dz11.main";

    public ObservableField<String> name = new ObservableField<>(" ");
    public ObservableField<String> itemsId = new ObservableField<>(" ");
    public ObservableField<String> ObjectId = new ObservableField<>(" ");

    @Override
    public void setItem(ProductModel item, int position) {
        Log.e("setItem", "ITEM " + position);
        name.set(item.getName());
        itemsId.set(item.getTrack());
        ObjectId.set(item.getObjectId());
    }


    public void onClickItem(View view) {
        Log.e("Dz11ItemViewModel", " onClickItem" + itemsId.get());
        Context context = view.getContext();
        Intent intent = new Intent(context, InfoActivity.class);
        intent.putExtra(KEY_INFO, itemsId.get());
        context.startActivity(intent);
    }
}

