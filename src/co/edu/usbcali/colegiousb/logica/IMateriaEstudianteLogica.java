/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usbcali.colegiousb.logica;

import co.edu.usbcali.colegiousb.modelo.MateriaEstudiante;
import java.util.List;
/**
 *
 * @author joseph
 */
public interface IMateriaEstudianteLogica {
    public void crearMateriaEstudiante(MateriaEstudiante materiaEstudiante) throws Exception;
    public List<MateriaEstudiante> visualizarMateriaEstudiante() throws Exception;
}
