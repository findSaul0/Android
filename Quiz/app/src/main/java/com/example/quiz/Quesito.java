package com.example.quiz;

public class Quesito {
    private String testo;
    private boolean risposta;
    private boolean counted;

    public Quesito(String testo, boolean risposta){
        this.testo = testo;
        this.risposta = risposta;
        counted = false;
    }

    public String getTesto(){
        return testo;
    }

    public boolean getRisposta(){
        return risposta;
    }

    public boolean getCounted(){
        return counted;
    }

    public void setCounted() {
        counted = true;
    }
}
