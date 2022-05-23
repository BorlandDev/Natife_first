package com.borlanddev.natife_first.screens.details

import com.borlanddev.natife_first.model.Item
import com.borlanddev.natife_first.model.ItemList

class DetailsPresenter : DetailsContract.Presenter {
    private var view: DetailsContract.View? = null

    override fun attach(view: DetailsContract.View?) {
        this.view = view
    }

    override fun getItem(id: Int) {
        val currentItem: Item? = ItemList.getById(id)

        currentItem?.let { view?.showCurrentItem(it) }
    }

    override fun detach() {
        this.view = null
    }
}