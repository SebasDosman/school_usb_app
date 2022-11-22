/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usbcali.colegiousb.repositorio;

import co.edu.usbcali.colegiousb.modelo.MateriaEstudiante;
import java.util.List;
/**
 *
 * @author joseph
 */
public interface IMateriaEstudianteRepositorio {
    public void crearMateriaEstudiante(MateriaEstudiante materiaEstudiante) throws Exception;
    public List<MateriaEstudiante> visualizarMateriaEstudiante() throws Exception;
}
