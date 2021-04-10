package com.arandukaaty.practicas;

public class Cliente {
    // Atributos (variables o constantes)
    private int id;
    private String nombre;
    
    // Metodos (funciones)
    // Vacio
    public Cliente() {
    }

    // Con parametros
    public Cliente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    // Getter y Setter
    // Getter
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
