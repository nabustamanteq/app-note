/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestoralberto.appnotas;

import com.nestoralberto.config.Conexion;
import com.nestoralberto.controller.NotaController;
import com.nestoralberto.model.Nota;
import com.nestoralberto.service.impl.NotaImpl;
import com.nestoralberto.view.FrmNota;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author albertobq
 */
public class Main {
    
    
    public static void main(String[] args) {
        
        FrmNota frmNota = new FrmNota();
        NotaController controller = new NotaController(frmNota);
        
        try {
            
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        frmNota.setVisible(true);
        frmNota.setLocationRelativeTo(null);
        
    }
    
}
