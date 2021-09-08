package arbol;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Clase que ejecuta las acciones de una instrucción mientras y que implementa
 * la interfaz de instrucción
 * @author James
 */
public class Mientras implements Instruccion,Serializable{
    /**
     * Condición de la sentencia mientras.
     */
    private final Operacion condicion;
    private final LinkedList<Instruccion> listaInstrucciones;
    private final String linea;
    private final String columna;
    /**
     * Constructor de la clase Mientras
     * @param a condición que debe evaluarse para ejecutar el ciclo
     * @param b instrucciones que deben ejecutarse si la condición se cumpliera
     */
    public Mientras(Operacion a, LinkedList<Instruccion> b, String linea, String columna) {
        this.condicion=a;
        this.listaInstrucciones=b;
        this.linea=linea;
        this.columna=columna;
    }

    @Override
    public Object ejecutar(Arbol AST,TablaDeSimbolos ts) {
        
        while((Boolean)condicion.ejecutar(AST,ts)){
            TablaDeSimbolos tablaLocal=new TablaDeSimbolos();
            tablaLocal.addAll(ts);
            for(Instruccion ins:listaInstrucciones){
                ins.ejecutar(AST,tablaLocal);
            }
        }
        return null;
    }   
}