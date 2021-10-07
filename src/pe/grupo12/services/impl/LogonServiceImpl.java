/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.grupo12.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.grupo12.datasource.AccesoDB;
import pe.grupo12.modelo.Usuario;
import pe.grupo12.services.LogonService;

/**
 *
 * @author ID46499778
 */
public class LogonServiceImpl implements LogonService {

    @Override
    public Optional<Usuario> validarCredenciales(String username, String password) {
        Optional<Usuario> usuarioOptional = Optional.empty();
        Connection con = null;
        
        if (Objects.nonNull(username) && Objects.nonNull(password)) {
            try {
                con = AccesoDB.getConnection();
                con.setAutoCommit(false);
                String query = "select idempleado, usuario, clave, activo from usuario where usuario = ? and clave = ? and activo = 1";
                
                PreparedStatement statement = con.prepareStatement(query);
                statement.setString(1, username);
                statement.setString(2, password);
                
                ResultSet rs = statement.executeQuery(); 
                
                if (!rs.next()) {
                    usuarioOptional = Optional.empty();
                } else {
                    Usuario usuario = new Usuario(
                        rs.getInt("idempleado"),
                        rs.getString("usuario"),
                        rs.getString("clave"),
                        rs.getInt("activo")
                    );

                    usuarioOptional = Optional.of(usuario);
                }

                con.commit();
            } catch (Exception ex) {
                Logger.getLogger(LogonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return usuarioOptional;
    }
    
}
