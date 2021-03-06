package arbol;

import java.io.Serializable;


public class Retorna implements Instruccion,Serializable{
    private String linea;
    private String columna;
    private final Operacion a;

    public Retorna(Operacion a, String linea, String columna) {
        this.a=a;
        this.linea=linea;
        this.columna=columna;
    }
    /**
     * METODO RETORNA
     * @return En este caso retorna un valor;
     */
    @Override
    public Object ejecutar(Arbol AST,TablaDeSimbolos ts) {
        
        return a;
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

    public Operacion getValorReturn() {
        return a;
    }
    
}
