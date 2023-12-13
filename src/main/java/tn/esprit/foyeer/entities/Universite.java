package tn.esprit.foyeer.entities;

import jakarta.persistence.*;


@Entity

public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniv;
    String nomUniv;
    String adresse;

    @OneToOne
   // @JoinColumn(name = "idFoyer") // Define the foreign key column in the Universite table
    private Foyer foyer; // Reference to the associated foyer


}
