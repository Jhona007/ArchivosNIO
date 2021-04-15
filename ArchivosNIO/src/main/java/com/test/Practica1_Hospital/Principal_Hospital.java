/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.Practica1_Hospital;

import java.util.Scanner;

/**
 *
 * @author PC-AL_100
 */
public class Principal_Hospital {
    public static void main(String[] args) {
        Scanner sd =new Scanner (System.in);
        boolean con = true;
        int opc;
        OperacionesHos op = new OperacionesHos();
        do{
            System.out.println("");
            System.out.println("    ------------------- MENU DE OPCIONES ----------------- ");
            System.out.println("");
            System.out.println("    1. Crear Registro");
            System.out.println("    2. Registrar Hospital ");
            System.out.println("    3. Agregar Especialidad ");
            System.out.println("    4. Guardar Registros");
            System.out.println("    5. Mostrar Especialidades de un Hospital ");
            System.out.println("    6. Listar Hospitales de una Especialidad");
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
                    op.registrarHospital();
                    break;
                case 3:
                    op.AgregarEspecialidad();
                    break;
                case 4:
                    op.guardarObjetos();
                    break;
                case 5:
                    op.leerEspecialidad();
                    op.mostrarHospital();
                    break;
                case 6:
                    op.leerEspecialidad();
                    op.mostrarPorEspecialidad();
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
