package arbol;

import Error.Exeption;
import java.util.LinkedList;

/**
 *
 * @author James
 */
public class Llamada_Funcion implements Instruccion {

    private final String nombre;
    private final LinkedList<Valor_Parametro> listaParametros;
    private String fila;
    private String columna;

    /**
     * Constructor de la clase Llamada_funcion
     *
     * @param nombre
     * @param listaParametros
     * @param b
     * @param id identificador de la variable que se va a incrementar
     */
    public Llamada_Funcion(String nombre, LinkedList<Valor_Parametro> listaParametros, String fila, String columna) {
        this.nombre = nombre;
        this.listaParametros = listaParametros;
        this.fila = fila;
        this.columna = columna;

    }

    @Override
    public Object ejecutar(Arbol AST, TablaDeSimbolos ts) {

        try {
            int cantP1;
            int cantP2;
            TablaDeSimbolos tablaLocal = new TablaDeSimbolos();
            tablaLocal.addAll(ts);

            //VERIFICAR SI EXISTE LA FUNCION EL EL NOMBRE DADO
            if (AST.existeFuncion(nombre)) {
                //obtener la cantidad de parametros de la funcion ingresada al AST
                cantP1=AST.cantParametros(nombre);
                //obtiene la cantidad de parametros ingresados en la llamada de funcion
                cantP2=listaParametros.size();
                
                //si la cantidad de parametros es la misma 
                if(cantP1==cantP2){
                    //castea a objeto funcion
                    //AST.getFuncion(nombre);
                    if(AST.getFuncion(nombre) instanceof Funcion){
                       Funcion func=(Funcion) AST.getFuncion(nombre);
                       func.getParametros();
                       
                       for(int i=0;i<cantP1;i++){
                           
                           if(func.getParametros().get(i) instanceof Parametros){
                               Parametros pa=(Parametros) func.getParametros().get(i);
                               Valor_Parametro pa2= (Valor_Parametro) listaParametros.get(i);
                               
                               System.out.println("TIPO INGRESADO FUNC ");
                               System.out.println(pa.getTipo());
                               System.out.println("TIPO INGRESADO LLAMADA ");
                               System.out.println("");
                           }
                           
                           
                       }
                       
                       
                    }
                     
                     
                }else{
                    return new Exeption("","","","");
                }

            } else {
                return new Exeption("SEMANTICO", "LA FUNCION: " + nombre + " NO EXISTE", fila, columna);

            }

        } catch (Exception e) {
            System.out.println("ERROR EN METODO PRINCIPAL");
            //return new Exeption("SEMANTICO"," LOS PARAMETROS DE REPRODUCIR DEBEN SER TIPO ENTERO \n String nota ,int octava, int tiempo, int canal",linea,columna);
        }

        return null;
    }

}
