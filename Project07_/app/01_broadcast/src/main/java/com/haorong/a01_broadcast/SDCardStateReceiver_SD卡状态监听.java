package com.haorong.a01_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SDCardStateReceiver_SD卡状态监听 extends BroadcastReceiver {
    /**
     *
     * @param context 指的是哪里的context
     * @param intent 指的又是哪里的intent
     */
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.MEDIA_UNMOUNTED".equals(action)){
            System.out.println("SD卡被卸下了");
//            Toast.makeText(context,"SD卡被卸下了",Toast.LENGTH_SHORT).show();
        }else if ("android.intent.action.MEDIA_MOUNTED".equals(action)){
            System.out.println("SD卡被装上了");
//            Toast.makeText(context,"SD卡被装上了",Toast.LENGTH_SHORT).show();
        }
    }
}
