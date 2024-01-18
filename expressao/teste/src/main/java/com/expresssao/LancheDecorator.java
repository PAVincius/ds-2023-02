package com.expresssao;

public abstract class LancheDecorator implements Lanche {
    protected Lanche lancheDecorado;

    public LancheDecorator(Lanche lancheDecorado) {
        if (lancheDecorado == null) {
            throw new IllegalArgumentException("Lanche decorado não pode ser nulo");
        }
        this.lancheDecorado = lancheDecorado;
    }

    @Override
    public String getDescricao() {
        return lancheDecorado.getDescricao();
    }

    @Override
    public double getCusto() {
        return lancheDecorado.getCusto();
    }
}
