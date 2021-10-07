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
public class Publicacion {
    private Integer id;
    private String titulo;
    private String idTipo;
    private String autor;
    private String nroEdicion;
    private Float precio;
    private int stock;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNroEdicion() {
        return nroEdicion;
    }

    public void setNroEdicion(String nroEdicion) {
        this.nroEdicion = nroEdicion;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Publicacion() {
    }

    public Publicacion(Integer id, String titulo, String idTipo, String autor, String nroEdicion, Float precio, int stock) {
        this.id = id;
        this.titulo = titulo;
        this.idTipo = idTipo;
        this.autor = autor;
        this.nroEdicion = nroEdicion;
        this.precio = precio;
        this.stock = stock;
    }
}
