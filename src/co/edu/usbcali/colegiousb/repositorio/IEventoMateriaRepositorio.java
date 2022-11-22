/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usbcali.colegiousb.repositorio;

import co.edu.usbcali.colegiousb.modelo.EventoMateria;
import java.util.List;
/**
 *
 * @author joseph
 */
public interface IEventoMateriaRepositorio {
    public void crearEventoMateria(EventoMateria eventoMateria) throws Exception;
    public List<EventoMateria> visualizarEventoMateria() throws Exception;
}
