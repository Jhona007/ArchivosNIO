/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.Practica1_Discografia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC-AL_100
 */
public class Album implements Serializable{
    static final long serialVersionUID=2L;
    // ATRIBUTIOS
    private String nombre;
    private String artista;
    private String formato;
    
    // AGREGACION 
    private List<Cancion> listac;
    //CONSTRUCTOR
    public Album(){
        listac = new ArrayList<>();
    }
    
    // METODOS
    public void mostrarAlbum(){
        System.out.println("\n     --------- ALBUM --------- \n");
        System.out.println("Nombre   : "+this.nombre);
        System.out.println("Artista    : "+this.artista);
        System.out.println("Formato  : "+this.formato);
        System.out.println("\n ---- CANCIONES ---- \n");
        System.out.println("Nombre   \t\t Duracion(min)   \t\t   Genero ");
        if(listac != null){
            for (Cancion cc:listac){
                cc.mostrarCancion();
            }
            System.out.println("-------------------------------------------------------------");
        }
    }
    public void agregarCancion(Cancion can){
        this.listac.add(can);
        System.out.println("\n CANCION REGISTRADA ..!! \n");
    }
    
    // GETTER AND SETTER

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public List<Cancion> getListac() {
        return listac;
    }

    public void setListac(List<Cancion> listac) {
        this.listac = listac;
    }
}
