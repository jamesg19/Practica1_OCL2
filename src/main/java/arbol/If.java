package arbol;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Clase que ejecuta las acciones de una instrucción si...entonces y que implementa
 * la interfaz de instrucción
 * @author James
 */
public class If implements Instruccion,Serializable{

    private final Operacion condicion;
    private final LinkedList<Instruccion> listaInstrucciones;
    private LinkedList<Instruccion> listaElseIfInstrucciones;
    private LinkedList<Instruccion> listaInsElse;
    /**
     * Primer constructor de la clase, este se utiliza cuando la instrucción no 
     * tiene clausula ELSE.
     * @param a Condición del si..entonces
     * @param b Lista de instrucciones que deberían ejecutarse si la condición se cumple
     */
    public If(Operacion a, LinkedList<Instruccion> b) {
        condicion=a;
        listaInstrucciones=b;
    }
    /**
     * Segundo constructor de la clase, este se utiliza cuando la instrucción tiene
     * clausula ELSE.
     * @param a Condición del si..entonces
     * @param b Lista de instrucciones que deberían ejecutarse si la condición se cumple
     * @param c Lista de instrucciones que deberían ejecutarse si la condición no se cumple
     */
    public If(Operacion a, LinkedList<Instruccion> b, LinkedList<Instruccion> c) {
        condicion=a;
        listaInstrucciones=b;
        listaInsElse=c;
    }
    /**
     * Tercer constructor de la clase, este se utiliza cuando la instrucción tiene
     * clausula IF (ELSE IF/ ELSE).
     * @param a Condición del si..entonces
     * @param b Lista de instrucciones que deberían ejecutarse si la condición se cumple
     * @param l Lista de instrucciones que deberían ejecutarse si la condición ElSE IF se cumple
     * @param c Lista de instrucciones que deberían ejecutarse si la condición no se cumple
     */
    public If(Operacion a, LinkedList<Instruccion> b, LinkedList<Instruccion> l, LinkedList<Instruccion> c) {
        condicion=a;
        listaInstrucciones=b;
        listaElseIfInstrucciones = l;
        listaInsElse=c;
    }
    /**
     * Método que ejecuta la instrucción si..entonces, es una sobreescritura del 
     * método ejecutar que se debe programar por la implementación de la interfaz
     * instrucción
     * @param ts tabla de símbolos del ámbito padre de la sentencia.
     * @return Estra instrucción retorna nulo porque no produce ningún valor en 
     * su ejecución
     */
    @Override
    public Object ejecutar(Arbol AST,TablaDeSimbolos ts) {
        // si la condicion del if es VERDADERA
        //try{
        boolean FLAG=Boolean.parseBoolean(condicion.ejecutar(AST,ts).toString());
        
        
        if(FLAG){
            //crea un ambito para instrucciones dentro del IF
            TablaDeSimbolos tablaLocal=new TablaDeSimbolos();
            tablaLocal.addAll(ts);
            //ejecuta las instrucciones dentro del IF
            for(Instruccion in: listaInstrucciones){
                //System.out.println(in.ejecutar(tablaLocal).getClass().getSimpleName());
                if(in instanceof Continue){
                    
                    return new Continue();
                }
                
                    in.ejecutar(AST,tablaLocal);
                
                
                
            }
            return true;
          
        }
        // SI LA CONDICION ES FALSE DEL IF
        else{
            boolean bandera = false;
            //ejecuta las instrucciones de los sino si
            if(listaElseIfInstrucciones != null){
                //lee la lista de instrucciones
                for(Instruccion in: listaElseIfInstrucciones){
                    if(in instanceof Continue){
                    
                    return new Continue();
                }
                    if((boolean)in.ejecutar(AST,ts)){
                        bandera = true;
                        break;
                    }
                }
            }
            //ejecuta la instruccion DEFAULT
            if(listaInsElse!=null && !bandera){
                TablaDeSimbolos tablaLocal=new TablaDeSimbolos();
                tablaLocal.addAll(ts);
                for(Instruccion in: listaInsElse){
                    if(in instanceof Continue){
                    
                    return new Continue();
                }
                    in.ejecutar(AST,tablaLocal);
                }            
            }
        }

        return false;
    }
}
