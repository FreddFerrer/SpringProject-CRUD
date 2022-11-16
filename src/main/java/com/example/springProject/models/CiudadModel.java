package com.example.springProject.models;

import javax.persistence.*;

@Entity
@Table(name = "ciudades")
public class CiudadModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ciudad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "CiudadesModel{" +
                "id=" + id +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
