package com.rubaanxd.fechas;

import java.util.Calendar;

/**
 * Meses
 * Clase con metodos Miscelaneos para trabajar con Meses
 * <p>
 *  
 * @author RubaanxD
 * @version 1.0
 * @since 2019
 */
public class Meses {
    
    /**
     * Devuelve un array con todos los meses del año
     * @return Array con todos los meses del año 
     */
    public static String[] mesesAnio(){
        
        String mesesAnio[]={"enero", 
                            "febrero", 
                            "marzo", 
                            "abril", 
                            "mayo", 
                            "junio", 
                            "julio", 
                            "agosto", 
                            "septiembre", 
                            "octubre", 
                            "noviembre", 
                            "diciembre"};
        return mesesAnio;
    }
    
    /**
     * Indica si el mes pasado es correcto
     * No importa los espacios externos y mayusculas y minusculas
     * @param mes Mes a comprobar
     * @return True = mes es correcto
     */
    public static boolean mesCorrecto(String mes){
        
        boolean correcto=false;
        
        String meses[]=mesesAnio();
        
        for(int i=0;i<meses.length;i++){
            if(mes.toLowerCase().trim().equals(meses[i])){
                correcto=true;
            }
        }
        
        return correcto;
        
    }
    
    public static int calculaMeses(int dia, int mes, int anio) {

        Calendar inicio = Calendar.getInstance();
        inicio.set(anio, mes - 1, dia);

        Calendar actual = Calendar.getInstance();

        int anios_diferencia = Anios.calcularAniosCalendar(dia, mes, anio);

        int meses = Math.abs((anios_diferencia * 12) + (actual.get(Calendar.MONTH) - inicio.get(Calendar.MONTH)));

        if (actual.get(Calendar.DATE) < dia) {
            meses--;
        }

        return meses;

    }
    
}
