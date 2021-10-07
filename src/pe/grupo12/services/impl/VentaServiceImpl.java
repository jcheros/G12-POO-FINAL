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
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.grupo12.datasource.AccesoDB;
import pe.grupo12.modelo.Promocion;
import pe.grupo12.modelo.Venta;
import pe.grupo12.services.VentaService;

/**
 *
 * @author ID46499778
 */
public class VentaServiceImpl implements VentaService {

    @Override
    public Venta registrarVenta(Venta venta) {
        Connection con = null;
        
        try {
            con = AccesoDB.getConnection();
            con.setAutoCommit(false);
            String query = "INSERT INTO VENTA (IDVENTA, CLIENTE, FECHA, IDEMPLEADO, IDPUBLICACION, CANTIDAD, PRECIO, DCTO, SUBTOTAL, IMPUESTO, TOTAL) "
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            venta.setId(getId());
            
            // Verificamos si aplica promoción
            PromocionServiceImpl promocionService = new PromocionServiceImpl();
            Optional<Promocion> promocionOptional = promocionService.getPromocion(venta.getCantidad());
            
            if (promocionOptional.isPresent()) {
                venta.setDcto(venta.getPrecio() * promocionOptional.get().getPorcentaje());
            } else {
                venta.setDcto(0f);
            }
            
            venta.setSubTotal(venta.getPrecio() - venta.getDcto());
            
            // Verificamos el impuesto
            ControlServiceImpl controlService = new ControlServiceImpl();
            Float igv = controlService.getIGV();
            venta.setImpuesto(igv);
            
            // Calculamosel total
            venta.setTotal(venta.getSubTotal() +  (venta.getSubTotal() * venta.getImpuesto()));
                        
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, venta.getId());
            statement.setString(2, venta.getCliente());
            statement.setDate(3, new java.sql.Date(venta.getFecha().getTime()));
            statement.setInt(4, venta.getIdEmpleado());
            statement.setString(5, venta.getIdPublicacion());
            statement.setInt(6, venta.getCantidad());
            statement.setFloat(7, venta.getPrecio());
            statement.setFloat(8, venta.getDcto());
            statement.setFloat(9, venta.getSubTotal());
            statement.setFloat(10, venta.getImpuesto());
            statement.setFloat(11, venta.getTotal());
            
            int rows = statement.executeUpdate();
            
            if (rows > 0) {
                PublicacionServiceImpl publicacionService = new PublicacionServiceImpl();
                publicacionService.actualizarStock(venta.getIdPublicacion(), venta.getCantidad());
            }
            
            statement.close();
            con.commit();
        } catch (Exception ex) {
            Logger.getLogger(LogonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return venta;
    }
    
    private Integer getId() {
        Connection con = null;
        Integer id = 0;
        
        try {
            con = AccesoDB.getConnection();
            con.setAutoCommit(false);
            String query = "SELECT (MAX(IDVENTA) + 1) AS ID FROM VENTA";

            PreparedStatement statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery(); 

            if (!rs.next()) {
                id = 0;
            } else {
                id = rs.getInt("ID");
            }
            
            con.commit();
        } catch (Exception ex) {
            Logger.getLogger(LogonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }

    @Override
    public List<Venta> listarVentasPorTipoPublicacion(String tipoPublicacion) {
        Connection con = null;
        Venta venta = null;
        List<Venta> ventas = new ArrayList<>();
        
        try {
            con = AccesoDB.getConnection();
            con.setAutoCommit(false);
            String query = "SELECT " +
                            "idventa, cliente, fecha, idempleado, VENTA.idpublicacion, cantidad, VENTA.precio, dcto, subtotal, impuesto, total " +
                            "FROM VENTA " +
                            "JOIN PUBLICACION on PUBLICACION.IDPUBLICACION = VENTA.IDPUBLICACION " +
                            "WHERE PUBLICACION.IDTIPO = ?";
            
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, tipoPublicacion);
            
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                venta = new Venta();
                venta.setId(rs.getInt("idventa"));
                venta.setCliente(rs.getString("cliente"));
                venta.setFecha(rs.getDate("fecha"));
                venta.setIdEmpleado(rs.getInt("idempleado"));
                venta.setIdPublicacion(rs.getString("idpublicacion"));
                venta.setCantidad(rs.getInt("cantidad"));
                venta.setPrecio(rs.getFloat("precio"));
                venta.setDcto(rs.getFloat("dcto"));
                venta.setSubTotal(rs.getFloat("subtotal"));
                venta.setImpuesto(rs.getFloat("impuesto"));
                venta.setTotal(rs.getFloat("total"));
                
                ventas.add(venta);
            }
            
            con.commit();
        } catch (Exception ex) {
            Logger.getLogger(LogonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ventas;
    }

    @Override
    public List<Venta> listarVentasPorEmpleado(Integer idEmpleado) {
        Connection con = null;
        Venta venta = null;
        List<Venta> ventas = new ArrayList<>();
        
        try {
            con = AccesoDB.getConnection();
            con.setAutoCommit(false);
            String query = "SELECT " +
                            "idventa, cliente, fecha, idempleado, idpublicacion, cantidad, precio, dcto, subtotal, impuesto, total " +
                            "FROM VENTA " +
                            "WHERE idempleado = ?";
            
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, idEmpleado);
            
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                venta = new Venta();
                venta.setId(rs.getInt("idventa"));
                venta.setCliente(rs.getString("cliente"));
                venta.setFecha(rs.getDate("fecha"));
                venta.setIdEmpleado(rs.getInt("idempleado"));
                venta.setIdPublicacion(rs.getString("idpublicacion"));
                venta.setCantidad(rs.getInt("cantidad"));
                venta.setPrecio(rs.getFloat("precio"));
                venta.setDcto(rs.getFloat("dcto"));
                venta.setSubTotal(rs.getFloat("subtotal"));
                venta.setImpuesto(rs.getFloat("impuesto"));
                venta.setTotal(rs.getFloat("total"));
                
                ventas.add(venta);
            }
            
            con.commit();
        } catch (Exception ex) {
            Logger.getLogger(LogonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ventas;
    }

    @Override
    public List<Venta> listarVentasPorRangoFechas(Date inicio, Date fin) {
        Connection con = null;
        Venta venta = null;
        List<Venta> ventas = new ArrayList<>();
        
        try {
            con = AccesoDB.getConnection();
            con.setAutoCommit(false);
            String query = "SELECT " +
                            "idventa, cliente, fecha, idempleado, idpublicacion, cantidad, precio, dcto, subtotal, impuesto, total " +
                            "FROM VENTA " +
                            "WHERE FECHA between ? and ?";
            
            PreparedStatement statement = con.prepareStatement(query);
            statement.setDate(1, new java.sql.Date(inicio.getTime()));
            statement.setDate(2, new java.sql.Date(fin.getTime()));
            
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                venta = new Venta();
                venta.setId(rs.getInt("idventa"));
                venta.setCliente(rs.getString("cliente"));
                venta.setFecha(rs.getDate("fecha"));
                venta.setIdEmpleado(rs.getInt("idempleado"));
                venta.setIdPublicacion(rs.getString("idpublicacion"));
                venta.setCantidad(rs.getInt("cantidad"));
                venta.setPrecio(rs.getFloat("precio"));
                venta.setDcto(rs.getFloat("dcto"));
                venta.setSubTotal(rs.getFloat("subtotal"));
                venta.setImpuesto(rs.getFloat("impuesto"));
                venta.setTotal(rs.getFloat("total"));
                
                ventas.add(venta);
            }
            
            con.commit();
        } catch (Exception ex) {
            Logger.getLogger(LogonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ventas;
    }
    
}
