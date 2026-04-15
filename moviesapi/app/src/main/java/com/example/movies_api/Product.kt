package com.example.movies_api

interface Product {
    val name: String;
    val price: Int;
    val id: Int;
    fun printProductDetails();
}