/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.grupo12.test;

import java.util.Optional;
import pe.grupo12.modelo.Usuario;
import pe.grupo12.services.impl.LogonServiceImpl;

/**
 *
 * @author ID46499778
 */
public class LoginTest {
    public static void main(String[] args) {
        String username = "eaguero";
        String password = "cazador";
        
        LogonServiceImpl logonService = new LogonServiceImpl();
        Optional<Usuario> usuario = logonService.validarCredenciales(username, password);
        
        if (usuario.isPresent()) {
            System.out.println("Login correcto");
        } else {
            System.out.println("Login incorrecto");
        }
    }
}
