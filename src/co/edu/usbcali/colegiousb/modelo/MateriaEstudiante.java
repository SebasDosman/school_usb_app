/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usbcali.colegiousb.modelo;

/**
 *
 * @author FAVI
 */
public class MateriaEstudiante {
    private Materia materia;
    private Estudiante estudiante;

    public MateriaEstudiante(Materia materia, Estudiante estudiante) {
        this.materia = materia;
        this.estudiante = estudiante;
    }

    public MateriaEstudiante() {
    }
    
    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
    @Override
    public String toString() {
        return "MateriaEstudiante{" + "materia=" + materia + ", estudiante=" + estudiante + '}';
    }
}
