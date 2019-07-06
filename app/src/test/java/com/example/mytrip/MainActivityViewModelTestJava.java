package com.example.mytrip;

import android.app.Application;
import android.databinding.ObservableField;
import android.util.Log;
import com.example.mytrip.viewmodels.MainActivityViewModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MainActivityViewModelTestJava {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void isValidReturnTrueTest() {

        MainActivityViewModel mainActivityViewModel = new MainActivityViewModel(Mockito.mock(Application.class));

        ObservableField<String> distancia = mainActivityViewModel.getDistancia();
        distancia.set("100");

        ObservableField<String> preco = mainActivityViewModel.getPreco();
        preco.set("30");

        ObservableField<String> autonomia = mainActivityViewModel.getAutonomia();
        autonomia.set("15");


        assertTrue(mainActivityViewModel.isValid());

    }

    @Test
    public void isValidReturnFalseTest() {

        MainActivityViewModel mainActivityViewModel = new MainActivityViewModel(Mockito.mock(Application.class));

        ObservableField<String> distancia = mainActivityViewModel.getDistancia();
        distancia.set("");

        ObservableField<String> preco = mainActivityViewModel.getPreco();
        preco.set("");

        ObservableField<String> autonomia = mainActivityViewModel.getAutonomia();
        autonomia.set("");

        assertFalse(mainActivityViewModel.isValid());

    }

    @Test
    public void ValidHandleCalculation() {

        MainActivityViewModel mainActivityViewModel = new MainActivityViewModel(Mockito.mock(Application.class));

        ObservableField<String> distancia = mainActivityViewModel.getDistancia();
        distancia.set("30");

        ObservableField<String> preco = mainActivityViewModel.getPreco();
        preco.set("15");

        ObservableField<String> autonomia = mainActivityViewModel.getAutonomia();
        autonomia.set("250");

        ObservableField<String> resultado = mainActivityViewModel.getResultado();

        mainActivityViewModel.handleCalculate();

        assertEquals(resultado.get(), "Total: R$ 1.8");

    }

    @Test
    public void ValidHandleCalculationWrongNumber() {

        MainActivityViewModel mainActivityViewModel = new MainActivityViewModel(Mockito.mock(Application.class));

        ObservableField<String> distancia = mainActivityViewModel.getDistancia();
        distancia.set("asadsaddsasdsdadssd");

        ObservableField<String> preco = mainActivityViewModel.getPreco();
        preco.set("15");

        ObservableField<String> autonomia = mainActivityViewModel.getAutonomia();
        autonomia.set("250");

        ObservableField<String> resultado = mainActivityViewModel.getResultado();

        boolean numberFormatException = false;

        try {
            mainActivityViewModel.handleCalculate();
            numberFormatException = false;
        }
        catch (Exception e) {
            numberFormatException = true;
        }

        assertTrue(numberFormatException);

    }

    @Test
    public void handleCalculateButtonClickCallHandleCalculate() {

        // Test the handleCalculateButtonClick call HandleCalculate

        MainActivityViewModel mainActivityViewModel = new MainActivityViewModel(Mockito.mock(Application.class));

        // MainActivityViewModel mainActivityViewModelMock = Mockito.mock(MainActivityViewModel.class);

        ObservableField<String> distancia = mainActivityViewModel.getDistancia();
        distancia.set("30");

        ObservableField<String> preco = mainActivityViewModel.getPreco();
        preco.set("15");

        ObservableField<String> autonomia = mainActivityViewModel.getAutonomia();
        autonomia.set("250");

        // when(mainActivityViewModelMock.isValid()).thenReturn(true);

        MainActivityViewModel spy = spy(mainActivityViewModel);

        spy.handleCalculateButtonClick();

        verify(spy, Mockito.times(1)).handleCalculate();

    }

}
