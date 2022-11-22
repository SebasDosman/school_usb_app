/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usbcali.colegiousb.repositorio;

import co.edu.usbcali.colegiousb.modelo.Grado;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FAVI
 */
public class GradoRepositorio implements IGradoRepositorio {
    private String localDir = System.getProperty("user.dir");
    private final String rutaArchivoGrado = localDir + "\\grado.txt";

    @Override
    public Grado obtenerGradoPorId(int id) throws Exception {
        Grado grado = null;
        FileReader fileReader = new FileReader(rutaArchivoGrado);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        try {
            String lineaLeida = "";
            String[] contenidoLinea;

            while ((lineaLeida = bufferedReader.readLine()) != null) {
                contenidoLinea = lineaLeida.split(",");
                if(contenidoLinea[0].trim().equals(id+"")) {
                    grado = new Grado(Integer.parseInt(contenidoLinea[0]), 
                            contenidoLinea[1]);
                }
            }

        } catch (Exception e) {
            Logger.getLogger(EstudianteRepositorio.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            bufferedReader.close();
            fileReader.close();
        }
        return grado;
    }
}
