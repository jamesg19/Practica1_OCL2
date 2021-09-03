package arbol;

import Error.Exeption;
import java.util.LinkedList;

/**
 *
 * @author James
 */
public class Principal implements Instruccion {

   private final LinkedList<Instruccion> listaInstrucciones;

    /**
     * Constructor de la clase Incremento
     *
     * @param id identificador de la variable que se va a incrementar
     */
    public Principal(LinkedList<Instruccion> b ) {
        this.listaInstrucciones=b;
    }


    @Override
    public Object ejecutar(Arbol AST,TablaDeSimbolos ts) {
        
        try{
        TablaDeSimbolos tablaLocal=new TablaDeSimbolos();
        tablaLocal.addAll(ts);
        
        for(Instruccion in: listaInstrucciones){
                //System.out.println(in.ejecutar(tablaLocal).getClass().getSimpleName());
                if(in instanceof Continue){
                    Continue cont=(Continue) in;
                    
                    return new Exeption("SEMANTICO","Continue en Principal",cont.getLinea(),cont.getColumna());
                }
                
                    in.ejecutar(AST,tablaLocal);
            }
        }
        catch(Exception e){
            System.out.println("ERROR EN METODO PRINCIPAL");
            //return new Exeption("SEMANTICO"," LOS PARAMETROS DE REPRODUCIR DEBEN SER TIPO ENTERO \n String nota ,int octava, int tiempo, int canal",linea,columna);
        }
        
        return null;
    }

    
    
    
    
}
