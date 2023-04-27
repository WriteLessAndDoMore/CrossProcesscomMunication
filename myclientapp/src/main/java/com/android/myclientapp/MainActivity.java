package com.android.myclientapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import com.android.myserviceapp.BookAidl;

import com.android.myserviceapp.IBookManager;

public class MainActivity extends AppCompatActivity {
    /**
     * 接口对象
     */
    private IBookManager mService;
    /**
     * 绑定服务的回调
     */
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            // 获取到书籍管理的对象
//            mService = IBookManager.Default.Stub.asInterface(iBinder);
            Log.i("aidl","iBinder:"+iBinder);
            mService = IBookManager.Stub.asInterface(iBinder);


        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent();
        //跨进程通信需要使用action启动
        intent.setAction("com.android.myserviceapp.BookService");
        //android5.0之后，如果servicer不在同一个App的包中，需要设置service所在程序的包名
        intent.setPackage("com.android.myserviceapp");
        bindService(intent, conn, BIND_AUTO_CREATE);
    }


    public void getListBook(View view) {
        try {
            Log.i("aidl","客户端查询书籍"+mService);
            /*Log.i("aidl","客户端查询书籍"+mService.getBookList());*/
            Log.i("aidl","客户端查询书籍"+mService.getBookList().toString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    public void addBook(View view) {
        try {
            mService.addBook(new BookAidl(3, "C++"));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}