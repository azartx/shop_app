package com.example.plugins

import com.example.routes.productsRoutes
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.http.content.*
import io.ktor.server.application.*
import io.ktor.server.response.*

fun Application.configureRouting() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause" , status = HttpStatusCode.InternalServerError)
        }
    }

    routing {
        productsRoutes()
        // Static plugin. Try to access `/static/index.html`
        static("/static") {
            resources("static")
        }
    }
}