package com.example.mynetapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class SetFragment extends Fragment {
    private String TAG="MyNetApp";
    private String ip,port;
    private TargetInfor targetInfor;
    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        targetInfor = new TargetInfor(getActivity(),"192.168.1.100","6000");
        ip = targetInfor.getTargetIP();
        port = targetInfor.getTargetPort();
        Log.d(TAG,"set fragment onCreate");
        Log.d(TAG,"read ip " + ip);
        Log.d(TAG,"read port " + port);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG,"set fragment onCreateView");
        View v = inflater.inflate(R.layout.fragment_set, container, false);
        Button button=v.findViewById(R.id.btn_save);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText ipEditText = getView().findViewById(R.id.editText);
                EditText portEditText = getView().findViewById(R.id.editText2);
                String s_ip = ipEditText.getText().toString();
                String s_port = portEditText.getText().toString();
                targetInfor.setTargetIP(s_ip);
                targetInfor.setTargetPort(s_port);

                Context context = getActivity().getApplicationContext();
                CharSequence text = "保存成功!";
                Toast toast = Toast.makeText(context,text,Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        EditText ipEditText = v.findViewById(R.id.editText);
        ipEditText.setText(ip);
        Log.d(TAG,"read ip " + ip);
        EditText portEditText = v.findViewById(R.id.editText2);
        portEditText.setText(port);
        Log.d(TAG,"read port " + port);
        return v;
    }

}
