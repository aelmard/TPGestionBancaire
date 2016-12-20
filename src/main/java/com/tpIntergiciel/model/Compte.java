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
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long idCompte;
    protected double solde;
    @ManyToOne()
    @JoinColumn(name = "IDCLIENT")
    protected User client;
    @Temporal(TemporalType.DATE)
    protected Date dateCompte = new Date();

    @OneToMany(mappedBy = "compte")
    protected List<Operation> listOperations;

    public Compte() {
        super();
    }

    public Compte(double solde, User client) {
        super();
        this.solde = solde;
        this.client = client;
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

    public List<Operation> getListOperations() {
        return listOperations;
    }

    public void setListOperations(List<Operation> listOperations) {
        this.listOperations = listOperations;
    }

    public boolean isCourantCompte(){
        return this instanceof CompteCourant;
    }

    public String getTypeCompte(){
        return this.getClass().getSimpleName();
    }
}
