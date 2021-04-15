/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.Practica1_Discografia;

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
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC-AL_100
 */
public class OperacionesD {
    // OBJETO DE LECTURA
    Scanner sd = new Scanner(System.in);
    // ATRIBUTOS
    private Cancion cc;
    private Album aa;
    private List<Album> listaAlbum;
    // CONSTRUCTOR
    public OperacionesD(){
        listaAlbum=new ArrayList<>();
    }
    
    // METODOS
    public void RegistrarAlbum(){
        aa = new Album();
        System.out.print("Introduzca nombre del Album : ");
        aa.setNombre(sd.nextLine());
        System.out.print("Introduzca nombre del Artista : ");
        aa.setArtista(sd.nextLine());
        System.out.print("Introduzca el Formato de las canciones : ");
        aa.setFormato(sd.nextLine());
        listaAlbum.add(aa);
        System.out.print("\n Introduzca la cantidad de canciones que tiene el Album : ");
        int n = sd.nextInt();
        sd.nextLine();
        for (int i = 1; i <= n; i++) {
            cc = new Cancion();
            System.out.print("Introduzca Nombre Cancion : ");
            cc.setNombrec(sd.nextLine());
            System.out.print("Introduzca Duracion Cancion : ");
            cc.setDuracion(sd.nextFloat());
            sd.nextLine();
            System.out.print("Introduzca Genero de la Cancion : ");
            cc.setGenero(sd.nextLine());
            aa.agregarCancion(cc);
        }
        
    }
    public void mostrarAlbum(){
        if(listaAlbum != null){
            for(Album al:listaAlbum){
                al.mostrarAlbum();
            }
        }else{
                 System.out.println("\n LISTAS DE ALBUMES...!!!\n ");
        }
    }
    public void buscarCancion(){
        if(listaAlbum != null){
            int sw=0;
            System.out.println("Introduzca nombre de la Cancion : ");
            String nc = sd.nextLine();
            for(Album al:listaAlbum){
                for(Cancion ca:al.getListac()){
                    if(ca.getNombrec().equalsIgnoreCase(nc)){
                        sw=1;
                        System.out.println("\nCancion   : " + ca.getNombrec());
                        System.out.println("-----------------------------------------------------");
                        System.out.println("Album   : "+ al.getNombre());
                        System.out.println("Artista   : " + al.getArtista());
                    }
                }
            }
              if(sw==0){
                 System.out.println("\n ALBUM NO ENCONTRADO ...!!!\n ");
             }
        }
    }
    public void mostrarXalbum(){
         if(listaAlbum != null){
             int sw=0;
             System.out.print("Introduzca nombre del Album : ");
             String alb = sd.nextLine();
             for(Album al:listaAlbum){
                if(al.getNombre().equalsIgnoreCase(alb)){
                    sw=1;
                    al.mostrarAlbum();
                }
            }
             if(sw==0){
                 System.out.println("\n ALBUM NO ENCONTRADO ...!!!\n ");
             }
        }
    }
    public void eliminarAlbum(){
        if(listaAlbum != null){
            int sw=0;
            System.out.print("Introduzca nombre del Album : ");
            String na = sd.nextLine();
             Iterator<Album> ite=listaAlbum.iterator();
             while(ite.hasNext()){
                Album alb = ite.next();
                if(alb.getNombre().equalsIgnoreCase(na)){
                    sw=1;
                    ite.remove();
                    System.out.println("    --------------------------------------------------");
                    System.out.println("    --------- ALBUM ELIMINADO --------- ");
                    System.out.println("    .................................................. \n");
                }
            }
             if(sw==0){
                 System.out.println("\n ALBUM NO ENCONTRADO ...!!!\n ");
             }
        }
    }
    //CREANDO UN ARCHIVO
    public void crearArchivo(){
        Path path=Paths.get("E:\\PROGRAMACION\\TercerAño\\archivoDiscografia.txt");
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
    //guardando la listama dentro del archivo creado con anterioridad
    public void guardarObjetos(){
        String ruta="E:\\PROGRAMACION\\TercerAño\\archivoDiscografia.txt";
        try {
            FileOutputStream archivo=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(archivo);
            oos.writeObject(listaAlbum);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperacionB.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(OperacionB.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }
    //cargamos los datos del archivo a un list<MaterialBibliografico>
    public void leerMaterial(){
        String ruta="E:\\PROGRAMACION\\TercerAño\\archivoDiscografia.txt";
        try {
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null){
                listaAlbum=(List<Album>)ois.readObject();
            }else{
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(OperacionesD.class.getName()).log(Level.SEVERE, null, e);
        }catch(IOException ex){
             Logger.getLogger(OperacionesD.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex){
             Logger.getLogger(OperacionesD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
