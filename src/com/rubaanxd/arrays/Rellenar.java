package com.rubaanxd.arrays;

import com.rubaanxd.numeros.Aleatorios;
import com.rubaanxd.numeros.Validacion;



/**
 * Rellenar
 * Clase para llenar de datos tipos de Arrays
 * <p>
 * @author RubaanxD
 * @version 1.0
 * @since 2019
 */
public class Rellenar {

    /**
     * Rellena un array de enteros, validando cada numero
     *
     * @param array Array que queremos rellenar
     */
    public static void rellenaArray(int array[]) {

        for (int i = 0; i < array.length; i++) {
            array[i] = Validacion.validarNumero();
        }
    }

    /**
     * Rellena un array de numeros aleatorios entre un mínimo y un máximo
     *
     * @param array Array que queremos rellenar
     * @param minimo Número mínimo
     * @param maximo Número máximo
     */
    public static void rellenaArrayAleatorios(int array[], int minimo, int maximo) {

        for (int i = 0; i < array.length; i++) {
            array[i] = Aleatorios.generaNumeroAleatorio(minimo, maximo);
        }
    }

}
