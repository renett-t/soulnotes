package dev.renett.soulnotes.api

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class SpotifyApi {
    // https://kotlinlang.org/docs/multiplatform-mobile-ktor-sqldelight.html#implement-an-api-service
//    private val httpClient = HttpClient {
//        install(ContentNegotiation) {
//            json(Json {
//                ignoreUnknownKeys = true
//                useAlternativeNames = true
//            })
//        }
//    }

    private val httpClient = httpClient()


    // ахереть если честно
    // Async network request will be executed in the HTTP client's thread pool.
    suspend fun getAllLaunches(): List<RocketLaunch> {
        return httpClient.get("https://api.spacexdata.com/v5/launches").body()
    }
}

// about engines: https://ktor.io/docs/http-client-engines.html#dependencies
expect fun httpClient(config: HttpClientConfig<*>.() -> Unit = {}): HttpClient
