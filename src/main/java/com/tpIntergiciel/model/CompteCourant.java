package com.tpIntergiciel.model;

import javax.persistence.Entity;

/**
 * Created by abdel on 19/12/2016.
 */
@Entity
public class CompteCourant extends Compte {
    private double decouvert;

    public CompteCourant() {
        super();
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }
}
