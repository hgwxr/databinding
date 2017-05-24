package com.example.administrator.databinding;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/5/23.
 */

public class User {
    private String userName;
    private String age;
    private String uId;
    private String head;
    private final  String   RRECYCLERVIEW = "0";;
    private boolean clickAble;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public void setClickAble(boolean clickAble) {
        this.clickAble = clickAble;
    }

    public boolean isClickAble() {
        return TextUtils.isEmpty(uId);
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getuId() {
        return uId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public final void onClick(View view){
        switch (uId) {
            case RRECYCLERVIEW :
                Context context = view.getContext();
                Intent intent = new Intent(context, RecyclerViewActivity.class);
                context.startActivity(intent);
                break;
                default:
                    if (view instanceof TextView){
                            ((TextView) view).setError("error", ContextCompat.getDrawable(view.getContext(),R.mipmap.ic_launcher_round));
                    }
                    break;
        }
    }
}
