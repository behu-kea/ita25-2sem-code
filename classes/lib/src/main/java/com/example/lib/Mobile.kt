package com.example.lib

//brand, price, batteryPercentage
class Mobile(val brand: String, var price: Float) {
    var batteryPercentage: Int = 0

    init {
        println("asd")
    }

    fun getDiscount(): Float {
        return price * 0.1f;
    }

    override fun toString(): String {
        return "Mobile(brand='$brand', price=$price, batteryPercentage=$batteryPercentage)"
    }
}