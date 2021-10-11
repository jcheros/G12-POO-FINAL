/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.grupo12.test;

import pe.grupo12.modelo.Publicacion;
import pe.grupo12.services.impl.PublicacionServiceImpl;

/**
 *
 * @author ID46499778
 */
public class PublicacionTest {
    public static void main(String[] args) {
        PublicacionServiceImpl publicacionService = new PublicacionServiceImpl();
        Publicacion publicacion = new Publicacion();
        
        publicacion.setId("LIB00020");
        publicacion.setTitulo("Prueba");
        publicacion.setIdTipo("LIB");
        publicacion.setAutor("Grupo 12");
        publicacion.setNroEdicion(123);
        publicacion.setPrecio(200f);
        publicacion.setStock(100);
        
        publicacion = publicacionService.agregar(publicacion);
        System.out.println("Registro ingresado: " +  publicacion.toString());
    }
}
