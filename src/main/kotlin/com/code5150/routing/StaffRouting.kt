package com.code5150.routing

import com.code5150.services.StaffService
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.kodein.di.instance
import org.kodein.di.ktor.closestDI

fun Route.staff() {
    val staffService by closestDI().instance<StaffService>()

    get("allStaff"){
        call.respond(staffService.selectAll())
    }
}