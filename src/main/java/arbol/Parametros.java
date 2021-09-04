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
public class Parametros implements Instruccion {

    //Identificador de la variable que se va a decrementar.
    private final Simbolo.Tipo tipo;
    private final String id;
    private Object valor;

    /**
     * Constructor de la clase Parametros de funcion
     *
     * @param id identificador de la variable que se va a decrementar
     */
    public Parametros(Simbolo.Tipo tipo, String id) {
        this.tipo=tipo;
        this.id = id;
    }

    /**
     *
     * @param ts tabla de símbolos del ámbito padre de la sentencia asignación.
     * @return el valor anterior al decremento.
     */
    @Override
    public Object ejecutar(Arbol AST,TablaDeSimbolos ts) {
            //declara la variable en el ambito de la funcion
            System.out.println("DECLARA VARIABLE EN LA FUNCION: " + id + " tipo: " + tipo);
            ts.add(new Simbolo(id ,tipo));
            
            
        return null;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public Simbolo.Tipo getTipo() {
        return tipo;
    }

    public String getId() {
        return id;
    }
    
    
    
}
