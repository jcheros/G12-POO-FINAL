/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.grupo12.services;

import java.util.List;
import pe.grupo12.modelo.Publicacion;

/**
 *
 * @author ID46499778
 */
public interface PublicacionService {
    List<Publicacion> listar();
    List<Publicacion> listarPorTipo(String tipo);
    Publicacion agregar(Publicacion publicacion);
    Publicacion actualizar(Publicacion publicacion);
    int actualizarStock(String id, int cantidad);
    int eliminar(String id);
}
