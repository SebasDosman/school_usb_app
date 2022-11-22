/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usbcali.colegiousb.repositorio;

import co.edu.usbcali.colegiousb.archivos.Archivos;
import co.edu.usbcali.colegiousb.archivos.IArchivos;
import co.edu.usbcali.colegiousb.modelo.Estudiante;
import co.edu.usbcali.colegiousb.modelo.Grado;
import co.edu.usbcali.colegiousb.modelo.Usuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class UsuarioRepositorio implements IUsuarioReposiorio {
    private IArchivos archivos = new Archivos();
    private String localDir = System.getProperty("user.dir");
    private final String rutaArchivoUsuarios = localDir + "\\usuario.txt";
    
    @Override
    public void crearUsuario(Usuario usuario) throws Exception {
        String lineaAAdicionar
                = usuario.getUsuario().concat(",")
                        .concat(usuario.getContrasenia()).concat(",")
                        .concat(usuario.getNombre()).concat(",")
                        .concat(usuario.getApellido()).concat(",")
                        .concat(usuario.getEmail());
        try {
            archivos.crearArchivo(rutaArchivoUsuarios);
            archivos.adicionarLineaFinal(rutaArchivoUsuarios, lineaAAdicionar);
        } catch (Exception ex) {
            Logger.getLogger(ActividadRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public boolean validarUsuario(String usuarioUsuario, String usuarioContrasena) throws Exception {
        Usuario usuario = obtenerUsuario(usuarioUsuario);
        
        if (usuario == null || !(usuario.getUsuario().equals(usuarioUsuario) && usuario.getContrasenia().equals(usuarioContrasena))) {
            return false;
        }
        
        return true;
    }

    @Override
    public Usuario obtenerUsuario(String usuarioPerfil) throws Exception {
        Usuario usuario = null;
        FileReader fileReader = new FileReader(rutaArchivoUsuarios);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        try {
            String lineaLeida = "";
            String[] contenidoLinea;

            while ((lineaLeida = bufferedReader.readLine()) != null) {
                contenidoLinea = lineaLeida.split(",");
                
                if(contenidoLinea[0].trim().equals(usuarioPerfil + "")) {
                    usuario = new Usuario(contenidoLinea[0].toString(), 
                            contenidoLinea[1].toString(),
                            contenidoLinea[2].toString(),
                            contenidoLinea[3].toString(),
                            contenidoLinea[4].toString());
                }
            }

        } catch (Exception e) {
            Logger.getLogger(EstudianteRepositorio.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            bufferedReader.close();
            fileReader.close();
        }
        
        return usuario;
    }
    
    
}
