/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmanager;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author edas
 */
public class Registro implements Serializable{//connjunto de campos
    String nombre;
    LinkedList<Campo> campos_de_registro=new LinkedList<>();
    
    public Registro(String nombre){
        this.nombre=nombre;
    }

    public LinkedList<Campo> getCampos_de_registro() {
        return campos_de_registro;
    }

    public void setCampos_de_registro(LinkedList<Campo> campos_de_registro) {
        this.campos_de_registro = campos_de_registro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void listar_campos(){
        
        for (int i = 0; i < campos_de_registro.size(); i++) {
            //System.out.print(campos_de_registro.get(i).getNombre()+":"+campos_de_registro.get(i).getData()+"|");
            //System.out.print(campos_de_registro.get(i).getData()+"|");
            System.out.println("  nombre tipo longitud llave");
            System.out.println("--------------------------------");
            System.out.println(campos_de_registro.get(i).getNombre()
                    +" "+campos_de_registro.get(i).getDatatype()+" "
                    +campos_de_registro.get(i).getLongitud()+" "+campos_de_registro.get(i).isKey());
        }
    }
    
    
    
}
