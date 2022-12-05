package com.example.routes.html

import com.example.plugins.respondCss
import io.ktor.server.application.*
import io.ktor.server.routing.*
import kotlinx.css.*

fun Route.css() {
    get("/styles.css") {
        call.respondCss {
            body {
                backgroundColor = Color.darkBlue
                margin(0.px)
            }
            rule("table.base") {
                width = 80.pct
                backgroundColor = Color.white
                marginLeft = LinearDimension.auto
                marginRight = LinearDimension.auto
            }
            rule("div.main-list") {
                width = 80.pct
               // alignContent = Align.center
                alignSelf = Align.center
                backgroundColor = Color.black
                fontSize = 14.px

            }
            rule(".text_bg") {
                width = LinearDimension.fitContent
                backgroundColor = Color.white
            }
            rule(".column") {
                marginLeft = LinearDimension.auto
                marginRight = LinearDimension.auto
                width = 33.3.pct
                textAlign = TextAlign.center
            }
            button {
                padding(10.px)
                marginBottom = 16.px
            }
            img {
                /*width = 80.pct
                height = 100.pct
                minWidth = 300.px
                minHeight = 200.px*/
                maxHeight = 300.px
            }
        }
    }
}
