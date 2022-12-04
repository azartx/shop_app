package com.example.routes.html

import com.example.plugins.respondCss
import io.ktor.server.application.*
import io.ktor.server.routing.*
import kotlinx.css.*
import kotlinx.css.Float

fun Route.css() {
    get("/styles.css") {
        call.respondCss {
            body {
                backgroundColor = Color.darkBlue
                margin(0.px)
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
                float = Float.left
                width = 33.3.pct
            }
            rule(".row") {
                after {
                    content = QuotedString("")
                    display = Display.table
                    clear = Clear.both
                }
            }
        }
    }
}
