/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestoralberto.model;

import java.sql.Date;


/**
 *
 * @author albertobq
 */
public class Nota {
    
    private Integer id;
    private String titulo;
    private String descripcion;
    private Integer idUsuario;
    private Date fecha;
    private String estado;
    
    public Nota(){}

    public Nota(String titulo, String descripcion, Integer idUsuario, Date fecha, String estado) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.estado = estado;
    }
    

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return titulo + " - " + descripcion;
    }
    
    
    
}
