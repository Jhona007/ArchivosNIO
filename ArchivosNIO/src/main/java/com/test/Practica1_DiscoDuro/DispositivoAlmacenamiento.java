/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.Practica1_DiscoDuro;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author PC-AL_100
 */
public class DispositivoAlmacenamiento implements Serializable{
    static final long serialVersionUID=2L;
    // OBJETO DE LECTURA
    transient Scanner sd = new Scanner (System.in);
    // ATRIBUTOS
    private String marca;
    private double capacidad;
    private double espacioDis;
    
    // METODOS
    public void llenar(){
        System.out.print("Ingrese marca del Dispositivo : ");
        this.marca = sd.nextLine();
        System.out.print("Ingrese la capacidad de Almacenamiento MB : ");
        this.capacidad = sd.nextDouble();
        System.out.print("Ingrese Espacio Disponible MB : ");
        this.espacioDis = sd.nextDouble();
        sd.nextLine();
    }
    public void mostrar(){
        System.out.println("Marca   : " + this.marca);
        System.out.println("Capacidad : " + this.capacidad);
        System.out.println("Espacio Disponible : " + this.espacioDis);
    }
    
    // GETTER AND SETTER 

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    public double getEspacioDis() {
        return espacioDis;
    }

    public void setEspacioDis(double espacioDis) {
        this.espacioDis = espacioDis;
    }
    
}
