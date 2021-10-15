/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.grupo12.modelo;

import java.util.Date;

/**
 *
 * @author ID46499778
 */
public class Venta {
    private Integer id;
    private String cliente;
    private Date fecha;
    private Integer idEmpleado;
    private String idPublicacion;
    private Integer cantidad;
    private Float precio;
    private Float dcto;
    private Float subTotal;
    private Float impuesto;
    private Float total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(String idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Float getDcto() {
        return dcto;
    }

    public void setDcto(Float dcto) {
        this.dcto = dcto;
    }

    public Float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Float subTotal) {
        this.subTotal = subTotal;
    }

    public Float getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Float impuesto) {
        this.impuesto = impuesto;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Venta() {
    }

    public Venta(Integer id, String cliente, Date fecha, Integer idEmpleado, String idPublicacion, Integer cantidad, Float precio, Float dcto, Float subTotal, Float impuesto, Float total) {
        this.id = id;
        this.cliente = cliente;
        this.fecha = fecha;
        this.idEmpleado = idEmpleado;
        this.idPublicacion = idPublicacion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.dcto = dcto;
        this.subTotal = subTotal;
        this.impuesto = impuesto;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", cliente=" + cliente + ", fecha=" + fecha + ", idEmpleado=" + idEmpleado + ", idPublicacion=" + idPublicacion + ", cantidad=" + cantidad + ", precio=" + precio + ", dcto=" + dcto + ", subTotal=" + subTotal + ", impuesto=" + impuesto + ", total=" + total + '}';
    }
}
