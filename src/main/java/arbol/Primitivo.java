/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arbol;

/**
 * 
 * @author James Gramajo 
 */
public class Primitivo implements Instruccion {
    private Object valor;
    private Operacion.Tipo_dato tipo;
    
    public Primitivo(Operacion.Tipo_dato tipo,Object valor) {
        this.tipo=tipo;
        this.valor=valor;
        
    }

    
    
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        System.out.println("primitivo");
        return valor;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public Operacion.Tipo_dato getTipo() {
        return tipo;
    }

    public void setTipo(Operacion.Tipo_dato tipo) {
        this.tipo = tipo;
    }


    

}
