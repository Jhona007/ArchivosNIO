/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen_Final1er;

import java.util.Scanner;

/**
 *
 * @author PC-AL_100
 */
public class Principal_Proveedor {
    public static void main(String[] args) {
        // OBJETO DE LECTURA
        Scanner sd = new Scanner(System.in);
        OperacionesP op = new OperacionesP();
        // MENU DE OPCIONES
        boolean con = true;
        int opc;
        do {
            System.out.println("\n   \b ------------------- MENU DE OPCIONES ----------------- \n");
            System.out.println("    1. Crear Archivo ");
            System.out.println("    2. Registrar Proveedor ");
            System.out.println("    3. Guardar Datos ");
            System.out.println("    4. Mostrar Proveedores ");
            System.out.println("    5. Buscar Proveedor ");
            System.out.println("    6. Registrar Compra de Productos ");
            System.out.println("    7. Registrar Salida de Productos ");
            System.out.println("    8. Salir \n");
            System.out.print("    Elija una opcion : ");
            opc = sd.nextInt();
            System.out.println("");
            switch (opc) {
                case 1:
                    op.crearArchivo();
                    break;
                case 2:
                    op.leerProveedor();
                    op.registrarProveedor();
                    op.guardarObjetos();
                    break;
                case 3:
                    System.out.println("\n Datos Guardados correctamente ..!!! \n");
                    op.guardarObjetos();
                    break;
                case 4:
                    op.leerProveedor();
                    op.mostrarProveedor();
                    break;
                case 5:
                    op.leerProveedor();
                    op.mostrarUnProv();
                    break;
                case 6:
                    op.leerProveedor();
                    op.compraProducto();
                    op.guardarObjetos();
                    break;
                case 7:
                    op.leerProveedor();
                    op.salidaProducto();
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
