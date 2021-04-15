/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.Practica1_Docente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PC-AL_100
 */
public class Docente implements Serializable{
    
    static final long serialVersionUID=2L;
    
    transient Scanner sd = new Scanner (System.in);
    
    // ATRIBUTOS
    private String nombre;
    private String paterno;
    private String materno;
    private String titulo;
    private int cargaH;
    private int hmax;
    // DEFINIENDO LA AGREGACION
    private List<Materia> listaMateria;
    
    public Docente(){
        listaMateria = new ArrayList<>();
    }
    
    // METODOS
  
    public void mostrar(){
        System.out.println("Nombre        : "+this.nombre);
        System.out.println("Ap. Paterno   : "+this.paterno);
        System.out.println("Ap. Materno   : "+this.materno);
        System.out.println("Titulo        : "+this.titulo);
        System.out.println("Carga Horaria : "+this.cargaH);
        if (listaMateria.size() > 0){
            System.out.println(" ------ MATERIAS ASIGNADAS ------ ");
            for (Materia ma: listaMateria){
                System.out.println("-----------------------------------------------");
                ma.mostrar();
                System.out.println("------------------------------------------------");
            }
        }
    }
    public void agregar(Materia mat){
        listaMateria.add(mat);
        System.out.println("");
        System.out.println("¡¡¡¡.....Materia Asignada.....!!!!");
        System.out.println("");
    }
    // GETTER AND SETTER
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }
    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCargaH() {
        return cargaH;
    }

    public void setCargaH(int cargaH) {
        this.cargaH = cargaH;
    }

    public List<Materia> getListaMateria() {
        return listaMateria;
    }

    public void setListaMateria(List<Materia> listaMateria) {
        this.listaMateria = listaMateria;
    }

    public int getHmax() {
        return hmax;
    }

    public void setHmax(int hmax) {
        this.hmax = hmax;
    }
}
