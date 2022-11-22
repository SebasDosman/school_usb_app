/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usbcali.colegiousb.modelo;
/**
 *
 * @author joseph
 */
public class Materia {
    private String id;
    private String nombre;
    private Empleado docente;
    private String contenido;
    private Grado grado;
    private String horario;
    
    public Materia(String id, String nombre, Empleado docente, String contenido, Grado grado, String horario) {
        this.id = id;
        this.nombre = nombre;
        this.docente = docente;
        this.contenido = contenido;
        this.grado = grado;
        this.horario = horario;
    }

    public Materia() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Empleado getDocente() {
        return docente;
    }

    public void setDocente(Empleado docente) {
        this.docente = docente;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Materia{" + "nombre=" + nombre + ", docente=" + docente + ", contenido=" + contenido + ", grado=" + grado + ", horario=" + horario + '}';
    }
}
