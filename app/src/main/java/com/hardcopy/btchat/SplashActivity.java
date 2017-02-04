package com.hardcopy.btchat;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import pl.droidsonroids.gif.GifTextView;

/**
 * Created by Junyoung on 2016-06-26.
 */

public class SplashActivity extends Activity {
    private static int INTRO_TIME = 1500;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mHandler = new Handler();
        mHandler.postDelayed(mRunnable, INTRO_TIME);

        GifTextView intro = (GifTextView) findViewById(R.id.splash);
    }

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(SplashActivity.this, Main0Activity.class);
            startActivity(intent);
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mHandler.removeCallbacks(mRunnable);
    }
}
