package com.alura.literalura.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int añodeNacimiento;
    private int añodeMuerte;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libros> libros = new ArrayList<>();

    public Autores(DatosAutores datosAutores) {
        this.name = datosAutores.nombreAutor();
        this.añodeNacimiento = datosAutores.añodeNacimiento();
        this.añodeMuerte = datosAutores.añodeMuerte();
    }

    public Autores() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAñodeNacimiento(){
        return añodeNacimiento;
   }

    public void setAñodeNacimiento(int añodeNacimiento) {
        this.añodeNacimiento = añodeNacimiento;
    }

    public int getAñodeMuerte() {
        return añodeMuerte;
    }

    public void setAñodeMuerte(int añodeMuerte) {
        this.añodeMuerte = añodeMuerte;
    }

    public List<Libros> getLibros() {
        return libros;
    }

    public void setLibros(List<Libros> libros) {
        this.libros = libros;
    }


    @Override
    public String toString() {
    StringBuilder librosTitulos = new StringBuilder();
    for (Libros libro : libros) {
        librosTitulos.append(libro.getTitulo()).append(", ");
    }

    if (librosTitulos.length() > 0) {
        librosTitulos.setLength(librosTitulos.length() - 2);
    }

    return  "--------------- AUTOR 👨‍🏫 ---------------" + "\n" +
            "Autor: " + name + "\n" +
            "Fecha de nacimiento: " + añodeNacimiento + "\n" +
            "Fecha de fallecimiento: " + añodeMuerte + "\n" +
            "Libros: " + librosTitulos + "\n";
    }
}
