package com.example.trainingapp.activities;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.PhoneStateListener;
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

                    Intent intent= new Intent();
                    intent.setAction(Intent.ACTION_CALL);
                    Uri uri = Uri.parse("tel:054-5555555");
                    intent.setData(uri);
                    //startActivity(intent);

                    Notification.Builder builder=new Notification.Builder(context);
                    builder.setContentText(incomingNumber);
                    builder.setSmallIcon(android.R.drawable.star_on);
                    Notification notification = builder.build();
                    NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                    notification.flags |= Notification.FLAG_AUTO_CANCEL;
                    notification.defaults=Notification.DEFAULT_VIBRATE | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND;
                    notificationManager.notify(0,notification);
                }
            }
        },PhoneStateListener.LISTEN_CALL_STATE);
    }
}