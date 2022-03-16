package com.example.ficha8.models;

import javax.persistence.*;

@Entity
@Table(name = "centro_comercial")
public class CentroComercial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String morada;
    private int numMaxAndar;

    // sem getters os dados não são lidos
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getNumMaxAndar() {
        return numMaxAndar;
    }

    public void setNumMaxAndar(int numMaxAndar) {
        this.numMaxAndar = numMaxAndar;
    }
}
