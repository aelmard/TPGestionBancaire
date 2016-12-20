package com.tpIntergiciel.service;

import com.tpIntergiciel.model.Compte;
import com.tpIntergiciel.model.User;
import com.tpIntergiciel.repository.CompteRepository;
import com.tpIntergiciel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by abdel on 19/12/2016.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private CompteRepository compteRepo;

    @Override
    public List<Compte> getAccountsByUser(User client) {
        if (client != null) {
            User c = userRepo.findByIdClient(client.getIdClient());
            if (c != null) {
                return compteRepo.findAllByClient(c);
            }
            else return null;
        } else return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
