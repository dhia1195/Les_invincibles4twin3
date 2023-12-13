package com.esprit.reservation.repositery;

import com.esprit.reservation.entities.Chambre;
import com.esprit.reservation.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ChambreRepo extends JpaRepository<Chambre,Long> {

    List<Chambre> findChambresByBloc_NomBloc(String nom);

   Chambre findByNumChambre(long numChambre);

    //long countByTypeAndBloc(TypeChambre type, Bloc bloc);

    Chambre findByReservationsContains(Reservation reservation);

   // List<Chambre> findChambresNonReserveByTypeAndFoyer(TypeChambre type, Foyer foyer);

    // List<Chambre> findNonReservedRoomsByFoyerAndType(Foyer foyer, TypeChambre type);
}
