/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.scprojectjava.model;


public class Unidad {
    private int id;
    private String nombre;
    private String abreviatura;
    private int activo;

    public Unidad(int id, String nombre, String abreviatura, int activo) {
        this.id = id;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.activo = activo;
    }

    public Unidad(String nombre, String abreviatura, int activo) {
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
}
