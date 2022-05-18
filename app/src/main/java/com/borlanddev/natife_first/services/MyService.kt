package com.borlanddev.natife_first.services

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.borlanddev.natife_first.NOTIFICATION_CHANNEL_ID
import com.borlanddev.natife_first.R

class MyService : Service() {

    @SuppressLint("LaunchActivityFromNotification")
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val pendingIntent =
            PendingIntent.getBroadcast(this, 0, Intent(MY_ACTION), PendingIntent.FLAG_IMMUTABLE)

        val notification = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setTicker(resources?.getString(R.string.notification_title))
            .setSmallIcon(R.drawable.baseline_sports_bar_black_24)
            .setContentTitle(resources?.getString(R.string.notification_title))
            .setContentText(resources?.getString(R.string.notification_text))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(223, notification)
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null

    companion object {
        const val MY_ACTION = "com.borlanddev.natife_first.MY_ACTION"
    }
}



