package com.example

import com.example.database.Database
import com.example.database.ProductsTable
import com.example.model.Product
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun main() {
    embeddedServer(Netty, port = 8089, host = "127.0.0.1", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    Database.init()
    configureSerialization()
    configureTemplating()
    configureMonitoring()
    configureHTTP()
    //configureSecurity()
    configureRouting()
/*CoroutineScope(Dispatchers.IO).launch {


PructsTable.dao.saveProducts(
    listOf(
        Product(
            0,
            "qwe",
            "asd",
            "qwe",
            "21"
        ),
        Product(
            2,
            "qwe",
            "asd",
            "qwe",
            "21"
        ),Product(
            3,
            "qwe",
            "asd",
            "qwe",
            "21"
        ),
        Product(
            4,
            "qwe",
            "asd",
            "qwe",
            "21"
        ),
        Product(
            5,
            "qwe",
            "asd",
            "qwe",
            "21"
        ),
        Product(
            6,
            "qwe",
            "asd",
            "qwe",
            "21"
        ),
        Product(
            7,
            "qwe",
            "asd",
            "qwe",
            "21"
        ),
        Product(
            8,
            "qwe",
            "asd",
            "qwe",
            "21"
        ),
        Product(
            9,
            "qwe",
            "asd",
            "qwe",
            "21"
        )

    )
)
}*/
}
