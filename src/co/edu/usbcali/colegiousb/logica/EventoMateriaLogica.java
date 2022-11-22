/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usbcali.colegiousb.logica;

import co.edu.usbcali.colegiousb.modelo.EventoMateria;
import co.edu.usbcali.colegiousb.repositorio.EventoMateriaRepositorio;
import co.edu.usbcali.colegiousb.repositorio.IEventoMateriaRepositorio;
import java.util.List;
/**
 *
 * @author joseph
 */
public class EventoMateriaLogica implements IEventoMateriaLogica {
    private IEventoMateriaRepositorio eventoMateriaRepositorio = new EventoMateriaRepositorio();
    
    @Override
    public void crearEventoMateria(EventoMateria eventoMateria) throws Exception {
        if (eventoMateria == null) {
            throw new Exception("El objeto EventoMateria viene null");
        }
        if (eventoMateria.getEvento() == null) {
            throw new Exception("El objeto Evento viene null");
        }
        if (eventoMateria.getMateria() == null) {
            throw new Exception("El objeto Materia viene null");
        }
        
        eventoMateriaRepositorio.crearEventoMateria(eventoMateria);
    }

    @Override
    public List<EventoMateria> visualizarEventoMateria() throws Exception {
        return eventoMateriaRepositorio.visualizarEventoMateria();
    }
}
