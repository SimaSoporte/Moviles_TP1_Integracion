package com.example.moviles_tp1_integracion;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class DetectarUSB extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Se ha conectado el USB", Toast.LENGTH_LONG).show();
    }
}
