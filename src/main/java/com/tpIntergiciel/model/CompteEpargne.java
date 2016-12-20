package com.tpIntergiciel.model;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by abdel on 19/12/2016.
 */
@Entity
public class CompteEpargne extends Compte {
    public CompteEpargne() {
        super();
    }
    public CompteEpargne(User user,double solde) {
        super(solde,user);
    }

}
