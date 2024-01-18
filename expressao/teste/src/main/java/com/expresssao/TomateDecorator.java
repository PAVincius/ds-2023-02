package com.expresssao;

public class TomateDecorator extends LancheDecorator {
    public TomateDecorator(Lanche lancheDecorado) {
        super(lancheDecorado);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + ", Tomate";
    }

    @Override
    public double getCusto() {
        return super.getCusto() + 0.75; // Adiciona o custo do tomate
    }
}
