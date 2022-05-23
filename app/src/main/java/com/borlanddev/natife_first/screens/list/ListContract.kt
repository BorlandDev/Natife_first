package com.borlanddev.natife_first.screens.list

import com.borlanddev.natife_first.model.Item

interface ListContract {

    interface Presenter {
        fun attach(view: View?)

        fun getItems()

        fun saveIDtoPref(id: Int)

        fun detach()
    }

    interface View {
        fun showItems(items: List<Item>)
    }

}


