/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Reproductor;

import arbol.Arbol;
import arbol.Instruccion;
import arbol.TablaDeSimbolos;
import java.io.Serializable;
import java.util.LinkedList;

/**
 * 
 * @author James Gramajo 
 */
public class Pista implements  Serializable {
    private String nombre;

    private LinkedList<String> extiende;
    private LinkedList<Instruccion> listaInstrucciones;
    private String CODIGO;
    private LinkedList<NotasLeidas> SONIDO = new LinkedList<NotasLeidas>();
    
    
    public Pista(String nombre) {

        this.nombre = nombre;
    }

    public Pista(String nombre, LinkedList<String> extiende) {
        this.nombre = nombre;

        this.extiende = extiende;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<String> getExtiende() {
        return extiende;
    }

    public void setExtiende(LinkedList<String> extiende) {
        this.extiende = extiende;
    }



    public LinkedList<Instruccion> getListaInstrucciones() {
        return listaInstrucciones;
    }

    public void setListaInstrucciones(LinkedList<Instruccion> listaInstrucciones) {
        this.listaInstrucciones = listaInstrucciones;
    }

    public String getCODIGO() {
        return CODIGO;
    }

    public void setCODIGO(String CODIGO) {
        this.CODIGO = CODIGO;
    }

    public LinkedList<NotasLeidas> getSONIDO() {
        return SONIDO;
    }

    public void setSONIDO(LinkedList<NotasLeidas> SONIDO) {
        this.SONIDO = SONIDO;
    }
    
    
    
    
    
}
