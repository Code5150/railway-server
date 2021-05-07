package com.code5150.plugins

import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.routing.*
import io.ktor.sessions.*

const val AUTH_COOKIE: String = "auth"

fun Application.configureSessions() {

    install(Sessions) {
        cookie<UserIdPrincipal>(AUTH_COOKIE, SessionStorageMemory()) {
            cookie.path = "/" // We cookies should work
            cookie.extensions["SameSite"] = "lax"
            cookie.maxAgeInSeconds = 360
        }
    }
}

data class UserSession(
    val name: String
) : Principal