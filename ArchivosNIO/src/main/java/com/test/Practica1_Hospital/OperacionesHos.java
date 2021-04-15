/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.Practica1_Hospital;

import com.test.Practica1_Docente.Materia;
import com.test.Practica1_Docente.OperacionesDoc;
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
public class OperacionesHos {
     // OBJETO DE LECTURA
    Scanner sd = new Scanner (System.in);
    
    // DEFINIENDO LISTAS
    private List <Hospital> listaHos;
    private Hospital hh;
    private Especialidad esp;
    // CONSTRUCTOR
    public OperacionesHos(){
        listaHos = new ArrayList<>();
    }
    
    // METODOS
    public void registrarHospital(){
        hh=new Hospital();
        System.out.print("Introduzca nombre del Hospital : ");
        hh.setNombre(sd.nextLine());
        System.out.print("Introduzca direccion del Hospital : ");
        hh.setDireccion(sd.nextLine());
        System.out.print("Introduzca el Nivel del Hospital : ");
        hh.setNivel(sd.nextInt());
        listaHos.add(hh);
    }
 
    public void AgregarEspecialidad(){
        boolean sw=true;
        
        System.out.print("Introduzca nombre del Hospital : ");
          String hos = sd.nextLine();         
          for (Hospital m:listaHos){
              if(m.getNombre().equalsIgnoreCase(hos)){
                  sw=false;
                  System.out.println(" - Cuantas Especialidades tiene el Hospital : ");
                  int lim = sd.nextInt();
                  for (int i = 1; i <= lim; i++) {
                      esp=new Especialidad();
                      System.out.println("Introduza nombre de Especialidad : ");
                      esp.setNomEspe(sd.nextLine());
                      m.agregarEs(esp);
                  }
         
              } 
          }
          if (sw){
              System.out.println("HOSPITAL NO REGISTRADO ...!!!!!");
          }
    }
    public void mostrarHospital(){
        int sw=0;
        System.out.print("Introduzca nombre del Hospital : ");
         String hospi = sd.nextLine();    
        for(Hospital hos: listaHos){
            if (hos.getNombre().equalsIgnoreCase(hospi)){
                sw = 1;
                hos.mostrarHospital();
            }
        }
        if (sw == 0){
            System.out.println("HOSPITAL NO REGISTRADO ...!!!!!");
        }
    }
    public void mostrarPorEspecialidad(){
        int sw=0;
        System.out.print("Introduzca nombre de la Especialidad : ");
        String espe = sd.nextLine();    
        for(Especialidad es: hh.getListaEs()){
            if (es.getNomEspe().equalsIgnoreCase(espe)){
                sw = 1;
                es.mostrarEspe();
            }
        }
        if (sw==0){
            System.out.println("HOSPITAL NO REGISTRADO ...!!!!!");
        }
    }
    // ------  GESTION DE ARCHIVOS -------
    
    //CREANDO UN ARCHIVO
    public void crearArchivo(){
        // D
        Path path=Paths.get("E:\\Incos\\ProgramacionIII\\archivoEspecialidad.txt");
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
    //guardando la listaMaterial dentro del archivo creado con anterioridad
    public void guardarObjetos(){
        String ruta="E:\\Incos\\ProgramacionIII\\rchivoEspecialidad.txt";
        try {
            FileOutputStream archivo=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(archivo);
            oos.writeObject(listaHos);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperacionesHos.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(OperacionesHos.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    //cargamos los datos del archivo a un list<Hospital>
    public void leerEspecialidad(){
        String ruta="E:\\Incos\\ProgramacionIII\\archivoEspecialidad.txt";
        try {
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null){
                listaHos=(List<Hospital>)ois.readObject();
            }else{
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(OperacionesHos.class.getName()).log(Level.SEVERE, null, e);
        }catch(IOException ex){
             Logger.getLogger(OperacionesHos.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex){
             Logger.getLogger(OperacionesHos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
