/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usbcali.colegiousb.modelo;

/**
 *
 * @author FAVI
 */
public class EventoMateria {
    private Evento evento;
    private Materia materia;

    public EventoMateria(Evento evento, Materia materia) {
        this.evento = evento;
        this.materia = materia;
    }

    public EventoMateria() {
    }
    
    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "EventoMateria{" + "evento=" + evento + ", materia=" + materia + '}';
    }
}
