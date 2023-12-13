package com.esprit.reservation.repositery;

import com.esprit.reservation.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDate;
import java.util.List;

public interface ReservationRepo extends JpaRepository<Reservation,String> {
    long countResvationByAnneUniversitaireBetween(LocalDate debut, LocalDate fin);

    int countReservationByChambre_IdChambre(long idChambre);

    List<Reservation> findReservationByAnneUniversitaireBetween(LocalDate debutAnnee, LocalDate finAnnee);
}

