package com.example.moviles_tp1_integracion;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private callingBroadCastReceiver du;

    // TUTORIAL
    // https://www.youtube.com/watch?v=pBRykMcu0lw
    private IntentFilter chargingIntentFilter;
    private ChargingBroadCastReceiver chargingBroadCastReceriver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chargingIntentFilter = new IntentFilter();
        chargingIntentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        chargingIntentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        chargingBroadCastReceriver = new ChargingBroadCastReceiver();

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M
                && checkSelfPermission(Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},1000);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //du = new DetectarUSB();
        //registerReceiver(du, new IntentFilter("android.hardware.usb.action.USB_STATE"));
        registerReceiver(chargingBroadCastReceriver, chargingIntentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //unregisterReceiver(du); // Detener la detección del conector USB
        unregisterReceiver(chargingBroadCastReceriver);
    }
}