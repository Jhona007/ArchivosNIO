/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.Practica1_Hospital;

import java.io.Serializable;

/**
 *
 * @author PC-AL_100
 */
public class Especialidad implements Serializable{
    transient static final long serialVersionUID=2L;
    // ATRIBUTOS
    private String nomEspe;
    
    // METODOS
    public void mostrarEspe(){
        System.out.println("Especialidad : "+this.nomEspe);
    }
    
    // GETTER AND SETTER

    public String getNomEspe() {
        return nomEspe;
    }

    public void setNomEspe(String nomEspe) {
        this.nomEspe = nomEspe;
    }
}
