/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.Practica1_Docente;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author PC-AL_100
 */
public class Materia implements Serializable{
    static final long serialVersionUID=1L;
    
    // ATRIBUTOS
    private int id = 11321321;
    private String nombreM;
    private int añoM;
    private int horaM;
    
    transient Scanner sd = new Scanner (System.in);
    
    // METODOS
    public void crearMat(){
        System.out.print("Introduzca nombre de la Materia : ");
         this.nombreM = sd.nextLine();
         System.out.print("Introduzca año de la Materia    : ");
         this.añoM = sd.nextInt();
         System.out.print("Digite las Horas de la Materia  : ");
         this.horaM = sd.nextInt();
         sd.nextLine();
    }
    public void mostrar(){
        System.out.println("Materia            : "+this.nombreM);
        System.out.println("Año de la Materia  : "+this.añoM);
        System.out.println("Hora de la Materia : "+this.horaM);
    }
 
    // GETTER AND SETTER

    public String getNombreM() {
        return nombreM;
    }

    public void setNombreM(String nombreM) {
        this.nombreM = nombreM;
    }

    public int getAñoM() {
        return añoM;
    }

    public void setAñoM(int añoM) {
        this.añoM = añoM;
    }

    public int getHoraM() {
        return horaM;
    }

    public void setHoraM(int horaM) {
        this.horaM = horaM;
    }
}
