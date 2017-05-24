package com.example.administrator.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.administrator.databinding.databinding.RecyclerItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/23.
 */

public class RecyclerBindingAdapter  extends RecyclerView.Adapter<RecyclerBindingAdapter.BindingHolder> {

    private LayoutInflater layoutInlater;
    private List<User> mTListl;

    public RecyclerBindingAdapter() {
        this.mTListl = new ArrayList<>();
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
         if (layoutInlater==null)
             layoutInlater = LayoutInflater.from(viewGroup.getContext());
        RecyclerItemBinding viewDataBinding = DataBindingUtil.inflate(layoutInlater, viewType, viewGroup, false);
        BindingHolder bindingHolder = new BindingHolder(viewDataBinding);
        return bindingHolder;
    }

    @Override
    public void onBindViewHolder(BindingHolder bindingHolder, int position) {
        User item = mTListl.get(position);
       bindingHolder.itemView.setVariable(BR.user,item);
    }
    public  void addAll(List<User> tList){
        int start=mTListl.size();
        mTListl.addAll(tList);
        notifyItemRangeInserted(start,tList.size());
    }
    @Override
    public int getItemViewType(int position) {
        return R.layout.recycler_item;
    }

    @Override
    public int getItemCount() {
        return mTListl.size();
    }

    public class BindingHolder  extends  RecyclerView.ViewHolder{
        private final ViewDataBinding itemView;
        public BindingHolder(ViewDataBinding itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;
        }
    }
}
