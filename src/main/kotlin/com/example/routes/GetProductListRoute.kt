package com.example.routes

import com.example.database.ProductsTable
import com.example.model.Product
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.productsRoutes() {
    get(path = "/products") {
        val products = ProductsTable.dao.getAllProducts()
        call.respond(HttpStatusCode.OK, products)
    }
    get(path = "/product") {
        val id = call.parameters["id"]?.toIntOrNull()
        if (id == null) {
            call.respond(HttpStatusCode.BadRequest, "You must provide the correct id as a call query")
            return@get
        }
        val product = ProductsTable.dao.getProductById(id)
        if (product == null) {
            call.respond(HttpStatusCode.BadRequest, "There is no product with id which equal to $id")
            return@get
        }
        call.respond(HttpStatusCode.OK, product)
    }
    post(path = "/products") {
        val products = runCatching { call.receive<List<Product>>() }
        if (products.isFailure)
            call.respond(HttpStatusCode.BadRequest, "Request cannot be converted to Product obj")
        else {
            ProductsTable.dao.saveProducts(products.getOrThrow())
            call.respond(HttpStatusCode.OK)
        }
    }
    post(path = "/product") {
        val products = runCatching { call.receive<Product>() }
        if (products.isFailure)
            call.respond(HttpStatusCode.BadRequest, "Request cannot be converted to Product obj")
        else {
            ProductsTable.dao.saveProduct(products.getOrThrow())
            call.respond(HttpStatusCode.OK)
        }
    }
}
