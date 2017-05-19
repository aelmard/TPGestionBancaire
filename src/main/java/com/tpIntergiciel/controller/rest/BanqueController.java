package com.tpIntergiciel.controller.rest;

import com.tpIntergiciel.model.Compte;
import com.tpIntergiciel.model.Operation;
import com.tpIntergiciel.model.User;
import com.tpIntergiciel.service.AccountService;
import com.tpIntergiciel.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by abdel on 16/03/2017.
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/BanqueController")
public class BanqueController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private OperationService operationService;

    @RequestMapping(value = "/getAllCompeByIdClient", method = RequestMethod.GET, produces = "application/json")
    public List<Compte> getAllCompeByIdClient(@RequestParam("idClient") long idClient) {
        List<Compte> listAccounts = new ArrayList<Compte>();
        User user = accountService.getUserByIdClient(idClient);
        if (user != null) {
            listAccounts = accountService.getAccountsByUser(user);
        }
        return listAccounts;
    }

    @RequestMapping(value = "/getAllClient", method = RequestMethod.GET, produces = "application/json")
    public List<User> getAllClient() {
        return accountService.getAllUsers();
    }

    @RequestMapping(value = "/getUserByIdClient", method = RequestMethod.GET, produces = "application/json")
    public User getUserByIdClient(@RequestParam("idClient") long idClient) {
        User user = new User();
        if (accountService.getUserByIdClient(idClient) != null) {
            user = accountService.getUserByIdClient(idClient);
        }
        return user;
    }

    @RequestMapping(value = "/getAllOperationByIdClient", method = RequestMethod.GET, produces = "application/json")
    public List<Operation> getAllOperationByIdClient(@RequestParam("idClient") long idClient) {
        User user = accountService.getUserByIdClient(idClient);
        List<Operation> operations = new ArrayList<Operation>();

        if (user != null) {
            List<Compte> listAccounts = accountService.getAccountsByUser(user);
            if (listAccounts != null) {
                for (Compte compte : listAccounts) {
                    operations.addAll(operationService.getAllOperationByCompte(compte));
                }
            }
        }
        return operations;
    }

    @RequestMapping(value = "/credit", method = RequestMethod.GET, produces = "application/xml")
    public PaymentDetails credit(@RequestParam("idClient") long idClient, @RequestParam("montant") double montant) {
        User user = accountService.getUserByIdClient(idClient);
        User site = accountService.getUserByUserName("ECOMMERCE");
        PaymentDetails paymentDetails = new PaymentDetails();
        if (user != null) {
            Compte compte = accountService.getFirstAccount(user);
            Compte compteSite = accountService.getFirstAccount(site);
            if (compte != null) {
                try {
                    operationService.credit(compte.getIdCompte(), montant);
                    operationService.debit(compteSite.getIdCompte(), montant);
                    paymentDetails.setType("credit");
                    paymentDetails.setNameClient(user.getPrenom() + " " + user.getNom());
                    paymentDetails.setIdentifier(UUID.randomUUID().toString());
                    paymentDetails.setAmount(montant + " €");
                    return paymentDetails;
                } catch (NumberFormatException e) {
                    System.out.println(e);
                    return paymentDetails;
                }
            }
        }
        return paymentDetails;
    }

    @RequestMapping(value = "/debit", method = RequestMethod.GET, produces = "application/xml")
    public PaymentDetails debit(@RequestParam("idClient") long idClient, @RequestParam("montant") double montant) {
        User user = accountService.getUserByIdClient(idClient);
        User site = accountService.getUserByUserName("ECOMMERCE");
        PaymentDetails paymentDetails = new PaymentDetails();
        if (user != null) {
            Compte compte = accountService.getFirstAccount(user);
            Compte compteSite = accountService.getFirstAccount(site);
            if (compte != null) {
                try {
                    operationService.debit(compte.getIdCompte(), montant);
                    operationService.credit(compteSite.getIdCompte(), montant);
                    paymentDetails.setType("debit");
                    paymentDetails.setNameClient(user.getPrenom() + " " + user.getNom());
                    paymentDetails.setIdentifier(UUID.randomUUID().toString());
                    paymentDetails.setAmount(montant + " €");
                    return paymentDetails;
                } catch (NumberFormatException e) {
                    System.out.println(e);
                    return paymentDetails;
                }
            }
        }
        return paymentDetails;
    }
}
