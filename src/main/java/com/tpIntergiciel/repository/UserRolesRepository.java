package com.tpIntergiciel.repository;

import com.tpIntergiciel.model.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by a602259 on 19/12/2016.
 */
@Repository
public interface UserRolesRepository extends CrudRepository<UserRole,Long>{
    @Query("select a.role from UserRole a, User b where b.username=?1 and a.idClient=b.idClient")
    public List<String> findRoleByUserName(String username);
}
