package arbol;

import java.io.Serializable;


public class Continue implements Instruccion,Serializable{
    private String linea;
    private String columna;

    public Continue(String linea, String columna) {
        this.linea=linea;
        this.columna=columna;
    }

    public Continue() {
    }
    
    /**
     * METODO CONTINUE
     * @return En este caso retorna nulo porque no es una sentencia que genere un valor.
     */
    @Override
    public Object ejecutar(Arbol AST,TablaDeSimbolos ts) {
        
        return null;
    }

    public String getLinea() {
        return linea;
    }

    public String getColumna() {
        return columna;
    }
    
}
