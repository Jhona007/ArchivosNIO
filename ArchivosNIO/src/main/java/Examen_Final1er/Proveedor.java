
package Examen_Final1er;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC-AL_100
 */
public class Proveedor implements Serializable{
    static final long serialVersionUID=1L;
    // ATRIBUTOS
    private String razonSocial;
    private String direccion;
    private int nrotel;
    
    // AGREGACION 
    private List<Producto> listap;
    //CONSTRUCTOR
    public Proveedor(){
        listap = new ArrayList<>();
    }
    
    // METODOS
    public void mostrarProveedor(){
        System.out.println("\n     --------- Proveedor  --------- \n");
        System.out.println("Razon Social  : "+this.razonSocial);
        System.out.println("Direccion   : "+this.direccion);
        System.out.println("Telefono  : "+this.nrotel);
        System.out.println("\n ---- PRODUCTOS ---- \n");
        if(listap != null){
            for (Producto cc:listap){
                cc.mostrarProducto();
            }
            System.out.println("-------------------------------------------------------------");
        }
    }
    public void agregarProducto(Producto prod){
        this.listap.add(prod);
        System.out.println("\n PRODUCTO REGISTRADO ..!! \n");
    }
    // GETTER AND SETTER

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNrotel() {
        return nrotel;
    }

    public void setNrotel(int nrotel) {
        this.nrotel = nrotel;
    }

    public List<Producto> getListap() {
        return listap;
    }

    public void setListap(List<Producto> listap) {
        this.listap = listap;
    }
    
}
