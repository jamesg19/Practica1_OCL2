package arbol;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Clase que ejecuta las acciones de una instrucción Para con declaracion y que implementa
 * la interfaz de instrucción
 * @author James
 */
public class Para1 implements Instruccion,Serializable{
    /**
     * Condición de la sentencia mientras.
     */
    private final Operacion condicion;
    private boolean hayContinue=false;
    /**hayCOntinue
     * Lista de las instrucciones que deben ejecutarse si la condición se cumple.
     */
    private final LinkedList<Instruccion> listaInstrucciones;
    private final Instruccion declaracion;
    private final Instruccion incremental;
    /**
     * Constructor de la clase Mientras
     * @param a condición que debe evaluarse para ejecutar el ciclo
     * @param b instrucciones que deben ejecutarse si la condición se cumpliera
     */
    public Para1(Instruccion a,Operacion b, Instruccion c, LinkedList<Instruccion> d) {
        this.declaracion=a;
        this.condicion=b;
        this.incremental=c;
        this.listaInstrucciones=d;
    }

    @Override
    public Object ejecutar(Arbol AST,TablaDeSimbolos ts) {
        //creacion del ambito  del FOR(PARA)
        TablaDeSimbolos tablaLocal1=new TablaDeSimbolos();
        tablaLocal1.addAll(ts);
        //realiza la declaracion
        declaracion.ejecutar(AST,tablaLocal1);
        if(declaracion instanceof Declaracion){
            Declaracion dec = (Declaracion) declaracion;
            dec.id.get(0);
        }
        
        //si la condicion es verdadera ejecuta las instrucciones
        while((Boolean)condicion.ejecutar(AST,tablaLocal1)){
            
            TablaDeSimbolos tablaLocal2=new TablaDeSimbolos();
            tablaLocal2.addAll(tablaLocal1);
            for(Instruccion ins:listaInstrucciones){
                
                Object a=ins.ejecutar(AST,tablaLocal2);
                if(a instanceof Salir){
                    
                } 
                if(a instanceof Continue){
                    System.out.println("HAY CONTINUE.....................");
                    hayContinue=true;
                    incremental.ejecutar(AST,tablaLocal2);
                    break;

                }
                
                if(hayContinue==true){
                    //ins.ejecutar(tablaLocal2);
                }
            }
            if(hayContinue==true){
                hayContinue=false;
                continue;
            }
            //ejecuta el incremento/decremento
            incremental.ejecutar(AST,tablaLocal2);
            
        }
        return null;
    }   
}