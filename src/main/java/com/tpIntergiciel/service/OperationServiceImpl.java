package com.tpIntergiciel.service;

import com.tpIntergiciel.model.*;
import com.tpIntergiciel.repository.CompteRepository;
import com.tpIntergiciel.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by abdel on 20/12/2016.
 */
@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private CompteRepository compteRepo;

    @Autowired
    private OperationRepository operationRepo;

    @Override
    public List<Operation> getAllOperation() {
        return operationRepo.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public double credit(int idCompte, double montant) {
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

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public double pret(int idCompte, double montant) {
        Compte compte = compteRepo.findByIdCompte(idCompte);
        if (compte.getSolde() >= 0) {
            compte.setSolde(compte.getSolde() + montant);
            compteRepo.save(compte);

            //Sauvegarde de l'opération en bdd
            Operation operation = new Operation();
            operation.setMontant(montant);
            operation.setTypeOperation(TypeOperation.PRET);
            operation.setCompte(compte);
            operationRepo.save(operation);
        } else {
            throw new NumberFormatException("Le solde n'est pas positif");
        }
        return compte.getSolde();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public double debit(int idCompte, double montant) {
        Compte compte = compteRepo.findByIdCompte(idCompte);
        if (compte instanceof CompteEpargne) {
            double montanCredi = compte.getSolde() - montant;
            if (compte.getSolde() >= 0 && compte.getSolde() >= montant) {
                compte.setSolde(montanCredi);
                compteRepo.save(compte);
                //Sauvegarde de l'opération en bdd
                Operation operation = new Operation();
                operation.setMontant(montant);
                operation.setTypeOperation(TypeOperation.DEBIT);
                operation.setCompte(compte);
                operationRepo.save(operation);
            } else {
                throw new NumberFormatException("Decouvert non autorisé sur compte epargne !!");
            }
        } else {
            CompteCourant courant = (CompteCourant) compte;
            double montanCredi = courant.getSolde() + courant.getDecouvert();
            if (montanCredi >= montant){
                courant.setSolde(montanCredi);
                compteRepo.save(courant);
                //Sauvegarde de l'opération en bdd
                Operation operation = new Operation();
                operation.setMontant(montant);
                operation.setTypeOperation(TypeOperation.DEBIT);
                operation.setCompte(courant);
                operationRepo.save(operation);
            } else {
                throw new NumberFormatException("Vous avez dépassé votre decouvert autorisé");
            }
        }
        return compte.getSolde();
    }
}
