/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.grupo12.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.grupo12.datasource.AccesoDB;
import pe.grupo12.services.ControlService;

/**
 *
 * @author ID46499778
 */
public class ControlServiceImpl implements ControlService {

    @Override
    public Float getIGV() {
        Float igv = 0f;
        Connection con = null;
        
        try {
            con = AccesoDB.getConnection();
            con.setAutoCommit(false);
            String query = "SELECT VALOR FROM CONTROL WHERE PARAMETRO = 'IGV'";

            PreparedStatement statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery(); 

            if (!rs.next()) {
                igv = 0F;
            } else {
                igv = rs.getFloat("VALOR");
            }
            
            con.commit();
        } catch (Exception ex) {
            Logger.getLogger(LogonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return igv;
    }
    
}
