package arbol;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Clase que ejecuta las acciones de una instrucción de declaración y que
 * implementa la interfaz de instrucción
 *
 * @author James
 */
public class Declaracion implements Instruccion {

    /**
     * Identificador de la variable que será declarada.
     */
    public LinkedList<String> id;
    private final Operacion valor;
    /**
     * Tipo de la variable que será declarada.
     */
    Simbolo.Tipo tipo;

    /**
     * Constructor de la clase
     *
     * @param a Identificador de la variable que será declarada
     * @param t Tipo de la clase que será declarada
     */
    public Declaracion(LinkedList<String> a, Simbolo.Tipo t) {
        id = a;
        tipo = t;
        this.valor = null;
    }

    /**
     * Constructor de la clase para declarar y asignar una variable
     *
     * @param a identificador de la variable
     * @param t Tipo de variable que sera declarada
     * @param b el valor que se va asignar a la variable
     */
    public Declaracion(LinkedList<String> a, Simbolo.Tipo t, Operacion b) {
        id = a;
        tipo = t;
        this.valor = b;
    }

    /**
     * Método que ejecuta la accion de declarar una variable, es una
     * sobreescritura del método ejecutar que se debe programar por la
     * implementación de la interfaz instrucción
     *
     * @param ts Tabla de símbolos del ámbito padre.
     * @return No retorna nada porque no es una sentencia que genere un valor.
     */
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        // verifica si no viene algun valor para asignar a las variables
        if (valor == null) {
            for (String in : id) {
                System.out.println("DECLARA VARIABLE: " + in.toString() + " tipo: " + tipo.toString());
                ts.add(new Simbolo(in.toString(), tipo));
            }
        } //de lo contrario hay que declarar y asignar valores
        else {
            for (String in : id) {
                //DECLARA LAS VARIABLE
                ts.add(new Simbolo(in.toString(), tipo));
                String tipovar=ts.getTipo(in).toString();
                //ASIGNA EL VALOR A LA VARIABLE
                ts.setValor(in.toString(), valor.ejecutar(ts));
                //informa en consola
                System.out.println("DECLARACION-ASIGNACION DE VARIABLES ID: " + in.toString() + " valor: " + valor.ejecutar(ts));
            }
        }

        return null;
    }

}