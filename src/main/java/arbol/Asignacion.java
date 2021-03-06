/*
 * Ejemplo desarrollado por Erick Navarro
 * Blog: e-navarro.blogspot.com
 * Septiembre - 2015
 */

package arbol;

import Error.Exeption;
import java.io.Serializable;
import java.util.LinkedList;

/**
 * Clase que ejecuta las acciones de una instrucción de asignación y que implementa
 * la interfaz de instrucción
 * @author James
 */
public class Asignacion implements Instruccion,Serializable{
    /**
     * Identificador de la variable a la que se le asigna el valor.
     */
    public LinkedList<String> id;
    /**
     * Valor que se le asigna a la variable.
     */
    private final Operacion valor;
    /**
     * Constructor de la clase asignación
     * @param a identificador de la variable
     * @param b valor que se le va a asignar
     */
    public Asignacion(LinkedList<String> a, Operacion b) {
        this.id=a;
        this.valor=b;
    }
    /**
     * Método que ejecuta la accion de asignar un valor, es una sobreescritura del 
     * método ejecutar que se debe programar por la implementación de la interfaz
     * instrucción
     * @param ts tabla de símbolos del ámbito padre de la sentencia asignación
     * @return En este caso retorna nulo porque no es una sentencia que genere un valor.
     */
    @Override
    public Object ejecutar(Arbol AST,TablaDeSimbolos ts) {
        for(String in : id){
            if(valor.ejecutar(AST,ts) instanceof Exeption){
                Exeption ex=(Exeption) valor.ejecutar(AST,ts);
                return ex;
            }else{
            System.out.println("ASIGNACION DE VARIABLE ID: "+in.toString()+" valor: "+valor.ejecutar(AST,ts));
            ts.setValor(in.toString(),valor.ejecutar(AST,ts));
            }
        }
        
        return null;
    }
    
}
