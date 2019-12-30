package com.rubaanxd.swing;

import javax.swing.JComboBox;
import com.rubaanxd.validaciones.ExpresionesRegulares;

/**
 * ErroresFormularios
 * Clase con metodos Miscelaneos para validar Formularios
 * <p>
 *  
 * @author RubaanxD
 * @version 1.0
 * @since 2019
 */
public class ErroresFormularios {

    private StringBuilder errores;
    /**
     * Constructor
     */
    public ErroresFormularios() {
        this.errores = new StringBuilder();
    }
    
    /**
     * Confirma si hay errores o no
     * @return boolean True si hay errores, False si no
     */
    public boolean hasError() {
        return !this.errores.toString().isEmpty();
    }
    
    /**
     * Muestra los errores
     * @return String errores
     */
    public String getErrores() {
        return errores.toString();
    }
    
    /**
     * Metodo para validar si un String es un numero entero
     * @param textoValidar String a validar 
     */
    public void validarNumeroEntero(String textoValidar) {
        if (!textoValidar.isEmpty() && !ExpresionesRegulares.validaNumeroEntero_Exp(textoValidar)) {
            this.errores.append(" - ").append(textoValidar).append(" no es un numero entero\n");
        }
    }
    
    /**
     * Metodo para validar si un String es un numero entero
     * @param textoValidar  String a validar
     * @param mensajeError  Mensaje de Error
     */
    public void validarNumeroEntero(String textoValidar, String mensajeError) {
        if (!textoValidar.isEmpty() && !ExpresionesRegulares.validaNumeroEntero_Exp(textoValidar)) {
            this.errores.append(mensajeError);
        }
    }
    
    /**
     * Metodo para validar si un String es un numero real
     * @param textoValidar String a validar
     */
    public void validarNumeroReal(String textoValidar) {
        if (!textoValidar.isEmpty() && !ExpresionesRegulares.validaNumeroReal_Exp(textoValidar)) {
            this.errores.append(" - ").append(textoValidar).append(" no es un numero real\n");
        }
    }
    
    /**
     * Metodo para validar si un String es un numero real
     * @param textoValidar  String a validar
     * @param mensajeError  Mensaje de Error
     */
    public void validarNumeroReal(String textoValidar, String mensajeError) {
        if (!textoValidar.isEmpty() && !ExpresionesRegulares.validaNumeroReal_Exp(textoValidar)) {
            this.errores.append(mensajeError);
        }
    }
    
    /**
     * Metodo para validar si un String es un numero Real
     * @param textoValidar  String a validar
     * @param decimales     Cantidad de decimales
     */
    public void validarNumeroReal(String textoValidar, int decimales) {
        if (!textoValidar.isEmpty() && !ExpresionesRegulares.validaNumeroReal_Exp(textoValidar, decimales)) {
            this.errores.append(" - ").append(textoValidar).append(" no es un numero real\n");
        }
    }
    
    /**
     * Metodo para validar si un String es un numero Real
     * @param textoValidar  String a validar
     * @param decimales     Cantidad de decimales
     * @param mensajeError  Mensaje de Error
     */
    public void validarNumeroReal(String textoValidar, int decimales, String mensajeError) {
        if (!textoValidar.isEmpty() && !ExpresionesRegulares.validaNumeroReal_Exp(textoValidar, decimales)) {
            this.errores.append(mensajeError);
        }
    }
    
    /**
     * Metodo para validar si un string es un numero Real positivo
     * @param textoValidar  String a validar
     */
    public void validarNumeroRealPositivo(String textoValidar) {
        if (!textoValidar.isEmpty() && !ExpresionesRegulares.validaNumeroRealPositivo_Exp(textoValidar)) {
            this.errores.append(" - ").append(textoValidar).append(" no es un numero real\n");
        }
    }

    /**
     * Metodo para validar si un string es un numero Real positivo
     * @param textoValidar  String a validar
     * @param mensajeError  Mensaje de Error
     */
    public void validarNumeroRealPositivo(String textoValidar, String mensajeError) {
        if (!textoValidar.isEmpty() && !ExpresionesRegulares.validaNumeroRealPositivo_Exp(textoValidar)) {
            this.errores.append(mensajeError);
        }
    }
    
    /**
     * Metodo para validar si un string es un numero Real positivo
     * @param textoValidar  String a validar
     * @param decimales     Cantidad de decimales
     */
    public void validarNumeroRealPositivo(String textoValidar, int decimales) {
        if (!textoValidar.isEmpty() && !ExpresionesRegulares.validaNumeroRealPositivo_Exp(textoValidar, decimales)) {
            this.errores.append(" - ").append(textoValidar).append(" no es un numero real\n");
        }
    }

    /**
     * Metodo para validar si un string es un numero Real positivo
     * @param textoValidar  String a validar
     * @param decimales     Cantidad de decimales
     * @param mensajeError  Mensaje de error
     */
    public void validarNumeroRealPositivo(String textoValidar, int decimales, String mensajeError) {
        if (!textoValidar.isEmpty() && !ExpresionesRegulares.validaNumeroRealPositivo_Exp(textoValidar, decimales)) {
            this.errores.append(mensajeError);
        }
    }

    /**
     * Metodo para validar si un String esta vacio y manda error
     * @param textoValidar String a validar
     */
    public void validarVacio(String textoValidar) {
        if (textoValidar.isEmpty()) {
            this.errores.append("- El texto no puede estar vacio\n");
        }
    }
    
    /**
     * Metodo para validar si un String esta vacio y manda error
     * @param textoValidar  String a validar
     * @param mensajeError  Mensaje de error
     */
    public void validarVacio(String textoValidar, String mensajeError) {
        if (textoValidar.isEmpty()) {
            this.errores.append(mensajeError);
        }
    }
    
    /**
     * Valida si un JComboBox esta seleccionado o no
     * @param cmb JComboBox a validar
     */
    public void validarOpcionSeleccionadaCMB(JComboBox cmb) {
        if (cmb.getSelectedIndex() == 0) {
            this.errores.append("- Debes una opcion del combo\n");
        }
    }
    
    /**
     * Valida si un JComboBox esta seleccionado o no
     * @param cmb JComboBox a Validar
     * @param mensajeError Mensaje de error
     */
    public void validarOpcionSeleccionadaCMB(JComboBox cmb, String mensajeError) {
        if (cmb.getSelectedIndex() == 0) {
            this.errores.append(mensajeError);
        }
    }

    /**
     * Valida si un Objeto apunta a Null
     * @param o Objeto a Validar
     */
    public void validarNulo(Object o) {
        if (o == null) {
            this.errores.append("- El objecto es nulo\n");
        }
    }

    /**
     * Valida si un Objeto apunta a Null
     * @param o Objeto a Validar  
     * @param mensajeError Mensaje de error
     */
    public void validarNulo(Object o, String mensajeError) {
        if (o == null) {
            this.errores.append(mensajeError);
        }
    }
    
    /**
     * Valida si un valor es distinto de cero
     * @param valor Valor a validar
     */
    public void validarDistintoCero(int valor) {
        if (valor == 0) {
            this.errores.append("- El valor no puede ser cero");
        }
    }

    /**
     * Valida si un valor INT es distinto de cero
     * @param valor Valor INT a validar
     * @param mensajeError Mensaje de Error
     */
    public void validarDistintoCero(int valor, String mensajeError) {
        if (valor == 0) {
            this.errores.append(mensajeError);
        }
    }

    /**
     * Validar si un valor Double es distinto de cero
     * @param valor Valor double a validar
     */
    public void validarDistintoCero(double valor) {
        if (valor == 0) {
            this.errores.append("- El valor no puede ser cero");
        }
    }
    
    /**
     * Validar si un valor Double es distinto de cero
     * @param valor Valor double a validar
     * @param mensajeError Mensaje de Error
     */
    public void validarDistintoCero(double valor, String mensajeError) {
        if (valor == 0) {
            this.errores.append(mensajeError);
        }
    }

    /**
     * Valida que el valor1 no sea mayor que el valor2
     * @param valor1 Valor1 a validar
     * @param valor2 Valor2 a validar
     */
    public void validarMayorQue(int valor1, int valor2) {
        if (valor1 > valor2) {
            this.errores.append("- El valor1 no puede ser mayor que el valor 2");
        }
    }
    
    /**
     * Valida que el valor1 no sea mayor que el valor2
     * @param valor1 Valor1 a validar
     * @param valor2 Valor2 a validar
     * @param mensajeError Mensaje de Error
     */
    public void validarMayorQue(int valor1, int valor2, String mensajeError) {
        if (valor1 > valor2) {
            this.errores.append(mensajeError);
        }
    }
    
    /**
     * Valida si un String es un numero INT y lo compara con otro mayor
     * @param numeroComoTexto String a validar
     * @param mayorQue Numero mayor a comparar
     */
    public void validarMayorQue(String numeroComoTexto, int mayorQue) {
        if (!ExpresionesRegulares.validaNumeroEntero_Exp(numeroComoTexto)) {
            this.errores.append("- El Valor introducido debe ser un número");
        } else {
            int valor = Integer.parseInt(numeroComoTexto);
            if (valor > mayorQue) {
                this.errores.append("- El valor1 no puede ser mayor que el valor 2");
            }
        }

    }

    /**
     * Valida si un String es un numero INT y lo compara con otro mayor
     * @param numeroComoTexto String a validar
     * @param mayorQue Numero mayoror a comparar
     * @param mensajeErrorNoNumero Mensaje de Error si el String no es un numero
     * @param mensajeErrorMayor Mensaje de Error si el numeroComoTexto es mayor que el mayorQue
     */
    public void validarMayorQue(String numeroComoTexto, int mayorQue, String mensajeErrorNoNumero, String mensajeErrorMayor) {
        if (!ExpresionesRegulares.validaNumeroEntero_Exp(numeroComoTexto)) {
            this.errores.append(mensajeErrorNoNumero);
        } else {
            int valor = Integer.parseInt(numeroComoTexto);
            if (valor > mayorQue) {
                this.errores.append(mensajeErrorMayor);
            }
        }
    }
    
    /**
     * Valida si un String tiene formato de Email
     * @param email String a validar
     */
    public void validarEmail(String email) {
        if (!email.isEmpty() && !ExpresionesRegulares.validar_Mail_Exp(email)) {
            this.errores.append("- El email no tiene el formato correcto \n");
        }
    }
    
    /**
     * Valida si un String tiene formato de Email
     * @param email String a validar
     * @param mensajeError Mensaje de error
     */
    public void validarEmail(String email, String mensajeError) {
        if (!email.isEmpty() && !ExpresionesRegulares.validar_Mail_Exp(email)) {
            this.errores.append("- El email no tiene el formato correcto \n");
        }
    }

    /**
     * Valida si un texto cumple con el formato
     * @param textoValidar String a Validar
     * @param patron String con el patron en forma de Expresion Regular
     */
    public void validarPatron(String textoValidar, String patron) {
        if (!textoValidar.isEmpty() && !patron.matches(patron)) {
            this.errores.append("- El texto no cumple patron indicado \n");
        }
    }

    /**
     * Valida si un texto cumple con el formato
     * @param textoValidar String a validar
     * @param patron String con el patron en forma de Expresion Regular
     * @param errores Mensaje de Error
     */
    public void validarPatron(String textoValidar, String patron, String errores) {
        if (!textoValidar.isEmpty() && !patron.matches(patron)) {
            this.errores.append(errores);
        }
    }

}
