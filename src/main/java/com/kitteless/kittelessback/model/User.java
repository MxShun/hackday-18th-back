package com.kitteless.kittelessback.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Random;

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

    public void setRandomId() {
        // userIdを 10,000～99,999 で発番する
        id = Integer.toString(new Random().nextInt(89_999) + 10_000);
    }
}
