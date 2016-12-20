package com.tpIntergiciel.service;

import com.tpIntergiciel.model.User;

/**
 * Created by abdel on 20/12/2016.
 */
public interface OperationService {
    double credit(int idCompte, double montant, User user);

/*    double debit(int idCompte, double montant, User user);

    double pret(int idCompte, double montant, User user);*/
}
