package com.borlanddev.natife_first.screens

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

class ListFragment : Fragment(R.layout.fragment_list) {
    private lateinit var binding: FragmentListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentListBinding.bind(view)

        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = ItemsAdapter(items = ItemList.items,
                onItemClick = {
                    val direction = ListFragmentDirections.actionListFragmentToDetailsFragment(it.id)
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
                    })
                }
            }


}





