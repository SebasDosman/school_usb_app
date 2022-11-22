/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usbcali.colegiousb.repositorio;

import co.edu.usbcali.colegiousb.archivos.Archivos;
import co.edu.usbcali.colegiousb.archivos.IArchivos;
import co.edu.usbcali.colegiousb.modelo.Evento;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author joseph
 */
public class EventoRepositorio implements IEventoRepositorio {
    private IArchivos archivos = new Archivos();
    private String localDir = System.getProperty("user.dir");
    private final String rutaArchivoEvento = localDir + "\\evento.txt";
    
    @Override
    public void crearEvento(Evento evento) throws Exception {
        String lineaAAdicionar
                = evento.getId().concat(",")
                        .concat(evento.getEvento()).concat(",")
                        .concat(evento.getUbicacion().concat(",")
                        .concat(evento.getDuracion()));   
        try {
            archivos.crearArchivo(rutaArchivoEvento);
            archivos.adicionarLineaFinal(rutaArchivoEvento, lineaAAdicionar);
        } catch (Exception ex) {
            Logger.getLogger(EventoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    @Override
    public List<Evento> visualizarEvento() throws Exception {
        FileReader fileReader = new FileReader(rutaArchivoEvento);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Evento> eventos = new ArrayList<Evento>();
        
        try {
            String lineaLeida = "";
            String[] contenidoLinea;
            
            while((lineaLeida = bufferedReader.readLine()) != null) {
                contenidoLinea = lineaLeida.split(",");
                eventos.add(new Evento(contenidoLinea[0], //Actividad
                                        contenidoLinea[1], //Fecha
                                        contenidoLinea[2],
                                        contenidoLinea[3])); //Materia
            }
        } catch (Exception e) {
            Logger.getLogger(EventoRepositorio.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }
        
        return eventos;
    }
    
    @Override
    public Evento obtenerEventoPorId(String id) throws Exception {
        Evento evento = null;
        FileReader fileReader = new FileReader(rutaArchivoEvento);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        try {
            String lineaLeida = "";
            String[] contenidoLinea;

            while ((lineaLeida = bufferedReader.readLine()) != null) {
                contenidoLinea = lineaLeida.split(",");
                if(contenidoLinea[0].trim().equals(id)) {
                    evento = new Evento(contenidoLinea[0],
                                        contenidoLinea[1],
                                        contenidoLinea[2],
                                        contenidoLinea[3]);
                }
            }
        } catch (Exception e) {
            Logger.getLogger(EventoRepositorio.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            bufferedReader.close();
            fileReader.close();
        }
        
        return evento;
    }

    @Override
    public boolean validarEventoId(String id) throws Exception {
        FileReader fileReader = new FileReader(rutaArchivoEvento);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        try {
            String lineaLeida = "";
            String[] contenidoLinea;

            while ((lineaLeida = bufferedReader.readLine()) != null) {
                contenidoLinea = lineaLeida.split(",");
                if(contenidoLinea[0].trim().equals(id)) {
                    return true;
                }
            }
        } catch (Exception e) {
            Logger.getLogger(EventoRepositorio.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            bufferedReader.close();
            fileReader.close();
        }
        
        return false;
    }
}
