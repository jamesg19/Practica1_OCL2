package arbol;


import Error.Exeption;
import java.io.Serializable;
import java.util.LinkedList;


public class TablaDeSimbolos extends LinkedList<Simbolo> implements Serializable{

    LinkedList<Instruccion> FUNCIONES;
    
    public TablaDeSimbolos() {
        super();
    }
    /**
     * Método que busca una variable en la tabla de símbolos y devuelve su valor.
     * @param id Identificador de la variable que quiere buscarse
     * @return Valor de la variable que se buscaba, si no existe se devuelve nulo
     */
    Object getValor(String id) {
        
        for(Simbolo s:this){
            if(s.getId().equals(id)){
                try{
                Object va=s.getValor();
                return s.getValor();
                }catch(Exception e){
                    System.out.println("LA VARIABLE "+id+" ES NULAA........................ ");
                    
                    return new Exeption("SEMANTICO"," la variable "+id+" es Nula","","");
                }
                //return s.getValor();
            }
        }
        System.out.println("La variable "+id+" no existe en este ámbito.");
        return "Desconocido";
    }
    
    /**
     * Método que asigna un valor a una variable específica, si no la encuentra 
     * no realiza la asignación y despliega un mensaje de error.
     * @param id Identificador de la variable que quiere buscarse
     * @param valor Valor que quiere asignársele a la variable buscada
     */
    void setValor(String id, Object valor) {
        for(Simbolo s:this){
            
            if(s.getId().equals(id)){
                s.setValor(valor);
                return;
            }
        }
        System.out.println("La variable "+id+" no existe en este ámbito, por lo "
                + "que no puede asignársele un valor.");
    }
    boolean existeVariable(String id){
        for(Simbolo s:this){
            
            if(s.getId().equals(id)){
                
                return true;
            }
        }
        return false;
    }
    
    Simbolo.Tipo getTipo(String id){
        //verifica cada simbolo
        for(Simbolo s:this){
            //verifica que la variable sea igual
                //System.out.println("VERIFICA IGUALDAD "+id+" con "+s.getId());
            if(s.getId().equals(id)){
                //System.out.println("TIPOOOO: "+s.getTipo());
                return s.getTipo();
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
    
}