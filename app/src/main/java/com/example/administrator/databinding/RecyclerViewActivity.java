package com.example.administrator.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Pair;

import com.example.administrator.databinding.adapter.BaseRecyclerBindingAdapter;
import com.example.administrator.databinding.databinding.ActivityRecyclerViewBinding;

import java.util.ArrayList;
import java.util.HashMap;

public class RecyclerViewActivity extends AppCompatActivity {

    private static final String TAG = RecyclerViewActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRecyclerViewBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view);
//        RecyclerBindingAdapter adapter = new RecyclerBindingAdapter();
        HashMap<Class<?>, Pair<Integer, Integer>> map = new HashMap<>();
        map.put(User.class,Pair.create(R.layout.recycler_item, BR.user));
        Log.e(TAG, "onCreate() called with: savedInstanceState = [" + BR.user + "]");
        final BaseRecyclerBindingAdapter<User> adapter = new BaseRecyclerBindingAdapter<>(map);
          viewDataBinding.recyclerView.setAdapter(adapter);
          viewDataBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
          viewDataBinding.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
              @Override
              public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                  super.onScrollStateChanged(recyclerView, newState);
              }
              @Override
              public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                  Log.e(TAG, "onScrolled() called with: recyclerView = ["  + "], dx = [" + dx + "], dy = [" + dy + "]");
                  super.onScrolled(recyclerView, dx, dy);
              }
          });
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setuId(i+"");
            user.setUserName("数据"+i);
            user.setAge(18+i+"");
            user.setHead("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495538647488&di=8f281ec408705d4cba0d031d0680f063&imgtype=0&src=http%3A%2F%2Fimg.bitscn.com%2Fupimg%2Fallimg%2Fc160120%2F1453262W253120-12J05.jpg");
            users.add(user);
        }
         adapter.addAll(users);
    }
}
