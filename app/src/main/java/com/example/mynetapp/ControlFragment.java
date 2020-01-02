package com.example.mynetapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;


public class ControlFragment extends Fragment {
    private static final String TAG = "MyNetApp";
    private TargetInfor targetInfor;
    private Communicate communicate;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            switch(msg.what){
                case 1:
                    Log.d(TAG,"recv msg 1");
                    Switch connectSwitch = getView().findViewById(R.id.switch_connect);
                    connectSwitch.setChecked(false);
                    break;
                case 2:
                    Log.d(TAG,"recv msg 2");
                    break;
            }
        }
    };
    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        communicate = new Communicate();
        targetInfor = new TargetInfor(getActivity(),"192.168.1.100","6000");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_control, container, false);
        TextView ipTextView = v.findViewById(R.id.textView_control_ip);
        ipTextView.setText("IP: " +targetInfor.getTargetIP());

        TextView portTextView = v.findViewById(R.id.textView_control_port);
        portTextView.setText("PORT: "+targetInfor.getTargetPort());

        Switch connectSwitch = v.findViewById(R.id.switch_connect);
        connectSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(final CompoundButton switchView, boolean isChecked){
                if(isChecked){
                    /*new Thread(){
                        @Override
                        public void run() {
                            super.run();
                            try {
                                Thread.sleep(1000);
                                mHandler.sendEmptyMessage(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();*/


                    Log.d(TAG,"switch on");
                }else{

                    mHandler.sendEmptyMessage(2);
                    Log.d(TAG,"switch off");
                }
            }
        });
        Button leftButton = v.findViewById(R.id.button_left);
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                communicate.sendSomeMessage(1);
            }
        });
        Button rightButton = v.findViewById(R.id.button_right);
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                communicate.sendSomeMessage(2);
            }
        });
        return v;
    }
}
