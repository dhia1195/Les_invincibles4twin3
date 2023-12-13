package tn.esprit.foyeer.services;

import org.springframework.stereotype.Service;
import tn.esprit.foyeer.entities.Foyer;
import tn.esprit.foyeer.repositories.FoyerRepo;


import java.util.List;

@Service
public class FoyerServiceImpl implements IFoyerService {

    FoyerRepo foyerRepo;

    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepo.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer b) {
        return foyerRepo.save(b);
    }

    @Override
    public Foyer updateFoyer(Foyer b) {
        return foyerRepo.save(b);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return foyerRepo.findById(idFoyer).orElse(null);
    }

    @Override
    public void removeFoyer(long idFoyer) {
        foyerRepo.deleteById(idFoyer);
    }

}