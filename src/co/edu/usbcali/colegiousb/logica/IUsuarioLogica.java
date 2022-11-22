/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usbcali.colegiousb.logica;

import co.edu.usbcali.colegiousb.modelo.Usuario;

/**
 *
 * @author Usuario
 */
public interface IUsuarioLogica {
    public void crearUsuario(Usuario usuario) throws Exception;
    public boolean validarUsuario(String usuario, String contrasena) throws Exception;
    public Usuario obtenerUsuario(String usuario) throws Exception;
}
