/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.grupo12.services;

import java.util.List;
import pe.grupo12.modelo.TipoPublicacion;

/**
 *
 * @author ID46499778
 */
public interface TipoPublicacionService {
    List<TipoPublicacion> litarTipos();
    int actualizarContador(String id);
}
