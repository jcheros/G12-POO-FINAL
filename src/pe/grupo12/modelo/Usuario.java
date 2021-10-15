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
public class Usuario {
    private Integer id;
    private String usuario;
    private String clave;
    private int activo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public Usuario() {
    }

    public Usuario(Integer id, String usuario, String clave, int activo) {
        this.id = id;
        this.usuario = usuario;
        this.clave = clave;
        this.activo = activo;
    }    
    
}
