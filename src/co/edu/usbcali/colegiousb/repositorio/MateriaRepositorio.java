/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usbcali.colegiousb.repositorio;

import co.edu.usbcali.colegiousb.archivos.Archivos;
import co.edu.usbcali.colegiousb.archivos.IArchivos;
import co.edu.usbcali.colegiousb.modelo.Empleado;
import co.edu.usbcali.colegiousb.modelo.Materia;
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
public class MateriaRepositorio implements IMateriaRepositorio {
    private IArchivos archivos = new Archivos();
    private IGradoRepositorio gradoRepositorio = new GradoRepositorio();
    private IEmpleadoRepositorio empleadoRepositorio = new EmpleadoRepositorio();
    private String localDir = System.getProperty("user.dir");
    private final String rutaArchivoMateria = localDir + "\\materia.txt";
    private final String rutaArchivoEmpleado = localDir + "\\empleado.txt";
    
    @Override
    public void crearMateria(Materia materia) throws Exception {
        String lineaAAdicionar
                = materia.getId().concat(",")
                        .concat(materia.getNombre()).concat(",")
                        .concat(materia.getDocente().getId()).concat(",")
                        .concat(materia.getContenido()).concat(",")
                        .concat("" + materia.getGrado().getId()).concat(",")
                        .concat(materia.getHorario());
        try {
            archivos.crearArchivo(rutaArchivoMateria);
            archivos.adicionarLineaFinal(rutaArchivoMateria, lineaAAdicionar);
        } catch (Exception ex) {
            Logger.getLogger(MateriaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public List<Materia> visualizarMateria() throws Exception {
        FileReader fileReader = new FileReader(rutaArchivoMateria);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Materia> materias = new ArrayList<Materia>();
        
        try {
            String lineaLeida = "";
            String[] contenidoLinea;
            
            while((lineaLeida = bufferedReader.readLine()) != null) {
                contenidoLinea = lineaLeida.split(",");
                materias.add(new Materia(contenidoLinea[0], //Id
                                         contenidoLinea[1], //Nombre
                                         empleadoRepositorio.obtenerEmpleadoPorId(contenidoLinea[2]), //Docente
                                         contenidoLinea[3],
                                         gradoRepositorio.obtenerGradoPorId(Integer.parseInt(contenidoLinea[4])), //Nombre, //Grado
                                         contenidoLinea[5])); //Uniforme
            }
        } catch (Exception e) {
            Logger.getLogger(MateriaRepositorio.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            bufferedReader.close();
            fileReader.close();
        }
        
        return materias;
    }
    
    @Override
    public Materia obtenerMateriaPorId(String id) throws Exception {
        Materia materia = null;
        FileReader fileReader = new FileReader(rutaArchivoMateria);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        try {
            String lineaLeida = "";
            String[] contenidoLinea;

            while ((lineaLeida = bufferedReader.readLine()) != null) {
                contenidoLinea = lineaLeida.split(",");
                if(contenidoLinea[0].trim().equals(id+"")) {
                    materia = new Materia(contenidoLinea[0],
                            contenidoLinea[1],
                            empleadoRepositorio.obtenerEmpleadoPorId(contenidoLinea[2]),
                            contenidoLinea[3],
                            gradoRepositorio.obtenerGradoPorId(Integer.parseInt(contenidoLinea[4])),
                            contenidoLinea[5]);
                }
            }
        } catch (Exception e) {
            Logger.getLogger(MateriaRepositorio.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            bufferedReader.close();
            fileReader.close();
        }
        
        return materia;
    }

    @Override
    public boolean validarMateriaId(String id) throws Exception {
        FileReader fileReader = new FileReader(rutaArchivoMateria);
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
            Logger.getLogger(MateriaRepositorio.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            bufferedReader.close();
            fileReader.close();
        }
        
        return false;
    }

    @Override
    public boolean validarDocenteMateria(String id) throws Exception {
        try {
            Empleado empleado = empleadoRepositorio.obtenerEmpleadoPorId(id);
            
            if (empleado.getRol().equals("Profesor")) {
                return true;
            }
        } catch (Exception e) {
            Logger.getLogger(MateriaRepositorio.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }
        
        return false;
    }
}
