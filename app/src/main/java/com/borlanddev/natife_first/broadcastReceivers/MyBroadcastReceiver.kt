package com.borlanddev.natife_first.broadcastReceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.borlanddev.natife_first.MainActivity
import com.borlanddev.natife_first.screens.APP_PREFERENCES
import com.borlanddev.natife_first.screens.PREF_ID

class MyBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        val preferences = context?.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
        val lastID = preferences?.getInt(PREF_ID, -1)

        val intentForMainActivity = Intent(context, MainActivity::class.java).apply {
            putExtra("lastID", lastID)
        }

        context?.startActivity(intentForMainActivity)
    }
}
