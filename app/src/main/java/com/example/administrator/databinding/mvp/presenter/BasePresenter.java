package com.example.administrator.databinding.mvp.presenter;

/**
 * Created by Administrator on 2017/5/24.
 */

public class BasePresenter<V> {
    protected  V mView;
    public void attach(V iBaseView) {
        mView=  iBaseView;
    }

    public void deAttach() {
        mView=null;
    }


}
