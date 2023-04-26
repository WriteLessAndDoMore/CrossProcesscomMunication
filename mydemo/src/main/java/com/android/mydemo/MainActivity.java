package com.android.mydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.android.mylibrary.bean.User2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "dxy";
    @SuppressLint("SdCardPath")
    public static final String PATH = "/data/data/com.android.myapplication/user.txt";;
    @SuppressLint("SdCardPath")
    public static final String DIR = "/data/data/com.android.myapplication";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File userFile = getUserFile();
        User2 user = readUserFromFile(userFile);
        Log.d(TAG, "Read user:" + user + " from file:" + userFile);

    }

    private File getUserFile() {
        File dir = new File(DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File userFile = new File(PATH);
        return userFile;
    }

    private User2 readUserFromFile(File file) {
        User2 user = null;
        ObjectInputStream in = null;
        try {
            Log.e(TAG,"------------666");
            in = new ObjectInputStream(new FileInputStream(file));
            Log.e(TAG,"------------0");
            user = (User2) in.readObject();
            Log.e(TAG,"------------1");
        } catch (ClassNotFoundException e) {
            Log.e(TAG,"------------2");
            e.printStackTrace();
        } catch (IOException e) {
            Log.e(TAG,"------------3");
            String s = e.getMessage();
            Log.e(TAG,"------------3" + s);
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    Log.e(TAG,"------------4");
                    e.printStackTrace();
                }
            }
        }
        return user;
    }

    private void read() {
       /* try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH));
            user2= (User2) ois.readObject();
            Log.d(TAG, "user ->" + user2);
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            Log.d(TAG, "user ->" + e.getMessage());
            e.printStackTrace();
        }*/

    }


}