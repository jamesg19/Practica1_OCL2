package arbol;

import Error.Exeption;
import java.util.LinkedList;

/**
 *
 * @author James
 */
public class Arbol implements Instruccion {

   private  LinkedList<Instruccion> FUNCIONES;

    /**
     * Constructor de la ARBOL
     *
     * @param id identificador de la variable que se va a incrementar
     */
    public Arbol(LinkedList<Instruccion> b ) {
        this.FUNCIONES=b;
    }

    public Arbol() {
    }


    @Override
    public Object ejecutar(Arbol AST,TablaDeSimbolos ts) {

        return null;
    }

    public LinkedList<Instruccion> getFUNCIONES() {
        return FUNCIONES;
    }

    public void setFUNCIONES(LinkedList<Instruccion> FUNCIONES) {
        this.FUNCIONES = FUNCIONES;
    }

    
    
    
    
}
