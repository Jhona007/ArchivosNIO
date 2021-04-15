/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.Practica1_Docente;

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
public class OperacionesDoc {
    // ATRIBUTOS
    private Docente doc;
    private List<Materia> listaMat;
    
    // CONSTRUCTOR
    public OperacionesDoc(){
        listaMat = new ArrayList<>();
    }
    
    Scanner sd = new Scanner (System.in);
    
    // METODOS
      public void crearDocente(){
        doc = new Docente();
        System.out.print("Introduzca nombre      : ");
        doc.setNombre(sd.nextLine());
        System.out.print("Introduzca Ap. Paterno : ");
        doc.setPaterno(sd.nextLine());
        System.out.print("Introduzca Ap. Materno : ");
        doc.setMaterno(sd.nextLine());
        System.out.print("Introduzca su Titulo   : ");
        doc.setTitulo(sd.nextLine());
        System.out.print("Introduzca su carga Horaria : ");
        doc.setCargaH(sd.nextInt());
        doc.setHmax(0);
    }
      public void mostraDocente(){
          if(doc != null){
              doc.mostrar();
          }
      }
      // CREANDO MATERIAS
      public void crearMateria(){
          Materia mm = new Materia();
          mm.crearMat();
          listaMat.add(mm);
      }
      // ASIGNANDO MATERIAS AL DOCENTE
      public void asignar(){
          boolean sw=true;
          System.out.print("Introduzca nombre de la Materia : ");
          String nm = sd.nextLine();
          for (Materia m:listaMat){
              if(m.getNombreM().equalsIgnoreCase(nm)){
                  sw=false;
                  if(doc.getCargaH() == doc.getHmax()){
                      System.out.println("");
                      System.out.println("  ..Carga Horaria Completada......!!!!! ");
                      System.out.println("     Nose puede asignar mas Materia...!!!!");
                      System.out.println("");
                  }else{
                  if(doc.getCargaH()>doc.getHmax()){
                      doc.agregar(m);
                      int su = m.getHoraM() + doc.getHmax();
                      doc.setHmax(su);
                  }else{
                      int re = doc.getCargaH() - doc.getHmax();
                      System.out.println("");
                      System.out.println("Carga Horaria libre del Docente : "+re);
                      System.out.println("");
                  }
                  }
              } 
          }
          if(sw){
              System.out.println("Materia no existente ....!!!!!");
                  System.out.println("Registrelo primero Por favor ...!!!!!");
          }
      }
      // ------  GESTION DE ARCHIVOS -------
    
    //CREANDO UN ARCHIVO
    public void crearArchivo(){
        // D
        Path path=Paths.get("E:\\Incos\\ProgramacionIII\\archivoDocente.txt");
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
        String ruta="E:\\Incos\\ProgramacionIII\\archivoDocente.txt";
        try {
            FileOutputStream archivo=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(archivo);
            oos.writeObject(listaMat);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperacionesDoc.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(OperacionesDoc.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    //cargamos los datos del archivo a un list<Seguro>
    public void leerMaterias(){
        String ruta="E:\\Incos\\ProgramacionIII\\archivoDocente.txt";
        try {
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null){
                listaMat=(List<Materia>)ois.readObject();
            }else{
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(OperacionesDoc.class.getName()).log(Level.SEVERE, null, e);
        }catch(IOException ex){
             Logger.getLogger(OperacionesDoc.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex){
             Logger.getLogger(OperacionesDoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
