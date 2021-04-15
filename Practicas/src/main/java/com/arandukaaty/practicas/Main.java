package com.arandukaaty.practicas;

// Clase

public class Main {
    // Atributos

    // Metodos
    public static void main(String[] args) {
        if (false) {
            Cliente cliente = new Cliente();
            System.out.println(cliente.getId());
            System.out.println(cliente.getNombre());
            cliente.setId(1);
            cliente.setNombre("Cliente uno");
            System.out.println(cliente.getId());
            System.out.println(cliente.getNombre());

            Cliente clienteDos = new Cliente(2, "Cliente dos");
            System.out.println(clienteDos.getId());
            System.out.println(clienteDos.getNombre());

            // Estructuras del lenguaje
            Estructura.structuraIf();

            // Paquetes de Java
            PaquetesJava.paquetesJavaSystem();
        }

        // Base de Datos
        BaseDatos.baseDatos();
    }

}
