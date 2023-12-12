package com.example.reservation.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    String idReservation;
    LocalDate anneUniversitaire;
    Boolean estValide;
    //@JsonIgnore
     /*@ManyToMany(mappedBy = "reservationSet", cascade= CascadeType. PERSIST ,fetch = FetchType.LAZY )
    private List<Etudiant> etudiant ;*/
   /* @OneToOne
    Etudiant etudiant;*/
  /*  @ManyToOne
    Chambre chambre;
    @ManyToOne
    Etudiant etudiant;*/
}
