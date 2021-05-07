package com.code5150.di

import com.code5150.services.StaffService
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

fun DI.MainBuilder.bindServices(){
    bind<StaffService>() with singleton { StaffService() }
}