package arbol;

import Error.Exeption;
import java.util.LinkedList;

/**
 *
 * @author James
 */
public class Funcion implements Instruccion {

    private final LinkedList<Instruccion> listaInstrucciones;
    private final String id;
    private final LinkedList<Instruccion> parametros;
    private final Simbolo.Tipo tipo;

    /**
     * Constructor de la clase Funcion
     *
     * @param id identificador de la variable que se va a incrementar
     */
    public Funcion(Simbolo.Tipo tipo, String id, LinkedList<Instruccion> parametros, LinkedList<Instruccion> b) {
        this.tipo = tipo;
        this.id = id;
        this.parametros = parametros;
        this.listaInstrucciones = b;
    }

    @Override
    public Object ejecutar(Arbol AST, TablaDeSimbolos ts) {

        try {
            // CREA UNA TABLA DE SIMBOLOS LOCAL
            TablaDeSimbolos tablaLocal = new TablaDeSimbolos();
            tablaLocal.addAll(ts);
            //PARAMETROS
            //determina si viene un parametro para ejecutarlo
            if (!parametros.isEmpty()) {
                for (Instruccion in : parametros) {
                    in.ejecutar(AST, tablaLocal);
                }
            }
            //INSTRUCCIONES
            for (Instruccion in : listaInstrucciones) {
                //System.out.println(in.ejecutar(tablaLocal).getClass().getSimpleName());
                in.ejecutar(AST, tablaLocal);
                if (in instanceof Continue) {
                    Continue cont = (Continue) in;

                    return new Exeption("SEMANTICO", "Continue en Funcion ", "", "");
                }
                if (in instanceof Salir) {
                    Salir cont = (Salir) in;

                    return new Exeption("SEMANTICO", "Salir en Funcion ", "", "");
                }

                
            }
        } catch (Exception e) {
            System.out.println("ERROR EN METODO PRINCIPAL");
            //return new Exeption("SEMANTICO"," LOS PARAMETROS DE REPRODUCIR DEBEN SER TIPO ENTERO \n String nota ,int octava, int tiempo, int canal",linea,columna);
        }

        return null;
    }

    public LinkedList<Instruccion> getListaInstrucciones() {
        return listaInstrucciones;
    }

    public String getId() {
        return id;
    }

    public LinkedList<Instruccion> getParametros() {
        return parametros;
    }

    public Simbolo.Tipo getTipo() {
        return tipo;
    }

}
