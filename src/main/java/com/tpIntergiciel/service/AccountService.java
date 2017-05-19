package com.tpIntergiciel.service;

import com.tpIntergiciel.model.Compte;
import com.tpIntergiciel.model.User;

import java.util.List;

/**
 * Created by abdel on 19/12/2016.
 */
public interface AccountService {
    User getUserByUserName(String userName);
    User getUserByIdClient(long idClient);
    List<Compte> getAccountsByUser(User client);
    List<User> getAllUsers();
    List<Compte> getAllAccounts();
    Compte getFirstAccount(User client);
    boolean ifUserExists(String username);
    void createUser(String usernameC, String passwordC, String nom, String prenom);
    void createAccount(String typeCompte,double solde, double decouvert,User user);
}
