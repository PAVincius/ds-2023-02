package com.markdown;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Digite um Texto");
        Texto texto = new Texto(new Scanner(System.in).nextLine());
        Negrito negrito = new Negrito(texto);
        negrito.Negrito(texto);
        
        System.out.println("Digite outro Texto");
        Texto texto2 = new Texto(new Scanner(System.in).nextLine());
        Italico italico = new Italico(texto2);
        italico.Italico(texto2);
    }
}