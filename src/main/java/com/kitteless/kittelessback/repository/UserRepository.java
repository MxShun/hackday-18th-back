package com.kitteless.kittelessback.repository;

import com.kitteless.kittelessback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT u.id FROM User u " +
            "WHERE u.name = :name AND u.password = :password")
    String getUserid(String name, String password);
}
