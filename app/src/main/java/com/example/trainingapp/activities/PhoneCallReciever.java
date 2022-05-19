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
import android.widget.Toast;

import java.util.prefs.NodeChangeEvent;

public class PhoneCallReciever extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {
        TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                if((intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_RINGING) && intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER) != null)){
                    String num=intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
                    SmsManager smsManager=SmsManager.getDefault();
                    smsManager.sendTextMessage(num,null,"Hey, I am busy at the moment",null,null);
                }
            }
        }

