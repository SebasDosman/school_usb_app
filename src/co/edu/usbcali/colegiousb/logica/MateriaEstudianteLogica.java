/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usbcali.colegiousb.logica;

import co.edu.usbcali.colegiousb.modelo.MateriaEstudiante;
import co.edu.usbcali.colegiousb.repositorio.IMateriaEstudianteRepositorio;
import co.edu.usbcali.colegiousb.repositorio.MateriaEstudianteRepositorio;
import java.util.List;
/**
 *
 * @author joseph
 */
public class MateriaEstudianteLogica implements IMateriaEstudianteLogica {
    private IMateriaEstudianteRepositorio materiaEstudianteRepositorio = new MateriaEstudianteRepositorio();
    
    @Override
    public void crearMateriaEstudiante(MateriaEstudiante materiaEstudiante) throws Exception {
        if(materiaEstudiante == null) {
            throw new Exception("El objeto materiaEstudiante viene null");
        }
        if(materiaEstudiante.getMateria() == null){
            throw new Exception("El objeto materia viene null");
        }
        if(materiaEstudiante.getEstudiante() == null) {
            throw new Exception("El objeto estudiante viene null");
        }
        
        materiaEstudianteRepositorio.crearMateriaEstudiante(materiaEstudiante);
    }

    @Override
    public List<MateriaEstudiante> visualizarMateriaEstudiante() throws Exception {
        return materiaEstudianteRepositorio.visualizarMateriaEstudiante();
    }
}
