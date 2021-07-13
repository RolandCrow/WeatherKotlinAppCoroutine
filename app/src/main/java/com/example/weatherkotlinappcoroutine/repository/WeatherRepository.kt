package com.example.weatherkotlinappcoroutine.repository


import com.example.weatherkotlinappcoroutine.api.ApiService
import javax.inject.Inject

class WeatherRepository
    @Inject
    constructor(private val apiService: ApiService) { // репозиторий иницируем через инжект и
    // конструктор
        suspend fun getWeather() = apiService.getWeather()
    }
