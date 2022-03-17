package com.example.ficha8.models;

import javax.persistence.*;

@Entity
@Table(name = "andar")
public class Andar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numAndar;
    private int numMaxLojas;

    @ManyToOne
    @JoinColumn(name = "centro_comercial_id")
    private CentroComercial centroComercial;

    public CentroComercial getCentroComercial() {
        return centroComercial;
    }

    public Long getId() {
        return id;
    }

    public int getNumAndar() {
        return numAndar;
    }

    public void setNumAndar(int numAndar) {
        this.numAndar = numAndar;
    }

    public int getNumMaxLojas() {
        return numMaxLojas;
    }

    public void setNumMaxLojas(int numMaxLojas) {
        this.numMaxLojas = numMaxLojas;
    }
}
