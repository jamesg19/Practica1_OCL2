package arbol;

import Error.Exeption;
import java.io.Serializable;
import java.util.LinkedList;

/**
 * Clase que ejecuta las acciones de una instrucción mientras y que implementa
 * la interfaz de instrucción
 * @author James
 */
public class Hacer_Mientras implements Instruccion,Serializable{
    /**
     * Condición de la sentencia hacer mientras.
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
    public Hacer_Mientras(Operacion a, LinkedList<Instruccion> b, String linea, String columna) {
        this.condicion=a;
        this.listaInstrucciones=b;
        this.linea=linea;
        this.columna=columna;
    }

    @Override
    public Object ejecutar(Arbol AST,TablaDeSimbolos ts) {
        try{
        do{
            TablaDeSimbolos tablaLocal=new TablaDeSimbolos();
            tablaLocal.addAll(ts);
            for(Instruccion ins:listaInstrucciones){
                ins.ejecutar(AST,tablaLocal);
                if(ins instanceof Exeption){
                    Exeption ext=(Exeption) ins;
                    AST.getERROR().add(ext);
                    return ext;
                }
            }
        }while((Boolean)condicion.ejecutar(AST,ts));
        } catch(Exception e){
            return new Exeption("SEMANTICO"," ERROR EN HCAER MIENTRAS",linea,columna);
        }
        return null;
    }   
}