package com.rubaanxd.fechas;

/**
 * Horas
 * Clase con metodos Miscelaneos para trabajar con Horas
 * <p>
 *  
 * @author RubaanxD
 * @version 1.0
 * @since 2019
 */
public class Horas {

    /**
     * devuelve la diferencia entre dos horas
     * solo horas en punto y media hora (08:00, 08:30, 09:00)
     * @param horaInicio hora de incio
     * @param horaFin hora de fin
     * @return Diferencia entre dos horas
     */
    public static double numeroHoras(String horaInicio, String horaFin) {

        double numHoraInicio;
        double numHoraFin;

        String[] horaMinutoInicio = horaInicio.split(":");

        numHoraInicio = Double.parseDouble(horaMinutoInicio[0]);
        if (Integer.parseInt(horaMinutoInicio[1]) == 30) {
            numHoraInicio += 0.5;
        }

        String[] horaMinutoFin = horaFin.split(":");

        numHoraFin = Double.parseDouble(horaMinutoFin[0]);
        if (Integer.parseInt(horaMinutoFin[1]) == 30) {
            numHoraFin += 0.5;
        }

        return numHoraFin - numHoraInicio;

    }
}
