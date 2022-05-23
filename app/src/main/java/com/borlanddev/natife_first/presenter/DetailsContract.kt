package com.borlanddev.natife_first.presenter

import com.borlanddev.natife_first.model.Item

interface DetailsContract {

    interface Model {
        fun getById(id: Int): Item?
    }

    interface Presenter {
        fun getCurrentItem(id: Int): Item?
    }

}

