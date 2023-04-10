package com.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.myapplication.constant.Constant;

public class MainActivity2 extends AppCompatActivity {
    public static final String TAG = "MainActivity2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.i(TAG, "result:" + Constant.num);
    }

    public void go3(View view) {
        startActivity(new Intent(this, MainActivity3.class));
    }
}