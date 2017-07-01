package com.gulbalasalamov.phonestatedemo;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class PhoneReceiver extends PhoneStateListener {

    Context context;

    public PhoneReceiver(Context context) {
        this.context = context;
    }

    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
        super.onCallStateChanged(state, incomingNumber);

        switch (state) {
            case TelephonyManager.CALL_STATE_IDLE:
                //Telefon ne çalıyor ne de çağrıda değilse
                Toast.makeText(context, "boşta", Toast.LENGTH_SHORT).show();
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                //Telefon çağrı esnasındaysa
                Toast.makeText(context, "görüşme modunda", Toast.LENGTH_SHORT).show();
                break;
            case TelephonyManager.CALL_STATE_RINGING:
                //Telefon çalıyorsa
                Toast.makeText(context, "gelen arama", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
