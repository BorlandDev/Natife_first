package com.borlanddev.natife_first.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.borlanddev.natife_first.R
import com.borlanddev.natife_first.databinding.FragmentListBinding

class ListFragment: Fragment(R.layout.fragment_list)  {

    private lateinit var binding: FragmentListBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentListBinding.bind(view)

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_detailsFragment)
        }
    }
}