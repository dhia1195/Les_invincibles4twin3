package tn.esprit.foyeer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.foyeer.entities.Foyer;

@Repository
public interface FoyerRepo extends JpaRepository<Foyer,Long> {
    Foyer findFoyerByNomFoyer(String nomFoyer);
}
