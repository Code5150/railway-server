package com.code5150.plugins

import com.code5150.dto.StaffDTO
import com.code5150.dto.SectionDTO
import io.ktor.gson.*
import io.ktor.features.*
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        gson {
        }
    }

    routing {
        get("/json/gson") {
            call.respond(mapOf("hello" to "world"))
        }
        /*get("/masters") {
            call.respond(listOf(
                mapOf("master1" to StaffDTO("Геннадий", "Алексеев", "Дорожный мастер")),
                mapOf("master2" to StaffDTO("Алексей", "Коровин", "Дорожный мастер"))
            ))
        }*/
        get("/sections"){
            call.respond(listOf(
                SectionDTO(1, listOf(1, 2, 3)),
                SectionDTO(2, listOf(1, 7, 3, 95)),
                SectionDTO(3, listOf( 2, 45, 17 )),
            ))
        }
        /*authenticate(AUTH_CONF_FORM, AUTH_CONF_SESSION) {
            get("/protected") {
                val principal = call.principal<UserIdPrincipal>()!!
                call.respond(HttpStatusCode.OK, listOf(MasterDTO("Геннадий")))
            }
        }*/
    }
}
