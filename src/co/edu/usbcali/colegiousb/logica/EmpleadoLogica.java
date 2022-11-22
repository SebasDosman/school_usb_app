/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usbcali.colegiousb.logica;

import co.edu.usbcali.colegiousb.modelo.Empleado;
import co.edu.usbcali.colegiousb.repositorio.EmpleadoRepositorio;
import co.edu.usbcali.colegiousb.repositorio.IEmpleadoRepositorio;
import java.util.List;
/**
 *
 * @author joseph
 */
public class EmpleadoLogica implements IEmpleadoLogica { 
    private IEmpleadoRepositorio empleadoRepositorio = new EmpleadoRepositorio();
    
    @Override
    public void crearEmpleado(Empleado empleado) throws Exception {
        if(empleado == null) {
            throw new Exception("El objeto empleado viene null");
        }
        if(empleado.getId() == null || 
                empleado.getId().trim().equals("")) {
            throw new Exception("El id del empleado no puede ser nulo ni vacío");
        }
        if(empleado.getRol() == null || 
                empleado.getRol().trim().equals("")) {
            throw new Exception("El rol no puede ser nulo ni vacío");
        }
        if(empleado.getNombre() == null || 
                empleado.getNombre().trim().equals("")) {
            throw new Exception("El nombre no puede ser nulo ni vacío");
        }
        if(empleado.getEdad() == null || 
                empleado.getEdad().trim().equals("")) {
            throw new Exception("La edad no puede ser nula ni vacía");
        }
        if(empleado.getSexo() == null || 
                empleado.getSexo().trim().equals("")) {
            throw new Exception("El sexo no puede ser nulo ni vacío");
        }
        if(empleado.getSalario() == null || 
                empleado.getSalario().trim().equals("")) {
            throw new Exception("El salario no puede ser nulo ni vacío");
        }
        
        empleadoRepositorio.crearEmpleado(empleado);
    }

    @Override
    public List<Empleado> visualizarEmpleado() throws Exception {
        return empleadoRepositorio.visualizarEmpleado();
    }

    @Override
    public Empleado obtenerEmpleadoPorId(String id) throws Exception {
        if(id == null){
            throw new Exception("El Id no puede ser vacio");
        }
        
        return empleadoRepositorio.obtenerEmpleadoPorId(id);
    }

    @Override
    public boolean validarEmpleadoId(String id) throws Exception {
        if (empleadoRepositorio.validarEmpleadoId(id)) {
            return true;
        }
        
        return false;
    }
}
