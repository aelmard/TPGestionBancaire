package com.tpIntergiciel.repository;

import com.tpIntergiciel.model.Compte;
import com.tpIntergiciel.model.Operation;
import com.tpIntergiciel.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by abdel on 20/12/2016.
 */
public interface OperationRepository extends CrudRepository<Operation, Long> {
    List<Operation> findAllByCompte(Compte compte);
}
