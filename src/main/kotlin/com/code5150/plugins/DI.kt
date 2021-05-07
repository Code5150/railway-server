package com.code5150.plugins

import com.code5150.di.bindServices
import io.ktor.application.*
import org.kodein.di.ktor.di

fun Application.configureDI(){
    di {
        bindServices()
    }
}
