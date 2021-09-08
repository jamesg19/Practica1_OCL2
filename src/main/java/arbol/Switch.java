package arbol;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Clase que ejecuta las acciones de una instrucción si...entonces y que
 * implementa la interfaz de instrucción
 *
 * @author James
 */
public class Switch implements Instruccion,Serializable {

    private Operacion variable;
    private Operacion variableSwitch;
    private final LinkedList<Instruccion> listaInstrucciones;
    private LinkedList<Instruccion> listaCases;
    private LinkedList<Instruccion> listaInsDefault;
    private String VariableGlobal;

    /**
     * Primer constructor de la clase, este se utiliza cuando la instrucción
     * tiene clausula IF (ELSE IF/ ELSE).
     *
     * @param a Condición del si..entonces
     * @param b Lista de instrucciones que deberían ejecutarse si la condición
     * se cumple
     * @param l Lista de instrucciones que deberían ejecutarse si la condición
     * ElSE IF se cumple
     * @param c Lista de instrucciones que deberían ejecutarse si la condición
     * no se cumple
     */
    public Switch(Operacion a, LinkedList<Instruccion> b, LinkedList<Instruccion> l, LinkedList<Instruccion> c) {
        variableSwitch = a;
        variable = null;
        listaInstrucciones = b;
        listaCases = l;

        listaInsDefault = c;
    }

    /**
     * Método que ejecuta la instrucción si..entonces, es una sobreescritura del
     * método ejecutar que se debe programar por la implementación de la
     * interfaz instrucción
     *
     * @param ts tabla de símbolos del ámbito padre de la sentencia.
     * @return Estra instrucción retorna nulo porque no produce ningún valor en
     * su ejecución
     */
    @Override
    public Object ejecutar(Arbol AST,TablaDeSimbolos ts) {
        System.out.println("ENTRA AL SWITCH");
        boolean bandera = false;
        //verifica que venga mas de un Case en el Switch
        if (listaCases != null) {
            
            //obtiene toda la lista de Case
            for (Instruccion in : listaCases) {
                //verifica que sea una instancia de Case
                if (in instanceof Case) {
                    //castea el objeto a case
                    Case caso = (Case) in;
                    //verifica que la condicion se cumpla
                    String aa=caso.getCondicion().ejecutar(AST,ts)+"";
                    String bb=variableSwitch.ejecutar(AST,ts)+"";

                    if (aa.equals(bb)) {
                        //ejecuta las instrucciones 
                        if ((boolean) in.ejecutar(AST,ts)) {
                            //verifica si viene la instruccion Salir
                            bandera = false;
//                            break;
                        }else{
                            //si la ejecucion devuelve un false es porque viene SALIR
                            bandera=true;
                            break;
                        }
                    }

                }

            }
        }

        if (listaInsDefault != null && !bandera) {
            TablaDeSimbolos tablaLocal = new TablaDeSimbolos();
            tablaLocal.addAll(ts);
            for (Instruccion in : listaInsDefault) {
                in.ejecutar(AST,tablaLocal);
            }
        }

        return false;
    }

    public Operacion getVariable() {
        return variable;
    }

    public void setVariable(Operacion variable) {
        this.variable = variable;
    }

    public Operacion getVariableSwitch() {
        return variableSwitch;
    }

    public void setVariableSwitch(Operacion variableSwitch) {
        this.variableSwitch = variableSwitch;
    }

    public LinkedList<Instruccion> getListaCases() {
        return listaCases;
    }

    public void setListaCases(LinkedList<Instruccion> listaCases) {
        this.listaCases = listaCases;
    }

    public LinkedList<Instruccion> getListaInsDefault() {
        return listaInsDefault;
    }

    public void setListaInsDefault(LinkedList<Instruccion> listaInsDefault) {
        this.listaInsDefault = listaInsDefault;
    }

}
