package com.example.mediaTech.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class LigneFacturekey implements Serializable {

    private static final long serialVersionUID = 472235211631783282L;

    @Column(name= "facture_id")
    private Integer factureId;

    @Column(name= "produit_id")
    private Integer produitId;

}
