package com.rubaanxd.cifrado;

/**
 * Cifrado de Strings
 * Clase con metodos ppara cifrar y obtener checksums de strings
 * <p>
 *  
 * @author RubaanxD
 * @version 1.0
 * @since 2019 rubaanxd
 */
public class Cifrados {
    
    /**
     * Calcula el SHA1 de un String
     * @param original String original.
     * @return El checksum SHA1 del String
     */
    public static String StringToSHA1(String original){
        return org.apache.commons.codec.digest.DigestUtils.sha1Hex(original);
    }
    
}
