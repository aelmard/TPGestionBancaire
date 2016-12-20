package com.tpIntergiciel.service;

import com.tpIntergiciel.model.Compte;
import com.tpIntergiciel.model.Operation;
import com.tpIntergiciel.model.TypeOperation;
import com.tpIntergiciel.model.User;
import com.tpIntergiciel.repository.CompteRepository;
import com.tpIntergiciel.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by abdel on 20/12/2016.
 */
@Service
public class OperationServiceImpl implements OperationService{

    @Autowired
    private CompteRepository compteRepo;

    @Autowired
    private OperationRepository operationRepo;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public double credit(int idCompte, double montant, User user) {
        Compte compte = compteRepo.findByIdCompte(idCompte);
        compte.setSolde(compte.getSolde() + montant);
        compteRepo.save(compte);

        //Sauvegarde de l'opération en bdd
        Operation operation = new Operation();
        operation.setMontant(montant);
        operation.setTypeOperation(TypeOperation.CREDIT);
        operation.setCompte(compte);
        operationRepo.save(operation);

        return compte.getSolde();
    }

/*    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public double debit(int idCompte, double montant, User user) {
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public double pret(int idCompte, double montant, User user) {
        return 0;
    }*/
}
