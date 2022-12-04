package com.example.routes.html

import com.example.database.ProductsTable
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.*

fun Route.homePage() {
    get("/q") {
        val listProducts = ProductsTable.dao.getAllProducts()
        call.respondHtml {
            head {
                link(rel = "stylesheet", href = "/styles.css", type = "text/css")
                title("Shop online")
            }
            body {
                img {
                    width = "100%"
                    src = "https://cdn.pixabay.com/photo/2015/08/23/09/22/banner-902589__340.jpg"
                }
                val chunkedList = listProducts.chunked(3)
                table {
                    chunkedList.forEach { row ->
                        tr {
                            row.forEach {
                                text(it.name)
                            }
                        }
                        br
                    }
                }
            }
        }
    }
}
