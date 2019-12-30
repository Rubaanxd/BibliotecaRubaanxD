package com.rubaanxd.ficheros;

import java.io.File;

/**
 * Rutas
 * Clase con metodos Miscelaneos rutas de Ficheros
 * <p>
 *  
 * @author RubaanxD
 * @version 1.0
 * @since 2019
 */
public class Rutas {
    
    /**
     * Devuelve la ruta de un fichero, sin incluir a este
     * Comprobar siempre que se pasa un fichero por parametro
     * @param rutaFichero Cadena con la ruta del fichero
     * @return Solo ruta del fichero
     */
    public static String devolverRutaFichero(String rutaFichero){
       
        int pos=rutaFichero.lastIndexOf(File.separator);

        if(pos!=-1){
            return rutaFichero.substring(0, pos+1);
        }else{
            return rutaFichero;
        }
        
    }
    
    /**
     * Devuelve la ruta de un fichero, sin incluir a este
     * Comprobar siempre que se pasa un fichero por parametro
     * @param rutaFichero Ruta del fichero
     * @return Solo ruta del fichero
     */
    public static String devolverRutaFichero(File rutaFichero){
       
        int pos=rutaFichero.getAbsoluteFile().toString().lastIndexOf(File.separator);

        if(pos!=-1){
            return rutaFichero.getAbsoluteFile().toString().substring(0, pos+1);
        }else{
            return rutaFichero.getAbsoluteFile().toString();
        }
        
    }
    
    /**
     * Devuelve todos los ficheros recursivos de un directorio
     * @param directorio Directorio original
     * @param separador Forma de separar cada fichero o directorio
     * @return Cadena con todos los ficheros y directorios recursivos
     */
    public static String ficherosRecursivos(File directorio, String separador){
        File[] ficheros = directorio.listFiles();
        
        String contenido="";
            for (int x=0;x<ficheros.length;x++){                    
                contenido+=separador + ficheros[x].getName();

                if (ficheros[x].isDirectory()){
                    String nuevo_separador;
                    nuevo_separador = separador + " ";
                    ficherosRecursivos(ficheros[x],nuevo_separador);
                }
            }
        
        return contenido;
    }
    
}
