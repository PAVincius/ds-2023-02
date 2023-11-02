package com.expresssao;

public class LancheXTudo extends LancheDecorator{
    
    public LancheXTudo(int i){
        super(i);
    }

    @Override
    public Double getValor() {
        return this.lanche.getValor() * 2;
    }
}
