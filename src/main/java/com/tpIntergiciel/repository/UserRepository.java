package com.tpIntergiciel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tpIntergiciel.entity.User;

/**
 * Created by abdel on 18/12/2016.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}