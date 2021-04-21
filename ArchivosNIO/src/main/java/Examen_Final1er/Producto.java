/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen_Final1er;

import java.io.Serializable;

/**
 *
 * @author PC-AL_100
 */
public class Producto implements Serializable{
    static final long serialVersionUID=2L;
    // ATRIBUTOS
    private String nombrepro;
    private float costouni;
    private int stock;
    
    // METODOS
    public void mostrarProducto(){
        System.out.println("----------------------------------------------------");
        System.out.println("Nombre producto : " + this.nombrepro);
        System.out.println("Costo Unitario    : " + this.costouni);
        System.out.println("Stock   :  " + this.stock);
        System.out.println("----------------------------------------------------");
    }
    // GETTER AND SETTER

    public String getNombrepro() {
        return nombrepro;
    }

    public void setNombrepro(String nombrepro) {
        this.nombrepro = nombrepro;
    }

    public float getCostouni() {
        return costouni;
    }

    public void setCostouni(float costouni) {
        this.costouni = costouni;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
}
