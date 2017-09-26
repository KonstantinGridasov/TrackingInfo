package com.example.ghome.trackinginfo.base;


import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;


public abstract class BaseItemViewHolder
        <Model,
                ViewModel extends BaseItemViewModel<Model>,
                DataBinding extends ViewDataBinding>
        extends RecyclerView.ViewHolder {

    private DataBinding dataBinding;
    private ViewModel viewModel;

    public BaseItemViewHolder(DataBinding dataBinding, ViewModel viewModel) {
        super(dataBinding.getRoot());
        this.dataBinding = dataBinding;
        this.viewModel = viewModel;
        viewModel.init();
    }


    public void bindTo(Model item, int position) {
        viewModel.setItem(item, position);
        dataBinding.executePendingBindings();
    }

    public void release() {
        viewModel.release();
    }


}

//    public void setItemOnClickListener(BaseItemOnClickListener itemClickListener)
//    {
//        this.itemClickListener=itemClickListener;
//    }
//
//    @Override
//    public void onClick(View view) {
//        Log.e("BaseItemViewHolder "," onClick");
//        this.itemClickListener.onItemClick(this.getLayoutPosition());
//    }
//}
//public void bind(final int item, final BaseItemOnClickListener listener) {
//        itemView.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View view) {
//        Log.e("BaseItemViewHolder "," setOnClickListener");
//        listener.onItemClick(item);
//        }
//        });