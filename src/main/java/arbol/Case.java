package arbol;

import java.util.LinkedList;

/**
 * Clase que ejecuta las acciones de una instrucción si...entonces y que
 * implementa la interfaz de instrucción
 *
 * @author James
 */
public class Case implements Instruccion {

    private final Operacion condicion;
    private final LinkedList<Instruccion> listaInstrucciones;

    /**
     * Primer constructor de la clase, este se utiliza cuando la instrucción no
     * tiene clausula ELSE.
     *
     * @param a Condición del si..entonces
     * @param b Lista de instrucciones que deberían ejecutarse si la condición
     * se cumple
     */
    public Case(Operacion a, LinkedList<Instruccion> b) {
        condicion = a;
        listaInstrucciones = b;
    }

    @Override
    public Object ejecutar(TablaDeSimbolos ts) {

        TablaDeSimbolos tablaLocal = new TablaDeSimbolos();
        tablaLocal.addAll(ts);
        for (Instruccion in : listaInstrucciones) {
            in.ejecutar(tablaLocal);
            if (in instanceof Salir) {
                return false;
            }
        }

        return true;

    }

    public Operacion getCondicion() {
        return condicion;
    }

    public LinkedList<Instruccion> getListaInstrucciones() {
        return listaInstrucciones;
    }

}
