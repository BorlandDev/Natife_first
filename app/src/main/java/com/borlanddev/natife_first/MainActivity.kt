package com.borlanddev.natife_first

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions
import androidx.navigation.ui.NavigationUI
import com.borlanddev.natife_first.broadcastReceivers.MyBroadcastReceiver
import com.borlanddev.natife_first.screens.ListFragmentDirections
import com.borlanddev.natife_first.services.MyService

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var broadcastReceiver: MyBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lastID = intent.extras?.getInt("lastID")

        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHost.navController
        NavigationUI.setupActionBarWithNavController(this, navController)

        if (lastID != -1 && lastID in 0..19) {
            val direction = ListFragmentDirections.actionListFragmentToDetailsFragment(lastID!!)

            navController.navigate(
                direction,
                navOptions {
                    anim {
                        enter = R.anim.enter
                        exit = R.anim.exit
                        popEnter = R.anim.pop_enter
                        popExit = R.anim.pop_exit
                    }
                })
        }


        val intent = Intent(this, MyService::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) startForegroundService(intent)

        broadcastReceiver = MyBroadcastReceiver()

        val filter = IntentFilter().apply {
            addAction(MyService.MY_ACTION)
        }

        registerReceiver(broadcastReceiver, filter)

    }

    override fun onSupportNavigateUp(): Boolean =
        navController.navigateUp() || super.onSupportNavigateUp()

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(broadcastReceiver)
    }

}


