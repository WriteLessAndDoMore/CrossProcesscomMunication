package com.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.myapplication.constant.Constant;
import com.android.mylibrary.bean.User2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MainActivity2 extends AppCompatActivity {
    public static final String PATH = "/data/data/com.android.myapplication/user.txt";
    public static final String TAG = "dxy";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.i(TAG, "result:" + Constant.num);
        read();
    }

    public void go3(View view) {
        startActivity(new Intent(this, MainActivity3.class));
    }

    private void read() {
        User2 user2 = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH));
            user2 = (User2) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "user ->" + user2);
    }
}