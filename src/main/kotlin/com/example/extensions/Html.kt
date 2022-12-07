package com.example.extensions

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

suspend fun PipelineContext<Unit, ApplicationCall>.respondBadRequest(message: String = "") {
    call.respond(HttpStatusCode.BadRequest, message)
}
