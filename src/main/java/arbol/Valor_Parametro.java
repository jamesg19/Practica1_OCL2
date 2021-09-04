/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

/**
 *
 * @author James
 */
public class Valor_Parametro implements Instruccion {

    //Identificador de la variable que se va a decrementar.
    private final Operacion valor;
    private final String fila;
    private final String columna;
    private String tipo_parametro;

    /**
     * Constructor de la clase Parametros de funcion
     *
     * @param id identificador de la variable que se va a decrementar
     */
    public Valor_Parametro(Operacion valor, String fila, String columna) {
        this.valor = valor;
        this.fila = fila;
        this.columna = columna;
    }

    /**
     *
     * @param ts tabla de símbolos del ámbito padre de la sentencia asignación.
     * @return el valor anterior al decremento.
     */
    @Override
    public Object ejecutar(Arbol AST, TablaDeSimbolos ts) {
        try {
            //ejecutamos el valor
            Object val = ((Object) valor.ejecutar(AST, ts));

            if (val.getClass().getSimpleName().toString().equals("Integer")) {
                tipo_parametro="Integer";
            }
            else if (val.getClass().getSimpleName().toString().equals("Char")) {
                tipo_parametro="Char";
            }
            else if (val.getClass().getSimpleName().toString().equals("Boolean")) {
                tipo_parametro="Boolean";
            }
            else if (val.getClass().getSimpleName().toString().equals("String")) {
                tipo_parametro="String";
            }
            else if (val.getClass().getSimpleName().toString().equals("Double")) {
                tipo_parametro="Double";
            }else{
                tipo_parametro="Arreglo";
            }
            // valor.ejecutar(AST, ts);
            return valor.ejecutar(AST, ts);

        } catch (Exception e) {
            System.out.println("ERROR EN PARAMETRO DE FUNCION");
        }

        return null;
    }

    public Operacion getValor() {
        return valor;
    }

    public String getFila() {
        return fila;
    }

    public String getColumna() {
        return columna;
    }

    public String getTipo_parametro() {
        return tipo_parametro;
    }

    public void setTipo_parametro(String tipo_parametro) {
        this.tipo_parametro = tipo_parametro;
    }

}
