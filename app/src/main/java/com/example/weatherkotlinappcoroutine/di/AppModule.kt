package com.example.weatherkotlinappcoroutine.di

import com.example.weatherkotlinappcoroutine.api.ApiService
import com.example.weatherkotlinappcoroutine.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // работа с даггером и хилтом одновременно одиночный компонент
object AppModule { // работа с внедрением зависимостей

    @Provides // передатчик
    fun provideBaseUrl() = Constants.BASE_URL // передатчик базоваого юрл

    @Provides // передатчик для работы ретрофита
    @Singleton
    fun provideRetrofitInstance(BASE_URL: String): ApiService =  // передача значений
            Retrofit.Builder() // строим ретрофит
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) // конвертер джейсона
                .build()
                .create(ApiService::class.java)

    }

