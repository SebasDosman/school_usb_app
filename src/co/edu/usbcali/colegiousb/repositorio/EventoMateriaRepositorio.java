/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usbcali.colegiousb.repositorio;

import co.edu.usbcali.colegiousb.archivos.Archivos;
import co.edu.usbcali.colegiousb.archivos.IArchivos;
import co.edu.usbcali.colegiousb.modelo.Actividad;
import co.edu.usbcali.colegiousb.modelo.EventoMateria;
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
public class EventoMateriaRepositorio implements IEventoMateriaRepositorio {
    private IArchivos archivos = new Archivos();
    private IEventoRepositorio eventoRepositorio = new EventoRepositorio();
    private IMateriaRepositorio materiaRepositorio = new MateriaRepositorio();
    private String localDir = System.getProperty("user.dir");
    private final String rutaArchivoEventoMateria = localDir + "\\eventoMateria.txt";
    
    @Override
    public void crearEventoMateria(EventoMateria eventoMateria) throws Exception {
        String lineaAAdicionar
                = eventoMateria.getEvento().getId().concat(",")
                        .concat(eventoMateria.getMateria().getId());
        try {
            archivos.crearArchivo(rutaArchivoEventoMateria);
            archivos.adicionarLineaFinal(rutaArchivoEventoMateria, lineaAAdicionar);
        } catch (Exception ex) {
            Logger.getLogger(EventoMateriaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public List<EventoMateria> visualizarEventoMateria() throws Exception {
        FileReader fileReader = new FileReader(rutaArchivoEventoMateria);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<EventoMateria> eventosMaterias = new ArrayList<EventoMateria>();
        
        try {
            String lineaLeida = "";
            EventoMateria eventoMateria;
            
            while((lineaLeida = bufferedReader.readLine()) != null) {
                String[] contenidoLinea = lineaLeida.split(",");
                eventosMaterias.add(new EventoMateria(eventoRepositorio.obtenerEventoPorId(contenidoLinea[0]), //Actividad
                                                    materiaRepositorio.obtenerMateriaPorId(contenidoLinea[1]))); //Materia
            }
            
        } catch (Exception e) {
            Logger.getLogger(ActividadRepositorio.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }
        
        return eventosMaterias;
    }
}
