package com.borlanddev.natife_first.presenter

import android.content.SharedPreferences
import com.borlanddev.natife_first.model.Item

interface ListContract {

    interface Presenter {
        fun updateItems(): List<Item>

        fun saveIDtoPref(preferences: SharedPreferences, id: Int)
    }
    interface Model {
        fun getItemList(): List<Item>
    }
}