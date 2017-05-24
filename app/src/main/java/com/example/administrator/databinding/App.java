package com.example.administrator.databinding;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import java.util.logging.Logger;

/**
 * Created by Administrator on 2017/5/24.
 */

public class App extends Application  {
    private  final String TAG=App.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                Log.e(TAG, "onActivityCreated() called with: activity = [" + activity + "], savedInstanceState = [" + savedInstanceState + "]");
            }

            @Override
            public void onActivityStarted(Activity activity) {
                Log.e(TAG, "onActivityStarted: "+activity);
            }

            @Override
            public void onActivityResumed(Activity activity) {
                Log.e(TAG, "onActivityResumed: "+activity );
            }

            @Override
            public void onActivityPaused(Activity activity) {
                Log.e(TAG, "onActivityPaused: " +activity);
            }

            @Override
            public void onActivityStopped(Activity activity) {
                Log.e(TAG, "onActivityStopped: "+activity);
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                Log.e(TAG, "onActivitySaveInstanceState: "+activity+" "+outState );
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                Log.e(TAG, "onActivityDestroyed: "+activity );
            }
        });
    }


}
