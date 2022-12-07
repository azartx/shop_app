package com.example.routes.html.product

import com.example.plugins.respondCss
import io.ktor.server.application.*
import io.ktor.server.routing.*
import kotlinx.css.*

fun Route.productCss(): String {
    val path = "/product-styles.css"
    get(path) {
        call.respondCss {
            body {
                backgroundColor = Color.darkBlue
                margin(0.px)
            }
            rule("table.base") {
                alignContent = Align.center
                width = 80.pct
                padding(60.px)
                backgroundColor = Color.white
                marginLeft = LinearDimension.auto
                marginRight = LinearDimension.auto
            }
            rule(".column") {
                marginLeft = LinearDimension.auto
                marginRight = LinearDimension.auto
                textAlign = TextAlign.center
            }
            button {
                padding(10.px)
            }
        }
    }
    return path
}
