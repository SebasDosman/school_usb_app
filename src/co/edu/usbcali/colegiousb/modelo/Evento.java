/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usbcali.colegiousb.modelo;
/**
 *
 * @author joseph
 */
public class Evento {
    private String id;
    private String evento;   
    private String ubicacion;
    private String duracion;

    public Evento(String id, String evento, String ubicacion, String duracion) {
        this.id = id;
        this.evento = evento;
        this.ubicacion = ubicacion;
        this.duracion = duracion;
    }

    public Evento() {
    }
    
    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Evento{" + "evento=" + evento + ", ubicacion=" + ubicacion + ", duracion=" + duracion + '}';
    }
}
