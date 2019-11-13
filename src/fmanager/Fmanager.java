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
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author edas
 */
public class Fmanager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        /*
        //escribir un objeto en un archivo binario
        Archivo archivo1=new Archivo("archivo.dat");
        archivo1.crear_archivo();
        Archivo archivo2=new Archivo("archivo.dat");
        archivo2.crear_archivo();
        System.out.println(archivo1.getNombre());
        System.out.println(archivo2.getNombre());
        
        archivo1.crear_registro();
        archivo1.crear_registro();
        archivo1.crear_registro();
        archivo1.listar_registros();
        archivo1.guardar_registros();
        */
        // TODO code application logic here
        int cont_reg=1;//contador de registros
        Scanner scanner=new Scanner(System.in);
        boolean salir=false;
        char opcion1;
        Desktop fichero_abrir;
        File filename ;
        FileInputStream flujo_entrada = null;
        FileOutputStream flujo_salida;
        LinkedList <Campo> temp_campos=new LinkedList<>();
        LinkedList <Registro>temp_registro=new LinkedList<>();
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
                                    flujo_entrada=new FileInputStream(filename);
                                    System.out.println("open!");
                                } catch (IOException e) {
                                }
                                
                            }else{
                                System.out.println("not found");
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
                            
                            break;
                        case '4':
                            //cerrar el archivo abierto actualmente
                            if(flujo_entrada!=null){
                                try{
                                    flujo_entrada.close();
                                    flujo_entrada=null;
                                    System.out.println("closed!");
                                }catch(IOException e){

                                }
                               
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
                            //crear registro
                            temp_registro.add(new Registro("registro"+cont_reg++));
                            do {
                                System.out.println("--add campo--");
                                System.out.print("nombre: ");
                                String name_campo=in.nextLine();
                                System.out.print("llave primaria(v/f)?");
                                //char isKey=scanner.nextLine().charAt(0);
                                if(Character.toLowerCase(in.nextLine().charAt(0))=='v'){
                                    temp_campos.add(new Campo(name_campo, true));
                                }else{
                                    temp_campos.add(new Campo(name_campo, false));
                                    
                                }
                                System.out.println("s para salir otra tecla para continuar: ");
                                resp=in.nextLine().charAt(0);
                            } while (Character.toLowerCase(resp)!='s');
                            //los campos van al registro correspondiente
                            temp_registro.getFirst().setCampos_de_registro(temp_campos);
                            break;
                        case '2':
                            //por cada registro listar campos
                            if (temp_registro.isEmpty()) {
                                System.out.println("no hay registros");
                            }else{
                                for (int i = 0; i < temp_registro.size(); i++) {
                                    temp_registro.get(i).listar_campos();
                                }
                            }
                            break;
                        case '3':
                            
                            break;
                        case '4':
                            
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
