package com.example.reservation.services;

import com.example.reservation.entites.Reservation;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface IReservationService {
    Reservation add(Reservation reservation);
    //Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(long numChambre, long cin);
    List<Reservation> getReservationParAnneeUniversitaire(LocalDate debutAnnee, LocalDate finAnnee);
    List<Reservation> getAll();
    Reservation getById(String id);
    Reservation updateReservation(Reservation res);

    ResponseEntity<String> annulerReservation(String idReservation);
}
