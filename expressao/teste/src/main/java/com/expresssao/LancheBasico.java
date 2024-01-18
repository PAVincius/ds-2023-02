package com.expresssao;

public class LancheBasico implements Lanche {
    @Override
    public String getDescricao() {
        return "Lanche Básico";
    }

    @Override
    public double getCusto() {
        return 5.0; // Custo base do lanche básico
    }
}
