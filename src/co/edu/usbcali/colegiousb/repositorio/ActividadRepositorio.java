/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usbcali.colegiousb.repositorio;

import co.edu.usbcali.colegiousb.archivos.Archivos;
import co.edu.usbcali.colegiousb.archivos.IArchivos;
import co.edu.usbcali.colegiousb.modelo.Actividad;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author joseph
 */
public class ActividadRepositorio implements IActividadRepositorio {
    private IArchivos archivos = new Archivos();
    private IMateriaRepositorio materiaRepositorio = new MateriaRepositorio();
    private String localDir = System.getProperty("user.dir");
    private final String rutaArchivoActividades = localDir + "\\actividad.txt";
    
    @Override
    public void crearActividad(Actividad actividad) throws Exception {
        String lineaAAdicionar
                = actividad.getId().concat(",")
                        .concat(actividad.getActividad().concat(","))
                        .concat(actividad.getFecha().concat(",")
                        .concat(actividad.getMateria().getId()));
        try {
            archivos.crearArchivo(rutaArchivoActividades);
            archivos.adicionarLineaFinal(rutaArchivoActividades, lineaAAdicionar);
        } catch (Exception ex) {
            Logger.getLogger(ActividadRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public List<Actividad> visualizarActividad() throws Exception {
        FileReader fileReader = new FileReader(rutaArchivoActividades);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Actividad> actividades = new ArrayList<Actividad>();
        
        try {
            String lineaLeida = "";
            Actividad actividad;
            
            while((lineaLeida = bufferedReader.readLine()) != null) {
                String[] contenidoLinea = lineaLeida.split(",");
                actividades.add(new Actividad(contenidoLinea[0], //Actividad
                                            contenidoLinea[1],
                                            contenidoLinea[2],
                                            materiaRepositorio.obtenerMateriaPorId(contenidoLinea[3]))); //Materia
            }
        } catch (Exception e) {
            Logger.getLogger(ActividadRepositorio.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }
        
        return actividades;
    }

    @Override
    public boolean validarActividadId(String id) throws Exception {
        FileReader fileReader = new FileReader(rutaArchivoActividades);
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
            Logger.getLogger(ActividadRepositorio.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            bufferedReader.close();
            fileReader.close();
        }
        
        return false;
    }

    @Override
    public boolean validarActividadFecha(String fecha) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(new Date());
        
        Date fechaActual = (Date) dateFormat.parse(date);
        Date fechaConvertida = (Date) dateFormat.parse(fecha);
        
        return fechaActual.after(fechaConvertida);
    }
}
