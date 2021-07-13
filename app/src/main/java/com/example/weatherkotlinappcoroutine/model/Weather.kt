package com.example.weatherkotlinappcoroutine.model

data class Weather( // дата класс с методом копи

    val description: String,
    val forecast: List<Forecast> , // лист для другого дата класса
    val temperature: String,
    val wind: String

)
