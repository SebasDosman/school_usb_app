/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usbcali.colegiousb.repositorio;

import co.edu.usbcali.colegiousb.modelo.Empleado;
import java.util.List;
/**
 *
 * @author joseph
 */
public interface IEmpleadoRepositorio {
    public void crearEmpleado(Empleado empleado) throws Exception;
    public List<Empleado> visualizarEmpleado() throws Exception;
    public Empleado obtenerEmpleadoPorId(String id) throws Exception;
    public boolean validarEmpleadoId(String id) throws Exception;
}
