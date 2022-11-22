/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usbcali.colegiousb.repositorio;

import co.edu.usbcali.colegiousb.modelo.Grado;

/**
 *
 * @author FAVI
 */
public interface IGradoRepositorio {
    public Grado obtenerGradoPorId(int id) throws Exception;
}
