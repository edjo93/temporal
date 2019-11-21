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
        int cont_reg=1;//contador de campos
        Scanner scanner=new Scanner(System.in);
        boolean salir=false;
        char opcion1;
        int pos;
        Desktop fichero_abrir;
        File filename = null ;
        
        LinkedList<Campo>campos=new LinkedList<>();
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
                                        campos=(LinkedList<Campo>)leer.readObject();
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
                                    escribir.writeObject(campos);
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
                                campos.clear();
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
                    String datatype;
                    Scanner in=new Scanner(System.in);
                    //menu campos
                    char opcion3;
                    System.out.print("1-crear\n2-listar\n3-modificar\n4-borrar\n5-volver\n?:");
                    opcion3=scanner.next().charAt(0);
                    switch (opcion3) {
                        case '1':
                            if (filename!=null) {
                                
                                char resp;
                                //crear campo
                                //crear registro temporal
                                //Registro temp= new Registro("registro"+cont_reg++);
                                do {
                                    System.out.println("--add campo--");
                                    System.out.print("name: ");//cuenta o domicilio p.ejm
                                    String name_campo=in.nextLine();
                                    System.out.println("---datatype---");//tipo de dato
                                    boolean move_on=false;
                                    do {
                                        System.out.println("1-int\n2-string\n3-double\n4-float");
                                        datatype=in.nextLine();
                                        switch (datatype.charAt(0)) {
                                            case '1':
                                                datatype="int";
                                                move_on=true;
                                                break;
                                            case '2':
                                                datatype="string";
                                                move_on=true;
                                                break;
                                            case '3':
                                                datatype="double";
                                                move_on=true;
                                                break;
                                            case '4':
                                                datatype="float";
                                                move_on=true;
                                                break;
                                            default:
                                                System.out.println("opcion no valida intente de nuevo");
                                        }
                                    } while (move_on!=true);

                                    System.out.print("longitud: ");
                                    int longitud=in.nextInt();
                                    in.nextLine();
                                    System.out.print("llave primaria(v/f)?");
                                    //char isKey=scanner.nextLine().charAt(0);
                                    if(Character.toLowerCase(in.nextLine().charAt(0))=='v'){
                                        //temp_campos.add(new Campo(name_campo, true));
                                        campos.add(new Campo(name_campo,datatype,longitud, true));
                                    }else{
                                        //temp_campos.add(new Campo(name_campo, false));
                                        campos.add(new Campo(name_campo,datatype,longitud,false));
                                    }
                                    System.out.print("seguir ingresando campos?(s/n): ");
                                    resp=in.nextLine().charAt(0);
                                } while (Character.toLowerCase(resp)=='s');
                            }else{
                                System.out.println("file not open");
                            }
                            /*
                            //los campos van al registro correspondiente
                            temp.setCampos_de_registro(temp_campos);
                            
                            //limpiamos la lista de campos
                            temp_campos.clear();
                            */
                            
                            break;
                        case '2':
                            //listar campos
                            if (campos.isEmpty()) {
                                System.out.println("no hay campos");
                            }else{
                                System.out.println("  nombre tipo longitud llave");
                                System.out.println("--------------------------------");
                                for (int i = 0; i < campos.size(); i++) {
                                    //System.out.print(campos.get(i).getNombre()+":"+campos.get(i).getData()+"|");
                                    //System.out.print(campos.get(i).getData()+"|");
                                    
                                    System.out.println(campos.get(i).getNombre()
                                            +" "+campos.get(i).getDatatype()+" "
                                            +campos.get(i).getLongitud()+" "+campos.get(i).isKey());
                                }
                                
                            }
                            break;
                        case '3':
                            //modificar
                            if(campos.isEmpty()){
                                System.out.println("no hay campos");
                            }else{
                                boolean pos_invalida=true;
                                
                                do {
                                    
                                    Scanner int_scanner=new Scanner(System.in);
                                    Scanner new_def=new Scanner(System.in);
                                    System.out.println("--modificar campos--");
                                    /*
                                    for (int i = 0; i < campos.get(0).getCampos_de_registro().size(); i++) {//cantidad de campos de un registo
                                        System.out.println("["+i+"]"+campos.get(0).getCampos_de_registro().get(i).getNombre());
                                    }*/
                                    for (int i = 0; i < campos.size(); i++) {
                                        System.out.println("["+i+"]"+campos.get(i).getNombre());
                                    }
                                    System.out.print("pos?: ");//se solicita la posicion del campo a modificar
                                    pos=int_scanner.nextInt();
                                    if (pos>=0&&pos<campos.size()) {
                                        pos_invalida=false;
                                    }
                                    
                                } while (pos_invalida==true);

                                //have pos
                                //ask data
                                
                                
                                
                                
                                System.out.print("name: ");//cuenta o domicilio p.ejm
                                String name_campo=in.nextLine();
                                System.out.println("---datatype---");//tipo de dato
                                boolean move_on=false;
                                do {
                                    System.out.println("1-int\n2-string\n3-double\n4-float");
                                    datatype=in.nextLine();
                                    switch (datatype.charAt(0)) {
                                        case '1':
                                            datatype="int";
                                            move_on=true;
                                            break;
                                        case '2':
                                            datatype="string";
                                            move_on=true;
                                            break;
                                        case '3':
                                            datatype="double";
                                            move_on=true;
                                            break;
                                        case '4':
                                            datatype="float";
                                            move_on=true;
                                            break;
                                        default:
                                            System.out.println("opcion no valida intente de nuevo");
                                    }
                                } while (move_on!=true);

                                System.out.print("longitud: ");
                                int longitud=in.nextInt();
                                in.nextLine();
                                System.out.print("llave primaria(v/f)?");
                                //char isKey=scanner.nextLine().charAt(0);
                                if(Character.toLowerCase(in.nextLine().charAt(0))=='v'){
                                    //temp_campos.add(new Campo(name_campo, true));
                                    campos.get(pos).setNombre(name_campo);
                                    campos.get(pos).setDatatype(datatype);
                                    campos.get(pos).setLongitud(longitud);
                                    campos.get(pos).setKey(true);



                                }else{
                                    campos.get(pos).setNombre(name_campo);
                                    campos.get(pos).setDatatype(datatype);
                                    campos.get(pos).setLongitud(longitud);
                                    campos.get(pos).setKey(false);
                                }
                                       
                               
                                System.out.println("done!");
                                    
                                }
                            
                            
                            break;
                        case '4':
                            //eliminar
                            if(campos.isEmpty()){
                                System.out.println("no hay campos");
                            }else{
                                boolean pos_invalida=true;
                                
                                do {
                                    
                                    Scanner int_scanner=new Scanner(System.in);
                                    Scanner new_def=new Scanner(System.in);
                                    System.out.println("--eliminar campos--");
                                    /*
                                    for (int i = 0; i < campos.get(0).getCampos_de_registro().size(); i++) {//cantidad de campos de un registo
                                        System.out.println("["+i+"]"+campos.get(0).getCampos_de_registro().get(i).getNombre());
                                    }*/
                                    for (int i = 0; i < campos.size(); i++) {
                                        System.out.println("["+i+"]"+campos.get(i).getNombre());
                                    }
                                    System.out.print("pos?: ");//se solicita la posicion del campo a modificar
                                    pos=int_scanner.nextInt();
                                    if (pos>=0&&pos<campos.size()) {
                                        pos_invalida=false;
                                    }
                                    
                                } while (pos_invalida==true);

                                //have pos
                                //delete
                                campos.remove(pos);
                                System.out.println("done!");
                                    
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
