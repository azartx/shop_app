package com.example.routes.html.home

import com.example.database.ProductsTable
import com.example.js.ext.moveOnClick
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.*

fun Route.homePage(cssPath: String) {
    get("/") {
        val listProducts = ProductsTable.dao.getAllProducts()
        call.respondHtml {
            head {
                link(rel = "stylesheet", href = cssPath, type = "text/css")
                title("Shop online")
            }
            body {
                img {
                    width = "100%"
                    src = "https://cdn.pixabay.com/photo/2015/08/23/09/22/banner-902589__340.jpg"
                }
                val chunkedList = listProducts.chunked(3)
                table(classes = "base") {
                    chunkedList.forEach { rowItems ->
                        tr {
                            rowItems.forEach {product ->
                                td(classes = "column") {
                                    moveOnClick("/product?id=${product.id}")
                                        img {
                                            width = "80%"
                                            height = "auto"
                                            src = product.image
                                        }
                                        br
                                        p { text(product.name) }
                                        br
                                        button {
                                            text("Add to cart: ${product.price} BYN")
                                        }
                                }
                            }
                        }
                        br
                    }
                }
            }
        }
    }
}
