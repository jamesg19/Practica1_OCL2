package arbol;


public class Salir implements Instruccion{


    public Salir() {

    }
    /**
     * METODO SALIR
     * @return En este caso retorna nulo porque no es una sentencia que genere un valor.
     */
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
       
        return null;
    }
    
}
