package com.example.campionatopallavolo;

public class Squadra {
    private final String nome;
    private int punti;
    private int setVinti;
    private int partiteVinte;
    private int partitePerse;

    public Squadra(String nome) {
        this.nome = nome;
        this.punti = 0;
        this.setVinti = 0;
        this.partiteVinte = 0;
        this.partitePerse = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getPunti() {
        return punti;
    }

    public void setPunti(int punti) {
        this.punti += punti;
    }

    public int getSetVinti() {
        return setVinti;
    }

    public void aggiungiSetVinti(int setVinti) {
        this.setVinti += setVinti;
    }

    public int getPartiteVinte() {
        return partiteVinte;
    }

    public void incrementaPartiteVinte() {
        this.partiteVinte++;
    }

    public int getPartitePerse() {
        return partitePerse;
    }

    public void incrementaPartitePerse() {
        this.partitePerse++;
    }
}

