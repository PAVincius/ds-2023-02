package com.expresssao;

public class App {
    public static void main(String[] args) {
        // Lanche básico
        Lanche lancheBasico = new LancheBasico();
        System.out.println("Lanche Básico:");
        exibirDetalhes(lancheBasico);

        // Lanche com queijo
        Lanche lancheComQueijo = new QueijoDecorator(new LancheBasico());
        System.out.println("\nLanche com Queijo:");
        exibirDetalhes(lancheComQueijo);

        // Lanche com queijo e tomate
        Lanche lancheComQueijoETomate = new TomateDecorator(new QueijoDecorator(new LancheBasico()));
        System.out.println("\nLanche com Queijo e Tomate:");
        exibirDetalhes(lancheComQueijoETomate);
    }

    private static void exibirDetalhes(Lanche lanche) {
        System.out.println("Descrição: " + lanche.getDescricao());
        System.out.println("Custo: $" + lanche.getCusto());
    }
}
