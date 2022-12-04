package com.example.extensions

import kotlinx.html.BODY
import kotlinx.html.DIV
import kotlinx.html.div

fun BODY.row(block: DIV.() -> Unit) {
    div(classes = "row", block)
}
