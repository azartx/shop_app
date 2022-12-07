package com.example.plugins

import com.example.routes.html.home.homeCss
import com.example.routes.html.home.homePage
import com.example.routes.html.product.productCss
import com.example.routes.html.product.productPage
import com.example.routes.provideApiRouting
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
        provideApiRouting()

        homePage(homeCss())
        productPage(productCss())

        // Static plugin. Try to access `/static/index.html`
        static("/static") {
            resources("static")
        }
    }
}
