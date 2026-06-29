package com.example.apicalling.repository

import com.example.apicalling.api.ApiService

class ProductRepository(
    private val apiService: ApiService
) {

    suspend fun getProducts(): List<com.example.apicalling.model.Product> {
        return apiService.getProducts()
    }
}

