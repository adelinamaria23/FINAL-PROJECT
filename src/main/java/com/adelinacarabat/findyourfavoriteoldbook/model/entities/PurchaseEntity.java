package com.adelinacarabat.findyourfavoriteoldbook.model.entities;

import jakarta.persistence.*;

@Table(name = "purchase")
@Entity
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private Long id;
}
