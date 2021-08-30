/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Error;

/**
 * 
 * @author James Gramajo 
 */
public class Exeption {
    private final String tipo;
    private final String descripcion;
    private final String linea;
    private final String columna;

    public Exeption(String tipo, String descripcion,String linea, String columna) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.linea=linea;
        this.columna=columna;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getLinea() {
        return linea;
    }

    public String getColumna() {
        return columna;
    }

    
    

}
