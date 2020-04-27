/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestoralberto.config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author albertobq
 */
public class Conexion {
    
    private final String URL = "jdbc:mysql://localhost:3306/dbnota_desktop?serverTimezone=UTC";
    
    private final String USER = "root";
    
    private final String PASS = "";
    
    private Connection con = null;
    
    /**
     * Instanciar conexion con la BD.
     * 
     * @return 
     */
    public Connection obtenerConexion() {
        try {
            this.con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexion hecha.");
        } catch (Exception ex) {
            System.out.println("ERROR : " + ex.getMessage());
        }
        return con;
    }
}
