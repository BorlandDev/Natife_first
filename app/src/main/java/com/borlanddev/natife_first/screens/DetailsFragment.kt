package com.borlanddev.natife_first.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.borlanddev.natife_first.R
import com.borlanddev.natife_first.databinding.FragmentDetailsBinding
import com.borlanddev.natife_first.viewModels.DetailsViewModel

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private lateinit var binding: FragmentDetailsBinding
    private val args: DetailsFragmentArgs by navArgs()
    private val detailsViewModel: DetailsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailsBinding.bind(view)

        val currentItem = detailsViewModel.getItem(args.id)

        with(binding) {
            itemId.text = currentItem?.id.toString()
            itemTextName.text = currentItem?.name
            itemDescriptionNote.text = currentItem?.description
        }
    }
}




