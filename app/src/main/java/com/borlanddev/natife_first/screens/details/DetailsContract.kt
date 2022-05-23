package com.borlanddev.natife_first.screens.details

import com.borlanddev.natife_first.model.Item

interface DetailsContract {

    interface Presenter {
        fun attach(view: View?)

        fun getItem(id: Int)

        fun detach()
    }

    interface View {
        fun showCurrentItem(item: Item)
    }
}

