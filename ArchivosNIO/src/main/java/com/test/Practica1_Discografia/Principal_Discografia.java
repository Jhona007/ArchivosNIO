/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.Practica1_Discografia;

import java.util.Scanner;

/**
 *
 * @author PC-AL_100
 */
public class Principal_Discografia {
    public static void main(String[] args) {
         // OBJETO DE LECTURA
        Scanner sd = new Scanner(System.in);
        OperacionesD op = new OperacionesD();
        // MENU DE OPCIONES
        boolean con = true;
        int opc;
        do {
            System.out.println("\n   \b ------------------- MENU DE OPCIONES ----------------- \n");
            System.out.println("    1. Crear Archivo ");
            System.out.println("    2. Registrar Album ");
            System.out.println("    3. Guardar Registros ");
            System.out.println("    4. Mostrar Albumes ");
            System.out.println("    5. Buscar Cancion ");
            System.out.println("    6. Mostrar Album ");
            System.out.println("    7. Eliminar Album ");
            System.out.println("    8. Salir \n");
            System.out.print("    Elija una opcion : ");
            opc = sd.nextInt();
            System.out.println("");
            switch (opc) {
                case 1:
                    op.crearArchivo();
                    break;
                case 2:
                    op.leerMaterial();
                    op.RegistrarAlbum();
                    break;
                case 3:
                    op.guardarObjetos();
                    break;
                case 4:
                    op.leerMaterial();
                    op.mostrarAlbum();
                    break;
                case 5:
                    op.leerMaterial();
                    op.buscarCancion();
                    break;
                case 6:
                    op.leerMaterial();
                    op.mostrarXalbum();
                    break;
                case 7:
                    op.leerMaterial();
                    op.eliminarAlbum();
                    op.guardarObjetos();
                    break;
                case 8:
                    System.out.println(" \n   Saliendo del Programa...!!!!! \n");
                    con = false;
                    break;
                default:
                    System.out.println("\n    Opcion Incorrecta....!!!!!");
                    System.out.println("    Intente de nuevo.....!!!!!!\n");
                    break;
            }
        } while (con);
    }
}
