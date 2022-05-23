package com.borlanddev.natife_first.screens.main

interface MainContract {

    interface Presenter {
        fun attach(view: View?)

        fun valideID(id: Int)

        fun detach()
    }

    interface View {
        fun goToLastItemDetails(lastID: Int)
    }
}