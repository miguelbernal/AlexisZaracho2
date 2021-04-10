package com.arandukaaty.practicas;

import java.util.ArrayList;
import java.util.Scanner;

public class Estructura {

    public static void structuraIf() {
        // If else
        int edad = 18;
        if (edad >= 18) {
            System.out.println("Eres mayor de edad");
        } else {
            System.out.println("Eres menor de edad");
        }

        // If anidado
        Scanner scanner = new Scanner(System.in);
        System.out.println("Estación actual: ");
        int estacion = scanner.nextInt();
        if (estacion == 1) {
            System.out.println("Primavera");
        } else {
            if (estacion == 2) {
                System.out.println("Verano");
            } else {
                if (estacion == 3) {
                    System.out.println("Otoño");
                } else {
                    if (estacion == 4) {
                        System.out.println("Invierno");
                    } else {
                        System.out.println("Estación incorrecta!");
                    }
                }
            }
        }

        // If else if
        // If anidado
        System.out.println("Estación actual: ");
        estacion = scanner.nextInt();
        if (estacion == 1) {
            System.out.println("Primavera");
        } else if (estacion == 2) {
            System.out.println("Verano");
        } else if (estacion == 3) {
            System.out.println("Otoño");
        } else if (estacion == 4) {
            System.out.println("Invierno");
        } else {
            System.out.println("Estación incorrecta!");
        }
        
        // Switch
        System.out.println("Estación actual: ");
        estacion = scanner.nextInt();
        switch (estacion) {
            case 1:
                System.out.println("Primavera");
                break;
            case 2:
                System.out.println("Verano");
                break;
            case 3:
                System.out.println("Otoño");
                break;
            case 4:
                System.out.println("Invierno");
                break;
            default:
                System.out.println("Estación incorrecta!");
                break;
        }
        
        // Ciclos
        // For
        for (int i = 0; i < 10; i++) {
            System.out.println("For " + i);
        }

        ArrayList<Cliente> clientes = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            Cliente cliente = new Cliente(i, "Cliente " + i);
            clientes.add(cliente);
        }
                       
        String gNombre = "";
        boolean imprimir = false;
        for (Cliente cliente : clientes) {
            if(gNombre.equals(cliente.getNombre())){
                imprimir = false;
            } else {
                imprimir = true;
                gNombre = cliente.getNombre();
            }
            System.out.println(imprimir);
            if(imprimir){
                System.out.println("Nombre: " + cliente.getNombre());
            }
        }
        
        // While
        int i = 0;
        while (i <= 10) {            
            System.out.println("While " + i);
            i++;
        }
        
        // Do While
        i = 0;
        do {            
            System.out.println("Do While " + i);
            i++;
            for (int j = 0; j < 10; j++) {
                System.out.println("For " + j);
            }
        } while  (i <= 10);
    }
}
