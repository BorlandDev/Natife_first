package com.borlanddev.natife_first.presenter

import com.borlanddev.natife_first.model.Item
import com.borlanddev.natife_first.model.ItemList

class DetailsPresenter : DetailsContract.Presenter {
    override fun getCurrentItem(id: Int): Item? = ItemList.getById(id)
}