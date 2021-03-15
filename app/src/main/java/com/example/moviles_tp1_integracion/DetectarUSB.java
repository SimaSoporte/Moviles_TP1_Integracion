package com.example.moviles_tp1_integracion;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class DetectarUSB extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Se ha conectado/desconectado el USB. Se está iniciando una llamada al 911.", Toast.LENGTH_LONG).show();
        Intent i = new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:" + "911"));
        context.startActivity(i);
    }
}
