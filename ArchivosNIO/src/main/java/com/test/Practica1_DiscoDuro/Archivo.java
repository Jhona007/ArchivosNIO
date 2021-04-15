/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.Practica1_DiscoDuro;

import java.io.Serializable;

/**
 *
 * @author PC-AL_100
 */
public class Archivo implements Serializable{
    transient static final long serialVersionUID=3L;
    // ATRIBUTOS
    private String nombrear;
    private double tamar;
    
    // METODOS
    public void mostrar(){
        System.out.println("Nombre de archivo  : " + this.nombrear);
        System.out.println("Tamaño de archivo MB : " + this.tamar);
    }
    
    // GETTER AND SETTER

    public String getNombrear() {
        return nombrear;
    }

    public void setNombrear(String nombrear) {
        this.nombrear = nombrear;
    }

    public double getTamar() {
        return tamar;
    }

    public void setTamar(double tamar) {
        this.tamar = tamar;
    }
    
}
