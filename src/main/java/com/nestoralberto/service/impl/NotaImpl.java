/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestoralberto.service.impl;

import com.nestoralberto.config.Conexion;
import com.nestoralberto.model.Nota;
import com.nestoralberto.service.INota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author albertobq
 */
public class NotaImpl implements INota{

    Connection conexion = null;
    String sql = "";
    boolean respuesta = false;
    
    @Override
    public boolean registrar(Nota obj) throws Exception {
        
        conexion = new Conexion().obtenerConexion();
        PreparedStatement ps = null;
        sql = "INSERT INTO nota (titulo, descripcion, id_usuario, fecha, estado) VALUES(?,?,?, NOW(),'A')";
        
        try {
            conexion.setAutoCommit(false);
            ps = conexion.prepareStatement(sql);
            ps.setString(1, obj.getTitulo());
            ps.setString(2, obj.getDescripcion());
            ps.setInt(3, obj.getIdUsuario());
            
            if (ps.executeUpdate() > 0) {
                conexion.commit();
                respuesta = true;
            } else {
                conexion.rollback();
            }
        } catch (Exception ex) {
            
            conexion.rollback();
            throw ex;
            
        } finally {
            ps.close();
            conexion.close();
            return respuesta;
        }
    }

    @Override
    public boolean modificar(Nota obj) throws Exception {
        conexion = new Conexion().obtenerConexion();
        PreparedStatement ps = null;
        sql = "UPDATE nota SET titulo = ?, descripcion = ? WHERE id_nota = ?";
        
        try {
            conexion.setAutoCommit(false);
            ps = conexion.prepareStatement(sql);
            ps.setString(1, obj.getTitulo());
            ps.setString(2, obj.getDescripcion());
            ps.setInt(3, obj.getId());
            
            if (ps.executeUpdate() > 0) {
                conexion.commit();
                respuesta = true;
            } else {
                conexion.rollback();
            }
        } catch (Exception ex) {

            conexion.rollback();
            throw ex;

        } finally {
            ps.close();
            conexion.close();
            return respuesta;
        }
    }

    @Override
    public List<Nota> listar() throws Exception {
        conexion = new Conexion().obtenerConexion();
        List<Nota> lista = null;
        Nota obj = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        sql = "SELECT id_nota, titulo, descripcion, id_usuario, fecha, estado FROM nota WHERE estado = 'A'";
        
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            
            lista = new ArrayList<>();
            
            while (rs.next()) {
                obj = new Nota();
                obj.setId(rs.getInt("id_nota"));
                obj.setTitulo(rs.getString("titulo"));
                obj.setDescripcion(rs.getString("descripcion"));
                obj.setIdUsuario(rs.getInt("id_usuario"));
                obj.setFecha(rs.getDate("fecha"));
                obj.setEstado(rs.getString("estado"));
                lista.add(obj);
            }
        } catch (Exception ex) {
            
            throw ex;
            
        } finally {
            ps.close();
            conexion.close();
            return lista;
        }
    }

    @Override
    public Nota listarPorId(Integer id) throws Exception {
        conexion = new Conexion().obtenerConexion();
        
        Nota obj = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        sql = "SELECT id_nota, titulo, descripcion, id_usuario, fecha, estado FROM nota WHERE id_nota = ?";
        
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                obj = new Nota();
                obj.setId(rs.getInt("id_nota"));
                obj.setTitulo(rs.getString("titulo"));
                obj.setDescripcion(rs.getString("descripcion"));
                obj.setIdUsuario(rs.getInt("id_usuario"));
                obj.setFecha(rs.getDate("fecha"));
                obj.setEstado(rs.getString("estado"));
            }
        } catch (Exception ex) {
            
            throw ex;
            
        } finally {
            ps.close();
            conexion.close();
            return obj;
        }
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        conexion = new Conexion().obtenerConexion();
        PreparedStatement ps = null;
        sql = "UPDATE nota SET estado = 'I' WHERE id_nota = ?";
        
        try {
            conexion.setAutoCommit(false);
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            
            if (ps.executeUpdate() > 0) {
                conexion.commit();
                respuesta = true;
            } else {
                conexion.rollback();
            }
        } catch (Exception ex) {
            
            conexion.rollback();
            throw ex;
            
        } finally {
            ps.close();
            conexion.close();
            return respuesta;
        }
    }
    
    
}
