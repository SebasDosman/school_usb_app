/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usbcali.colegiousb.logica;

import co.edu.usbcali.colegiousb.modelo.Usuario;
import co.edu.usbcali.colegiousb.repositorio.IUsuarioReposiorio;
import co.edu.usbcali.colegiousb.repositorio.UsuarioRepositorio;

/**
 *
 * @author Usuario
 */
public class UsuarioLogica implements IUsuarioLogica {
    private IUsuarioReposiorio usuarioRepositorio = new UsuarioRepositorio();
            
    @Override
    public void crearUsuario(Usuario usuario) throws Exception {
        if(usuario == null) {
            throw new Exception("El objeto actividad viene null");
        }
        
        if(usuario.getUsuario()== null || 
                usuario.getUsuario().trim().equals("")) {
            throw new Exception("El usuario no puede estar nulo ni vacío");
        }
        
        if(usuario.getContrasenia() == null || 
                usuario.getContrasenia().trim().equals("")) {
            throw new Exception("La contraseña no puede estar nula ni vacía");
        }
        
        if(usuario.getNombre() == null || 
                usuario.getNombre().trim().equals("")) {
            throw new Exception("El nombre no puede ser nulo ni vacío");
        }
        
        if(usuario.getApellido() == null || 
                usuario.getApellido().trim().equals("")) {
            throw new Exception("El apellido no puede ser nulo ni vacío");
        }
        
        if(usuario.getEmail() == null || 
                usuario.getEmail().trim().equals("")) {
            throw new Exception("El email no puede ser nulo ni vacío");
        }
        
        usuarioRepositorio.crearUsuario(usuario);
    }

    @Override
    public boolean validarUsuario(String usuario, String contrasena) throws Exception {
        if(usuario == null || contrasena == null) {
            throw new Exception("El usuario y la contraseña no pueden ser nulos ni vacios");
        }
        
        return usuarioRepositorio.validarUsuario(usuario, contrasena);
    }

    @Override
    public Usuario obtenerUsuario(String usuario) throws Exception {
        if(usuario == null) {
            throw new Exception("El usuario no puede ser nulo ni vacio");
        }
        
        return usuarioRepositorio.obtenerUsuario(usuario);
    }
}
