/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmanager;

import java.io.Serializable;

/**
 *
 * @author edas
 */
public class Campo implements Serializable {//nombre y id
    private String nombre;
    private String datatype;
    int longitud;
    private boolean key;

    public Campo(String nombre, String datatype, int longitud, boolean key) {
        this.nombre = nombre;
        this.datatype = datatype;
        this.longitud = longitud;
        this.key = key;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
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
