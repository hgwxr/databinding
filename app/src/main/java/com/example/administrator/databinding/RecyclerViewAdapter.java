package com.example.administrator.databinding;

import android.content.Context;

import com.example.administrator.databinding.adapter.BaseRecyclerAdapter;

/**
 * Created by Administrator on 2017/5/23.
 */

public class RecyclerViewAdapter  extends BaseRecyclerAdapter<User> {
    public RecyclerViewAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    protected void bindDataToView(BaseViewHolder holder, User data, int position) {

    }

    @Override
    protected int getItemType(int position) {
        return 0;
    }
}
