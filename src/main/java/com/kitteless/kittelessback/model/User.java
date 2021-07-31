package com.kitteless.kittelessback.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @Column(
            name="id",
            nullable = false
    )
    private String id;

    @Column(
            name="name",
            nullable = false
    )
    private String name;

    @Column(
            name="password",
            nullable = false
    )
    private String password;
}
