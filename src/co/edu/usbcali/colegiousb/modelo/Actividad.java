/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usbcali.colegiousb.modelo;
/**
 *
 * @author joseph
 */
public class Actividad {
    private String id;
    private String actividad;
    private String fecha;
    private Materia materia;

    public Actividad(String id, String actividad, String fecha, Materia materia) {
        this.id = id;
        this.actividad = actividad;
        this.fecha = fecha;
        this.materia = materia;
    }

    public Actividad() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Actividad{" + "id=" + id + ", actividad=" + actividad + ", fecha=" + fecha + ", materia=" + materia + '}';
    }
}
