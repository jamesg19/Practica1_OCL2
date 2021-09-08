package arbol;

import java.io.Serializable;


public class Salir implements Instruccion,Serializable{
    private String linea;
    private String columna;

    public Salir(String linea, String columna) {
        this.linea=linea;
        this.columna=columna;
    }
    /**
     * METODO SALIR
     * @return En este caso retorna nulo porque no es una sentencia que genere un valor.
     */
    @Override
    public Object ejecutar(Arbol AST,TablaDeSimbolos ts) {
       
        return null;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }
    
}
