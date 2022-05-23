package com.borlanddev.natife_first.presenter

import com.borlanddev.natife_first.model.ItemList

class MainPresenter: MainContract.Presenter {
    override fun valideID(id: Int): Boolean = ItemList.valideID(id)
}