package com.rubaanxd.multiidiomas;

import java.io.IOException;
import java.util.Properties;

/**
 * MultiIdiomas
 * Clase con metodos Miscelaneos para trabajar properties
 * <p>
 *  
 * @author RubaanxD
 * @version 1.0
 * @since 2019
 */
public class Idioma extends Properties{
    
    private static final long serialVersionUID = 1L;
	       
    /**
     * Recoge los datos de un fichero properties donde estan los datos de la traducción
     * Se necesitan los ficheros properties creados en el mismo paquete
     * @param idioma String con el nombre del idioma (Español, Inglés)
     */
    public Idioma(String idioma){
    	
        //Modificar si quieres añadir mas idiomas
    	switch(idioma){
	    	case "Español":
                    getProperties("espanol.properties");
                    break;
	    	case "Inglés":
                    getProperties("ingles.properties");
                    break;
	    	default:
                    getProperties("espanol.properties");
	   	}

    }

    /**
     * Carga el fichero properties
     * @param idioma String con el nombre del idioma (Español, Inglés)
     */
    private void getProperties(String idioma) {
        try {
            this.load( getClass().getResourceAsStream(idioma) );
        } catch (IOException ex) {
        
        }
   }
}
