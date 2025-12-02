package com.example;


import java.util.Map;

public class Pergunta {
    private Integer id;
    private String enunciado;

    private Map<String, String> opções;


    public Pergunta(int id, String enunciado, Map<String, String> opções) {
        this.id = id;
        this.enunciado = enunciado;
        this.opções = opções;
    }

    public int getId() { return id;}
    public String getEnunciado() {return enunciado;}
    public Map<String, String> getOpções() { return opções;}
}





