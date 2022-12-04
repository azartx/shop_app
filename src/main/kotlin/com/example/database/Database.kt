package com.example.database

import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

object Database {
    var database: Database? = null

    fun init() {
        val driverClassName = "org.h2.Driver"
        val jdbcURL = "jdbc:h2:file:./build/db"
        database = Database.connect(jdbcURL, driverClassName)
        transaction {
            SchemaUtils.create(ProductsTable)
        }
    }
}

suspend fun <T> callDb(block: suspend Transaction.() -> T): T =
    newSuspendedTransaction(Dispatchers.IO, com.example.database.Database.database, statement = block)
