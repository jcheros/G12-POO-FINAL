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
import pe.grupo12.modelo.Publicacion;
import pe.grupo12.services.PublicacionService;

/**
 *
 * @author ID46499778
 */
public class PublicacionServiceImpl implements PublicacionService {
    
    TipoPublicacionServiceImpl tipoPublicacionService;

    public PublicacionServiceImpl() {
        tipoPublicacionService = new TipoPublicacionServiceImpl();
    }

    @Override
    public List<Publicacion> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Publicacion> listarPorTipo(String tipo) {
        Connection con = null;
        Publicacion publicacion = null;
        List<Publicacion> publicaciones = new ArrayList<>();
        
        try {
            con = AccesoDB.getConnection();
            con.setAutoCommit(false);
            String query = "SELECT IDPUBLICACION, TITULO, IDTIPO, AUTOR, NROEDICION, PRECIO, STOCK " +
                            "FROM PUBLICACION " +
                            "WHERE IDTIPO = ?";
            
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, tipo);
            
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                publicacion = new Publicacion();
                publicacion.setId(rs.getString("IDPUBLICACION"));
                publicacion.setTitulo(rs.getString("TITULO"));
                publicacion.setIdTipo(rs.getString("IDTIPO"));
                publicacion.setAutor(rs.getString("AUTOR"));
                publicacion.setNroEdicion(rs.getInt("NROEDICION"));
                publicacion.setPrecio(rs.getFloat("PRECIO"));
                publicacion.setStock(rs.getInt("STOCK"));
                
                publicaciones.add(publicacion);
            }
            
            con.commit();
            statement.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(LogonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return publicaciones;
    }

    @Override
    public Publicacion agregar(Publicacion publicacion) {
        Connection con = null;
        
        try {
            con = AccesoDB.getConnection();
            con.setAutoCommit(false);
            String query = "INSERT INTO PUBLICACION (IDPUBLICACION, TITULO, IDTIPO, AUTOR, NROEDICION, PRECIO, STOCK) VALUES " +
                    "(?, ?, ?, ?, ?, ?, ?)";
                       
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, publicacion.getId());
            statement.setString(2, publicacion.getTitulo());
            statement.setString(3, publicacion.getIdTipo());
            statement.setString(4, publicacion.getAutor());
            statement.setInt(5, publicacion.getNroEdicion());
            statement.setInt(6, publicacion.getPrecio().intValue());
            statement.setInt(7, publicacion.getStock());
            
            int rows = statement.executeUpdate();
            
            if (rows > 0) {
                tipoPublicacionService.actualizarContador(publicacion.getIdTipo());
            }
            
            con.commit();
            statement.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(LogonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return publicacion;
    }

    @Override
    public Publicacion actualizar(Publicacion publicacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizarStock(String id, int cantidad) {
        Connection con = null;
        int rows = 0;
        
        try {
            con = AccesoDB.getConnection();
            con.setAutoCommit(false);
            String query = "UPDATE PUBLICACION " +
                            "SET STOCK = (STOCK - ?) " +
                            "WHERE IDPUBLICACION = ?";

            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, cantidad);
            statement.setString(2, id);

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

    @Override
    public int eliminar(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
