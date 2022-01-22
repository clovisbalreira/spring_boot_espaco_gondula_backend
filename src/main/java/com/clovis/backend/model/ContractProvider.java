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
@Table(name = "contractprovider")

public class ContractProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_contractprovider")
    private long code_contractprovider;

    @Column(name = "name")
    private String name;

    @Column(name = "percentage")
    private float percentage;

    @Column(name = "id_provider")
    private int id_provider;

    @Column(name = "id_marketplace")
    private int id_marketplace;

}
