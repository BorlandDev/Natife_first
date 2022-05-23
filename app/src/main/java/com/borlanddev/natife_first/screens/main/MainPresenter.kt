package com.borlanddev.natife_first.screens.main

import com.borlanddev.natife_first.model.ItemList

class MainPresenter : MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun attach(view: MainContract.View?) {
        this.view = view
    }

    override fun valideID(id: Int) {
        val lastID = id != -1 && id <= ItemList.items.size - 1

        if (lastID) {
            view?.goToLastItemDetails(id)
        }
    }

    override fun detach() {
        this.view = null
    }
}
