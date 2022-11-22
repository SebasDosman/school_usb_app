/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usbcali.colegiousb.repositorio;

import co.edu.usbcali.colegiousb.archivos.Archivos;
import co.edu.usbcali.colegiousb.archivos.IArchivos;
import co.edu.usbcali.colegiousb.modelo.Empleado;
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
public class EmpleadoRepositorio implements IEmpleadoRepositorio {
    private IArchivos archivos = new Archivos();
    private String localDir = System.getProperty("user.dir");
    private final String rutaArchivoEmpleado = localDir + "\\empleado.txt";
    
    @Override
    public void crearEmpleado(Empleado empleado) throws Exception {
        String lineaAAdicionar
                = empleado.getId().concat(",")
                        .concat(empleado.getRol()).concat(",")
                        .concat(empleado.getNombre()).concat(",")
                        .concat(empleado.getEdad()).concat(",")
                        .concat(empleado.getSexo()).concat(",")
                        .concat(empleado.getSalario());
        try {
            archivos.crearArchivo(rutaArchivoEmpleado);
            archivos.adicionarLineaFinal(rutaArchivoEmpleado, lineaAAdicionar);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public List<Empleado> visualizarEmpleado() throws Exception {
        FileReader fileReader = new FileReader(rutaArchivoEmpleado);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Empleado> empleados = new ArrayList<Empleado>();
        
        try {
            String lineaLeida = "";
            Empleado empleado;
            
            while((lineaLeida = bufferedReader.readLine()) != null) {
                String[] contenidoLinea = lineaLeida.split(",");
                empleados.add(new Empleado(contenidoLinea[0], //Id
                                         contenidoLinea[1], //Rol
                                         contenidoLinea[2], //Nombre
                                         contenidoLinea[3], //Edad
                                         contenidoLinea[4], //Sexo
                                         contenidoLinea[5])); //Salario
            }
        } catch (Exception e) {
            Logger.getLogger(EmpleadoRepositorio.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }
        
        return empleados;
    }

    @Override
    public Empleado obtenerEmpleadoPorId(String id) throws Exception {
        Empleado empleado = null;
        FileReader fileReader = new FileReader(rutaArchivoEmpleado);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        try {
            String lineaLeida = "";
            String[] contenidoLinea;

            while ((lineaLeida = bufferedReader.readLine()) != null) {
                contenidoLinea = lineaLeida.split(",");
                if(contenidoLinea[0].trim().equals(id+"")) {
                    empleado = new Empleado(contenidoLinea[0],
                                            contenidoLinea[1],
                                            contenidoLinea[2],
                                            contenidoLinea[3],
                                            contenidoLinea[4],
                                            contenidoLinea[5]);
                }
            }
        } catch (Exception e) {
            Logger.getLogger(EmpleadoRepositorio.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            bufferedReader.close();
            fileReader.close();
        }
        
        return empleado;
    }

    @Override
    public boolean validarEmpleadoId(String id) throws Exception {
        FileReader fileReader = new FileReader(rutaArchivoEmpleado);
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
            Logger.getLogger(EmpleadoRepositorio.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            bufferedReader.close();
            fileReader.close();
        }
        
        return false;
    }
}