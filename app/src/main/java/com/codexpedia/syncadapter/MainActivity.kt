package com.codexpedia.syncadapter

import android.annotation.TargetApi
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat

import com.codexpedia.syncadapter.sync.MyServiceSyncAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MyServiceSyncAdapter.initializeSyncAdapter(applicationContext)

        val NOTIFICATION_CHANNEL_ID = "lksjgioajw20u43knjak"
        val mBuilder = NotificationCompat.Builder(this, "default")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("A simple notification")
                .setContentText("Swipe to dismiss it")
                .setChannelId(NOTIFICATION_CHANNEL_ID)
                .setAutoCancel(true)
        val notification = mBuilder.build()

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        @TargetApi(26)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(NOTIFICATION_CHANNEL_ID,
                    "A simple notification",
                    NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }
        notificationManager.notify(1, notification)
    }
}
