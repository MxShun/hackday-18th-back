package com.kitteless.kittelessback.repository;

import com.kitteless.kittelessback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<String, User> {
    @Query(
            value = "INSERT INTO user(id, name, password) VALUES (:id, :name, :password)",
            nativeQuery = true
    )
    String insert(
            @Param("id") String id,
            @Param("name") String name,
            @Param("password") String password
    );
}
