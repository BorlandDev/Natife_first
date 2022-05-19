package com.borlanddev.natife_first.services

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.borlanddev.natife_first.R
import com.borlanddev.natife_first.helpers.MY_ACTION
import com.borlanddev.natife_first.helpers.NOTIFICATION_CHANNEL_ID
import com.borlanddev.natife_first.helpers.NOTIFICATION_ID
import com.borlanddev.natife_first.helpers.REQUEST_CODE_PENDING_INTENT

class MyService : Service() {

    @SuppressLint("LaunchActivityFromNotification")
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val pendingIntent =
            PendingIntent.getBroadcast(
                this,
                REQUEST_CODE_PENDING_INTENT,
                Intent(MY_ACTION),
                PendingIntent.FLAG_IMMUTABLE
            )

        val notification = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setTicker(resources?.getString(R.string.notification_title))
            .setSmallIcon(R.drawable.baseline_sports_bar_black_24)
            .setContentTitle(resources?.getString(R.string.notification_title))
            .setContentText(resources?.getString(R.string.notification_text))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(NOTIFICATION_ID, notification)
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null

}



