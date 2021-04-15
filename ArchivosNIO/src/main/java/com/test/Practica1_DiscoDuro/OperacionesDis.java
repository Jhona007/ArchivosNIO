/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.Practica1_DiscoDuro;

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
public class OperacionesDis {
    // OBJETO DE LECTURA
    Scanner sd = new Scanner (System.in);
    
    // DEFINIENDO LISTAS
    private List <DiscoDuro> listaDis;
    private DiscoDuro dd;
    private Archivo ar;
    // CONSTRUCTOR
    public OperacionesDis(){
        listaDis = new ArrayList<>();
    }
    
    // METODOS
    public void registrarDiscoDuro(){
        dd=new DiscoDuro();
        dd.llenar();
        listaDis.add(dd);
    }
 
    public void AgregarArchivos(){
        boolean sw=true;
        
        System.out.print("Introduzca marca del Disco Duro : ");
          String nom = sd.nextLine();         
          for (DiscoDuro m:listaDis){
              if(m.getMarca().equalsIgnoreCase(nom)){
                  sw=false;
                  System.out.print(" - Cuantas Archivos desea agregar : ");
                  int lim = sd.nextInt();
                  ar =new Archivo();
                  for (int i = 1; i <= lim; i++) {
                      sd.nextLine();
                      System.out.print("Introduzca nombre del Archivo : ");
                      ar.setNombrear(sd.nextLine());
                      System.out.print("Ingrese el Tamaño del Archivo : ");
                      double tam = sd.nextDouble();
                      if(m.getEspacioDis() > tam){
                        ar.setTamar(tam);
                        double esp = m.getEspacioDis() - tam;
                        m.setEspacioDis(esp);
                        m.agregarEs(ar);
                      }else{
                          System.out.println("ESPACIO INSUFICIENTE ...!!! ");
                      }
                      
                  }
         
              } 
          }
          if (sw){
              System.out.println("DISCO DURO NO EXISTENTE ...!!!!!");
          }
    }
    public void mostrarDisco(){
        int sw=0;
        System.out.print("Introduzca marca del Disco Duro : ");
         String disco = sd.nextLine();    
        for(DiscoDuro dis: listaDis){
            if (dis.getMarca().equalsIgnoreCase(disco)){
                sw = 1;
                dis.mostrar();
            }
        }
        if (sw == 0){
            System.out.println("DISCO DURO NO EXISTENTE ...!!!!!");
        }
    }
    
    public void eliminarAr(){
        int sw=0;
        System.out.print("\nIngrese marca del Disco Duro : ");
        String disco = sd.nextLine();
        for(DiscoDuro dis: listaDis){
            if (dis.getMarca().equalsIgnoreCase(disco)){
                sw = 1;
                System.out.println("Ingrese nombre del Archivo : ");
                String name = sd.nextLine();
                dis.eliminarar(name);
            }
        }
    
        if (sw == 0){
            System.out.println("DISCO DURO NO EXISTENTE ...!!!!!");
        }
    }
  
    // ------  GESTION DE ARCHIVOS -------
    
    //CREANDO UN ARCHIVO
    public void crearArchivo(){
        // D
        Path path=Paths.get("E:\\Incos\\ProgramacionIII\\archivoDiscoduro.txt");
        try {
            if(!Files.exists(path)){
                Files.createFile(path);
                System.out.println("El archivo se creo correctamente");
            }else{
                System.out.println("El archivo ya existe");
            }
        } catch (Exception e) {
        }
    }
    //guardando 
    public void guardarObjetos(){
        String ruta="E:\\Incos\\ProgramacionIII\\archivoDiscoduro.txt";
        try {
            FileOutputStream archivo=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(archivo);
            oos.writeObject(listaDis);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperacionesDis.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(OperacionesDis.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    //cargamos los datos
    public void leerDiscoDuro(){
        String ruta="E:\\Incos\\ProgramacionIII\\archivoDiscoduro.txt";
        try {
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null){
                listaDis=(List<DiscoDuro>)ois.readObject();
            }else{
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(OperacionesDis.class.getName()).log(Level.SEVERE, null, e);
        }catch(IOException ex){
             Logger.getLogger(OperacionesDis.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex){
             Logger.getLogger(OperacionesDis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
