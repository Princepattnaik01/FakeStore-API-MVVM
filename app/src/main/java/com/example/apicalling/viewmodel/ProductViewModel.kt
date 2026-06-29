package com.example.apicalling.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicalling.api.RetrofitClient
import com.example.apicalling.model.Product
import com.example.apicalling.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {

    private val repository =
        ProductRepository(
            RetrofitClient.apiService
        )

    private val _products =
        MutableStateFlow<List<Product>>(emptyList())

    val products: StateFlow<List<Product>>
            = _products

    init {
        fetchProducts()
    }

    private fun fetchProducts() {

        viewModelScope.launch {

            try {

                _products.value =
                    repository.getProducts()

            } catch (e: Exception) {

                e.printStackTrace()
            }
        }
    }
}

