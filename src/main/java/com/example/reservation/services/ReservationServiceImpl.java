package com.example.reservation.services;

import com.example.reservation.entites.Reservation;
import com.example.reservation.respositeries.ReservationRepo;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public class ReservationServiceImpl   implements IReservationService{
   ReservationRepo resRepo;
    //ChambreRepo chambrerepo;


    @Override
    public Reservation add(Reservation reservation) {
        return resRepo.save(reservation);
    }





    @Override
    public List<Reservation> getReservationParAnneeUniversitaire(
            LocalDate debutAnnee,
            LocalDate finAnnee
    ) {
        return resRepo.findReservationByAnneUniversitaireBetween(debutAnnee, finAnnee);
    }

    @Override
    public List<Reservation> getAll() {
        return resRepo.findAll();
    }

    @Override
    public Reservation getById(String id) {
        return resRepo.findById(id).orElse(null);
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return resRepo.save(res);
    }

    @Override
    public ResponseEntity<String> annulerReservation(String idReservation) {
        try {
            Reservation reservation = resRepo.findById(idReservation).orElse(null);
            reservation.setEstValide(false);
            resRepo.save(reservation);
            return ResponseEntity.ok().body("reservation annuler");
        }catch (NullPointerException ex){
            throw new RuntimeException("reservation not found");
        }

    }

    public int typeCToInt(String typeC) {
        switch (typeC) {
            case "SIMPLE":
                return 1;
            case "DOUBLE":
                return 2;
            case "TRIPLE":
                return 3;
            default:
                return 0;
        }
    }

}
