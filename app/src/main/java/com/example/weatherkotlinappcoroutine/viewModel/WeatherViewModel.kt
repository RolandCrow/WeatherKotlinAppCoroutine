package com.example.weatherkotlinappcoroutine.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherkotlinappcoroutine.model.Weather
import com.example.weatherkotlinappcoroutine.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel  // делаем вьюмодел для взаимодействия модели и вью подключаем через хилт
@Inject
constructor(private val repository: WeatherRepository) : ViewModel() { // ининируем конструктор с подключением репозитория

    private val _response = MutableLiveData<Weather>() // из респонса делаем переводим в
// изменяемую лайв дата

    val weatherResponse: LiveData<Weather> // перевод в лайв дата из корутины вызова
    get() = _response


    init {
        getWeather() // обязательно для инициации
    }

    private fun getWeather() = viewModelScope.launch {  // запускаем работу с сетью через
    // корутину через лаунч и скоуп связанный с вью моделью
        repository.getWeather().let { response ->
            if(response.isSuccessful) { // проверка ответа по сети
                _response.postValue(response.body()) // передача данных из запроса дальше
            } else {
                Log.d("tag", "getWeather error: {${response.code()}} " ) // если ошибка то анализ

            }

        }
    }

}

