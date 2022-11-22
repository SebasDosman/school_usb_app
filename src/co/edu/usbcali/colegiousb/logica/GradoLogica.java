/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usbcali.colegiousb.logica;

import co.edu.usbcali.colegiousb.modelo.Grado;
import co.edu.usbcali.colegiousb.repositorio.GradoRepositorio;
import co.edu.usbcali.colegiousb.repositorio.IGradoRepositorio;

/**
 *
 * @author Usuario
 */
public class GradoLogica implements IGradoLogica {
    private IGradoRepositorio gradoRepositorio = new GradoRepositorio();
    
    @Override
    public Grado obtenerGradoPorId(int id) throws Exception {
        if (id < 1 || id > 11) {
            throw new Exception("El id no puede ser menor a 1 y mayor a 11");
        }
        
        return gradoRepositorio.obtenerGradoPorId(id);
    }
}
