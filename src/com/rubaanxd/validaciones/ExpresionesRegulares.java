package com.rubaanxd.validaciones;

/**
 * Expresions Regulares
 * Clase con metodos Miscelaneos para realizar validaciones a partir de Expresions regulares
 * <p>
 *  
 * @author RubaanxD
 * @version 1.0
 * @since 2019
 */
public class ExpresionesRegulares {
    
    /**
     * Valida si una cadena es un numero entero
     *
     * @param texto String que contiene el valor a validar
     * @return True = es un numero entero
     */
    public static boolean validaNumeroEntero_Exp(String texto) {

        return texto.matches("^-?[0-9]+$");
    }

    /**
     * Valida si una cadena es un numero entero
     *
     * @param texto String que contiene el valor a validar
     * @return True = es un numero entero positivo
     */
    public static boolean validaNumeroEnteroPositivo_Exp(String texto) {

        return texto.matches("^[0-9]+$");
    }

    /**
     * Valida si una cadena es un numero entero
     *
     * @param texto String que contiene el valor a validar
     * @return True = es un numero entero negativo
     */
    public static boolean validaNumeroEnteroNegativo_Exp(String texto) {

        return texto.matches("^-[0-9]+$");
    }

    /**
     * Valida si una cadena es un numero real (positivo o negativo)
     *
     * @param texto String que contiene el valor a validar
     * @return True = es un numero real
     */
    public static boolean validaNumeroReal_Exp(String texto) {

        return texto.matches("^-?[0-9]+([\\.,][0-9]+)?$");
    }

    /**
     * Valida si una cadena es un numero real (positivo o negativo) con un
     * numero de decimales
     *
     * @param texto String que contiene el valor a validar
     * @param num_deciamales numero de decimales maximo, no puede ser menor que
     * cero
     * @return True = es un numero real
     */
    public static boolean validaNumeroReal_Exp(String texto, int num_deciamales) {
        if (num_deciamales > 0) {
            return texto.matches("^-?[0-9]+([\\.,][0-9]{1," + num_deciamales + "})?$");
        } else {
            return false;
        }

    }

    /**
     * Valida si una cadena es un numero real negativo
     *
     * @param texto String que contiene el valor a validar
     * @return True = es un numero real negativo
     */
    public static boolean validaNumeroRealNegativo_Exp(String texto) {

        return texto.matches("^-[0-9]+([\\.,][0-9]+)$");
    }

    /**
     * Valida si una cadena es un numero real (positivo o negativo) con un
     * numero de decimales
     *
     * @param texto String que contiene el valor a validar
     * @param num_deciamales numero de decimales maximo, no puede ser menor que
     * cero
     * @return True = es un numero real
     */
    public static boolean validaNumeroRealNegativo_Exp(String texto, int num_deciamales) {
        if (num_deciamales > 0) {
            return texto.matches("^-[0-9]+([\\.,][0-9]{1," + num_deciamales + "})?$");
        } else {
            return false;
        }

    }

    /**
     * Valida si una cadena es un numero real positivo
     *
     * @param texto String que contiene el valor a validar
     * @return True = es un numero real positivo
     */
    public static boolean validaNumeroRealPositivo_Exp(String texto) {

        return texto.matches("^[0-9]+([\\.,][0-9]+)?$");
    }

    /**
     * Valida si una cadena es un numero real (positivo o negativo) con un
     * numero de decimales
     *
     * @param texto String que contiene el valor a validar
     * @param num_deciamales numero de decimales maximo, no puede ser menor que
     * cero
     * @return True = es un numero real
     */
    public static boolean validaNumeroRealPositivo_Exp(String texto, int num_deciamales) {
        if (num_deciamales > 0) {
            return texto.matches("^[0-9]+([\\.,][0-9]{1," + num_deciamales + "})?$");
        } else {
            return false;
        }

    }

    /**
     * Valida si una cadena tiene el formato de fecha dd/mm/aaaa
     *
     * @param texto String que contiene el valor a validar
     * @return True = es una fecha válida
     */
    public static boolean validaNumeroFecha_Exp(String texto) {

        return texto.matches("^(0?[1-9]|[12][0-9]|3[01])[\\/](0?[1-9]|1[012])[/\\/](19|20)\\d{2}$");
    }

    /**
     * Valida si una cadena es un email
     *
     * @param email String que contiene el valor a validar
     * @return True = es un email válido
     */
    public static boolean validar_Mail_Exp(String email) {

        return email.matches("^([\\w-]+\\.)*?[\\w-]+@[\\w-]+\\.([\\w-]+\\.)*?[\\w]+$");

    }

    /**
     * Valida si una cadena es un email complejo (subdominios)
     *
     * @param email String que contiene el valor a validar
     * @return True = es un email complejo válido
     */
    public static boolean validar_Mail_Complejo_Exp(String email) {

        return email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    }

    /**
     * Valida si una cadena es una IP válida
     *
     * @param ip String que contiene el valor a validar
     * @return True = es una IP válida
     */
    public static boolean validaIP_Exp(String ip) {

        return ip.matches("^(([1-9]?[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]).){3}([1-9]?[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
    }

    /**
     * Valida si una cadena es una url
     *
     * @param url String que contiene el valor a validar
     * @return True = es una url válida
     */
    public static boolean validaURL_Exp(String url) {

        return url.matches("^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\?=.-]*)*\\/?$");
    }

    /**
     * Valida si una cadena es un número binario
     *
     * @param binario String que contiene el valor a validar
     * @return True = es un número binario válido
     */
    public static boolean validaBinario_Exp(String binario) {

        return binario.matches("^[0-1]+$");

    }

    /**
     * Valida si una cadena es un número octal
     *
     * @param octal String que contiene el valor a validar
     * @return True = es un número octal válido
     */
    public static boolean validaOctal_Exp(String octal) {

        return octal.matches("^[0-7]+$");

    }

    /**
     * Valida si una cadena es un número hexadecimal
     *
     * @param hexadecimal String que contiene el valor a validar
     * @return True = es un número hexadecimal válido
     */
    public static boolean validaHexadecimal_Exp(String hexadecimal) {

        return hexadecimal.matches("^[0-9A-F]+$");

    }

    /**
     * Valida las posiciones donde se esperan letras, vocales y consonantes de los nombres y apellidos.
     * Fecha válida (aunque para simplificarlo, no se están validando meses con menos de 31 días).
     * Listado válido de entidades federativas.
     * Y genera referencias para separar los primeros 17 dígitos (grupo 1) del último dígito (grupo 2).
     *
     * @param CURP String que contiene el valor a validar
     * @return True = es un DNI válido
     */
    public static boolean validaCURP_Exp(String CURP) {

        return CURP.matches("^([A-Z][AEIOUX][A-Z]{2}\\d{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[12]\\d|3[01])[HM](?:AS|B[CS]|C[CLMSH]|D[FG]|G[TR]|HG|JC|M[CNS]|N[ETL]|OC|PL|Q[TR]|S[PLR]|T[CSL]|VZ|YN|ZS)[B-DF-HJ-NP-TV-Z]{3}[A-Z\\d])(\\d)$");

    }

    /**
     * Valida si una cadena tiene el formato de nombre de persona, incluyendo
     * nombres compuestos
     *
     * @param texto String que contiene el valor a validar
     * @return True = es un nombre válido
     */
    public static boolean validaNombre_Exp(String texto) {

        return texto.matches("^([A-Z]{1}[a-z]+[ ]?){1,2}$");
    }

    /**
     * Valida si una cadena es una matricula europea (&#60;2000)
     *
     * @param matricula String que contiene el valor a validar
     * @return True = es una matricula europea (&#60;2000)
     */
    public static boolean validarMatriculaEuropea_Exp(String matricula) {

        return matricula.matches("^[0-9]{4}[A-Z]{3}$");

    }

    /**
     * Valida si una cadena es un usuario de twitter
     *
     * @param usuario_twitter String que contiene el valor a validar
     * @return True = es un usuario de twitter
     */
    public static boolean validarUsuarioTwitter_Exp(String usuario_twitter) {

        return usuario_twitter.matches("^@([A-Za-z0-9_]{1,15})$");

    }

    /**
     * Valida si una cadena es un ISBN de 13 digitos
     *
     * @param ISBN String que contiene el valor a validar
     * @return True = es un usuario de twitter
     */
    public static boolean validarISBN13_Exp(String ISBN) {

        return ISBN.matches("^(978|979)[0-9]{9}$");

    }

    /**
     * Valida si una cadena tiene formato de telefono (10 Digitos)
     * @param texto
     * @return 
     */
    public static boolean validarTelefono_Exp(String texto) {
        return texto.matches("[0-9]{10}");
    }
    
    /**
     * Valida si una cadena tiene formato de Ticket (6+ Digitos)
     * @param texto
     * @return 
     */
    public static boolean validarTicket(String texto) {
        return texto.matches("[0-9]{6}+");
    }
}
