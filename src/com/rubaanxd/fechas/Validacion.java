package com.rubaanxd.fechas;

import static com.rubaanxd.fechas.Dias.numeroDeDiasMes;


/**
 * Dias
 * Clase con metodos Miscelaneos para trabajar con Dias
 * <p>
 *  
 * @author RubaanxD
 * @version 1.0
 * @since 2019
 */
public class Validacion {
    
    /**
     * Valida si la fecha es valida
     * @param anio Año
     * @param mes Mes
     * @param dia Día
     * @return True = fecha valida
     */
     public static boolean validarFecha(int anio, int mes, int dia){
        
        boolean valido=false;
        
        if (anio>=0 && (mes>=1 && mes<=12)){
            if(numeroDeDiasMes(mes) >= dia){
                valido=true;
            }
        }
        
        return valido;
        
    } 

     /**
      * Valida si la hora es correcta
      * @param hora Hora
      * @param minuto Minuto
      * @param segundo Segundo
      * @return True = hora correcta
      */
    public static boolean validaHora(int hora, int minuto, int segundo){
        
        boolean valido=false;
        
        if ((hora >= 0 && hora <= 23) && (minuto >= 0 && minuto <= 59) && (segundo >= 0 && segundo <= 59)){
            valido = true;
        }

        return valido;
    }
    
}
