package com.tpIntergiciel.service;

import com.tpIntergiciel.model.*;
import com.tpIntergiciel.repository.CompteRepository;
import com.tpIntergiciel.repository.UserRepository;
import com.tpIntergiciel.repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
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
    @Autowired
    private UserRolesRepository roleRepo;

    @Override
    public User getUserByUserName(String userName) {
        if (userRepo.findByUsername(userName) != null) {
            return userRepo.findByUsername(userName);
        } else return null;
    }

    @Override
    public User getUserByIdClient(long idClient) {
        if (userRepo.findByIdClient(idClient) != null) {
            return userRepo.findByIdClient(idClient);
        } else return null;
    }

    @Override
    public Compte getFirstAccount(User client) {
        if (client != null) {
            User c = userRepo.findByIdClient(client.getIdClient());
            if (c != null) {
                return compteRepo.findFirstByClient(client);
            } else return null;
        } else return null;
    }

    @Override
    public List<Compte> getAccountsByUser(User client) {
        if (client != null) {
            User c = userRepo.findByIdClient(client.getIdClient());
            if (c != null) {
                return compteRepo.findAllByClient(c);
            } else return null;
        } else return null;
    }

    @Override
    public List<Compte> getAllAccounts() {
        return compteRepo.findAll();
    }

    @Override
    public boolean ifUserExists(String username) {
        if (userRepo.findByUsername(username) != null) {
            return true;
        }
        return false;
    }

    @Override
    public void createUser(String usernameC, String passwordC, String nom, String prenom) {
        User user = new User();
        user.setUsername(usernameC);
        user.setPassword(passwordC);
        user.setNom(nom);
        user.setPrenom(prenom);
        userRepo.save(user);

        UserRole userRole = new UserRole();
        userRole.setRole("ROLE_USER");
        userRole.setUserid(user.getIdClient());
        roleRepo.save(userRole);
    }

    @Override
    public void createAccount(String typeCompte, double solde, double decouvert, User user) {
        if (typeCompte.equals("courant")) {
            CompteCourant courant = new CompteCourant(user, solde, decouvert);
            compteRepo.save(courant);
        } else {
            CompteEpargne epargne = new CompteEpargne(user, solde);
            compteRepo.save(epargne);
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> listUsers = userRepo.findAll();
        if (listUsers != null && !listUsers.isEmpty()) {
            Iterator<User> iter = listUsers.iterator();
            while (iter.hasNext()) {
                User tmp = iter.next();
                if (roleRepo.findRoleByUserName(tmp.getUsername()).contains("ROLE_ADMIN")) {
                    System.out.println("Role admin");
                    iter.remove();
                }
            }
        }
        return listUsers;
    }
}
