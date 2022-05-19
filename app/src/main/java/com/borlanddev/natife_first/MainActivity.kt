package com.borlanddev.natife_first

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions
import androidx.navigation.ui.NavigationUI
import com.borlanddev.natife_first.broadcastReceivers.MyBroadcastReceiver
import com.borlanddev.natife_first.helpers.KEY_LAST_ID
import com.borlanddev.natife_first.helpers.MY_ACTION
import com.borlanddev.natife_first.screens.ListFragmentDirections
import com.borlanddev.natife_first.services.MyService
import com.borlanddev.natife_first.viewModels.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var broadcastReceiver: MyBroadcastReceiver
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lastID = intent.extras?.getInt(KEY_LAST_ID)

        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHost.navController
        NavigationUI.setupActionBarWithNavController(this, navController)

        mainViewModel.valideID(lastID ?: -1)

        mainViewModel.singleLiveEvent.observe(
            this
        ) {
            val direction = ListFragmentDirections.actionListFragmentToDetailsFragment(it)

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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val intentForService = Intent(this, MyService::class.java)
            startForegroundService(intentForService)
        }

        broadcastReceiver = MyBroadcastReceiver()

        val filter = IntentFilter().apply {
            addAction(MY_ACTION)
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


