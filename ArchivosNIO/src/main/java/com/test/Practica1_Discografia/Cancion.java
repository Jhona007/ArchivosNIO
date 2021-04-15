/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.Practica1_Discografia;

import java.io.Serializable;

/**
 *
 * @author PC-AL_100
 */
public class Cancion implements Serializable{
    static final long serialVersionUID=1L;
    // ATRIBUTOS
    private String nombrec;
    private float duracion;
    private String genero;
    
    // METODOS
    public void mostrarCancion(){
        System.out.println(this.nombrec+"  \t\t\t "+this.duracion+"  \t\t\t  "+this.genero);
        /*System.out.println("Duracion    : "+ this.duracion);
        System.out.println("Genero    : "+ this.genero);*/
    }
    
    // GETTER AND SETTER

    public String getNombrec() {
        return nombrec;
    }

    public void setNombrec(String nombrec) {
        this.nombrec = nombrec;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
