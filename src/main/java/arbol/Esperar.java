package arbol;

import Error.Exeption;

/**
 *
 * @author James
 */
public class Esperar implements Instruccion {


    private final Operacion tiempo;
    private final Operacion canal;
    private int TIEMPO;
    private int CANAL;
    private final String linea;
    private final String columna;

    /**
     * Constructor de la clase Incremento
     *
     * @param id identificador de la variable que se va a incrementar
     */
    public Esperar( Operacion tiempo, Operacion canal, String linea, String columna) {

        this.tiempo=tiempo;
        this.canal=canal;
        this.linea=linea;
        this.columna=columna;
    }


    @Override
    public Object ejecutar(Arbol AST,TablaDeSimbolos ts) {
        
        try{
        
        TIEMPO=Integer.parseInt(tiempo.ejecutar(AST,ts).toString());
        CANAL=Integer.parseInt(canal.ejecutar(AST,ts).toString());
        
        
        return null;
        }
        catch(Exception e){
            return new Exeption("SEMANTICO"," LOS PARAMETROS DE (ESPERAR) DEBEN SER TIPO ENTERO \n int tiempo, int canal",linea,columna);
        }
        
        //  return null;
    }

    public int getTIEMPO() {
        return TIEMPO;
    }

    public int getCANAL() {
        return CANAL;
    }

    public String getLinea() {
        return linea;
    }

    public String getColumna() {
        return columna;
    }
    
    
    
    
}
