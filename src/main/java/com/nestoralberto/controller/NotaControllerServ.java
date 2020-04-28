
package com.nestoralberto.controller;

import com.nestoralberto.model.Nota;
import com.nestoralberto.service.INota;
import com.nestoralberto.service.impl.NotaImpl;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author albertobq
 */
public class NotaControllerServ {
    
    INota service;
    
    // Metodos sin dependencias de componentes Frame
    public boolean registrar(Nota obj) {
        boolean res = false;
        service = new NotaImpl();
        try {
            res = service.registrar(obj);
        } catch (Exception ex) {
            Logger.getLogger(ex.getMessage());
        }
        return res;
    }
    
    public boolean modificar(Nota obj) {
        boolean res = false;
        service = new NotaImpl();
        try {
            res = service.modificar(obj);
        } catch (Exception ex) {
            Logger.getLogger(ex.getMessage());
        }
        return res;
    }
    
    public List<Nota> listar() {
        service = new NotaImpl();
        List<Nota> lista = null;
        try {
            lista = service.listar();
        } catch (Exception ex) {
            Logger.getLogger(ex.getMessage());
        }
        return lista;
    }
    
    public Nota listarPorId(int id) {
        service = new NotaImpl();
        Nota obj = null;
        try {
            obj = service.listarPorId(id);
        } catch (Exception ex) {
            Logger.getLogger(ex.getMessage());
        }
        return obj;
    }
    
    public boolean eliminar(int id) {
        service = new NotaImpl();
        boolean res = false;
        try {
            res = service.eliminar(id);
        } catch (Exception ex) {
            Logger.getLogger(ex.getMessage());
        }
        return res;
    }
}
