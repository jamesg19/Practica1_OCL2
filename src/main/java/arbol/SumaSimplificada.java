/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

import Error.Exeption;
import java.io.Serializable;

/**
 *
 * @author James
 */
public class SumaSimplificada implements Instruccion,Serializable {

    //Identificador de la variable que se va a incrementar.
    private final String id;
    private final Operacion operacion;

    /**
     * Constructor de la clase Incremento
     *
     * @param id identificador de la variable que se va a incrementar
     */
    public SumaSimplificada(String id, Operacion b) {
        this.id = id;
        this.operacion = b;
    }

    /**
     * Metodo que ejecuta el incremento de una variables mediante el incremento
     * postfijo, por lo tanto incrementa la variable en 1 y retorna el valor
     * antiguo.
     *
     * @param ts tabla de símbolos del ámbito padre de la sentencia asignación.
     * @return el valor anterior al incremento.
     */
    @Override
    public Object ejecutar(Arbol AST,TablaDeSimbolos ts) {
        try{
        Object tmp = ts.getValor(id.toString());
        //System.out.println("SUMA SIMPLIFICADA: ID: " + id + " valor actual: " + (Double) tmp + " sumar " + operacion.ejecutar(ts));

        String tipo = ts.getTipo(id).toString();

        if (tipo.equals("CADENA")) {
            ts.setValor(id, (tmp.toString() + operacion.ejecutar(AST,ts).toString()));

        } else if (tipo.equals("CARACTER")) {
            ts.setValor(id, ((Integer) tmp + operacion.ejecutar(AST,ts).toString()));

        } else if (tipo.equals("NUMERO")) {
            ts.setValor(id, ((Integer) tmp + (Integer) operacion.ejecutar(AST,ts)));

        } else if (tipo.equals("DECIMAL")) {
            ts.setValor(id, ((Double) tmp + (Double) operacion.ejecutar(AST,ts)));
        } else {

        }

//        ts.setValor(id,((Double)tmp + operacion.ejecutar(ts)));
        return tmp;
    }catch(Exception e){
            System.out.println("Semantico "+"la variable: "+id.toString()+" para suma simplificada no existe");
            AST.getERROR().add(new Exeption("Semantico","la variable: "+id.toString()+" no existe","",""));
        return new Exeption("Semantico","la variable: "+id.toString()+" no existe","","");
    }
    }
}
