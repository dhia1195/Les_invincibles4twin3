package com.example.reservation.RestController;

import com.example.reservation.entites.Reservation;
import com.example.reservation.services.IReservationService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

public class ReservationRestController {
    IReservationService ireservationservice;

    @GetMapping("/getByAnneeUniversitaire/{deb}/{fin}")
    public List<Reservation> getReservationbyAnneeUniversitaire(
            @PathVariable("deb") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate debutAnnee,
            @PathVariable("fin") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate finAnnee
    ) {
        return ireservationservice.getReservationParAnneeUniversitaire(debutAnnee, finAnnee);
    }

    @GetMapping("/getAll")
    public List<Reservation> getAllReservations() {
        return ireservationservice.getAll();
    }

    @GetMapping("/getById/{id}")
    public Reservation getReservationById(@PathVariable("id") String id) {
        return ireservationservice.getById(id);
    }

    @PostMapping("/add/{numChambre}/{cin}")
    public ResponseEntity<Reservation> add(@RequestBody Reservation reservation)
    {
        return ResponseEntity.ok(ireservationservice.add(reservation));
    }

    @PostMapping("/annulerReservation/{idReservation}")
    public ResponseEntity<String>
    annulerReservation(
            @PathVariable("idReservation") String idReservation
    ) {
        return ireservationservice.annulerReservation(idReservation);
    }

    @PutMapping("/update")
    public ResponseEntity<Reservation> updateUniversite(@RequestBody Reservation reservation) {
        return ResponseEntity.ok(ireservationservice.updateReservation(reservation));
    }
}
