package com.example.moviles_tp1_integracion;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DetectarUSB extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"  Se ha conectado/desconectado el USB. Se está iniciando una llamada al 911.", Toast.LENGTH_LONG).show();
        Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "911"));
        //i.setData(Uri.parse("tel:" + "911"));
        context.startActivity(i);
    }
}
