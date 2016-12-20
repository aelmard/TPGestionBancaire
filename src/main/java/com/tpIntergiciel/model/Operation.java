package com.tpIntergiciel.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by a602259 on 19/12/2016.
 */
@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idOperation;
    @Enumerated(EnumType.STRING)
    private TypeOperation typeOperation;
    private double montant;
    @Temporal(TemporalType.DATE)
    private Date dateOperation = new Date();

    @ManyToOne
    @JoinColumn(name = "IDCOMPTE")
    private Compte compte;

    public Operation() {
    }

    public long getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(long idOperation) {
        this.idOperation = idOperation;
    }

    public TypeOperation getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(TypeOperation typeOperation) {
        this.typeOperation = typeOperation;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
