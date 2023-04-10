package com.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.myapplication.bean.User;
import com.android.myapplication.constant.Constant;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "result:" + Constant.num);
        Constant.num++;

    }

    public void go2(View view) {
        startActivity(new Intent(this, MainActivity2.class));
    }
}