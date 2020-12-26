package com.haorong.a01_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class DailReceiver_ip电话 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //获取电话号码
        String number = getResultData();
        //默认增加前缀：10086
        setResultData("10086"+number);
        System.out.println("打电话了...");
    }
}
