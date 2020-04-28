
package com.nestoralberto.controller;

import com.nestoralberto.model.Nota;
import com.nestoralberto.service.impl.NotaImpl;
import com.nestoralberto.view.FrmNota;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author albertobq
 */
public class NotaController extends NotaControllerServ {
    
    //MouseAdapter
    FrmNota frmNota = new FrmNota();
    
    //https://www.youtube.com/watch?v=Soe5FrO-tp4   SinFloo
    //https://www.youtube.com/watch?v=AUcibt-cf4E   Egloba Systems
    public NotaController(FrmNota frmNota) {
        this.frmNota = frmNota;
        
        //https://es.stackoverflow.com/questions/23145/problema-mouselistener-y-jtable/23150
        //http://www.myjavazone.com/2010/08/mouselistener.html
//        this.frmNota.listNota.addMouseListener(this); // Se puede utilizar un Adaptador MouseAdapter
        declareEvents();
        
        listarNotas(frmNota.listNota);
        frmNota.labelMensaje.setText("");
    }
    
    // Metodos con uso de Componentes del Frame
    public void listarNotas(JList jlistNota) {
        List<Nota> lista = listar();
        DefaultListModel model = new DefaultListModel();
        
        if (lista != null) {
            for (Nota n : lista) {
                model.addElement(n);
            }
        }
        jlistNota.setModel(model);
    }
    
    private void mostrarMensaje(String msg, String type) {
        switch (type) {
            case "error":
                frmNota.labelMensaje.setForeground(Color.RED);
                break;
            default:
                frmNota.labelMensaje.setForeground(Color.BLUE);
                break;
        }
        frmNota.labelMensaje.setText(msg);
    }
    
    private void registrarNota() {
        String titulo = frmNota.textTitulo.getText();
        String descripcion = frmNota.textDescripcion.getText();

        if (!titulo.trim().equals("")
                || !descripcion.trim().equals("")) {

            Nota obj = new Nota();
            obj.setTitulo(titulo);
            obj.setDescripcion(descripcion);
            obj.setIdUsuario(1);

            if (!registrar(obj)) {

                mostrarMensaje("No se pudo registrar la nota.", "error");

            } else {
                listarNotas(frmNota.listNota);
                frmNota.textTitulo.setText("");
                frmNota.textDescripcion.setText("");
                frmNota.labelMensaje.setText("");

                frmNota.textTitulo.requestFocus();
            }
        } else {

            mostrarMensaje("Escribe el titulo o la descripción.", "error");
        }
    }

    // Eventos de los componentes del Frame -------------------------------------
    
    private void btnAgregarActionPerformed(ActionEvent e) {
        if (e.getSource() == frmNota.btnAgregar) {
            registrarNota();
        }
    }

    private void listaNotaMouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            
            int index = frmNota.listNota.getModel().getElementAt(frmNota.listNota.getSelectedIndex()).getId();
            
            byte option = (byte) JOptionPane.showConfirmDialog(null, "¿Quiere eliminar esta nota?", "Confirmacion", JOptionPane.YES_NO_OPTION);
            
            if (option == 0) {
                if (eliminar(index)) {
                    
                    mostrarMensaje("Nota eliminada", "");
                    listarNotas(frmNota.listNota);
                    
                } else {
                    mostrarMensaje("No se pudo eliminar la nota.", "error");
                }
            }
        }
    }
    
    private void textTituloKeyPressed(java.awt.event.KeyEvent evt) {                                      
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            frmNota.textDescripcion.requestFocus();
        }
    }
    
    private void textDescripcionKeyPressed(java.awt.event.KeyEvent evt) {                                      
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            frmNota.btnAgregar.requestFocus();
        }
    }
    
    private void btnAgregarKeyPressed(java.awt.event.KeyEvent evt) {                                      
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            registrarNota();
        }
    }
    
    /**
     * Declaracion de Eventos ---------------------------------------------------
     */
    private void declareEvents() {
        frmNota.listNota.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                listaNotaMouseClicked(me);
            }
        });
        
        frmNota.btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        
        frmNota.textTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textTituloKeyPressed(evt);
            }
        });
        
        frmNota.textDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textDescripcionKeyPressed(evt);
            }
        });
        
        frmNota.btnAgregar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAgregarKeyPressed(evt);
            }
        });
        
    }

}
