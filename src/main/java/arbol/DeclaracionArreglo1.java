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
public class DeclaracionArreglo1 implements Instruccion {

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
    public DeclaracionArreglo1(Simbolo.Tipo t, LinkedList<String> a, LinkedList<Instruccion> dimensiones, String linea, String columna) {
        tipo = t;
        id = a;
        this.dimensiones = dimensiones;
        this.linea = linea;
        this.columna = columna;
        this.valor = null;
    }

    /**
     * Constructor de la clase para declarar y asignar un ARREGLO
     *
     * @param a identificador de la variable
     * @param t Tipo de variable que sera declarada
     * @param b el valor que se va asignar a la variable
     */
    public DeclaracionArreglo1(LinkedList<String> a, Simbolo.Tipo t, Operacion b) {
        id = a;
        tipo = t;
        this.valor = b;

        /*
        byte[][] edad = new byte[4][3];

-        short ][] edad = new short[4][3];

-        int[][] edad = new int[4][3];

-        long[][] edad = new long[4][3];

-        float[][] estatura = new float[3][2];

-        double[][] estatura = new double[3][2];

-        boolean[][] estado = new boolean[5][4];

-        char[][] sexo = new char[2][1];

-        String[][] nombre = new String[2][1];
         */
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
                ts.add(new Simbolo(in.toString(), tipo, arr.ARREGLO));
            }
        }

        return null;
    }

}
