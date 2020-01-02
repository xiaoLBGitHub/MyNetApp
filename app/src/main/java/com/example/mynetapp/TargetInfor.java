package com.example.mynetapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class TargetInfor {
    private String TargetIP;
    private String TargetPort;
    private SharedPreferences SharedPref;
    private String KeyIp = "IP";
    private String KeyPort = "PORT";

    TargetInfor(Activity activity,String ip,String port){
        TargetIP = ip;
        TargetPort = port;
        SharedPref = activity.getPreferences(Context.MODE_PRIVATE);
    }

    public String getTargetIP() {
        TargetIP = SharedPref.getString(KeyIp,TargetIP);
        return TargetIP;
    }

    public void setTargetIP(String targetIP) {
        SharedPreferences.Editor editor = SharedPref.edit();
        editor.putString(KeyIp,targetIP);
        editor.commit();
        TargetIP = targetIP;
    }

    public String getTargetPort() {
        TargetPort = SharedPref.getString(KeyPort,TargetPort);
        return TargetPort;
    }

    public void setTargetPort(String targetPort) {
        SharedPreferences.Editor editor = SharedPref.edit();
        editor.putString(KeyPort,targetPort);
        editor.commit();
        TargetPort = targetPort;
    }
}
