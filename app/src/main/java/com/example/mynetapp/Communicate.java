package com.example.mynetapp;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

public class Communicate{
    private static final String TAG = "MyNetApp";
    private boolean state = false;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    Log.d(TAG,"Recv left button");
                    break;
                case 2:
                    Log.d(TAG,"Recv Right button");
                    break;
            }
        }
    };

    public Communicate() {
        Log.d(TAG,"New Thread in communicate");
    }
    public void sendSomeMessage(int sendData){
        handler.sendEmptyMessage(sendData);
    }
}
