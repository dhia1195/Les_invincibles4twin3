package tn.esprit.foyeer.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;
    String nomBloc;
    Long CapaciteBloc;




}
