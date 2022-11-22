/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usbcali.colegiousb.logica;

import co.edu.usbcali.colegiousb.modelo.Evento;
import co.edu.usbcali.colegiousb.repositorio.EventoRepositorio;
import co.edu.usbcali.colegiousb.repositorio.IEventoRepositorio;
import java.util.List;
/**
 *
 * @author joseph
 */
public class EventoLogica implements IEventoLogica {
    private IEventoRepositorio eventoRepositorio = new EventoRepositorio();
    
    @Override
    public void crearEvento(Evento evento) throws Exception {
        if (evento == null) {
            throw new Exception("El objeto evento viene null");
        }
        if (evento.getId() == null || 
                evento.getId().trim().equals("")) {
            throw new Exception("El id del evento no puede ser nulo ni vacío");
        }
        if (evento.getEvento() == null || 
                evento.getEvento().trim().equals("")) {
            throw new Exception("El evento no puede ser nulo ni vacío");
        } 
        if (evento.getUbicacion()== null || 
                evento.getUbicacion().trim().equals("")) {
            throw new Exception("La ubicación del evento no puede ser nula ni vacía");
        }
        if (evento.getDuracion()== null || 
                evento.getDuracion().trim().equals("")) {
            throw new Exception("La duración del evento no puede ser nula ni vacía");
        }
        
        eventoRepositorio.crearEvento(evento);
    }

    @Override
    public List<Evento> visualizarEvento() throws Exception {
        return eventoRepositorio.visualizarEvento();
    }
        
    @Override
    public Evento obtenerEventoPorId(String id) throws Exception {
        if (id == null) {
            throw new Exception("El id no puede ser vacio");
        }

        return eventoRepositorio.obtenerEventoPorId(id);
    }

    @Override
    public boolean validarEventoId(String id) throws Exception {
        if (eventoRepositorio.validarEventoId(id)) {
            return true;
        }
        
        return false;
    }
}
