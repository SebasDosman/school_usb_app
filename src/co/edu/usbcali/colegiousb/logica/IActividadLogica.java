/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usbcali.colegiousb.logica;

import co.edu.usbcali.colegiousb.modelo.Actividad;
import java.util.List;
/**
 *
 * @author joseph
 */
public interface IActividadLogica {
    public void crearActividad(Actividad actividad) throws Exception;
    public List<Actividad> visualizarActividad() throws Exception;
    public boolean validarActividadId(String id) throws Exception;
    public boolean validarActividadFecha(String fecha) throws Exception;
}
