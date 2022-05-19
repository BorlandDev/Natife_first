package com.borlanddev.natife_first.viewModels

import androidx.lifecycle.ViewModel
import com.borlanddev.natife_first.data.Item
import com.borlanddev.natife_first.data.ItemList

class DetailsViewModel : ViewModel() {

    fun getItem(id: Int): Item? = ItemList.getById(id)
}