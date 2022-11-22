/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usbcali.colegiousb.logica;

import co.edu.usbcali.colegiousb.modelo.Estudiante;
import java.util.List;
/**
 *
 * @author joseph
 */
public interface IEstudianteLogica {
    public void crearEstudiante(Estudiante estudiante) throws Exception;
    public List<Estudiante> visualizarEstudiante() throws Exception;
    public Estudiante obtenerEstudiantePorId(String id) throws Exception;
    public boolean validarEstudianteId(String id) throws Exception;
}
