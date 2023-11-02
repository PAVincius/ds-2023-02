package com.expresssao;

public abstract class LancheDecorator implements Lanche {
    protected Lanche lanche;

    protected LancheDecorator(Lanche lanche){
        this.lanche = lanche;
    }
}
