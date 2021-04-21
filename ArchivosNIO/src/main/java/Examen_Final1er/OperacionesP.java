/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen_Final1er;

import com.test.Laboratorio1.MaterialBibliografico;
import com.test.Laboratorio1.OperacionB;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC-AL_100
 */
public class OperacionesP {
    // OBJETO DE LECTURA
    Scanner sd = new Scanner(System.in);
    // ATRIBUTOS
    private Proveedor prov;
    private Producto prod;
    private List<Proveedor> listapro;
    // CONSTRUCTOR
    public OperacionesP(){
        listapro = new ArrayList<>();
    }
    // METODOS 
    public void registrarProveedor(){
        prov = new Proveedor();
        System.out.print("\nIngrese Razon Social  : ");
        prov.setRazonSocial(sd.nextLine());
        System.out.print("Ingrese direccion  : ");
        prov.setDireccion(sd.nextLine());
        System.out.print("Ingrese Telefono  :  ");
        prov.setNrotel(sd.nextInt());
        listapro.add(prov);
        System.out.print("\nIngrese la cantidad de Productos que registrara  : ");
        int n = sd.nextInt();  
        sd.nextLine();
        for (int i = 1; i <= n; i++) {
            prod = new Producto();
            System.out.print("Ingrese nombre de Producto  :  ");
            prod.setNombrepro(sd.nextLine());
            System.out.print("Ingrese costo unitario   :  " );
            prod.setCostouni(sd.nextFloat());
            System.out.print("Ingrese el Stock  : ");
            prod.setStock(sd.nextInt());
            prov.agregarProducto(prod);
            sd.nextLine();
        }
    }
    public void mostrarProveedor(){
        if(listapro != null){
            for(Proveedor pp:listapro){
                pp.mostrarProveedor();
            }
        }
    }
    public void mostrarUnProv(){
        if(listapro != null){
            int sw=0;
            System.out.print("\nIngrese razon social del Proveedor : ");
            String nom = sd.nextLine();
            for(Proveedor pp:listapro){
                if(pp.getRazonSocial().equalsIgnoreCase(nom)){
                    sw=1;
                    pp.mostrarProveedor();
                }
            }
            if(sw==0){
                System.out.println(" PROVEEDOR NO REGISTRADO ..!!!!!!");
            }
        }
    }
    public void compraProducto(){
        if(listapro != null){
            int sw=0;
             int ss=0;
            System.out.print("\nIngrese razon social del Proveedor : ");
            String nom = sd.nextLine();
            for(Proveedor pp:listapro){
                if(pp.getRazonSocial().equalsIgnoreCase(nom)){
                    sw=1;
                    System.out.print("Ingrese nombre del Producto : ");
                    String nomp = sd.nextLine();             
                    for(Producto pr:pp.getListap()){
                        if(pr.getNombrepro().equalsIgnoreCase(nomp)){
                            ss=1;
                            System.out.print("Ingrese la cantidad a comprar  : ");
                            int can = sd.nextInt();
                            int total = can +pr.getStock();
                            pr.setStock(total);
                            System.out.println("\nGuardando cambios ..!!! \n");
                            pr.mostrarProducto();
                        }
                    }
                }
            }
            if(sw==0){
                System.out.println(" PROVEEDOR NO ENCONTRADO ..!!!!!!");
            }
            if(ss==0){
                System.out.println(" PRODUCTO NO ENCONTRADO ..!!!!!!");
            }
        }
    }
    public void salidaProducto(){
        if(listapro != null){
            int sw=0;
             int ss=0;
            System.out.print("\nIngrese razon social del Proveedor : ");
            String nom = sd.nextLine();
            for(Proveedor pp:listapro){
                if(pp.getRazonSocial().equalsIgnoreCase(nom)){
                    sw=1;
                    System.out.print("Ingrese nombre del Producto : ");
                    String nomp = sd.nextLine();             
                    for(Producto pr:pp.getListap()){
                        if(pr.getNombrepro().equalsIgnoreCase(nomp)){
                            ss=1;
                            System.out.print("Ingrese la cantidad de Salida  : ");
                            int can = sd.nextInt();
                            if(can < pr.getStock()){
                                int total = pr.getStock() - can;
                                pr.setStock(total);
                                System.out.println("\nGuardando cambios ..!!! \n");
                                pr.mostrarProducto();
                            }else{
                                System.out.println("\nStock insuficiente ... !!!\n");
                            }
                        }
                    }
                }
            }
            if(sw==0){
                System.out.println(" PROVEEDOR NO ENCONTRADO ..!!!!!!");
            }
            if(ss==0){
                System.out.println(" PRODUCTO NO ENCONTRADO ..!!!!!!");
            }
        }
    }
     //CREANDO UN ARCHIVO
    public void crearArchivo(){
        Path path=Paths.get("E:\\PROGRAMACION\\TercerAño\\archivoProveedor.txt");
        try {
            if(!Files.exists(path)){
                Files.createFile(path);
                System.out.println("El archivo se creo correctamente..!!! ");
            }else{
                System.out.println("El archivo ya existe...!!! ");
            }
        } catch (Exception e) {
        }
    }
    //guardando la listapro dentro del archivo creado con anterioridad
    public void guardarObjetos(){
        String ruta="E:\\PROGRAMACION\\TercerAño\\archivoProveedor.txt";
        try {
            FileOutputStream archivo=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(archivo);
            oos.writeObject(listapro);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperacionesP.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(OperacionesP.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }
    //cargamos los datos del archivo a un list<Proveedor>
    public void leerProveedor(){
        String ruta="E:\\PROGRAMACION\\TercerAño\\archivoProveedor.txt";
        try {
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null){
                listapro=(List<Proveedor>)ois.readObject();
            }else{
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(OperacionesP.class.getName()).log(Level.SEVERE, null, e);
        }catch(IOException ex){
             Logger.getLogger(OperacionesP.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex){
             Logger.getLogger(OperacionesP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
