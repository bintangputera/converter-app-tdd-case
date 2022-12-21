package com.bintangpoetra.converterapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainActivityTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun `CelciusToKelvinConverterIsCorrect`() {
        val converterResult = MainActivity().convertingProcess("Celcius", "Kelvin", "100")
        Assert.assertTrue(converterResult == 373)
    }

    @Test
    fun `IfTheInputIsNullOrEmpty`() {
        val emptyInput = ""
        Assert.assertTrue(emptyInput.isEmpty())
        val converterResult = MainActivity().convertingProcess("Celcius", "Fahrenheit", emptyInput)
        Assert.assertTrue(converterResult == 0)
    }

    @Test
    fun `IfTheInputIsNotNumber`() {
        val initialInput = "notNumberValue"
        var converterResult = 0
        try {
            converterResult = MainActivity().convertingProcess("Kelvin", "Celcius", initialInput)
        } catch (ex: Exception) {
            print(ex.message)
        }
        Assert.assertFalse(converterResult == 0)
    }

}