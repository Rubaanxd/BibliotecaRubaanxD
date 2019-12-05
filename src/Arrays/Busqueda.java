package arrays;

import java.util.Arrays;

/**
 * @author RubaanxD
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
    public static boolean busquedaString(String array[], String valorBuscado){
        String resultado = Arrays.stream(array)
                         .filter(s -> s.equals(valorBuscado))
                         .findFirst()
                         .orElse(null);
        return resultado != null;
        }
    
}
