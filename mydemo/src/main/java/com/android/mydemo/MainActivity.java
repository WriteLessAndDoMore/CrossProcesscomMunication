package com.android.mydemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        String result = getIntent().getStringExtra("stringextra");
//        User user = getIntent().getParcelableExtra("userextra");
        Bundle bundle = getIntent().getBundleExtra("userextra");
//        Toast.makeText(this, user.getName() + user.getAge(), Toast.LENGTH_LONG).show();
    }
}