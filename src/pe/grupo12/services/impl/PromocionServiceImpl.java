/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.grupo12.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.grupo12.datasource.AccesoDB;
import pe.grupo12.modelo.Promocion;
import pe.grupo12.services.PromocionService;

/**
 *
 * @author ID46499778
 */
public class PromocionServiceImpl implements PromocionService {

    @Override
    public Optional<Promocion> getPromocion(int cantidad) {
        Optional<Promocion> promocionOptional = Optional.empty();
        Connection con = null;
        
        try {
            con = AccesoDB.getConnection();
            con.setAutoCommit(false);
            String query = "SELECT IDPROMOCION, CANTMIN, CANTMAX, PORCENTAJE " +
                            "FROM PROMOCION " +
                            "WHERE CANTMAX >= ? AND ROWNUM = 1 " +
                            "ORDER BY CANTMAX";

            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, cantidad);

            ResultSet rs = statement.executeQuery(); 

            if (!rs.next()) {
                promocionOptional = Optional.empty();
            } else {
                Promocion promocion = new Promocion(
                    rs.getInt("IDPROMOCION"),
                    rs.getInt("CANTMIN"),
                    rs.getInt("CANTMAX"),
                    rs.getFloat("PORCENTAJE")
                );

                promocionOptional = Optional.of(promocion);
            }

            con.commit();
        } catch (Exception ex) {
            Logger.getLogger(LogonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return promocionOptional;
    }
    
}
