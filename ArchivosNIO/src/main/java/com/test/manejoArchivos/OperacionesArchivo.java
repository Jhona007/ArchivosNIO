/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.manejoArchivos;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PC-AL_100
 */
public class OperacionesArchivo {
    public void crearD(){
        Path path = Paths.get("E:\\PROGRAMACION\\TercerAño");
        try{
            if (!Files.exists(path)){
                Files.createDirectory(path);
                System.out.println("Directorio Creado ... !!!");
                
            }else{
                System.out.println("Ya existe el directorio ...!!! ");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void crearArchivo(){
        Path path = Paths.get("E:\\PROGRAMACION\\TercerAño\\miArchivo.txt");
        try {
            if(!Files.exists(path)){
                Files.createFile(path);
                System.out.println("Archivo creado!! ");
            }else{
                System.out.println("El archivo ya existe !! ");
                // agregando contenido al archivo creado anteriormente
                //Files.write(path, "Creando archivo con Java 13".getBytes(), StandardOpenOption.);
            }
        } catch (Exception e)  {
            e.printStackTrace();
        }
    }
    public void agregarContenido(){
        Path path = Paths.get("E:\\PROGRAMACION\\TercerAño\\miArchivo.txt");
        String texto,res;
        Scanner sd = new Scanner (System.in);
        try{
            System.out.println("Deseas agregar contenido al archivo s/n? ");
            res = sd.nextLine();
            while(res.equalsIgnoreCase("s")){
                texto = sd.nextLine();
                texto = texto + "\n";
                Files.write(path, texto.getBytes(), StandardOpenOption.APPEND);
                System.out.println("Desea seguir agregando contenido s/n?");
                res = sd.nextLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void mostrarContenido(){
        Path path = Paths.get("E:\\PROGRAMACION\\TercerAño\\miArchivo.txt");
        try{
            List<String> lineasAr = Files.readAllLines(path);
            System.out.println("    -------  CONTENIDO DEL ARCHIVO ---------- ");
            for(String linea:lineasAr){
                System.out.println(linea);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
        public void eliminarDirectorio() {
        Path path = Paths.get("C:\\Users\\Usuario\\Documents\\ArchivoElim");
        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println("Archivo a eliminar: " + file.toString());
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Files.delete(dir);
                    System.out.println("Directorio a eliminar: " + dir.toString());
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
