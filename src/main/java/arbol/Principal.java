package arbol;

import Error.Exeption;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author James
 */
public class Principal implements Instruccion,Serializable {

   private final LinkedList<Instruccion> listaInstrucciones;
   private final String linea;
   private final String columna;

    /**
     * Constructor de la clase Incremento
     *
     * @param id identificador de la variable que se va a incrementar
     */
    public Principal(LinkedList<Instruccion> b ,String linea, String columna) {
        this.listaInstrucciones=b;
        this.linea=linea;
        this.columna=columna;
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
                    AST.getERROR().add(new Exeption("SEMANTICO","Continue en Principal",cont.getLinea(),cont.getColumna()));
                    return new Exeption("SEMANTICO","Continue en Principal",cont.getLinea(),cont.getColumna());
                }
                if(in instanceof Salir){
                    Salir cont=(Salir) in;
                     AST.getERROR().add(new Exeption("SEMANTICO","Salir en Principal",cont.getLinea(),cont.getColumna()));
                    return new Exeption("SEMANTICO","Salir en Principal",cont.getLinea(),cont.getColumna());
                }
                if(in instanceof Exeption){
                    Exeption cont=(Exeption) in;
                     AST.getERROR().add(new Exeption("SEMANTICO","Salir en Principal",cont.getLinea(),cont.getColumna()));
                    return new Exeption("SEMANTICO","Salir en Principal",cont.getLinea(),cont.getColumna());
                }
                if(in instanceof Principal){
                    Principal cont=(Principal) in;
                     AST.getERROR().add(new Exeption("SEMANTICO","Salir en Principal",cont.getLinea(),cont.getColumna()));
                    return new Exeption("SEMANTICO","Salir en Principal",cont.getLinea(),cont.getColumna());
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

    public String getLinea() {
        return linea;
    }

    public String getColumna() {
        return columna;
    }

    
    
    
    
}
