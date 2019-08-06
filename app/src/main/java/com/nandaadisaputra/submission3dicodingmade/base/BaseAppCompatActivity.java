package com.nandaadisaputra.submission3dicodingmade.base;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;

@SuppressLint("Registered")
public class BaseAppCompatActivity extends AppCompatActivity {

    public static final String KEY_TITLE = "title";
    public static final String KEY_FRAGMENT = "fragment";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidNetworking.initialize(this);
    }
}
