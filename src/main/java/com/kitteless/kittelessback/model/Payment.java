package com.kitteless.kittelessback.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "payment")
@Data
public class Payment {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "userId")
    private String userId;

    @Column(name = "amount")
    private int amount;

    @Column(name = "stampCode")
    private String stampCode;
}
