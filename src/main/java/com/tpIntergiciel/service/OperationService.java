package com.tpIntergiciel.service;

import com.tpIntergiciel.model.Compte;
import com.tpIntergiciel.model.Operation;
import com.tpIntergiciel.model.User;

import java.util.List;

/**
 * Created by abdel on 20/12/2016.
 */
public interface OperationService {

    List<Operation> getAllOperationByCompte(Compte compte);

    List<Operation> getAllOperation();

    double credit(long idCompte, double montant);

    double debit(long idCompte, double montant);

    double pret(long idCompte, double montant);
}
