package com.nandaadisaputra.submission3dicodingmade.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.nandaadisaputra.submission3dicodingmade.R;
import com.nandaadisaputra.submission3dicodingmade.base.BaseAppCompatActivity;

public class SplashScreenActivity extends BaseAppCompatActivity {

    //Set waktu lama splashscreen
    private static int splashInterval = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // menghubungkan activity splashscren ke main activity dengan intent
                Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(i);


                //jeda selesai Splashscreen
                this.finish();
            }

            private void finish() {

            }
        }, splashInterval);

    }

}