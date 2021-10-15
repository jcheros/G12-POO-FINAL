/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.grupo12.services;

import java.util.Date;
import java.util.List;
import pe.grupo12.modelo.Venta;

/**
 *
 * @author ID46499778
 */
public interface VentaService {
    Venta registrarVenta(Venta venta);
    Venta calcularMontos(Venta venta);
    List<Venta> listarVentasPorTipoPublicacion(String tipoPublicacion);
    List<Venta> listarVentasPorEmpleado(Integer idEmpleado);
    List<Venta> listarVentasPorRangoFechas(Date inicio, Date fin);
}
