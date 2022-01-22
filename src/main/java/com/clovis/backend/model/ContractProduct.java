package com.clovis.backend.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Table(name = "contractproduct")

public class ContractProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_contractproduct")
    private long code_contractproduct;

    @Column(name = "name")
    private String name;

    @Column(name = "percentage")
    private int percentage;

    @Column(name = "id_product")
    private int id_product;

    @Column(name = "id_contractprovider")
    private int id_contractprovider;

}
