package com.example;

public class App {

    public static double calculateSquareRoot(double number, double tolerance) {
        if (number < 0) {
            throw new IllegalArgumentException("Não é possível calcular a raiz quadrada de um número negativo.");
        }

        if (number == 0) {
            return 0;
        }

        double guess = number / 2; 

        while (Math.abs(guess * guess - number) > tolerance) {
            guess = (guess + number / guess) / 2;
        }

        return guess;
    }
}
