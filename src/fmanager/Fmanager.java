/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmanager;

import java.awt.Desktop;
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
public class Fmanager {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException{
        // TODO code application logic here
        int cont_reg=1;//contador de registros
        Scanner scanner=new Scanner(System.in);
        boolean salir=false;
        char opcion1;
        Desktop fichero_abrir;
        File filename = null ;
        
        LinkedList<Registro>temp_registro=new LinkedList<>();
        //Queue<Registro> cola_registros=new LinkedList<>();
        //el programa continua mientras el usuario asi lo decida
        do {
            System.out.print("1-archivo\n2-campos\n3-registros\n4-indices\n5-utilidades\n?:");
            opcion1=scanner.next().charAt(0);
            switch (opcion1) {
                
                    
                case '1':
                    char opcion2;
                    System.out.print("1-abrir\n2-nuevo\n3-salvar\n4-cerrar\n5-salir\n?:");
                    opcion2=scanner.next().charAt(0);
                    switch (opcion2) {
                        case '1':
                            if(filename!=null){
                                System.out.println("close existing file first");
                            }else{
                            
                                //abre un archivo
                                File ruta=new File("C:\\Users\\edas\\Documents\\NetBeansProjects\\fmanager");
                                String[] archivos=ruta.list();
                                for (String archivo : archivos) {
                                    System.out.println(archivo);
                                }
                                Scanner in=new Scanner(System.in);

                                System.out.print("nombre del archivo a abrir: ");
                                String fname=in.nextLine();
                                filename=new File(fname);
                                if(filename.exists()){
                                    /*

                                    ---abrir con windows---
                                    fichero_abrir=Desktop.getDesktop();
                                    try {
                                        fichero_abrir.open(filename);
                                    } catch (IOException e) {
                                        System.out.println("error al abrir el archivo");
                                    }*/

                                    try {

                                        ObjectInputStream leer=new ObjectInputStream(new FileInputStream(filename));
                                        temp_registro=(LinkedList<Registro>)leer.readObject();
                                        leer.close();
                                        System.out.println("open!");
                                    } catch (IOException e) {
                                    }

                                }else{
                                    filename=null;
                                    System.out.println("not found");
                                }
                            }
                            
                            
                            break;
                        case '2':
                            Scanner input=new Scanner(System.in);
                            //archivo nuevo
                            System.out.print("nombre del archivo: ");
                            String nombre_archivo=input.nextLine();
                            File nuevo=new File(nombre_archivo);
                            if(nuevo.exists()){
                                //preguntar si desea reemplazar el archivo
                                System.out.print("archivo existente/reemplazar (s/n)? ");
                                if(Character.toLowerCase(input.nextLine().charAt(0))=='s'){
                                    try{
                                        FileOutputStream generar_archivo=new FileOutputStream(new File(nombre_archivo));
                                        generar_archivo.close();
                                        System.out.println("reemplazado con exito!");
                                    }catch(IOException e){

                                    }
                                }else{
                                    System.out.println("no se registran cambios");
                                }
                                    
                                
                            }else{
                                //crea el archivo directamente
                                try{
                                    FileOutputStream generar_archivo=new FileOutputStream(new File(nombre_archivo));
                                    generar_archivo.close();
                                    System.out.println("creado con exito!");
                                }catch(IOException e){

                                }
                            }
                            break;
                        case '3':
                            
                            //guardar registros
                            if(filename!=null){
                                try{
                                    ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream(filename));
                                    escribir.writeObject(temp_registro);
                                    escribir.close();
                                    System.out.println("saved!");
                                }catch(IOException e){

                                }
                            }else{
                                System.out.println("not open");
                            }
                            
                            
                            break;
                        case '4':
                            //cerrar el archivo abierto actualmente
                            //if(flujo_entrada!=null&leer!=null||flujo_salida!=null&escribir!=null){
                            if(filename!=null){
                                filename=null;
                                System.out.println("closed!");
                            }else{
                                System.out.println("not open."); 
                            }
                            break;
                        case '5':
                            salir=true;
                            break;    
                        default:
                            System.out.println("la opcion que ingreso no es corrrecta");
                    }
                    
                    break;
                case '2':
                    
                    Scanner in=new Scanner(System.in);
                    //menu campos
                    char opcion3;
                    System.out.print("1-crear\n2-listar\n3-modificar\n4-borrar\n5-volver\n?:");
                    opcion3=scanner.next().charAt(0);
                    switch (opcion3) {
                        case '1':
                            char resp;
                            //crear campo
                            //crear registro temporal
                            Registro temp= new Registro("registro"+cont_reg++);
                            do {
                                System.out.println("--add campo--");
                                System.out.print("name: ");//cuenta o domicilio p.ejm
                                String name_campo=in.nextLine();
                                System.out.print("data: ");//informacion ligada al nombre 
                                String data=in.nextLine();
                                System.out.print("llave primaria(v/f)?");
                                //char isKey=scanner.nextLine().charAt(0);
                                if(Character.toLowerCase(in.nextLine().charAt(0))=='v'){
                                    //temp_campos.add(new Campo(name_campo, true));
                                    temp.getCampos_de_registro().add(new Campo(name_campo,data, true));
                                }else{
                                    //temp_campos.add(new Campo(name_campo, false));
                                    temp.getCampos_de_registro().add(new Campo(name_campo,data, false));
                                }
                                System.out.print("s para salir otra tecla para continuar: ");
                                resp=in.nextLine().charAt(0);
                            } while (Character.toLowerCase(resp)!='s');
                            /*
                            //los campos van al registro correspondiente
                            temp.setCampos_de_registro(temp_campos);
                            
                            //limpiamos la lista de campos
                            temp_campos.clear();
                            */
                            temp_registro.add(temp);
                            break;
                        case '2':
                            //por cada registro listar campos
                            if (temp_registro.isEmpty()) {
                                System.out.println("no hay registros");
                            }else{
                                for (int i = 0; i < temp_registro.size(); i++) {
                                    temp_registro.get(i).listar_campos();
                                    System.out.println("");
                                }
                                
                            }
                            break;
                        case '3':
                            //segun registro
                            //nos movemos a traves de los registros
                            if(temp_registro.isEmpty()){
                                System.out.println("no hay registros");
                            }else{
                                //listar campos de un unico registro,ya que todos los registros tienen estos campos en comun
                                Scanner int_scanner=new Scanner(System.in);
                                Scanner new_def=new Scanner(System.in);
                                System.out.println("--modificar campos--");
                                for (int i = 0; i < temp_registro.get(0).getCampos_de_registro().size(); i++) {//cantidad de campos de un registo
                                    System.out.println("["+i+"]"+temp_registro.get(0).getCampos_de_registro().get(i).getNombre());
                                }
                                System.out.print("pos?: ");//se solicita la posicion del campo a modificar
                                int pos=int_scanner.nextInt();
                                boolean pos_invalida=true;
                                if(pos>=0&pos<temp_registro.get(0).getCampos_de_registro().size()){
                                    //nueva definicion
                                    System.out.print("new field name: ");//cuenta -->account
                                    String new_name=new_def.nextLine();
                                    for (int i = 0; i < temp_registro.size(); i++) {
                                        temp_registro.get(i).getCampos_de_registro().get(pos).setNombre(new_name);
                                    }
                                    System.out.println("done!");
                                }else{
                                    System.out.println("--modificar campos--");
                                    while (pos_invalida) {
                                        for (int i = 0; i < temp_registro.get(0).getCampos_de_registro().size(); i++) {//cantidad de campos de un registo
                                            System.out.println("["+i+"]"+temp_registro.get(0).getCampos_de_registro().get(i).getNombre());
                                        }
                                        System.out.print("posicion no valida/intente de nuevo: ");
                                        pos=int_scanner.nextInt();
                                        if (pos>=0&pos<temp_registro.get(0).getCampos_de_registro().size()) {
                                           pos_invalida=false;
                                        }
                                    }
                                    //nueva definicion
                                    System.out.print("new field name: ");//cuenta -->account
                                    String new_name=new_def.nextLine();
                                    for (int i = 0; i < temp_registro.size(); i++) {
                                        temp_registro.get(i).getCampos_de_registro().get(pos).setNombre(new_name);
                                    }
                                    System.out.println("done!");
                                    
                                }
                            }
                            
                            break;
                        case '4':
                            //segun registro
                            //nos movemos a traves de los registros
                            if(temp_registro.isEmpty()){
                                System.out.println("no hay registros");
                            }else{
                                //listar campos de un unico registro,ya que todos los registros tienen estos campos en comun
                                Scanner int_scanner=new Scanner(System.in);
                                Scanner new_def=new Scanner(System.in);
                                System.out.println("--eliminar campos--");
                                for (int i = 0; i < temp_registro.get(0).getCampos_de_registro().size(); i++) {//cantidad de campos de un registo
                                    System.out.println("["+i+"]"+temp_registro.get(0).getCampos_de_registro().get(i).getNombre());
                                }
                                System.out.print("pos?: ");//se solicita la posicion del campo a modificar
                                int pos=int_scanner.nextInt();
                                boolean pos_invalida=true;
                                if(pos>=0&pos<temp_registro.get(0).getCampos_de_registro().size()){
                                    for (int i = 0; i < temp_registro.size(); i++) {
                                        temp_registro.get(i).getCampos_de_registro().remove(pos);//remover el campo seleccionado en todos los registros
                                    }
                                    System.out.println("done!");
                                }else{
                                    System.out.println("--eliminar campos--");
                                    while (pos_invalida) {
                                        for (int i = 0; i < temp_registro.get(0).getCampos_de_registro().size(); i++) {//cantidad de campos de un registo
                                            System.out.println("["+i+"]"+temp_registro.get(0).getCampos_de_registro().get(i).getNombre());
                                        }
                                        System.out.print("posicion no valida/intente de nuevo: ");
                                        pos=int_scanner.nextInt();
                                        if (pos>=0&pos<temp_registro.get(0).getCampos_de_registro().size()) {
                                           pos_invalida=false;
                                        }
                                    }
                                    
                                    for (int i = 0; i < temp_registro.size(); i++) {
                                        temp_registro.get(i).getCampos_de_registro().remove(pos);
                                    }
                                    System.out.println("done!");
                                    
                                }
                                
                            }
                            //si un registro no tiene campos|| clear all reg
                            if(!temp_registro.isEmpty()){
                                if(temp_registro.get(0).getCampos_de_registro().isEmpty()){
                                    temp_registro.clear();
                                }
                            }
                            
                            break;
                        case '5':
                            //back
                            break;
                        default:
                            System.out.println("la opcion que ingreso no es correcta");
                    }
                    break;
                case '3':
                    
                    break;
                case '4':
                    
                    break;
                case '5':
                    
                    break;    
                default:
                    System.out.println("la opcion que ingreso no es correcta");
            }
        } while (salir==false);
        
    }
    
    
    
    
    
}
