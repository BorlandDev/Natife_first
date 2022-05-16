package com.borlanddev.natife_first.data

import com.borlanddev.natife_first.R

object ItemList {

    val items = mutableListOf<Item>()

    init {
        for (i in 0 until 20) {

            val item = Item().apply {
                id = i
                name = "Something name $i"
                description = "Description #$i \n Some description for the given list item,\n" +
                        " who invented it and why? But it had to be so, otherwise, how else can you see all the\n" +
                        " beauty of this view if there is not a sufficient description size? Here it is.\n" +
                        " Well , not a bad example of a description , right ? Well , the sample text should be longer ,\n" +
                        " I hope you have not read it here yet . An example of sample text, this should be enough, just increase its size."
            }
            items += item
        }
    }

}