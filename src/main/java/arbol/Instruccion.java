package arbol;

/**
 *
 * @author James
 */
public interface Instruccion {
    /**
     * Método que ejecuta la accion propia de la instrucción que se implemente.
     * @param ts Tabla de símbolos del ámbito padre de la sentencia.
     * @return Retorna nulo cuando la sentencia no produce valor al ser ejecutada, 
     * pero cuando se trata de una operación aritmética, una concatenación o una 
     * operación relacional, entonces se devuelve el valor que la operación da como 
     * resultado.
     */
    public Object ejecutar(TablaDeSimbolos ts);
}
