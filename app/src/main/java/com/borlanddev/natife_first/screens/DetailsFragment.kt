package com.borlanddev.natife_first.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.borlanddev.natife_first.R
import com.borlanddev.natife_first.databinding.FragmentDetailsBinding
import com.borlanddev.natife_first.presenter.DetailsPresenter

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private lateinit var binding: FragmentDetailsBinding
    private val args: DetailsFragmentArgs by navArgs()
    private val detailsPresenter = DetailsPresenter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailsBinding.bind(view)

        val currentItem = detailsPresenter.getCurrentItem(args.id)

        with(binding) {
            itemId.text = currentItem?.id.toString()
            itemTextName.text = currentItem?.name
            itemDescriptionNote.text = currentItem?.description
        }
    }


}




