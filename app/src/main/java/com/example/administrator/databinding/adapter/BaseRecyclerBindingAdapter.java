package com.example.administrator.databinding.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/5/24.
 */

public class BaseRecyclerBindingAdapter<D> extends RecyclerView.Adapter<BaseRecyclerBindingAdapter.BindingHolder> {

    private static final String TAG = BaseRecyclerAdapter.class.getSimpleName();
    private LayoutInflater inflater;
    private HashMap<Class<?>,Pair<Integer,Integer>> params;
    private List<D> mDList;
    private int ITEMADD=1;
    public BaseRecyclerBindingAdapter(HashMap<Class<?>, Pair<Integer, Integer>> params) {
        this.params = params;
        mDList=new ArrayList<>();
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Log.e(TAG, "onCreateViewHolder: "+viewType);
          if (inflater==null) {
              inflater = LayoutInflater.from(viewGroup.getContext());
          }
        ViewDataBinding inflate = DataBindingUtil.inflate(inflater, viewType, viewGroup, false);
        BindingHolder bindingHolder = new BindingHolder(inflate);
        return bindingHolder;
    }

    @Override
    public void onBindViewHolder(BindingHolder bindingHolder, int position) {
        D d = mDList.get(position);
        Pair<Integer, Integer> pair = params.get(mDList.get(position).getClass());
        bindingHolder.itemView.setVariable( pair.second,d);
    }
    @Override
    public int getItemViewType(int position) {
        Pair<Integer, Integer> pair = params.get(mDList.get(position).getClass());
        Log.e(TAG, "onCreateViewHolder: "+params.size()+ " "+ pair.first+" "+pair.second);
        return pair.first;
    }

    public void removeItem(D t){
        int position = mDList.indexOf(t);
        mDList.remove(position);
        notifyItemRangeRemoved(position,mDList.size()-position+1);
    }
    public void removeSelectedItem(List<D> tList){
        // int minIndex=0;
        /*for (D t : tList) {
            int position = mDList.indexOf(t);
            minIndex = Math.min(minIndex, position);
        }*/
        //int oldSize = mDList.size();
        mDList.removeAll(tList);
        notifyDataSetChanged();
        //notifyItemRangeRemoved(minIndex,oldSize-1);
    }
    public void remove(int position){
        mDList.remove(position);
        notifyItemRangeRemoved(position,mDList.size()-position+1);
    }
    public void clear(){
        int size = mDList.size();
        mDList.removeAll(mDList);
        notifyItemRangeRemoved(0, size);
    }
    public void add(D t,int index){
        mDList.add(index,t);
        notifyItemRangeInserted(index, ITEMADD);
    }
    public void add(D t ){
        mDList.add(t);
        notifyItemRangeInserted(mDList.size()-ITEMADD, ITEMADD);
    }
    public  void addAll(List<D> tList){
        int start=mDList.size();
        mDList.addAll(tList);
        notifyItemRangeInserted(start,tList.size());
    }
    @Override
    public int getItemCount() {
        return mDList.size();
    }
    public  static class BindingHolder  extends  RecyclerView.ViewHolder{
        private final ViewDataBinding itemView;
        public BindingHolder(ViewDataBinding itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;
        }
    }
}
