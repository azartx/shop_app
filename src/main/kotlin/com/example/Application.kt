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
    ProductsTable.dao.saveProducts(
        listOf(
            Product(
                0,
                "qwe",
                "asd",
                "https://picsum.photos/id/237/536/354",
                "21"
            ),
            Product(
                2,
                "qwe",
                "asd",
                "https://picsum.photos/seed/picsum/536/354",
                "21"
            ),Product(
                3,
                "qwe",
                "asd",
                "https://picsum.photos/id/1084/536/354?grayscale",
                "21"
            ),
            Product(
                4,
                "qwe",
                "asd",
                "https://picsum.photos/id/1060/536/354?blur=2",
                "21"
            ),
            Product(
                5,
                "qwe",
                "asd",
                "https://picsum.photos/id/870/536/354?grayscale&blur=2",
                "21"
            ),
            Product(
                6,
                "qwe",
                "asd",
                "https://randomwordgenerator.com/img/picture-generator/55e5dd454d52ab14f1dc8460962e33791c3ad6e04e507440742a7ed09445c3_640.jpg",
                "21"
            ),
            Product(
                7,
                "qwe",
                "asd",
                "https://pixabay.com/get/g7c07c2f223ad4d80d2d6345a6ea7de22cc7570bc7e7193d8278182e92cb5aae16006d6c3fdc5c7247bfe60d0a892e918_1280.jpg",
                "21"
            ),
            Product(
                8,
                "qwe",
                "asd",
                "https://www.generatormix.com/images/thumbs/reddit-name-generator.jpg",
                "21"
            ),
            Product(
                9,
                "qwe",
                "asd",
                "https://www.generatormix.com/images/thumbs/minecraft-name-generator.jpg",
                "21"
            )
        )
    )
    }*/
}
