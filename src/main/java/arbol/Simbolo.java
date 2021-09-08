
package arbol;

import java.io.Serializable;

/**
 * Clase símbolo, que es un nodo de la tabla de símbolos, estos símbolos son 
 * variables con su valor, identificador y tipo, actualmente todas las variables 
 * son de tipo número, pero se colocó la variable tipo por si se quisiera ampliar
 * el lenguaje y agregar más tipos.
 * @author James
 */
public class Simbolo implements Serializable{
    private final Tipo tipo;
    private final String id;
    private Object valor;  
    private ARREGLO arr;
    private Object arreglo;
    private int CANT_DIMENSION=0;
    /**
     * Constructor de la clase Símbolo.
     * @param id identificador de la variable que se desea almacenar
     * @param tipo tipo de la variable que se desea almacenar
     */
    public Simbolo(String id, Tipo tipo) {
        this.tipo = tipo;
        this.id = id;
        this.arr=null;
    }
    /**
     * PRIMER CONSTRUCTOR DE ARREGLO EN DECLARACION-DIMENSION
     * keep VAR TIPO ARREGLO ID [][]
     * @param id
     * @param tipo
     * @param arr
     * @param c 
     */
    public Simbolo(String id, Tipo tipo, ARREGLO  arr, int c) {
        this.tipo = tipo;
        this.id = id;
        this.arr=arr;
        this.CANT_DIMENSION=c;
    }
    /**
     * PRIMER CONSTRUCTOR DE ARREGLO EN DECLARACION-DIMENSION
     * keep VAR TIPO ARREGLO ID 
     * @param id
     * @param tipo
     * @param arr 
     */
    public Simbolo(String id, Tipo tipo, ARREGLO  arr) {
        this.tipo = tipo;
        this.id = id;
        this.arr=arr;
    }

    /**
     * Método que devuelve el identificador de la variable almacenada en el símbolo.
     * @return Identificador de la variable
     */
    public String getId() {
        return id.toString();
    }
    /**
     * Método que devuelve el valor que almacena la variable.
     * @return Valor de la variable
     */
    public Object getValor() {
        return valor;
    }
    /**
     * Método que asigna un nuevo valor a la variable.
     * @param v Nuevo valor para la variable.
     */
    void setValor(Object v) {
        valor=v;
    }

    public Tipo getTipo() {
        return tipo;
    }
    
    /**
     * Enumeración que lista todos los tipos de variable reconocidos en el lenguaje.
     */
    public static enum Tipo{
        NUMERO,
        CADENA,
        DECIMAL,
        BOOLEAN,
        CARACTER,
        
    }
    public static enum ARREGLO{
        ARREGLO
    }
}
