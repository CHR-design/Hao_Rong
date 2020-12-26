package com.haorong.a01_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;

public class SmsReceiver_短信监听 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Object[] objects = (Object[]) intent.getExtras().get("pdus");
        for(Object obj:objects){
            SmsMessage message = SmsMessage.createFromPdu((byte[]) obj);
            String originatingAddress = message.getOriginatingAddress();
            String messageBody = message.getMessageBody();
            System.out.println("from "+originatingAddress+":\n\t"+messageBody);
        }

        System.out.println("来短信了..");
    }
}
