package com.example.routes.html.product

import com.example.database.ProductsTable
import com.example.js.ext.moveOnClick
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.*

fun Route.productPage(cssPath: String) {
    get("/product") {
        val productId = call.parameters["id"]?.toIntOrNull()
        val product = if (productId == null) ProductsTable.errorProduct else
            ProductsTable.dao.getProductById(productId) ?: ProductsTable.errorProduct

        call.respondHtml {
            head {
                link(rel = "stylesheet", href = cssPath, type = "text/css")
                title("Product ${product.name}")
            }
            body {
                img {
                    width = "100%"
                    src = "https://cdn.pixabay.com/photo/2015/08/23/09/22/banner-902589__340.jpg"
                }

                table(classes = "base") {
                    tr(classes = "column") {
                        td {
                            img { src = product.image }
                        }
                    }
                    tr(classes = "column") {
                        td {
                            p { text(product.name) }
                        }
                    }
                    tr(classes = "column") {
                        td {
                            p { text(product.description) }
                        }
                    }
                    if (product.id >= 0) {
                        tr(classes = "column") {
                            td {
                                button {
                                    moveOnClick("")
                                    text("Add to cart: ${product.price} BYN")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
