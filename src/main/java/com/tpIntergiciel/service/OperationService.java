package com.tpIntergiciel.service;

import com.tpIntergiciel.model.Operation;
import com.tpIntergiciel.model.User;

import java.util.List;

/**
 * Created by abdel on 20/12/2016.
 */
public interface OperationService {

    List<Operation> getAllOperation();

    double credit(int idCompte, double montant);

    double debit(int idCompte, double montant);

    double pret(int idCompte, double montant);
}
