package com.borlanddev.natife_first.presenter

import android.content.SharedPreferences
import com.borlanddev.natife_first.helpers.PREF_ID
import com.borlanddev.natife_first.model.ItemList

class ListPresenter : ListContract.Presenter {

    override fun updateItems() = ItemList.getItemList()

    override fun saveIDtoPref(preferences: SharedPreferences, id: Int) {
        preferences.edit()
            .putInt(PREF_ID, id)
            .apply()
    }
}