/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.Practica1_Hospital;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PC-AL_100
 */
public class Hospital implements Serializable{
    static final long serialVersionUID=1L;
    // OBJETO DE LECTURA
    transient Scanner sd = new Scanner (System.in);
    
    // ATRIBUTOS
    private String nombre;
    private String direccion;
    private int nivel;
    // AGREGANDO ESPECIALIDAD
    private List <Especialidad> listaEs;
    
    //CONSTRUCTOR
    public Hospital(){
        listaEs = new ArrayList<>();
    }
    // METODOS
    public void mostrarHospital(){
        System.out.println("    ------ DATOS DE HOPITAL ------ \n");
        System.out.println("Nombre  : "+this.nombre);
        System.out.println("Direccion : "+this.direccion);
        System.out.println("Nivel    : "+this.nivel+"\n");
        if (listaEs.size() > 0){
            System.out.println(" ------ ESPECIALIDADES DEL HOSPITAL ------ ");
            for (Especialidad ee: listaEs){
                System.out.print(" - ");
                ee.mostrarEspe();
            }
        }
    }
    public void mostrarH(){
        System.out.println("Nombre  : "+this.nombre);
        System.out.println("Direccion : "+this.direccion);
        System.out.println("Nivel    : "+this.nivel);
    }
    public void agregarEs(Especialidad es){
        listaEs.add(es);
        System.out.println("");
        System.out.println("¡¡¡¡.....Especialidad Agregada.....!!!!");
        System.out.println("");
    }
    
    // GETTER AND SETTER
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public List<Especialidad> getListaEs() {
        return listaEs;
    }

    public void setListaEs(List<Especialidad> listaEs) {
        this.listaEs = listaEs;
    }
}
