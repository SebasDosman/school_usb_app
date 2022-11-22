/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usbcali.colegiousb.repositorio;

import co.edu.usbcali.colegiousb.modelo.Empleado;
import co.edu.usbcali.colegiousb.modelo.Grado;
import co.edu.usbcali.colegiousb.modelo.Materia;
import java.util.List;
/**
 *
 * @author joseph
 */
public interface IMateriaRepositorio {
    public void crearMateria(Materia materia) throws Exception;
    public List<Materia> visualizarMateria() throws Exception;
    public Materia obtenerMateriaPorId(String id) throws Exception;
    public boolean validarMateriaId(String id) throws Exception;
    public boolean validarDocenteMateria(String id) throws Exception;
}
