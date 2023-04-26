package com.android.mymessage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    /**
     * Messenger 对象
     */
    private Messenger mService;
    private ServiceConnection conn = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // IBinder 对象
            // 通过服务端返回的Binder 对象 构造Messenger
            mService = new Messenger(service);

            Log.i("messenger", "客户端以获取服务端Messenger对象");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 启动服务
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    public void send(View view) {
        try {
            // 向服务端发送消息
            Message message = Message.obtain();

            Bundle data = new Bundle();

            data.putString("msg", "lalala");

            message.setData(data);

            // ----- 传入Messenger 对象
            message.replyTo = messengerClient;
            // 发送消息
            mService.send(message);

            Log.i("messenger","向服务端发送了消息");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 构建handler 对象
     */
    public static Handler handler = new Handler(Looper.getMainLooper()){
        public void handleMessage(android.os.Message msg) {
            // 接受服务端发送的消息

            String msgService = msg.getData().getString("msg");

            Log.i("messenger","接收到服务端的消息--"+msgService);

        };
    };


    // 通过handler 构建Mesenger 对象
    private final Messenger messengerClient = new Messenger(handler);



}