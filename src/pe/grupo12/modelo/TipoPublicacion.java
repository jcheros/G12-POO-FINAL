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
public class TipoPublicacion {
    private String id;
    private String descripcion;
    private int contador;
    
    public TipoPublicacion() {
    }

    public TipoPublicacion(String id, String descripcion, int contador) {
        this.id = id;
        this.descripcion = descripcion;
        this.contador = contador;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }    
}
