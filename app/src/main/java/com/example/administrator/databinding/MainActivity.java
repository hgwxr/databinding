package com.example.administrator.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.databinding.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User();
        mainBinding.setUser(user);
        user.setUserName("recyclerview");
        user.setuId("0");
    }
}
