package com.example.plagins

import com.example.di.koinModule
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger


fun Application.configureKoin() {
    install(Koin) {
        slf4jLogger() // логирование относительно блока с предоставлениями зависимостей
        modules(koinModule) // подключение нашего модуля
    } // указываем что работает плагин
}