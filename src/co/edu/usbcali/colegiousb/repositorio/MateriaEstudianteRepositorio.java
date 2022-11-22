/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usbcali.colegiousb.repositorio;

import co.edu.usbcali.colegiousb.archivos.Archivos;
import co.edu.usbcali.colegiousb.archivos.IArchivos;
import co.edu.usbcali.colegiousb.modelo.MateriaEstudiante;
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
public class MateriaEstudianteRepositorio implements IMateriaEstudianteRepositorio {
    private IArchivos archivos = new Archivos();
    private IMateriaRepositorio materiaRepositorio = new MateriaRepositorio();
    private IEstudianteRepositorio estudianteRepositorio = new EstudianteRepositorio();
    private String localDir = System.getProperty("user.dir");
    private final String rutaArchivoMateriaEstudiante = localDir + "\\materiaEstudiante.txt";
    
    @Override
    public void crearMateriaEstudiante(MateriaEstudiante materiaEstudiante) throws Exception {
        String lineaAAdicionar
                = materiaEstudiante.getMateria().getId().concat(",")
                        .concat(materiaEstudiante.getEstudiante().getId());
        try {
            archivos.crearArchivo(rutaArchivoMateriaEstudiante);
            archivos.adicionarLineaFinal(rutaArchivoMateriaEstudiante, lineaAAdicionar);
        } catch (Exception ex) {
            Logger.getLogger(MateriaEstudianteRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public List<MateriaEstudiante> visualizarMateriaEstudiante() throws Exception {
        FileReader fileReader = new FileReader(rutaArchivoMateriaEstudiante);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<MateriaEstudiante> materiasEstudiantes = new ArrayList<MateriaEstudiante>();
        
        try {
            String lineaLeida = "";
            String[] contenidoLinea;
            
            while((lineaLeida = bufferedReader.readLine()) != null) {
                contenidoLinea = lineaLeida.split(",");
                materiasEstudiantes.add(new MateriaEstudiante(materiaRepositorio.obtenerMateriaPorId(contenidoLinea[0]), //Id
                                                estudianteRepositorio.obtenerEstudiantePorId(contenidoLinea[1]))); //Uniforme
            }
            
        } catch (Exception e) {
            Logger.getLogger(MateriaEstudianteRepositorio.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            bufferedReader.close();
            fileReader.close();
        }
        return materiasEstudiantes;
    }
}

