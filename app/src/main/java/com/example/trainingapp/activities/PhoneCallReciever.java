package com.example.trainingapp.activities;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

import java.util.prefs.NodeChangeEvent;

public class PhoneCallReciever extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {
        TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        manager.listen(new PhoneStateListener(){
            @Override
            public void onCallStateChanged(int state, String incomingNumber){
                super.onCallStateChanged(state, incomingNumber);
                if(state==TelephonyManager.CALL_STATE_RINGING){

                    SmsManager smsManager=SmsManager.getDefault();
                    smsManager.sendTextMessage(incomingNumber,null,"Hey, I am busy at the moment writing my training program with the 'Training Planner' app. I will make sure to call you later. In the meantime, maybe check out the app on Play Store: https://play.google.com/store/apps/details?id=com.example.trainingapp.",null,null);

                }
            }
        },PhoneStateListener.LISTEN_CALL_STATE);
    }
}