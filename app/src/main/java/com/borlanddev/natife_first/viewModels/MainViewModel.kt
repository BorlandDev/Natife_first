package com.borlanddev.natife_first.viewModels

import androidx.lifecycle.ViewModel
import com.borlanddev.natife_first.data.ItemList
import com.borlanddev.natife_first.helpers.SingleLiveEvent

class MainViewModel : ViewModel() {

    private val _singleLiveEvent = SingleLiveEvent<Int>()
    val singleLiveEvent = _singleLiveEvent

    fun valideID(id: Int) {

        if (id != -1 && id <= ItemList.items.size)
        singleLiveEvent.value = id
    }
}



