package com.example.testing

import com.example.testing.models.Cart
import com.example.testing.models.Item
import junit.framework.TestCase.assertEquals
import org.junit.Test

class CartTester {
    @Test
    fun testCartTotal() {
        val tv = Item("TV", 2000.0, 2)
        val mobile = Item("Mobile", 7000.0, -2)

        val cart = Cart()
        cart.addItem(tv)
        cart.addItem(mobile)

        val total = cart.calculateTotal()
        assertEquals(4000.0, total)
    }
}