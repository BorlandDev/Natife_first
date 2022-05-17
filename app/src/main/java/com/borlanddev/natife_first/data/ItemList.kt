package com.borlanddev.natife_first.data

import java.nio.file.Files.find

object ItemList {
    val items: List<Item> by lazy {
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

    fun getById(id: Int): Item? = items.find { item -> item.id == id }


}
