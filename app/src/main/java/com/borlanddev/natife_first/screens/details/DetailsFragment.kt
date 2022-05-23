package com.borlanddev.natife_first.screens.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.borlanddev.natife_first.R
import com.borlanddev.natife_first.databinding.FragmentDetailsBinding
import com.borlanddev.natife_first.model.Item

class DetailsFragment : Fragment(R.layout.fragment_details), DetailsContract.View {

    private lateinit var binding: FragmentDetailsBinding
    private val args: DetailsFragmentArgs by navArgs()
    private val detailsPresenter = DetailsPresenter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailsBinding.bind(view)
        detailsPresenter.attach(this)
        detailsPresenter.getItem(args.id)
    }

    override fun showCurrentItem(item: Item) {
        with(binding) {
            itemId.text = item.id.toString()
            itemTextName.text = item.name
            itemDescriptionNote.text = item.description
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        detailsPresenter.detach()
    }
}
