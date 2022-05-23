package com.borlanddev.natife_first.presenter

interface MainContract {

    interface Presenter {
        fun valideID(id: Int): Boolean
    }

    interface Model {
        fun valideID(id: Int): Boolean
    }
}