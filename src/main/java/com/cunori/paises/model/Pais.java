package com.cunori.paises.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "paises")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100)
    private String nombre;

    @NotBlank(message = "El código ISO es obligatorio")
    @Size(min = 2, max = 3, message = "Debe tener 2 o 3 letras")
    private String codigoIso;

    @NotBlank(message = "La capital es obligatoria")
    @Size(max = 100)
    private String capital;

    @NotBlank(message = "El continente es obligatorio")
    @Size(max = 50)
    private String continente;

    @NotNull(message = "La población es obligatoria")
    @Min(value = 0, message = "No puede ser negativa")
    private Long poblacion;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCodigoIso() { return codigoIso; }
    public void setCodigoIso(String codigoIso) { this.codigoIso = codigoIso; }
    public String getCapital() { return capital; }
    public void setCapital(String capital) { this.capital = capital; }
    public String getContinente() { return continente; }
    public void setContinente(String continente) { this.continente = continente; }
    public Long getPoblacion() { return poblacion; }
    public void setPoblacion(Long poblacion) { this.poblacion = poblacion; }
}