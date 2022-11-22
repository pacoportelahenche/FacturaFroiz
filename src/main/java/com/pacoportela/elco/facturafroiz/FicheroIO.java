package com.pacoportela.elco.facturafroiz;

/* Esta clase nos ofrece la utilidad de escribir un string en un fichero Ã³ de
  recuperar un string de un fichero*/


import java.io.*;

/**
 * 
 * @author Paco
 */
public class FicheroIO {

  /**
   * Constructor sin parÃ¡metros.
   */
  public FicheroIO(){}

  /**
   * Metodo que nos permite recuperar un String de un fichero.
   * @param fichero El fichero del que recuperaremos los datos.
   * @return Un String con el contenido del fichero (que se supone texto).
   */
  public String ficheroAString(File fichero){
    StringBuilder buffer = new StringBuilder();
    String line;
    FileReader fReader;
    BufferedReader bReader;
    try {
      fReader = new FileReader(fichero);
      bReader = new BufferedReader(fReader);
      while ((line = bReader.readLine()) != null){
        buffer.append(line).append("\n");
      }
      bReader.close();
      fReader.close();
    } catch (FileNotFoundException e) {
    } catch (IOException e) {
    } return buffer.toString();
  }

  /**
   * Metodo que nos permite escribir un String en un fichero.
   * @param string El String que grabaremos en el fichero.
   * @param fichero El fichero en el que guardaremos los datos.
   * @param append Si es 'true' aÃ±adiremos el String al final del fichero,
   * a continuaciÃ³n de lo que ya estuviese grabado. Si es 'false' regrabaremos
   * el fichero y se perderÃ¡ toda la informaciÃ³n que contuviese.
   */
  public void stringAFichero(String string, File fichero, boolean append){
    FileWriter fWriter;
    BufferedWriter bWriter; try {
      fWriter = new FileWriter(fichero, append);
      bWriter = new BufferedWriter(fWriter);
      bWriter.write(string);
      bWriter.close();
      fWriter.close();
    } catch (IOException e) {
    }
  }
}