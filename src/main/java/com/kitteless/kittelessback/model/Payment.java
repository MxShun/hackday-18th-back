package com.kitteless.kittelessback.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "payment")
@Data
public class Payment {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "amount")
    private int amount;

    @Column(name = "stamp_code")
    private String stampCode;
}
