package com.tpIntergiciel.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by a602259 on 19/12/2016.
 */
@Entity
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCompte;
    private String typeCompte;
    private double decouvert;
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

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
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
