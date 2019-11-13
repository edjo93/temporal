/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author edas
 */
public class Archivo {
    int cont;
    String nombre;//nombre del archivo
    private LinkedList<Registro> lista_registros=new LinkedList<>();
    
    public Archivo(){
      //no se le da un nombre al archivo  
    }
    
    public Archivo(String nombre){ //validacion de nombre
        cont=0;//conteo de registros
        setNombre(nombre);
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        File archivo=new File(nombre);
        
        if(archivo.exists()){
           nombre=null;
        }else{
            this.nombre=nombre;
        }
        
    }

    public LinkedList<Registro> getLista_registros() {
        return lista_registros;
    }

    public void setLista_registros(LinkedList<Registro> lista_registros) {
        this.lista_registros = lista_registros;
    }

    

    public void crear_registro(){
        //se ingresa un registro 
        lista_registros.add(new Registro(""+ cont++));
        
    }
    public void listar_registros(){
        for (int i = 0; i < lista_registros.size(); i++) {
            System.out.println(lista_registros.get(i).getNombre());
        }
    }
    public void crear_archivo(){
        if(nombre!=null){
            //crea un archivo con un nombre valido
            try{
                FileOutputStream generar_archivo=new FileOutputStream(new File(nombre));
                generar_archivo.close();
            }catch(IOException e){
                
            }
            
        }else{
            Scanner input=new Scanner(System.in);
            System.out.print("archivo existente/reemplazar (s/n)?:");
            String newname=input.nextLine();
            
            if(Character.toLowerCase(newname.charAt(0))=='s'){
                try{
                    FileOutputStream generar_archivo=new FileOutputStream(new File(newname));
                    generar_archivo.close();
                }catch(IOException e){

                }
            }else{
                //nuevo nombre
                System.out.print("nuevo nombre: ");
                newname=input.nextLine();
                while(newname.equals(nombre)){
                    System.out.print("nuevo nombre: ");
                    newname=input.nextLine();
                }
                try{
                    FileOutputStream generar_archivo=new FileOutputStream(new File(newname));
                    generar_archivo.close();
                }catch(IOException e){

                }
                
            }
            
            
        }
    }
    public void guardar_registros() throws ClassNotFoundException{
        try{
            
            ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream(nombre));
            //escribir todo el linkedList
            escribir.writeObject(lista_registros);
            escribir.close();
            //recuperar la informacion
            
            ObjectInputStream leer = new ObjectInputStream(new FileInputStream(nombre));
            
            LinkedList<Registro>registros_recuperados=(LinkedList<Registro>)leer.readObject();

            for (int i = 0; i < registros_recuperados.size(); i++) {
                System.out.println(registros_recuperados.get(i).getNombre()+"<- pos recuperada");
            }
            
            
            
        }catch(IOException e){
            
        }
        
    }
    
}
