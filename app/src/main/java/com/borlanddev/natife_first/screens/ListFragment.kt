package com.borlanddev.natife_first.screens

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.LinearLayoutManager
import com.borlanddev.natife_first.R
import com.borlanddev.natife_first.adapter.ItemsAdapter
import com.borlanddev.natife_first.databinding.FragmentListBinding
import com.borlanddev.natife_first.helpers.APP_PREFERENCES
import com.borlanddev.natife_first.helpers.ViewModelFactory
import com.borlanddev.natife_first.viewModels.ListViewModel

class ListFragment : Fragment(R.layout.fragment_list) {
    private lateinit var binding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)

        val preferences = (requireContext().getSharedPreferences(
            APP_PREFERENCES,
            Context.MODE_PRIVATE
        )) as SharedPreferences

        listViewModel = ViewModelProvider(this, ViewModelFactory(preferences))
            .get(ListViewModel::class.java)

        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(context)

            listViewModel.items.observe(
                viewLifecycleOwner
            )
            { itemLiveData ->

                recyclerView.adapter = ItemsAdapter(items = itemLiveData)
                {
                    listViewModel.saveID(it.id)

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

}





