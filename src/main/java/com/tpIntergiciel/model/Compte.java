package com.tpIntergiciel.model;

import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by a602259 on 19/12/2016.
 */
@Entity
@DiscriminatorColumn(name="TYPE_COMPTE")
public abstract class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCompte;
    private double solde;
    @ManyToOne()
    @JoinColumn(name = "IDCLIENT")
    private User client;
    @Temporal(TemporalType.DATE)
    private Date dateCompte = new Date();

    @OneToMany(mappedBy = "compte")
    private List<Operation> listOperations;

    public Compte() {
    }

    public long getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(long idCompte) {
        this.idCompte = idCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Date getDateCompte() {
        return dateCompte;
    }

    public void setDateCompte(Date dateCompte) {
        this.dateCompte = dateCompte;
    }
}
