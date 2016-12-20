package com.tpIntergiciel.repository;

import com.tpIntergiciel.model.Compte;
import com.tpIntergiciel.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by abdel on 19/12/2016.
 */

@Repository
public interface CompteRepository extends CrudRepository<Compte, Long> {
    //get allaccounts by client
    List<Compte> findAllByClient(User user);
    Compte findByIdCompte(long idCompte);
    List<Compte> findAll();
}