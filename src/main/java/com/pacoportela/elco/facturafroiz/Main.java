package com.pacoportela.elco.facturafroiz;

/**
 *Clase que arranca la ejecuci�n del proyecto.
 * @author Paco Portela Henche. Marzo 2022.
 */
public class Main {

    /**
     * @param args los argumentos pasados en la linea de comandos.
     */
    public static void main(String[] args) {
        Interfaz ventana = new Interfaz();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
    
}
