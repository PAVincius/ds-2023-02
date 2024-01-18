package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NewtonSquareRootTest {

    @Test
    void testCalculateSquareRoot() {
        double result = NewtonSquareRoot.calculateSquareRoot(25, 0.0001);
        assertEquals(5, result, 0.0001);

        result = NewtonSquareRoot.calculateSquareRoot(2, 0.0001);
        assertEquals(1.4142, result, 0.0001);

        result = NewtonSquareRoot.calculateSquareRoot(0, 0.0001);
        assertEquals(0, result, 0.0001);

        result = NewtonSquareRoot.calculateSquareRoot(16, 0.0001);
        assertEquals(4, result, 0.0001);

        result = NewtonSquareRoot.calculateSquareRoot(100, 0.0001);
        assertEquals(10, result, 0.0001);
    }

    @Test
    void testNegativeNumber() {
        //exceção 
        assertThrows(IllegalArgumentException.class, () -> {
            NewtonSquareRoot.calculateSquareRoot(-1, 0.0001);
        });
    }
}
