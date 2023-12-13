package tn.esprit.foyeer.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idFoyer;
  String nomFoyer;
  long capacite;

    public Long getIdFoyer() {
        return idFoyer;
    }

    public String getNomFoyer() {
        return nomFoyer;
    }

  //  public long getCapacite() {
  //      return capacite;
   // }

  //  public Set<Bloc> getBlocs() {
   //     return blocs;
 //   }

  //  public Universite getUniversite() {
   //     return universite;
 //   }

    public void setIdFoyer(Long idFoyer) {
        this.idFoyer = idFoyer;
    }

    public void setNomFoyer(String nomFoyer) {
        this.nomFoyer = nomFoyer;
    }

    public void setCapacite(long capacite) {
        this.capacite = capacite;
    }

  // public void setBlocs(Set<Bloc> blocs) {
    //    this.blocs = blocs;
 //   }

   // public void setUniversite(Universite universite) {
      //  this.universite = universite;
  //  }

    public Foyer(Long idFoyer, String nomFoyer, long capacite, Set<Bloc> blocs, Universite universite) {
        this.idFoyer = idFoyer;
        this.nomFoyer = nomFoyer;
        this.capacite = capacite;
     //   this.blocs = blocs;
     //   this.universite = universite;
    }

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "foyer")
    //Set<Bloc> blocs;
   // @OneToOne(mappedBy = "foyer")
   // Universite universite;

}
