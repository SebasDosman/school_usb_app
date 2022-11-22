/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usbcali.colegiousb.logica;

import co.edu.usbcali.colegiousb.modelo.Actividad;
import co.edu.usbcali.colegiousb.repositorio.ActividadRepositorio;
import co.edu.usbcali.colegiousb.repositorio.IActividadRepositorio;
import java.util.List;
/**
 *
 * @author joseph
 */
public class ActividadLogica implements IActividadLogica {
    private IActividadRepositorio actividadRepositorio = new ActividadRepositorio();
    
    @Override
    public void crearActividad(Actividad actividad) throws Exception {
        if(actividad == null) {
            throw new Exception("El objeto actividad viene null");
        }
        
        if(actividad.getId() == null || 
                actividad.getActividad().trim().equals("")) {
            throw new Exception("El id de la actividad no puede estar nula ni vacía");
        }
        
        if(actividad.getActividad() == null || 
                actividad.getActividad().trim().equals("")) {
            throw new Exception("La actividad no puede estar nula ni vacía");
        }
        
        if(actividad.getFecha() == null || 
                actividad.getFecha().trim().equals("")) {
            throw new Exception("La Fecha de la actividad no puede ser nula ni vacía");
        }
        
        actividadRepositorio.crearActividad(actividad);
    }

    @Override
    public List<Actividad> visualizarActividad() throws Exception {
        return actividadRepositorio.visualizarActividad();
    }

    @Override
    public boolean validarActividadId(String id) throws Exception {
        if (actividadRepositorio.validarActividadId(id)) {
            return true;
        }
        
        return false;
    }

    @Override
    public boolean validarActividadFecha(String fecha) throws Exception {
        if (actividadRepositorio.validarActividadFecha(fecha)) {
            return true;
        }
        
        return false;
    }
}
