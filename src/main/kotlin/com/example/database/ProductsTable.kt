package com.example.database

import com.example.database.dao.impls.ProductsDaoImpl
import com.example.model.Product
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

object ProductsTable : Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 128)
    val description = varchar("description", 512)
    val image = varchar("image", 512)
    val price = varchar("price", 64)
    val priceWithDiscount = varchar("priceWithDiscount", 64)

    val dao = ProductsDaoImpl()
    override val primaryKey = PrimaryKey(id)
}

fun toProduct(row: ResultRow) = Product(
    id = row[ProductsTable.id],
    name = row[ProductsTable.name],
    description = row[ProductsTable.description],
    image = row[ProductsTable.image],
    price = row[ProductsTable.price],
    priceWithDiscount = row[ProductsTable.priceWithDiscount]
)
