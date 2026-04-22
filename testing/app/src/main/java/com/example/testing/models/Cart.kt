package com.example.testing.models

import com.example.testing.models.Item

class Cart {
    val items: MutableList<Item> = mutableListOf()

    fun addItem(item: Item) {
        items.add(item)
    }

    fun calculateTotal(): Double {
        return items.sumOf {
            if(it.price > 0 && it.quantity > 0) {
                it.price * it.quantity
            }
            else 0.0
        }
    }
}