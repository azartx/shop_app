package com.example.database.dao

import com.example.model.Product

interface ProductsDao {
    suspend fun getAllProducts(): List<Product>
    suspend fun getProductById(id: Int): Product?
    suspend fun saveProducts(products: List<Product>)
    suspend fun saveProduct(product: Product)
}
