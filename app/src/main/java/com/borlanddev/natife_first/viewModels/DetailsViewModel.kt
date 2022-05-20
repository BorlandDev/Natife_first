package com.borlanddev.natife_first.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.borlanddev.natife_first.data.Item
import com.borlanddev.natife_first.data.ItemList

class DetailsViewModel : ViewModel() {

    private val _getItemLiveData = MutableLiveData<Item>()
    val getItemLiveData = _getItemLiveData

    fun getItem(id: Int) {
        getItemLiveData.value = ItemList.getById(id)
    }
}