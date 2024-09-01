package com.example.practica02alarmas

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var alarmManager: AlarmManager
    private lateinit var pendingIntent: PendingIntent
    private lateinit var intent: Intent
    private lateinit var edtTiempo: EditText
    private lateinit var btnSetAlarm: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        intent = Intent(this, InfoActivity::class.java)
        pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
        edtTiempo = findViewById(R.id.edtTiempo)
        btnSetAlarm = findViewById(R.id.btnSetAlarm)
        btnSetAlarm.setOnClickListener {
            if(edtTiempo.text.isEmpty()){
                edtTiempo.error = "Campo requerido"
                return@setOnClickListener
            }
            val minutes = edtTiempo.text.toString().toInt()
            Toast.makeText(this, "Alarma programada en ${minutes} minutos", Toast.LENGTH_SHORT).show()
            setTimer(minutes)
        }
    }
    private fun setTimer(minutes: Int){
        val calendar: Calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            add(Calendar.MINUTE, minutes)
        }
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)
    }

}