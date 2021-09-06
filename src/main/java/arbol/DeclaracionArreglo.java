package arbol;

import Error.Exeption;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Clase que ejecuta las acciones de una instrucción de declaración y que
 * implementa la interfaz de instrucción
 *
 * @author James
 */
public class DeclaracionArreglo implements Instruccion {

    private LinkedList<String> id;
    private final Operacion valor;
    private LinkedList<Instruccion> dimensiones;
    private String linea;
    private String columna;
    /**
     * Tipo del arreglo que será declarado.
     */
    Simbolo.Tipo tipo;
    Simbolo.ARREGLO arr;

    /**
     * Constructor de la clase DeclaracionArreglo
     *
     * @param a Identificador de la variable que será declarada
     * @param t Tipo de la clase que será declarada
     */
    public DeclaracionArreglo(Simbolo.Tipo t, LinkedList<String> a, LinkedList<Instruccion> dimensiones, String linea, String columna) {
        tipo = t;
        id = a;
        this.dimensiones = dimensiones;
        this.linea = linea;
        this.columna = columna;
        this.valor = null;
    }


    @Override
    public Object ejecutar(Arbol AST, TablaDeSimbolos ts) {
        //DECLARACION ARREGLO
        //verificar cantidad de dimensiones
        int cantDimensiones = dimensiones.size();
        if (valor == null) {
            //busca si existela variable
            for (String in : id) {

                //buscar si existe la variable
                if (ts.existeVariable(in.toString())) {
                    return new Exeption("SEMANTICO", " EL ID DE ARREGLO: " + in.toString() + " YA EXISTE", linea, columna);
                }
            }
            //declara la variable
            for (String in : id) {
                System.out.println("DECLARA ARREGLO: " + in.toString() + " tipo: " + tipo.toString());
                ts.add(new Simbolo(in.toString(), tipo, arr.ARREGLO,cantDimensiones));
            }
        }

        return null;
    }

}
