package com.expresssao;

public class QueijoDecorator extends LancheDecorator {
    public QueijoDecorator(Lanche lancheDecorado) {
        super(lancheDecorado);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + ", Queijo";
    }

    @Override
    public double getCusto() {
        return super.getCusto() + 1.5; // Adiciona o custo do queijo
    }
}
