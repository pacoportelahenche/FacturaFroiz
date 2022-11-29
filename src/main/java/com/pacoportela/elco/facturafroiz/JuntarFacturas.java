/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pacoportela.elco.facturafroiz;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Paco Poetela Henche
 * @date 28-nov-2022
 * El objeto de esta clase es obtener los datos de dos � m�s ficheros de texto
 * para juntar todos los datos ordenados en otro fichero.
 */

public class JuntarFacturas {
    Interfaz interfaz;
    
    public JuntarFacturas(Interfaz interfaz){
        this.interfaz = interfaz;
        try {
            juntarYOrdenar(obtenerFicheros());
        } catch (IOException ex) {
            Logger.getLogger(JuntarFacturas.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    
    private  File[] obtenerFicheros(){
        File[] ficheros = null;
        JFileChooser buscador = 
                new JFileChooser("C:/Users/PACO/Desktop/tessdata/Ordenadas");
        buscador.setMultiSelectionEnabled(true);
        if (buscador.showOpenDialog(interfaz.getContentPane())
                == JFileChooser.APPROVE_OPTION) {
            ficheros = buscador.getSelectedFiles();
        }
        return ficheros;
    }
    
    private void juntarYOrdenar(File[] ficheros) throws IOException{
        List<Path> listaPaths = new ArrayList();
        List<String> listaLineas = new ArrayList();
        List<String> listaTotal = new ArrayList();
        for(int i = 0; i < ficheros.length; i++){
            listaPaths.add(ficheros[i].toPath());
        }
        ListIterator ite = listaPaths.listIterator();
        while(ite.hasNext()){
            listaLineas = (Files.readAllLines((Path)ite.next(),
                    Charset.forName("ISO_8859_1")));
            listaTotal.addAll(listaLineas);
        }
        Collections.sort(listaTotal);
        ite = listaTotal.listIterator();
        while(ite.hasNext()){
            System.out.println(ite.next().toString());
        }
        Files.write(Paths.get("FacturaUnida"), listaTotal,
                Charset.forName("ISO_8859_1"),
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }
}