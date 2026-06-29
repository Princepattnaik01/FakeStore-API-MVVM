package com.example.apicalling.api

import com.example.apicalling.model.Product
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getProducts(): List<Product>
}