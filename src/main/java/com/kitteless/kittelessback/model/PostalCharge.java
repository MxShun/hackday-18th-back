package com.kitteless.kittelessback.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "postal_charge")
@Data
public class PostalCharge {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "standard")
    private String stndard;
}
