package tn.esprit.foyeer.restController;

import org.springframework.web.bind.annotation.*;
import tn.esprit.foyeer.entities.Foyer;
import tn.esprit.foyeer.services.IFoyerService;


import java.util.List;

@RestController
@RequestMapping("/foyer")
public class FoyerRestController {
    IFoyerService iFoyerService ;
    @GetMapping("/afficherfoyers")
    List<Foyer> retrieveAllEtudiants(){
        return iFoyerService.retrieveAllFoyers();
    }
    @PostMapping("/ajouterfoyer")
    Foyer addFoyer(@RequestBody Foyer c){return iFoyerService.addFoyer(c);}
    @PutMapping("/modifierfoyer")
    Foyer updateFoyer (@RequestBody Foyer c){return iFoyerService.updateFoyer(c);}
    @GetMapping("/afficherfoyer/{idfoyer}")
    Foyer retrieveFoyer(@PathVariable("idfoyer") long idFoyer){return iFoyerService.retrieveFoyer(idFoyer);}

    @DeleteMapping("/removefoyer/{idfoyer}")
    public void removeFoyer(@PathVariable("idfoyer") long idFoyer) {
        iFoyerService.removeFoyer(idFoyer);
    }
}
