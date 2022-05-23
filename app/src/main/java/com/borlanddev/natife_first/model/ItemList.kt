package com.borlanddev.natife_first.model

import com.borlanddev.natife_first.presenter.DetailsContract
import com.borlanddev.natife_first.presenter.ListContract
import com.borlanddev.natife_first.presenter.MainContract

object ItemList : DetailsContract.Model, MainContract.Model, ListContract.Model {
    private val items: List<Item> by lazy {
        (0 until 20).map {
            Item(
                id = it,
                name = "Name #$it",
                description = "Description #$it \n Some description for the given list item,\n" +
                        " who invented it and why? But it had to be so, otherwise, how else can you see all the\n" +
                        " beauty of this view if there is not a sufficient description size? Here it is.\n" +
                        " Well , not a bad example of a description , right ? Well , the sample text should be longer ,\n" +
                        " I hope you have not read it here yet . An example of sample text, this should be enough, just increase its size."
            )
        }
    }

    override fun getItemList() = items

    override fun getById(id: Int): Item? = items.find { it.id == id }

    override fun valideID(id: Int): Boolean {
        return id != -1 && id <= items.size -1
    }
}
