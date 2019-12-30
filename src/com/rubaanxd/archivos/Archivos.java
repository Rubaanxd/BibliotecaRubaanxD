package com.rubaanxd.archivos;

import java.io.IOException;

/**
 * Archivos
 * Clase para poder trabajar con archivos variados
 * <p>
 * @author RubaanxD
 * @version 1.0
 * @since 2019
 */
public class Archivos {
    
    /**
     * Metodo para Abrir un Archivo
     * @param aplicacion        Es el nombre del proceso de la aplicacion para abrir el archivo
     *                          para ocupar el programa predeterminado se ocupa el cmd.exe.
     * @param discoUbicacion    Es la ubicaicon raiz del archivo. Ejemplo /c.
     * @param pathArchivo       Es la ubicacion exacta del Archivo. Ejemplo C:\\Users\\Usuario\\Desktop\\temp.pdf
     * @throws IOException      Algun Problema con la lectura, o error al abrir la aplicacion.
     */
    public static void abrirArchivo(String aplicacion,String discoUbicacion,String pathArchivo) throws IOException{
        ProcessBuilder pb = new ProcessBuilder();
        pb.command(aplicacion, discoUbicacion, pathArchivo);
        pb.start();
    }
    
    /**
     * Metodo para abrir archivo con la Aplicacion Predeterminada y en cualquier lugar de /C:
     * @param pathArchivo   Es la ubicacion exacta del Archivo. Ejemplo C:\\Users\\Usuario\\Desktop\\temp.pdf
     * @throws IOException  Algun Problema con la lectura, o error al abrir la aplicacion.
     */
    public static void abrirArchivo(String pathArchivo) throws IOException{
        ProcessBuilder pb = new ProcessBuilder();
        pb.command("cmd.exe", "/c", pathArchivo);
        pb.start();
    }
    
}
