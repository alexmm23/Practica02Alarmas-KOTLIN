package com.example.practica02alarmas

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class ReceptorAlarma : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val newIntent = Intent(context, InfoActivity::class.java)
        newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(newIntent)
    }


}