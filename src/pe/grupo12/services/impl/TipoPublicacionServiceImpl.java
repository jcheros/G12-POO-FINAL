/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.grupo12.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.grupo12.datasource.AccesoDB;
import pe.grupo12.modelo.TipoPublicacion;
import pe.grupo12.modelo.Venta;
import pe.grupo12.services.TipoPublicacionService;

/**
 *
 * @author ID46499778
 */
public class TipoPublicacionServiceImpl implements TipoPublicacionService {

    @Override
    public List<TipoPublicacion> litarTipos() {
        Connection con = null;
        List<TipoPublicacion> tipos = new ArrayList<>();
        TipoPublicacion tipo = null;
        
        try {
            con = AccesoDB.getConnection();
            con.setAutoCommit(false);
            String query = "SELECT IDTIPO, DESCRIPCION, CONTADOR FROM TIPO";
            
            PreparedStatement statement = con.prepareStatement(query);            
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                tipo = new TipoPublicacion();
                tipo.setId(rs.getString("IDTIPO"));
                tipo.setDescripcion(rs.getString("DESCRIPCION"));
                tipo.setContador(rs.getInt("CONTADOR"));
                
                tipos.add(tipo);
            }
            
            con.commit();
            statement.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(LogonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tipos;
    }

    @Override
    public int actualizarContador(String id) {
        Connection con = null;
        int rows = 0;
        
        try {
            con = AccesoDB.getConnection();
            con.setAutoCommit(false);
            String query = "UPDATE TIPO " +
                            "SET CONTADOR = (CONTADOR + 1) " +
                            "WHERE IDTIPO = ?";

            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, id);

            rows = statement.executeUpdate();
            System.out.println(rows + " Registros actualizados");

            con.commit();
            statement.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(LogonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rows;
    }
    
}
