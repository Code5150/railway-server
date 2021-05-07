package com.code5150

import io.ktor.server.netty.*
import com.code5150.plugins.*
import io.ktor.application.*

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
    initDatabase()

    configureSerialization()
    configureSessions()
    configureSecurity()
    configureHTTP()

    configureDI()
    configureRouting()
}
