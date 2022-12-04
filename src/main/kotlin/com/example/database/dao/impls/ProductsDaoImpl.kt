package com.example.database.dao.impls

import com.example.database.ProductsTable
import com.example.database.callDb
import com.example.database.dao.ProductsDao
import com.example.database.toProduct
import com.example.model.Product
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll

class ProductsDaoImpl : ProductsDao {
    override suspend fun getAllProducts() = callDb { ProductsTable.selectAll().map(::toProduct) }

    override suspend fun getProductById(id: Int): Product? {
        val row = ProductsTable.select(ProductsTable.id.eq(id)).firstOrNull() ?: return null
        return toProduct(row)
    }

    override suspend fun saveProducts(products: List<Product>) {
        callDb {
            products.forEach { product ->
                ProductsTable.insert {
                    it[name] = product.name
                    it[description] = product.description
                    it[image] = product.image
                    it[price] = product.price
                    it[priceWithDiscount] = product.priceWithDiscount
                }
            }
        }
    }

    override suspend fun saveProduct(product: Product) {
        callDb {
            ProductsTable.insert {
                it[name] = product.name
                it[description] = product.description
                it[image] = product.image
                it[price] = product.price
                it[priceWithDiscount] = product.priceWithDiscount
            }
        }
    }
}
