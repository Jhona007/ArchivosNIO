/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.Practica1_DiscoDuro;

import com.test.Laboratorio1.OperacionB;
import java.util.Scanner;

/**
 *
 * @author PC-AL_100
 */
public class Principal_Disco {
    public static void main(String[] args) {
        Scanner sd =new Scanner (System.in);
        boolean con = true;
        int opc;
        OperacionesDis op = new OperacionesDis();
        do{
            System.out.println("\n    ------------------- MENU DE OPCIONES ----------------- \n");
            System.out.println("    1. Crear archivo");
            System.out.println("    2. Registrar Disco Duro ");
            System.out.println("    3. Agregar Archivos ");
            System.out.println("    4. Guardar los registros");
            System.out.println("    5. Mostrar Disco Duro ");
            System.out.println("    6. Eliminar Archivo ");
            System.out.println("    7. Salir \n");
            System.out.print("    Elija una opcion : ");
            opc = sd.nextInt();
            System.out.println("");
            switch(opc){
                case 1:
                    op.crearArchivo();
                    break;
                case 2:
                    op.leerDiscoDuro();
                    op.registrarDiscoDuro();
                    break;
                case 3:
                    op.leerDiscoDuro();
                    op.AgregarArchivos();
                    op.guardarObjetos();
                    break;
                case 4:
                    System.out.println(" \nDatos guardados con exito...!!!");
                    op.guardarObjetos();
                    break;
                case 5:
                    op.leerDiscoDuro();
                    op.mostrarDisco();
                    break;
                case 6:
                    op.leerDiscoDuro();
                    op.eliminarAr();
                    op.guardarObjetos();
                    break;
                case 7:
                    System.out.println("    Saliendo del Programa...!!!!!");
                    con = false;
                    break;
                default:
                    System.out.println("    Opcion Incorrecta....!!!!!");
                    System.out.println("    Intente de nuevo.....!!!!!!");
                    break;
            }
        }while (con);
    }
}
