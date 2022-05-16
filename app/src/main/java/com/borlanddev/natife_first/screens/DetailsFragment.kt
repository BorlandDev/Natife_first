package com.borlanddev.natife_first.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.borlanddev.natife_first.R
import com.borlanddev.natife_first.data.Item
import com.borlanddev.natife_first.data.ItemList
import com.borlanddev.natife_first.databinding.FragmentDetailsBinding
import com.borlanddev.natife_first.viewModels.DetailsViewModel

class DetailsFragment: Fragment(R.layout.fragment_details) {

    private lateinit var binding: FragmentDetailsBinding
    private val detailsViewModel by viewModels<DetailsViewModel>()
    private val args: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Инициализация биндинга
        binding = FragmentDetailsBinding.bind(view)

        val itemID = args.id
        val currentItem = ItemList.items[itemID]

        binding.itemId.text = currentItem.id.toString()
        binding.itemTextName.text = currentItem.name
        binding.itemDescriptionNote.text = currentItem.description
    }
}




