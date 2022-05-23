package com.borlanddev.natife_first.helpers

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.borlanddev.natife_first.screens.list.ListViewModel

class ViewModelFactory(
    private val preferences: SharedPreferences
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListViewModel(preferences) as T
    }
}
