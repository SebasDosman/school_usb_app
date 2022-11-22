/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usbcali.colegiousb.repositorio;

import co.edu.usbcali.colegiousb.archivos.Archivos;
import co.edu.usbcali.colegiousb.archivos.IArchivos;
import co.edu.usbcali.colegiousb.modelo.Estudiante;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author joseph
 */
public class EstudianteRepositorio implements IEstudianteRepositorio {
    private IArchivos archivos = new Archivos();
    private IGradoRepositorio gradoRepositorio = new GradoRepositorio();
    private String localDir = System.getProperty("user.dir");
    private final String rutaArchivoEstudiante = localDir + "\\estudiante.txt";
    
    @Override
    public void crearEstudiante(Estudiante estudiante) throws Exception {
        String lineaAAdicionar
                = estudiante.getId().concat(",")
                        .concat(estudiante.getNombre()).concat(",")
                        .concat(estudiante.getEdad()).concat(",")
                        .concat(estudiante.getSexo()).concat(",")
                        .concat(""+estudiante.getGrado().getId()).concat(",")
                        .concat(estudiante.getUniforme());
        try {
            archivos.crearArchivo(rutaArchivoEstudiante);
            archivos.adicionarLineaFinal(rutaArchivoEstudiante, lineaAAdicionar);
        } catch (Exception ex) {
            Logger.getLogger(EstudianteRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public List<Estudiante> visualizarEstudiante() throws Exception {
        FileReader fileReader = new FileReader(rutaArchivoEstudiante);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Estudiante> estudiantes = new ArrayList<Estudiante>();
        
        try {
            String lineaLeida = "";
            String[] contenidoLinea;
            
            while((lineaLeida = bufferedReader.readLine()) != null) {
                contenidoLinea = lineaLeida.split(",");
                estudiantes.add(new Estudiante(contenidoLinea[0], //Id
                                                contenidoLinea[1], //Nombre
                                                contenidoLinea[2], //Edad
                                                contenidoLinea[3], //Sexo
                                                gradoRepositorio.obtenerGradoPorId(Integer.parseInt(contenidoLinea[4])), //Grado
                                                contenidoLinea[5])); //Uniforme
            }
        } catch (Exception e) {
            Logger.getLogger(EstudianteRepositorio.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            bufferedReader.close();
            fileReader.close();
        }
        
        return estudiantes;
    }
    
    @Override
    public Estudiante obtenerEstudiantePorId(String id) throws Exception {
        Estudiante estudiante = null;
        FileReader fileReader = new FileReader(rutaArchivoEstudiante);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        try {
            String lineaLeida = "";
            String[] contenidoLinea;

            while ((lineaLeida = bufferedReader.readLine()) != null) {
                contenidoLinea = lineaLeida.split(",");
                if(contenidoLinea[0].trim().equals(id+"")) {
                    estudiante = new Estudiante(contenidoLinea[0],
                                                contenidoLinea[1],
                                                contenidoLinea[2],
                                                contenidoLinea[3],
                                                gradoRepositorio.obtenerGradoPorId(Integer.parseInt(contenidoLinea[4])),
                                                contenidoLinea[5]);
                }
            }
        } catch (Exception e) {
            Logger.getLogger(EstudianteRepositorio.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            bufferedReader.close();
            fileReader.close();
        }
        
        return estudiante;
    }

    @Override
    public boolean validarEstudianteId(String id) throws Exception {
        FileReader fileReader = new FileReader(rutaArchivoEstudiante);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        try {
            String lineaLeida = "";
            String[] contenidoLinea;

            while ((lineaLeida = bufferedReader.readLine()) != null) {
                contenidoLinea = lineaLeida.split(",");
                if(contenidoLinea[0].trim().equals(id)) {
                    return true;
                }
            }
        } catch (Exception e) {
            Logger.getLogger(EstudianteRepositorio.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            bufferedReader.close();
            fileReader.close();
        }
        
        return false;
    }
}
