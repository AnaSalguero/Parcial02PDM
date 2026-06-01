package com.pdm0126.parcial2rankeduca.Data.Api

import android.util.Log
import com.pdm0126.parcial2rankeduca.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


object KtorClient {
  val BASE_URL = "https://qjcxdvfzyseuvezacxsd.supabase.co/functions/v1/rankeuca/"

  val client = HttpClient(OkHttp) {

    install(ContentNegotiation) {
      json(Json {
        ignoreUnknownKeys = true
      })
    }

    // Plugin de logging
    install(Logging) {
      logger = object : Logger {
        override fun log(message: String) {
          Log.d("KtorClient", message)
        }
      }
      level = LogLevel.ALL
    }

    // Configuración aplicada a todas las peticiones
    defaultRequest {
      url(BASE_URL)
      header(HttpHeaders.Authorization,"Bearer ${BuildConfig.API_TOKEN}")
      header(HttpHeaders.Accept, "application/json")
    }
  }
}