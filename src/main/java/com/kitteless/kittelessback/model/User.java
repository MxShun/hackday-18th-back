package com.kitteless.kittelessback.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;
}
