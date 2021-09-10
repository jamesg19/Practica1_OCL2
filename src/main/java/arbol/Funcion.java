package arbol;

import Error.Exeption;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author James
 */
public class Funcion implements Instruccion,Serializable {

    private final LinkedList<Instruccion> listaInstrucciones;
    private final String id;
    private final LinkedList<Instruccion> parametros;
    private final Simbolo.Tipo tipo;
    private Operacion retorna;

    /**
     * Constructor de la clase Funcion
     *
     * @param tipo
     * @param id identificador de la variable que se va a incrementar
     * @param parametros
     * @param b
     */
    public Funcion(Simbolo.Tipo tipo, String id, LinkedList<Instruccion> parametros, LinkedList<Instruccion> b) {
        this.tipo = tipo;
        this.id = id;
        this.parametros = parametros;
        this.listaInstrucciones = b;
    }

    @Override
    public Object ejecutar(Arbol AST, TablaDeSimbolos ts) {
        boolean hayRetorna=false;
        try {
            // CREA UNA TABLA DE SIMBOLOS LOCAL
            //PARAMETROS
            //determina si viene un parametro para ejecutarlo
            try{
            if (!parametros.isEmpty()) {
                for (Instruccion in : parametros) {
                    in.ejecutar(AST, ts);
                }
            }
            } catch(Exception e){
                
            }
            //INSTRUCCIONES
            for (Instruccion in : listaInstrucciones) {
                //System.out.println(in.ejecutar(tablaLocal).getClass().getSimpleName());
                
                
                if (in instanceof Continue) {
                    Continue cont = (Continue) in;
                    AST.getERROR().add(new Exeption("SEMANTICO", "Continue en Funcion ", cont.getLinea(), cont.getColumna()));
                    return new Exeption("SEMANTICO", "Continue en Funcion ", cont.getLinea(), cont.getColumna());
                }
                if (in instanceof Salir) {
                    
                    Salir cont = (Salir) in;
                     AST.getERROR().add(new Exeption("SEMANTICO", "Salir en Funcion ", cont.getLinea(), cont.getColumna()));
                    return new Exeption("SEMANTICO", "Salir en Funcion ", cont.getLinea(), cont.getColumna());
                }
                if (in instanceof Retorna) {
                    hayRetorna=true;
                    Retorna cont = (Retorna) in;
                    retorna=cont.getValorReturn();
                    return retorna;
                }
                in.ejecutar(AST, ts);
                if (in instanceof Exeption) {
                    Exeption ext = (Exeption) in;
                     AST.getERROR().add(ext);
                    System.out.println("ERROR SEMANTICO ");;
                    System.out.println(ext.getDescripcion() + " linea" + ext.getLinea() + " columna " + ext.getColumna());
                    return ext;
                }

                
            }
            if(hayRetorna){
                
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("ERROR EN FUNCION");
            AST.getERROR().add(new Exeption("SEMANTICO"," LOS PARAMETROS DE REPRODUCIR DEBEN SER TIPO ENTERO \n String nota ,int octava, int tiempo, int canal","",""));
            return new Exeption("SEMANTICO"," LOS PARAMETROS DE REPRODUCIR DEBEN SER TIPO ENTERO \n String nota ,int octava, int tiempo, int canal","","");
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

    public Operacion getRetorna() {
        return retorna;
    }

    public void setRetorna(Operacion retorna) {
        this.retorna = retorna;
    }

}
