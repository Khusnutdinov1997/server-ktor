package com.example.plagins

import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.statuspages.StatusPages

fun Application.configurePages(){
    install(plugin = StatusPages)
} // позволяет обрабратовать http status, исключений