package com.bintangpoetra.converterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bintangpoetra.converterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAction()
    }

    private fun initAction() {
        binding.btnCalculate.setOnClickListener {
            val from = binding.spinnerInitialUnit.selectedItem.toString()
            val to = binding.spinnerCalculateUnit.selectedItem.toString()
            val initialValue = binding.edtOriginalValue.text.toString()

            if (initialValue.isEmpty()) {
                binding.edtOriginalValue.apply {
                    requestFocus()
                    error = "Nilai awal tidak boleh kosong"
                }
            } else {
                val result = convertingProcess(from, to, initialValue)
                binding.tvConvertingResult.text = result.toString()
            }

        }
    }

    fun convertingProcess(from: String, to: String, initialValue: String): Int {
        return if (from == "Celcius" && to == "Fahrenheit") {
            (initialValue.toInt() * 9 / 5) + 32
        } else if (from == "Celcius" && to == "Kelvin") {
            initialValue.toInt() + 273
        } else if (from == "Fahrenheit" && to == "Celcius") {
            ((initialValue.toInt() - 32) * 5) / 9
        } else if (from == "Fahrenheit" && to == "Kelvin") {
            (initialValue.toInt() - 32) * 5 / 9 + 273
        } else if (from == "Kelvin" && to == "Celcius") {
            initialValue.toInt() - 273
        } else if (from == "Kelvin" && to == "Fahrenheit") {
            ((initialValue.toInt() - 273) * 9 / 5) + 32
        } else {
            0
        }
    }

}