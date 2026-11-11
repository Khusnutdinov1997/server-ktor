plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.kotlin.plugin.serialization)
}

group = "com.example"
version = "0.0.1"

application {
    mainClass = "io.ktor.server.netty.EngineMain"
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    implementation(libs.ktor.server.content.negotiation) // json ответа
    implementation(libs.ktor.server.core) // ядро сервера
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.server.call.logging) // логи запросов
    implementation(libs.ktor.server.netty) // движок сервера
    implementation(libs.ktor.server.default.headers) // работа с заголовками
    implementation(libs.ktor.server.status.pages) // обробка статусов и исключений
    implementation(libs.logback.classic) // логирование

    testImplementation(libs.ktor.server.test.host) // для тестирования хоста
    testImplementation(libs.kotlin.test.junit) // тесты функции

    // Koin
    implementation("io.insert-koin:koin-ktor:3.5.6") // зависимости библиотеки koin
    implementation("io.insert-koin:koin-logger-slf4j:3.5.6")
}