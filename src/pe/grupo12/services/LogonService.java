/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.grupo12.services;

import java.util.Optional;
import pe.grupo12.modelo.Usuario;

/**
 *
 * @author ID46499778
 */
public interface LogonService {
    Optional<Usuario> validarCredenciales(String usuario, String clave);
}
