package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val image: String,
    val price: String,
    val priceWithDiscount: String = ""
) {
    val hasDiscount = priceWithDiscount.isNotBlank()
}
