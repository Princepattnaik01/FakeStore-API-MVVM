package com.example.apicalling.model

data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val category: String,
    val image: String,
    val rating: Rating
)