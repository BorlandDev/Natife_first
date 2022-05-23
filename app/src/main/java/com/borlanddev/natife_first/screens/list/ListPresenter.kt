package com.borlanddev.natife_first.screens.list

import android.content.SharedPreferences
import com.borlanddev.natife_first.helpers.PREF_ID
import com.borlanddev.natife_first.model.ItemList

class ListPresenter(private val preferences: SharedPreferences) : ListContract.Presenter {
    private var view: ListContract.View? = null

    override fun attach(view: ListContract.View?) {
        this.view = view
    }

    override fun getItems() {
        val items = ItemList.getItemList()

        view?.showItems(items)
    }

    override fun saveIDtoPref(id: Int) {
        preferences.edit()
            .putInt(PREF_ID, id)
            .apply()
    }

    override fun detach() {
        view = null
    }
}