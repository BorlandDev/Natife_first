package com.borlanddev.natife_first.model

import com.borlanddev.natife_first.helpers.DEF_ITEM_ID

data class Item(
    var id: Int = DEF_ITEM_ID,
    var name: String = "",
    var description: String = ""
)
