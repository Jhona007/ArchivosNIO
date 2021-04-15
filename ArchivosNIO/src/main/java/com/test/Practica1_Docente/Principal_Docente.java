/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.Practica1_Docente;

import java.util.Scanner;

/**
 *
 * @author PC-AL_100
 */
public class Principal_Docente {
    public static void main(String[] args) {
        Scanner sd =new Scanner (System.in);
        boolean con = true;
        int opc;
        OperacionesDoc op = new OperacionesDoc();
        do{
            System.out.println("");
            System.out.println("    ---------- MENU DE OPCIONES ---------- ");
            System.out.println("");
            System.out.println("    1. Crear Archivo ");
            System.out.println("    2. Crear Docente ");
            System.out.println("    3. Crear Materias ");
            System.out.println("    4. Guardar Registros");
            System.out.println("    5. Asignar Materias al Docente ");
            System.out.println("    6. Mostrar Docente ");
            System.out.println("    7. Salir ");
            System.out.println("");
            System.out.print("    Elija una opcion : ");
            opc = sd.nextInt();
            System.out.println("");
            switch(opc){
                case 1:
                    op.crearArchivo();
                    break;
                case 2:
                    op.crearDocente();
                    break;
                case 3:
                    op.crearMateria();
                    break;
                case 4:
                    op.guardarObjetos();
                    break;
                case 5:
                    op.leerMaterias();
                    op.asignar();
                    break;
                case 6:
                    op.leerMaterias();
                    op.mostraDocente();
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
