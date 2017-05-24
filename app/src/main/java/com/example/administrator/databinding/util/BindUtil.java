package com.example.administrator.databinding.util;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Administrator on 2017/5/23.
 */

public class BindUtil  {
    @BindingAdapter("android:src")
    public  static  void  setImage(ImageView image,String url){
        Glide.with(image.getContext()).load(url).into(image);
    }
    @BindingAdapter("loadUrl")
    public  static  void  loadImage(ImageView image,String url){
        Glide.with(image.getContext()).load(url).into(image);
    }
    @BindingAdapter("android:text")
    public  static  void  setText(TextView image, String text){
         text = text.toUpperCase();
         image.setText(text);
    }
}
