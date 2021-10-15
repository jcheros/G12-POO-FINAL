/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.grupo12.modelo;

/**
 *
 * @author ID46499778
 */
public class Promocion {
    private Integer id;
    private int cantMin;
    private int cantMax;
    private Float porcentaje;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantMin() {
        return cantMin;
    }

    public void setCantMin(int cantMin) {
        this.cantMin = cantMin;
    }

    public int getCantMax() {
        return cantMax;
    }

    public void setCantMax(int cantMax) {
        this.cantMax = cantMax;
    }

    public Float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Float porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Promocion() {
    }

    public Promocion(Integer id, int cantMin, int cantMax, Float porcentaje) {
        this.id = id;
        this.cantMin = cantMin;
        this.cantMax = cantMax;
        this.porcentaje = porcentaje;
    }
    
    
}
