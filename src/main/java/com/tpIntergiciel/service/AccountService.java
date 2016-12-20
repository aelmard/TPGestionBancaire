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
}
