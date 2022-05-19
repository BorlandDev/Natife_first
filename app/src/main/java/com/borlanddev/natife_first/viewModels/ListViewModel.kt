package com.borlanddev.natife_first.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.borlanddev.natife_first.data.Item
import com.borlanddev.natife_first.data.ItemList

class ListViewModel : ViewModel() {

    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> = _items

    init {
        loadItem()
    }

    private fun loadItem() {
        _items.value = ItemList.items
    }
}