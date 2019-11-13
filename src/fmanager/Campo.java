/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmanager;

/**
 *
 * @author edas
 */
public class Campo {//nombre y id
    private String nombre;//ver que sucede con string a la hora de cargar al archivo binario
    private boolean key;

    public Campo(String nombre, boolean key) {
        this.nombre = nombre;
        this.key = key;
    }

    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    
    

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
}
