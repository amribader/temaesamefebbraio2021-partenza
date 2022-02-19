package it.unimi.di.prog2.esame.model;

import org.jetbrains.annotations.NotNull;

public class Domanda {
    private @NotNull String domanda;
    private int numVoti;
    //private int numDomanda;

    public Domanda(@NotNull String domanda, int numVoti){//, int numDomanda) {
        this.domanda = domanda;
        this.numVoti = numVoti;
        //this.numDomanda = numDomanda;
    }

    public String getDomanda() {
        return domanda;
    }

    public int getNumVoti() {
        return numVoti;
    }
/*
    public void setNumDomanda(int numDomanda) {
        this.numDomanda = numDomanda;
    }

 */

    @Override
    public String toString() {
        return "Domanda{" +
                "domanda='" + domanda + '\'' +
                ", numVoti=" + numVoti +
                '}';
    }
}
