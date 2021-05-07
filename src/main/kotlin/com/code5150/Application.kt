package com.code5150

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.code5150.plugins.*
import com.code5150.services.bindServices
import io.ktor.application.*
import org.kodein.di.ktor.di

/*fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
        configureSerialization()
        configureSessions()
        configureSecurity()
        configureRouting()
        configureHTTP()
    }.start(wait = true)
}*/

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
    initDatabase()

    configureSerialization()
    configureSessions()
    configureSecurity()
    configureHTTP()

    di {
        bindServices()
    }
    configureRouting()
}
