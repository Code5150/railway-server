package com.code5150.routing

import com.code5150.plugins.AUTH_CONF_SESSION
import com.code5150.services.SwitchService
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.response.*
import io.ktor.routing.*
import org.kodein.di.instance
import org.kodein.di.ktor.closestDI

fun Route.switch(){
    val switchService by closestDI().instance<SwitchService>()

    authenticate(AUTH_CONF_SESSION) {
        get("allSwitches") {
            call.respond(switchService.selectAll())
        }
    }
}