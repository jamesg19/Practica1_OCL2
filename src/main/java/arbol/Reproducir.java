package arbol;

import Error.Exeption;

/**
 *
 * @author James
 */
public class Reproducir implements Instruccion {

    //Identificador de la variable que se va a incrementar.
    private final String nota;
    private final Operacion octava;
    private final Operacion tiempo;
    private final Operacion canal;
    private final String linea;
    private final String columna;

    /**
     * Constructor de la clase Incremento
     *
     * @param id identificador de la variable que se va a incrementar
     */
    public Reproducir(String nota ,Operacion octava, Operacion tiempo, Operacion canal, String linea, String columna) {
        this.nota=nota;
        this.octava=octava;
        this.tiempo=tiempo;
        this.canal=canal;
        this.linea=linea;
        this.columna=columna;
    }


    @Override
    public Object ejecutar(Arbol AST,TablaDeSimbolos ts) {
        
        try{
        int octavaa=Integer.parseInt(octava.ejecutar(AST,ts).toString());
        int tiempoo=Integer.parseInt(tiempo.ejecutar(AST,ts).toString());
        int canall=Integer.parseInt(canal.ejecutar(AST,ts).toString());
        
        
        return tiempoo;
        }
        catch(Exception e){
            return new Exeption("SEMANTICO"," LOS PARAMETROS DE REPRODUCIR DEBEN SER TIPO ENTERO \n String nota ,int octava, int tiempo, int canal",linea,columna);
        }
        
        //  return null;
    }

    public String getNota() {
        return nota;
    }

    public Operacion getOctava() {
        return octava;
    }

    public Operacion getTiempo() {
        return tiempo;
    }

    public Operacion getCanal() {
        return canal;
    }

    public String getLinea() {
        return linea;
    }

    public String getColumna() {
        return columna;
    }
    
    
    
    
}
