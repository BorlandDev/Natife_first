package com.borlanddev.natife_first.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.borlanddev.natife_first.data.ItemList
import com.borlanddev.natife_first.helpers.SingleLiveEvent

class MainViewModel : ViewModel() {

    private val _getLastID = SingleLiveEvent<Int>()
    val getLastID: LiveData<Int> = _getLastID

    fun valideID(id: Int) {
        if (id != -1 && id <= ItemList.items.size) {
            _getLastID.value = id
        }
    }
}



