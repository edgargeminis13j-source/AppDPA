package com.example.appdpa.data.remote.apifooball

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://v3.football.api-sports.io/"
private const val API_KEY = "b6177a72452bab38c2942e5801fc7e39"

object Retrofitinstance {
    private val client = OkHttpClient.Builder()
        .addInterceptor (Interceptor { chain ->
            val newRequest = chain.request().newBuilder()
                .addHeader("x-apisport-key", API_KEY) )
            chain.proceed(newRequest.build())
        }).build()
    val api: ApiFootballService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiFootballService::class.java)
    }
}