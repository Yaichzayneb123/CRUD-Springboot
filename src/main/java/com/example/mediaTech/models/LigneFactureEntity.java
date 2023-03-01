package com.example.mediaTech.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
@Entity
@Table(name="ligne_facture")
@Data
@ToString

public class LigneFactureEntity implements Serializable {

    private static final long serialVersionUID = -3181735183192870271L;

    @EmbeddedId
    private LigneFacturekey id ;


    @ManyToOne()
    @MapsId("facture_id")
    @JoinColumn(name= "facture_id")
    private FactureEntity facture;
    @ManyToOne()
    @MapsId("produit_id")
    @JoinColumn(name="produit_id")
    private ProduitEntity produit;

    private double quantité;




}
