package com.code5150.routing

import com.code5150.plugins.AUTH_CONF_FORM
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.sessions.*

fun Route.auth() {
    authenticate(AUTH_CONF_FORM) {
        post("/auth") {
            val principal = call.principal<UserIdPrincipal>()!!
            call.sessions.set(principal)
            call.application.environment.log.info("User ${principal.name} logged in")
            call.respond(HttpStatusCode.OK, "OK")
        }
    }
}