/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usbcali.colegiousb.logica;

import co.edu.usbcali.colegiousb.modelo.Evento;
import java.util.List;
/**
 *
 * @author joseph
 */
public interface IEventoLogica {
    public void crearEvento(Evento evento) throws Exception;
    public List<Evento> visualizarEvento() throws Exception;
    public Evento obtenerEventoPorId(String id) throws Exception;
    public boolean validarEventoId(String id) throws Exception;
}
