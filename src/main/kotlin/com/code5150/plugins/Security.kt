package com.code5150.plugins

import com.code5150.dto.StaffDTO
import com.code5150.services.StaffService
import io.ktor.auth.*
import io.ktor.util.*
import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.locations.*
import io.ktor.application.*
import io.ktor.application.ApplicationCall
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.sessions.*
import org.kodein.di.instance
import org.kodein.di.ktor.closestDI

const val AUTH_CONF_FORM: String = "auth_form"
const val AUTH_CONF_SESSION: String = "auth_session"

fun Application.configureSecurity() {

    val staffService by closestDI().instance<StaffService>()

    authentication {
        form(name = AUTH_CONF_FORM) {
            skipWhen { call -> call.sessions.get<UserIdPrincipal>() != null }
            userParamName = "username"
            passwordParamName = "password"
            validate { credentials ->
                if (credentials.name == "jetbrains" && credentials.password == "foobar"
                    || staffService.checkCredentials(credentials.name, credentials.password)) {
                    UserIdPrincipal(credentials.name)
                } else {
                    null
                }
            }
        }
        session<UserIdPrincipal>(AUTH_CONF_SESSION){
            validate { session ->
                log.info("User ${session.name} logged in by existing session")
                session
            }
            challenge {
                call.respondRedirect("/auth")
            }
        }
    }
}
/*
@Location("/login/{type?}")
class login(val type: String = "")*/

