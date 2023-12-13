package com.esprit.reservation.repositery;

import com.esprit.reservation.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EtudiantRepo extends JpaRepository<Etudiant,Long> {
    Etudiant findByCin(long cin);
}
