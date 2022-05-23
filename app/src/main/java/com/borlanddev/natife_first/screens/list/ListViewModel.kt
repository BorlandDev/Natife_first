package com.borlanddev.natife_first.screens.list

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.borlanddev.natife_first.data.Item
import com.borlanddev.natife_first.data.ItemList
import com.borlanddev.natife_first.helpers.PREF_ID

class ListViewModel(private val preferences: SharedPreferences) :
    ViewModel() {

    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> = _items

    init {
        loadItem()
    }

    fun saveID(id: Int) {
        preferences.edit()
            .putInt(PREF_ID, id)
            .apply()
    }

    private fun loadItem() {
        _items.value = ItemList.items
    }
}