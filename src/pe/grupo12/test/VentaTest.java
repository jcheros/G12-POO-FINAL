/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.grupo12.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import pe.grupo12.modelo.Venta;
import pe.grupo12.services.impl.VentaServiceImpl;

/**
 *
 * @author ID46499778
 */
public class VentaTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Venta venta = new Venta();
        
        venta.setCliente("Juan Lopez");
        venta.setFecha(format.parse("2021-10-07"));
        venta.setIdEmpleado(3);
        venta.setIdPublicacion("LIB00007");
        venta.setCantidad(12);
        venta.setPrecio(35f);
        
        VentaServiceImpl ventaService = new VentaServiceImpl();
        
        venta = ventaService.registrarVenta(venta);
        System.out.println("registrarVenta");
        System.out.println(venta.toString());
        
        List<Venta> ventasPorEmpleado = ventaService.listarVentasPorEmpleado(3);
        System.out.println("ventasPorEmpleado");
        ventasPorEmpleado.forEach(System.out::println);
        
        List<Venta> ventasPorTipoPubli = ventaService.listarVentasPorTipoPublicacion("LIB");
        System.out.println("ventasPorTipoPubli");
        ventasPorTipoPubli.forEach(System.out::println);
        
        List<Venta> ventasPorFechas = ventaService.listarVentasPorRangoFechas(format.parse("2021-09-01"), format.parse("2021-09-31"));
        System.out.println("ventasPorFechas");
        ventasPorFechas.forEach(System.out::println);
    }
}
