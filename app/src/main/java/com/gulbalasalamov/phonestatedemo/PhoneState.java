package com.gulbalasalamov.phonestatedemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class PhoneState extends AppCompatActivity {

    TelephonyManager manager;
    PhoneReceiver myPhoneStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_state);

        myPhoneStateListener = new PhoneReceiver(this);
        manager = ((TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE));
    }

    public void onResume(){
        super.onResume();
        manager.listen(myPhoneStateListener, myPhoneStateListener.LISTEN_CALL_STATE);
    }

    public void onPause() {
        super.onPause();
        manager.listen(myPhoneStateListener,
                myPhoneStateListener.LISTEN_NONE);
    }

}
