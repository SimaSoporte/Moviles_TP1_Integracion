package com.example.moviles_tp1_integracion;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

public class USB_BroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        boolean isCharging = (action.equals(Intent.ACTION_POWER_CONNECTED));

        //if ( intent.getExtras().getBoolean("connected") ) {
        if ( isCharging ) {

            Log.d("mensaje","Cargando");
            Toast.makeText(context,"  Se ha conectado el USB. Se está iniciando una llamada al *152#.", Toast.LENGTH_LONG).show();
            Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "*152#"));
            //i.setData(Uri.parse("tel:" + "911"));
            context.startActivity(i);

        } else {
            Log.d("mensaje","No se está Cargando");
            Toast.makeText(context,"USB desconectado",Toast.LENGTH_LONG).show();
        }
    }
}
