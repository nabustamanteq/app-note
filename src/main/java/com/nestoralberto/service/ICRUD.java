/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestoralberto.service;

import java.util.List;

/**
 *
 * @author albertobq
 */
public interface ICRUD<T, V> {
    
    boolean registrar(T obj) throws Exception;

    boolean modificar(T obj) throws Exception;

    List<T> listar() throws Exception;

    T listarPorId(V id) throws Exception;

    boolean eliminar(V id) throws Exception;
    
    /*T registrar(T obj);

    T modificar(T obj);

    List<T> listar();

    T listarPorId(V id);

    boolean eliminar(V id);*/
    
}
