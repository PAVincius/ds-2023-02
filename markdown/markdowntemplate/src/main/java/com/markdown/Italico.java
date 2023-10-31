package com.markdown;

public class Italico {

    private Texto texto;

    public Italico(Texto texto) {
        this.texto = texto;
    }

    public String saida(){
        return("__"+texto.texto+"__");
    }
}
