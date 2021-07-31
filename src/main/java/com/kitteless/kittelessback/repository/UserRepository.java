package com.kitteless.kittelessback.repository;

import com.kitteless.kittelessback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
interface UserRepository extends JpaRepository<String, User> {
    // TODO DB ユーザテーブル 作成 #1 で考える
    @Query(
            value = "INSERT INTO user(name) VALUES (:name)",
            nativeQuery = true
    )
    String insert(
            @Param("name") String name
    );
}
