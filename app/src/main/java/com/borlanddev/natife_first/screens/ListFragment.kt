package com.borlanddev.natife_first.screens

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.LinearLayoutManager
import com.borlanddev.natife_first.MainActivity
import com.borlanddev.natife_first.NOTIFICATION_CHANNEL_ID
import com.borlanddev.natife_first.R
import com.borlanddev.natife_first.adapter.ItemsAdapter
import com.borlanddev.natife_first.data.ItemList
import com.borlanddev.natife_first.databinding.FragmentListBinding

private const val TAG = "ListFragment"
private const val APP_PREFERENCES = "APP_PREFERENCES"
private const val PREF_ID = "PREF_ID"

class ListFragment : Fragment(R.layout.fragment_list) {
    private lateinit var binding: FragmentListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentListBinding.bind(view)

        val intent = newIntent(requireContext())
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
        val resources = context?.resources

        val notification = NotificationCompat
            .Builder(requireContext(), NOTIFICATION_CHANNEL_ID)
            .setTicker(resources?.getString(R.string.notification_title))
            .setSmallIcon(R.drawable.baseline_sports_bar_black_24)
            .setContentTitle(resources?.getString(R.string.notification_title))
            .setContentText(resources?.getString(R.string.notification_text))
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .build()

        val notificationManager = NotificationManagerCompat.from(requireContext())
        notificationManager.notify(0, notification)

        val preferences = (context?.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
            ?: 1) as SharedPreferences
        Log.d(TAG, preferences.getInt(PREF_ID, -1).toString())

        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = ItemsAdapter(items = ItemList.items)
            {
                preferences.edit()
                    .putInt(PREF_ID, it.id)
                    .apply()

                val chekedID = ItemList.getById(it.id)
                val direction =
                    ListFragmentDirections.actionListFragmentToDetailsFragment(chekedID?.id ?: 0)

                findNavController().navigate(
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
        }
    }


    companion object {
        fun newIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

}





