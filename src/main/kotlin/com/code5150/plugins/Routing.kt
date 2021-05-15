package com.code5150.plugins

import com.code5150.routing.auth
import com.code5150.routing.staff
import com.code5150.routing.switch
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.sessions.*

fun Application.configureRouting() {
    /*install(Locations) {
    }*/

    routing {
        route("/api/v1"){
            staff()
            auth()
            switch()
        }

        get("/") {
            call.respondText("Hello World!")
        }
        /*authenticate(AUTH_CONF_FORM) {
            post("/auth") {
                val principal = call.principal<UserIdPrincipal>()!!
                    call.sessions.set(principal)
                    log.info("User ${principal.name} logged in")
                    call.respond(HttpStatusCode.OK, "OK")
            }
        }*/
        authenticate(AUTH_CONF_SESSION) {
            get("/getUsername"){
                call.principal<UserIdPrincipal>()?.let { call.respondText(it.name) } ?: call.respond("Fail")
            }
        }
    }
}

/*@Location("/location/{name}")
class MyLocation(val name: String, val arg1: Int = 42, val arg2: String = "default")
@Location("/type/{name}")
data class Type(val name: String) {
    @Location("/edit")
    data class Edit(val type: Type)

    @Location("/list/{page}")
    data class List(val type: Type, val page: Int)
}*/
