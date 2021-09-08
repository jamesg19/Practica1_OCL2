
package arbol;

import Error.Exeption;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 * Clase que ejecuta las acciones de una instrucción imprimir y que implementa
 * la interfaz de instrucción
 * @author James
 */
public class Mensaje implements Instruccion,Serializable{
    /**
     * Contenido que será impreso al ejecutar la instrucción imprimir, este debe
     * ser una instrucción que genere un valor al ser ejecutada.
     */
    private final Instruccion contenido;
    private String mensaje;
    /**
     * Constructor de la clase imprimir
     * @param contenido contenido que será impreso al ejecutar la instrucción
     */
    public Mensaje(Instruccion contenido) {
        this.contenido = contenido;
    }
    /**
     * Método que ejecuta la accion de imprimir un valor, es una sobreescritura del 
     * método ejecutar que se debe programar por la implementación de la interfaz
     * instrucción
     * @param ts Tabla de símbolos del ámbito padre de la sentencia.
     * @return Esta instrucción retorna nulo porque no produce ningun valor al ser
     * ejecutada.
     */
    @Override
    public Object ejecutar(Arbol AST,TablaDeSimbolos ts) {
        try{
        mensaje=contenido.ejecutar(AST,ts).toString();
        JOptionPane.showMessageDialog(null,mensaje);
        //System.out.println(contenido.ejecutar(ts).toString());
        return null;
        } catch(Exception e){
            return new Exeption("SEMANTICO","ERROR AL EJECUTAR LA INSTRUCCION MENSAJE","","");
        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
