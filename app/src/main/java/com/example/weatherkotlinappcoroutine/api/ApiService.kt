package com.example.weatherkotlinappcoroutine.api

import com.example.weatherkotlinappcoroutine.model.Weather
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {


    @GET("weather/tambov")
    suspend fun getWeather(): Response<Weather> // подключаем апи через респонс
}