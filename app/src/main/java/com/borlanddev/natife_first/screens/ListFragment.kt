package com.borlanddev.natife_first.screens

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.LinearLayoutManager
import com.borlanddev.natife_first.R
import com.borlanddev.natife_first.adapter.ItemsAdapter
import com.borlanddev.natife_first.data.ItemList
import com.borlanddev.natife_first.databinding.FragmentListBinding

const val APP_PREFERENCES = "APP_PREFERENCES"
const val PREF_ID = "PREF_ID"

class ListFragment : Fragment(R.layout.fragment_list) {
    private lateinit var binding: FragmentListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)

        val preferences = (requireContext().getSharedPreferences(
            APP_PREFERENCES,
            Context.MODE_PRIVATE
        )) as SharedPreferences

        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = ItemsAdapter(items = ItemList.items)
            {
                preferences.edit()
                    .putInt(PREF_ID, it.id)
                    .apply()

                val direction =
                    ListFragmentDirections.actionListFragmentToDetailsFragment(it.id)

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


}





