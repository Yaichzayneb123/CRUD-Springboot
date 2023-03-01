package com.example.mediaTech.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table( name="factures")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class FactureEntity implements Serializable {

    @Id
    private Integer id;

    @Column(nullable = false)
    private String ref;

    @Column(nullable = false, name= "date_creation")
    private Date date;

    @ManyToOne
    private ClientEntity client;

    @OneToMany(mappedBy ="facture",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    private List<LigneFactureEntity> ligneFactures;


}
