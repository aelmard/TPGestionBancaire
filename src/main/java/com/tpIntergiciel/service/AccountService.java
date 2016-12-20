package com.tpIntergiciel.service;

import com.tpIntergiciel.model.Compte;
import com.tpIntergiciel.model.User;

import java.util.List;

/**
 * Created by abdel on 19/12/2016.
 */
public interface AccountService {
    List<Compte> getAccountsByUser(User client);
    List<User> getAllUsers();
    List<Compte> getAllAccounts();
    boolean ifUserExists(String username);
    void createUser(String usernameC, String passwordC, String nom, String prenom);
    void createAccount(String typeCompte,double solde, double decouvert,User user);
}
