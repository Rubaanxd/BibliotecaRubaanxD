package com.rubaanxd.arrays;

import java.util.Arrays;

/**
 * Busqueda
 * Clase para buscar dentro de arrays
 * <p>
 * @author RubaanxD
 * @version 1.0
 * @since 2019
 */
public class Busqueda {
    
    
    /**
     * Busca un numero entero en un array
     * Necesita que el array este ordenado
     * @param array Array que queremos ordenar
     * @param numerobuscado Numero que queremos buscar en el array
     * @return Posicion del numero
     */
    public static int busquedaBinaria (int array[], int numerobuscado){
        int izq=0;
        int der=array.length;
        boolean encontrado=false;
        int pos=-1;

        for(int i=0;!encontrado && i<array.length;i++){
            int central=array[(izq+der)/2];
            if (central<=numerobuscado){
                if (central==numerobuscado){
                    encontrado=true;
                    pos=(izq+der)/2;
                }else{
                    izq=(izq+der)/2;
                }
            }else{
                der=(izq+der)/2;
            }
        }
        return pos;
    }
    /**
     * Funcion que te permite saber si hay un valor dentro de un array de Strings
     * @param array         Arreglo en el cual se buscara
     * @param valorBuscado  Valor que se buscara en el array
     * @return              Devuelve True si existe, false si no
     */
    public static boolean busquedaString(String array[], String valorBuscado){
        String resultado = Arrays.stream(array)
                         .filter(s -> s.equals(valorBuscado))
                         .findFirst()
                         .orElse(null);
        return resultado != null;
        }
    
}
