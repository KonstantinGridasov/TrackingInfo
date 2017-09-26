package com.example.ghome.trackinginfo.add;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ghome.trackinginfo.R;
import com.example.ghome.trackinginfo.base.BaseFragmentActivity;
import com.example.ghome.trackinginfo.databinding.FragmentAddBinding;

/**
 * Created by GHome on 12.09.2017.
 */

public class AddFragmentActivity extends BaseFragmentActivity {

    public static AddFragmentActivity newInstance(FragmentManager fragmentManager) {

        AddFragmentActivity fragment = new AddFragmentActivity();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        AddFragmentViewModel viewModel = new AddFragmentViewModel(getActivity());
        this.viewModel = viewModel;
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        FragmentAddBinding
                .bind(view)
                .setViewModel(viewModel);
        return view;
    }
}