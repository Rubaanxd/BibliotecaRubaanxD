package com.rubaanxd.swing;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Look And Feel (LAF)
 * Clase con el metodo necesario para cambiar el diseño de Swing segun el SO
 * <p>
 *  
 * @author RubaanxD
 * @version 1.0
 * @since 2019
 */
public class LAF {
    
    
     /**
     * Cambia el diseño del JFrame, segun el SO estemos
     */
    public static void disenoGUI(){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e){
            System.out.println("Error setting Java LAF: "+e);
        }
    }
    
}

