package com.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.android.myapplication.constant.Constant;
import com.android.mylibrary.bean.User2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "dxy";
    @SuppressLint("SdCardPath")
    public static final String PATH = "/data/data/com.android.myapplication/user.txt";;
    @SuppressLint("SdCardPath")
    public static final String DIR = "/data/data/com.android.myapplication/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "result:" + Constant.num);
        Constant.num++;

    }

    public void go2(View view) {
        write();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.android.mydemo", "com.android.mydemo.MainActivity"));
        startActivity(intent);
//        startActivity(new Intent(this, MainActivity2.class));
    }

    private void write() {
        User2 user = new User2();
        user.setAge(18);
        user.setName("张三");

        File dir = new File(DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File userFile = new File(PATH);
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(userFile));
            out.writeObject(user);
            Toast.makeText(MainActivity.this, "User data written successfully", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "write user:" + user + " to file:" + userFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




        /*User2 user2 = new User2();
        user2.setAge(18);
        user2.setName("张三");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH));
            oos.writeObject(user2);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

//        Log.d(TAG, "user ->" + user2);
    }
}