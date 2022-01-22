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
@Table(name = "marketplace")

public class MarketPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_marketplace")
    private long code_marketplace;

    @Column(name = "name")
    private String name;

    @Column(name = "gondola")
    private float gondola;

    @Column(name = "shelf")
    private float shelf;

    private double totalProductShelf(){
        float shelfSize = 1000;
        double productSize = 20;
        return shelfSize / productSize;
    }

}
