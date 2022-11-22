/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usbcali.colegiousb.logica;

import co.edu.usbcali.colegiousb.modelo.Estudiante;
import co.edu.usbcali.colegiousb.repositorio.EstudianteRepositorio;
import co.edu.usbcali.colegiousb.repositorio.IEstudianteRepositorio;
import java.util.List;
/**
 *
 * @author joseph
 */
public class EstudianteLogica implements IEstudianteLogica {
    private IEstudianteRepositorio estudianteRepositorio = new EstudianteRepositorio();

    @Override
    public void crearEstudiante(Estudiante estudiante) throws Exception {
        if (estudiante == null) {
            throw new Exception("El objeto estudiante viene null");
        }
        if (estudiante.getId() == null
                || estudiante.getId().trim().equals("")) {
            throw new Exception("El estudiante no puede estar nulo ni vacío");
        }
        if (estudiante.getNombre() == null
                || estudiante.getNombre().trim().equals("")) {
            throw new Exception("El nombre no puede ser nulo ni vacío");
        }
        if (estudiante.getEdad() == null
                || estudiante.getEdad().trim().equals("")) {
            throw new Exception("La edad no puede ser nulo ni vacío");
        }
        if (Integer.parseInt(estudiante.getEdad()) < 1 ) {
            throw new Exception("La edad no puede ser negativa");
        }
        if (estudiante.getSexo() == null
                || estudiante.getSexo().trim().equals("")) {
            throw new Exception("El sexo no puede ser nula ni vacía");
        }
        if (estudiante.getGrado() == null) {
            throw new Exception("El grado no puede ser nulo ni vacío");
        }
        if (estudiante.getUniforme() == null
                || estudiante.getUniforme().trim().equals("")) {
            throw new Exception("El uniforme no puede ser nulo ni vacío");
        }
        
        estudianteRepositorio.crearEstudiante(estudiante);
    }

    @Override
    public List<Estudiante> visualizarEstudiante() throws Exception {
        return estudianteRepositorio.visualizarEstudiante();
    }
    
    @Override
    public Estudiante obtenerEstudiantePorId(String id) throws Exception {
        if (id == null) {
            throw new Exception("El id no puede ser ser vacio");
        }
        
        return estudianteRepositorio.obtenerEstudiantePorId(id);
    }

    @Override
    public boolean validarEstudianteId(String id) throws Exception {
        if (estudianteRepositorio.validarEstudianteId(id)) {
            return true;
        }
        
        return false;
    }
}
