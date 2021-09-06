package arbol;

import Error.Exeption;
import java.util.LinkedList;

/**
 *
 * @author James
 */
public class Arbol implements Instruccion {

   private  LinkedList<Instruccion> FUNCIONES;
   LinkedList<Exeption> ERROR = new LinkedList<Exeption>();

    /**
     * Constructor de la ARBOL
     *
     * @param id identificador de la variable que se va a incrementar
     */
    public Arbol(LinkedList<Instruccion> b ) {
        this.FUNCIONES=b;
    }

    public Arbol() {
    }
    

    @Override
    public Object ejecutar(Arbol AST,TablaDeSimbolos ts) {

        return null;
    }
    //METODO PARA VERIFICAR SI EXISTE LA FUNCION
    public boolean existeFuncion(String id){
        boolean flag;
        
         for(Instruccion ins: FUNCIONES){
            //VERIFICA QUE SEA UNA INSTANCIA DE FUNCION
            if(ins instanceof Funcion){
                //castea a funcion
                Funcion func=(Funcion) ins;
                
                //OBTIENE EL NOMBRE DE LA FUNCION ENCONTRADA EN LA LISTA DEL AST
                //Y COMPRA QUE SEAN IGUALES
                if( func.getId().equals(id) ){
                    flag=true;
                    return true;
                } 
            }  
        }
         
        flag=false;
        return flag;
    }
     //METODO PARA VERIFICAR la cantidad de parametros dela funcion encontrada
    public int cantParametros(String id){
        int cant=0;
        
         for(Instruccion ins: FUNCIONES){
            //VERIFICA QUE SEA UNA INSTANCIA DE FUNCION
            if(ins instanceof Funcion){
                //castea a funcion
                Funcion func=(Funcion) ins;
                
                //OBTIENE EL NOMBRE DE LA FUNCION ENCONTRADA EN LA LISTA DEL AST
                //Y COMPRA QUE SEAN IGUALES
                if( func.getId().equals(id) ){
                    try{        
                    cant=func.getParametros().size();
                    return cant;
                    } catch(Exception e){
                        return cant;
                    }
                } 
            }  
        }
       
        return cant;
    }
    public Instruccion getFuncion(String id){
        for(Instruccion ins: FUNCIONES){
            //VERIFICA QUE SEA UNA INSTANCIA DE FUNCION
            if(ins instanceof Funcion){
                
                //castea a funcion
                Funcion func=(Funcion) ins;
                
                //OBTIENE EL NOMBRE DE LA FUNCION ENCONTRADA EN LA LISTA DEL AST
                //Y COMPRA QUE SEAN IGUALES
                if( func.getId().equals(id) ){
                    return ins;
                } 
            }  
        }
        return null;
    }

    public LinkedList<Instruccion> getFUNCIONES() {
        return FUNCIONES;
    }

    public void setFUNCIONES(LinkedList<Instruccion> FUNCIONES) {
        this.FUNCIONES = FUNCIONES;
    }

    public LinkedList<Exeption> getERROR() {
        return ERROR;
    }

    public void setERROR(LinkedList<Exeption> ERROR) {
        this.ERROR = ERROR;
    }
    
    
    
    
    
}
