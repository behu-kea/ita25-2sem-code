package com.example.movies_api

import android.util.Log

class Mobile(override val name: String, override val price: Int): Computer {
    var battery: Int = 0

    override fun printNameAndPrice() {
        Log.d("hej", "printNameAndPrice: ")
    }
}
