/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usbcali.colegiousb.logica;

import co.edu.usbcali.colegiousb.modelo.Materia;
import co.edu.usbcali.colegiousb.repositorio.IMateriaRepositorio;
import co.edu.usbcali.colegiousb.repositorio.MateriaRepositorio;
import java.util.List;

/**
 *
 * @author joseph
 */
public class MateriaLogica implements IMateriaLogica {
    private IMateriaRepositorio materiaRepositorio = new MateriaRepositorio();
    
    @Override
    public void crearMateria(Materia materia) throws Exception {
        if (materia == null) {
            throw new Exception("El objeto materia viene null");
        }
        if (materia.getId() == null || 
                materia.getId().trim().equals("")) {
            throw new Exception("El id de la materia no puede ser nulo ni vacío");
        }
        if (materia.getNombre() == null || 
                materia.getNombre().trim().equals("")) {
            throw new Exception("El nombre de la materia no puede ser nulo ni vacío");
        }
        if (materia.getDocente() == null) {
            throw new Exception("El docente de la materia no puede ser nulo");
        }
        if (materia.getContenido()== null || 
                materia.getContenido().trim().equals("")) {
            throw new Exception("El contenido de la materia no puede ser nulo ni vacío");
        } 
        if (materia.getGrado() == null) {
            throw new Exception("El grado de la materia no puede ser nulo");
        }
        if (materia.getHorario() == null || 
                materia.getContenido().trim().equals("")) {
            throw new Exception("El horario de la materia no puede ser nulo ni vacío");
        }
        
        materiaRepositorio.crearMateria(materia);
    }

    @Override
    public List<Materia> visualizarMateria() throws Exception {
        return materiaRepositorio.visualizarMateria();
    }
    
    @Override
    public Materia obtenerMateriaPorId(String id) throws Exception {
        if (id == null) {
            throw new Exception("El id no puede ser vacio");
        }
        
        return materiaRepositorio.obtenerMateriaPorId(id);
    }

    @Override
    public boolean validarMateriaId(String id) throws Exception {
        if (materiaRepositorio.validarMateriaId(id)) {
            return true;
        }
        
        return false;
    }

    @Override
    public boolean validarDocenteMateria(String id) throws Exception {
        if (materiaRepositorio.validarDocenteMateria(id)) {
            return true;
        }
        
        return false;
    }
}
