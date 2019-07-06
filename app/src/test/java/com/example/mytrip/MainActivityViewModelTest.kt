package com.example.mytrip

import android.app.Application
import android.databinding.ObservableField
import android.util.Log
import com.example.mytrip.viewmodels.MainActivityViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.junit.Assert.*
import org.mockito.Mockito.*

class MainActivityViewModelTest {

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun isValidReturnTrueTest() {

        val mainActivityViewModel = MainActivityViewModel(Mockito.mock(Application::class.java))

        val distancia = mainActivityViewModel.distancia
        distancia.set("100")

        val preco = mainActivityViewModel.preco
        preco.set("30")

        val autonomia = mainActivityViewModel.autonomia
        autonomia.set("15")


        assertTrue(mainActivityViewModel.isValid())

    }

    @Test
    fun isValidReturnFalseTest() {

        val mainActivityViewModel = MainActivityViewModel(Mockito.mock(Application::class.java))

        val distancia = mainActivityViewModel.distancia
        distancia.set("")

        val preco = mainActivityViewModel.preco
        preco.set("")

        val autonomia = mainActivityViewModel.autonomia
        autonomia.set("")

        assertFalse(mainActivityViewModel.isValid())

    }

    @Test
    fun ValidHandleCalculation() {

        val mainActivityViewModel = MainActivityViewModel(Mockito.mock(Application::class.java))

        val distancia = mainActivityViewModel.distancia
        distancia.set("30")

        val preco = mainActivityViewModel.preco
        preco.set("15")

        val autonomia = mainActivityViewModel.autonomia
        autonomia.set("250")

        val resultado = mainActivityViewModel.resultado

        mainActivityViewModel.handleCalculate()

        assertEquals("Total: R$ 1.8", resultado.get())

    }

    @Test
    fun ValidHandleCalculationWrongNumber() {

        val mainActivityViewModel = MainActivityViewModel(Mockito.mock(Application::class.java))

        val distancia = mainActivityViewModel.distancia
        distancia.set("asadsaddsasdsdadssd")

        val preco = mainActivityViewModel.preco
        preco.set("15")

        val autonomia = mainActivityViewModel.autonomia
        autonomia.set("250")

        val resultado = mainActivityViewModel.resultado

        var numberFormatException = false

        try {
            mainActivityViewModel.handleCalculate()
            numberFormatException = false
        } catch (e : Exception) {
            numberFormatException = true
        }

        assertTrue(numberFormatException)

    }

    @Test
    fun handleCalculateButtonClickCallHandleCalculate() {

        // Test the handleCalculateButtonClick call HandleCalculate

        val mainActivityViewModel = MainActivityViewModel(Mockito.mock(Application::class.java))

        val distancia = mainActivityViewModel.distancia
        distancia.set("30")

        val preco = mainActivityViewModel.preco
        preco.set("15")

        val autonomia = mainActivityViewModel.autonomia
        autonomia.set("250")

        val spy = spy(mainActivityViewModel)

        spy.handleCalculateButtonClick()

        verify(spy, Mockito.times(1)).handleCalculate()

    }

}
