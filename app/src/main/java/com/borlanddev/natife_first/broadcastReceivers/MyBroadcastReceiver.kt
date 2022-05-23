package com.borlanddev.natife_first.broadcastReceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.borlanddev.natife_first.screens.main.MainActivity
import com.borlanddev.natife_first.helpers.APP_PREFERENCES
import com.borlanddev.natife_first.helpers.DEF_PREF_VALUE
import com.borlanddev.natife_first.helpers.KEY_LAST_ID
import com.borlanddev.natife_first.helpers.PREF_ID

class MyBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        val preferences = context?.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
        val lastID = preferences?.getInt(PREF_ID, DEF_PREF_VALUE)

        val intentForMainActivity = Intent(context, MainActivity::class.java).apply {
            putExtra(KEY_LAST_ID, lastID)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        context?.startActivity(intentForMainActivity)
    }
}
