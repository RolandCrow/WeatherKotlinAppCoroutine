package com.example.weatherkotlinappcoroutine


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.weatherkotlinappcoroutine.databinding.ActivityMainBinding
import com.example.weatherkotlinappcoroutine.viewModel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // присоединили биндинг
    private val viewModel: WeatherViewModel by viewModels() // присоединили вьюмодел






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // присоединяем биндинг к разметке
        setContentView(binding.root)

        viewModel.weatherResponse.observe(this, { weather -> // иницируем передачу данных
            binding.apply {
                cityName.text = "Tambov"
                description.text = weather.description // подключаем данные к вью
                tvTemperature.text = weather.temperature
                wind.text = weather.wind

                val forecast1 = weather.forecast[0]
                val forecast2 = weather.forecast[1]
                val forecast3 = weather.forecast[2]

                TVforecast1.text = "${forecast1.temperature}/${forecast1.wind}"
                TVforecast2.text = "${forecast2.temperature}/${forecast2.wind}"
                Tvforecast3.text = "${forecast3.temperature}/${forecast3.wind}"



            }

        } )

    }
}