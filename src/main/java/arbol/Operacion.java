package arbol;

import Error.Exeption;

/**
 * Clase que ejecuta las acciones de una operación, ya sea aritmética o
 * realacional y que implementa la interfaz de instrucción, ya que estas
 * operaciones pueden ejecutarse y al ejecutarse retornan un valor.
 *
 * @author James
 */
public class Operacion implements Instruccion {

    /**
     * Enumeración del tipo_operacion de operación que puede ser ejecutada por esta clase.
     */
    public static enum Tipo_operacion {
        SUMA,
        RESTA,
        MULTIPLICACION,
        DIVISION,
        POTENCIA,
        MODULO,
        IGUALACION,
        DIFERENCIACION,
        MAYOR_QUE,
        MENOR_QUE,
        MAYOR_IGUAL,
        MENOR_IGUAL,
        //OPERADORES LOGICOS
        OR,
        XOR,
        NOR,
        AND,
        NAND,
        INCREMENTO,
        DECREMENTO,
        //OPERADORES prec rigth
        NEGATIVO,
        NEGACION,
        //TIPO DE VARIABLES
        NUMERO,
        CARACTER,
        DECIMAL,
        IDENTIFICADOR,
        CADENA,
        BOOLEAN,
        CONCATENACION
    }

    public static enum Tipo_dato {
        DECIMALL,
        NUMEROO,
        CADENAA,
        BOLEANN,
        CARACTERR

    }
    /**
     * Tipo de operación a ejecutar.
     */
    private Tipo_operacion tipo_operacion;
    private Tipo_dato tipo_dato;
    private Operacion operadorIzq;
    private Operacion operadorDer;
    private Object valor;

    public Operacion(Operacion operadorIzq, Operacion operadorDer, Tipo_operacion tipo) {
        this.tipo_operacion = tipo;
        this.operadorIzq = operadorIzq;
        this.operadorDer = operadorDer;
    }

    /**
     * Constructor para operaciones unarias (un operador), estas operaciones
     * son: NEGATIVO
     *
     * @param operadorIzq Único operador de la operación
     * @param tipo Tipo de operación
     */
    public Operacion(Operacion operadorIzq, Tipo_operacion tipo) {
        this.tipo_operacion = tipo;
        this.operadorIzq = operadorIzq;
    }

    /**
     * Constructor para operaciones unarias (un operador), cuyo operador es
     * específicamente una cadena, estas operaciones son: IDENTIFICADOR, CADENA
     * , CARACTER
     *
     * @param a Cadena que representa la operación a realizar
     * @param tipo Tipo de operación
     */
    
    public Operacion(String a, Tipo_operacion tipo) {
        this.valor = a;
        this.tipo_operacion = tipo;
    }
    public Operacion(Primitivo a) {
        this.valor = a;

    }

    public Operacion(Double a) {
        this.valor = a;
        this.tipo_dato = Tipo_dato.DECIMALL;
        this.tipo_operacion = Tipo_operacion.DECIMAL;
    }
    public Operacion(Integer a) {
        this.valor = a;
        this.tipo_dato = Tipo_dato.NUMEROO;
        this.tipo_operacion = Tipo_operacion.NUMERO;
    }
    public Operacion(Boolean a) {
        this.valor = a;
        this.tipo_dato = Tipo_dato.BOLEANN;
        this.tipo_operacion = Tipo_operacion.BOOLEAN;
    }

    @Override
    public Object ejecutar(Arbol AST,TablaDeSimbolos ts) {

        /* ======== OPERACIONES ARITMETICAS ======== */
        if (tipo_operacion == Tipo_operacion.DIVISION) {
            //return (Double) operadorIzq.ejecutar(AST,ts) / (Double) operadorDer.ejecutar(AST,ts);
            
                        
            ///////////////NUMERO
            //NUMERO  / NUMERO
            if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){

                int a=Integer.parseInt(operadorIzq.ejecutar(AST,ts).toString());
                int b=Integer.parseInt(operadorDer.ejecutar(AST,ts).toString());
                
                return a/b;
            }
            //NUMERO  / DECIMAL //YA
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){

                return Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString()) / (Double) operadorDer.ejecutar(AST,ts);
            }
            //NUMERO  / CARACTER
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")     ){
                int a= Integer.parseInt(operadorIzq.ejecutar(AST,ts).toString());
                int b=operadorDer.ejecutar(AST,ts).toString().charAt(0);
                return a * b;
            }
            //NUMERO  / BOOLEAN
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")     ){
                int a= Integer.parseInt(operadorIzq.ejecutar(AST,ts).toString());
                int b=valorBoolean(operadorDer.ejecutar(AST,ts).toString());
                return a / b;
            }
            
            //DECIMAL / DECIMAL 
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){

                return (Double) operadorIzq.ejecutar(AST,ts) / (Double) operadorDer.ejecutar(AST,ts);
            }
            //DECIMAL / NUMERO
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
 
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                return (Double) operadorIzq.ejecutar(AST,ts) / b;
            }
            //DECIMAL / CARACTER
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")     ){
                int b=Integer.parseInt(operadorDer.ejecutar(AST,ts).toString());
                return (Double) operadorIzq.ejecutar(AST,ts) / (b);
            }
            //DECIMAL / BOOLEAN
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")     ){
                int b=valorBoolean(operadorDer.ejecutar(AST,ts).toString());
                return (Double) operadorIzq.ejecutar(AST,ts) / b;
            }
            /////////CARACTER
            //CARACTER / NUMERO
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
                int a=operadorIzq.ejecutar(AST,ts).toString().charAt(0);
                int b=Integer.parseInt(operadorDer.ejecutar(AST,ts).toString());
                return  a/b;
            }
            //CARACTER / DECIMAL
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){
                int b=operadorIzq.ejecutar(AST,ts).toString().charAt(0);
                return  b/(Double) operadorDer.ejecutar(AST,ts);
            }
            //CARACTER / CARACTER
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")     ){
                int a=operadorIzq.ejecutar(AST,ts).toString().charAt(0);
                int b=operadorDer.ejecutar(AST,ts).toString().charAt(0);
                return  a/b;
            }
            //CARACTER * BOOLEAN
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")     ){
                int a=operadorIzq.ejecutar(AST,ts).toString().charAt(0);
                int b=valorBoolean(operadorDer.ejecutar(AST,ts).toString());
                return  a/b;
            }
            ///////BOOLEAN
            //BOOLEAN / NUMERO
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
                int a=valorBoolean(operadorIzq.ejecutar(AST,ts).toString());
                
                int b=Integer.parseInt(operadorDer.ejecutar(AST,ts).toString());
                return  a/b;
            }
            //BOOLEAN * DECIMAL
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){

                int a=valorBoolean(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                return  a/b;
            }
            //BOOLEAN * CARACTER
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")     ){
                int a=valorBoolean(operadorIzq.ejecutar(AST,ts).toString());
                int b=operadorDer.ejecutar(AST,ts).toString().charAt(0);
                
                return  a/b;
            }
            else{
                return null;
            }
            

        } 
        ///////////////////////////////MULTIPLICACION//////////////////////////////////////// 
        ///////////////////////////////MULTIPLICACION////////////////////////////////////////
        ///////////////////////////////MULTIPLICACION////////////////////////////////////////
        else if (tipo_operacion == Tipo_operacion.MULTIPLICACION) {

            
            ///////////////NUMERO
            //NUMERO  * NUMERO
            if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){

                return (Integer) operadorIzq.ejecutar(AST,ts) * (Integer) operadorDer.ejecutar(AST,ts);
            }
            //NUMERO  * DECIMAL //YA
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){

                return Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString()) * (Double) operadorDer.ejecutar(AST,ts);
            }
            //NUMERO  * CARACTER
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")     ){
                int a= Integer.parseInt(operadorIzq.ejecutar(AST,ts).toString());
                int b=operadorDer.ejecutar(AST,ts).toString().charAt(0);
                return a * b;
            }
            //NUMERO  * BOOLEAN
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")     ){
                int a= Integer.parseInt(operadorIzq.ejecutar(AST,ts).toString());
                int b=valorBoolean(operadorDer.ejecutar(AST,ts).toString());
                return a * b;
            }
            
            //DECIMAL * DECIMAL 
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){
                
                return (Double) operadorIzq.ejecutar(AST,ts) * (Double) operadorDer.ejecutar(AST,ts);
            }
            //DECIMAL * NUMERO
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){

                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                return (Double) operadorIzq.ejecutar(AST,ts) * b;
            }
            //DECIMAL * CARACTER
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")     ){
                int b=Integer.parseInt(operadorDer.ejecutar(AST,ts).toString());
                return (Double) operadorIzq.ejecutar(AST,ts) * (b);
            }
            //DECIMAL * BOOLEAN
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")     ){
                int b=valorBoolean(operadorDer.ejecutar(AST,ts).toString());
                return (Double) operadorIzq.ejecutar(AST,ts) * b;
            }
            /////////CARACTER
            //CARACTER * NUMERO
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
                int a=operadorIzq.ejecutar(AST,ts).toString().charAt(0);
                int b=Integer.parseInt(operadorDer.ejecutar(AST,ts).toString());
                return  a*b;
            }
            //CARACTER * DECIMAL
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){
                int b=operadorIzq.ejecutar(AST,ts).toString().charAt(0);
                return  b*(Double) operadorDer.ejecutar(AST,ts);
            }
            //CARACTER * CARACTER
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")     ){
                int a=operadorIzq.ejecutar(AST,ts).toString().charAt(0);
                int b=operadorDer.ejecutar(AST,ts).toString().charAt(0);
                return  a*b;
            }
            //CARACTER * BOOLEAN
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")     ){
                int a=operadorIzq.ejecutar(AST,ts).toString().charAt(0);
                int b=valorBoolean(operadorDer.ejecutar(AST,ts).toString());
                return  a*b;
            }
            ///////BOOLEAN
            //BOOLEAN * NUMERO
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
                int a=valorBoolean(operadorIzq.ejecutar(AST,ts).toString());
                
                int b=Integer.parseInt(operadorDer.ejecutar(AST,ts).toString());
                return  a*b;
            }
            //BOOLEAN * DECIMAL
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){
                int a=valorBoolean(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                return  a*b;
            }
            //BOOLEAN * CARACTER
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")     ){
                int a=valorBoolean(operadorIzq.ejecutar(AST,ts).toString());
                int b=operadorDer.ejecutar(AST,ts).toString().charAt(0);
                
                return  a*b;
            }
            //BOOLEAN * BOOLEAN
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")     ){
                int a=valorBoolean(operadorIzq.ejecutar(AST,ts).toString());
                int b=valorBoolean(operadorDer.ejecutar(AST,ts).toString());
                return  a*b;
            }
            
            
            
                return null;


        }
        ////////////////////////////////////////RESTA/////////////////////////////////////////
        ////////////////////////////////////////RESTA/////////////////////////////////////////
        ////////////////////////////////////////RESTA/////////////////////////////////////////
        ////////////////////////////////////////RESTA/////////////////////////////////////////
        else if (tipo_operacion == Tipo_operacion.RESTA) {
            //return (Double) operadorIzq.ejecutar(AST,ts) - (Double) operadorDer.ejecutar(AST,ts);
            
            ///////////////NUMERO
            //NUMERO  - NUMERO
            if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
                
                return (Integer) operadorIzq.ejecutar(AST,ts) - (Integer) operadorDer.ejecutar(AST,ts);
            }
            //NUMERO  - DECIMAL //YA
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){

                return Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString()) - (Double) operadorDer.ejecutar(AST,ts);
            }
            //NUMERO  - CARACTER
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")     ){
                int a= Integer.parseInt(operadorIzq.ejecutar(AST,ts).toString());
                int b=operadorDer.ejecutar(AST,ts).toString().charAt(0);
                return a - b;
            }
            //NUMERO  - BOOLEAN
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")     ){
                int a= Integer.parseInt(operadorIzq.ejecutar(AST,ts).toString());
                int b=valorBoolean(operadorDer.ejecutar(AST,ts).toString());
                return a - b;
            }
            
            ////////////DECIMAL
            //DECIMAL - DECIMAL 
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){
                return (Double) operadorIzq.ejecutar(AST,ts)- (Double) operadorDer.ejecutar(AST,ts);
            }
            //DECIMAL - NUMERO
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){

                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                return (Double) operadorIzq.ejecutar(AST,ts) - b;
            }
            //DECIMAL - CARACTER
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")     ){
                int b=Integer.parseInt(operadorDer.ejecutar(AST,ts).toString());
                return (Double) operadorIzq.ejecutar(AST,ts) -b;
            }
            //DECIMAL - BOOLEAN
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")     ){
                int b=valorBoolean(operadorDer.ejecutar(AST,ts).toString());
                return (Double) operadorIzq.ejecutar(AST,ts) - b;
            }
            
            /////////CARACTER
            //CARACTER - NUMERO
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
                int a=operadorIzq.ejecutar(AST,ts).toString().charAt(0);
                int b=Integer.parseInt(operadorDer.ejecutar(AST,ts).toString());
                return  a-b;
            }
            //CARACTER - DECIMAL
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){
                int b=operadorIzq.ejecutar(AST,ts).toString().charAt(0);
                return  b-(Double) operadorDer.ejecutar(AST,ts);
            }
            //CARACTER - CARACTER
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")     ){
                int a=operadorIzq.ejecutar(AST,ts).toString().charAt(0);
                int b=operadorDer.ejecutar(AST,ts).toString().charAt(0);
                return  a-b;
            }
            
            ///////BOOLEAN
            //BOOLEAN - NUMERO
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
                int a=valorBoolean(operadorIzq.ejecutar(AST,ts).toString());
                int b=Integer.parseInt(operadorDer.ejecutar(AST,ts).toString());
                return  a-b;
            }
            //BOOLEAN - DECIMAL
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){
                int a=valorBoolean(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                return  a-b;
            }
            
            else{
                //Exeption e= new Exeption("SEMANTICO","Tipo erroneo en RESTA","",""); 
                return new Exeption("SEMANTICO","Tipo erroneo en RESTA","",""); 
            }

        } 
        
        ////////////////////////////////////////SUMA/////////////////////////////////////////
        ////////////////////////////////////////SUMA/////////////////////////////////////////
        ////////////////////////////////////////SUMA/////////////////////////////////////////
        ////////////////////////////////////////SUMA/////////////////////////////////////////
        else if (tipo_operacion == Tipo_operacion.SUMA) {
            
            ///////////////NUMERO
            //NUMERO  + NUMERO
            if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
                
                return (Integer) operadorIzq.ejecutar(AST,ts) + (Integer) operadorDer.ejecutar(AST,ts);
            }
            //NUMERO  + CADENA //YA
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("String")     ){

                return operadorIzq.ejecutar(AST,ts).toString() +operadorDer.ejecutar(AST,ts).toString();
            }
            //NUMERO  + DECIMAL //YA
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){
                
                return Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString()) + (Double) operadorDer.ejecutar(AST,ts);
            }
            //NUMERO  + CARACTER
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")     ){
                int a= Integer.parseInt(operadorIzq.ejecutar(AST,ts).toString());
                int b=operadorDer.ejecutar(AST,ts).toString().charAt(0);
                return a +b;
            }
            //NUMERO  + BOOLEAN
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")     ){
                int a= Integer.parseInt(operadorIzq.ejecutar(AST,ts).toString());
                int b=valorBoolean(operadorDer.ejecutar(AST,ts).toString());
                return a + b;
            }
            
            ////////////CADENA
            //CADENA + NUMERO 
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("String")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){

                return  operadorIzq.ejecutar(AST,ts).toString()+ operadorDer.ejecutar(AST,ts).toString();
            }
            // CADENA + DECIMAL
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("String")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){

                return  operadorIzq.ejecutar(AST,ts).toString()+ operadorDer.ejecutar(AST,ts).toString();
            }
            //CADENA + CHAR
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("String")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")     ){

                return  operadorIzq.ejecutar(AST,ts).toString()+ operadorDer.ejecutar(AST,ts).toString();
            }
            // CADENA + CADENA
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("String")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("String")     ){

                return  operadorIzq.ejecutar(AST,ts).toString()+ operadorDer.ejecutar(AST,ts).toString();
            }
            //CADENA  + BOOLEAN
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("String")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")     ){

                return  operadorIzq.ejecutar(AST,ts).toString()+operadorDer.ejecutar(AST,ts).toString();
            }
            
            
            ////////////DECIMAL
            //DECIMAL +DECIMAL 
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){

                return (Double) operadorIzq.ejecutar(AST,ts)+ (Double) operadorDer.ejecutar(AST,ts);
            }
            //DECIMAL + NUMERO
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){

                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                return (Double) operadorIzq.ejecutar(AST,ts) + b;
            }
            //DECIMAL + CARACTER
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")     ){
                int b=Integer.parseInt(operadorDer.ejecutar(AST,ts).toString());
                return (Double) operadorIzq.ejecutar(AST,ts) +b;
            }
            //DECIMAL + BOOLEAN
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")     ){
                int b=valorBoolean(operadorDer.ejecutar(AST,ts).toString());
                return (Double) operadorIzq.ejecutar(AST,ts) + b;
            }
            //DECIMAL + CADENA
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")     ){
                return (Double) operadorIzq.ejecutar(AST,ts) + operadorDer.ejecutar(AST,ts).toString();
            }
            
            /////////CARACTER
            //CARACTER + NUMERO
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
                int a=operadorIzq.ejecutar(AST,ts).toString().charAt(0);
                int b=Integer.parseInt(operadorDer.ejecutar(AST,ts).toString());
                return  a+b;
            }
            //CARACTER + CADENA
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("String")     ){
                
                return operadorIzq.ejecutar(AST,ts).toString() + operadorDer.ejecutar(AST,ts).toString();
            }
            //CARACTER + DECIMAL
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){
                int a=operadorIzq.ejecutar(AST,ts).toString().charAt(0);
                return  a*(Double) operadorDer.ejecutar(AST,ts);
            }
            //CARACTER + CARACTER
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")     ){
                int a=operadorIzq.ejecutar(AST,ts).toString().charAt(0);
                int b=operadorDer.ejecutar(AST,ts).toString().charAt(0);
                return  a+b;
            }
            //CARACTER + BOOLEAN
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")     ){
                int a=operadorIzq.ejecutar(AST,ts).toString().charAt(0);
                int b=valorBoolean(operadorDer.ejecutar(AST,ts).toString());
                return  a+b;
            }
            
            ///////BOOLEAN
            //BOOLEAN + NUMERO
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
                int a=valorBoolean(operadorIzq.ejecutar(AST,ts).toString());
                int b=Integer.parseInt(operadorDer.ejecutar(AST,ts).toString());
                return  a+b;
            }
            //BOOLEAN + DECIMAL
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){
                int a=valorBoolean(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                return  a+b;
            }
            //BOOLEAN + CHAR
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")     ){
                int a=valorBoolean(operadorIzq.ejecutar(AST,ts).toString());
                int b =operadorDer.ejecutar(AST,ts).toString().charAt(a);
                return  a+b;
            }
            //BOOLEAN + BOOLEAN
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")     ){
                int a=valorBoolean(operadorIzq.ejecutar(AST,ts).toString());
                int b =valorBoolean(operadorDer.ejecutar(AST,ts).toString());
                return  a+b;
            }
            
            else{
                //Exeption e= new Exeption("SEMANTICO","Tipo erroneo en RESTA","",""); 
                return new Exeption("SEMANTICO","Tipo erroneo en SUMA","",""); 
            }
        } 
        
        ////////////////////////////////////MODULO////////////////////////////
        ////////////////////////////////////MODULO////////////////////////////
        ////////////////////////////////////MODULO////////////////////////////
        else if (tipo_operacion == Tipo_operacion.MODULO) {
            // ENTERO % ENTERO
            if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
                int a=Integer.parseInt(operadorIzq.ejecutar(AST,ts).toString());
                int b=Integer.parseInt(operadorDer.ejecutar(AST,ts).toString());
                return  a%b;
            }
            // ENTERO % DECIMAL
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){
                double a=Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                return  a%b;
            }
            // DECIMAL % ENTERO
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
                double a=Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                return  a%b;
            }
            // DECIMAL % DECIMAL
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){
                double a=Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                return  a%b;
            }
            return null;
        }
        ////////////////////////////////////POTENCIA////////////////////////////
        ////////////////////////////////////POTENCIA////////////////////////////
        ////////////////////////////////////POTENCIA////////////////////////////
        else if (tipo_operacion == Tipo_operacion.POTENCIA) {
            // ENTERO ^ ENTERO
            if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
                double a=Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                double result= (double) Math.pow(a, b);
                return  result;
            }

            // DECIMAL ^ ENTERO
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
                double a=Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                double result= (double) Math.pow(a, b);
                return  result;
            }

            return null;
        }
        //////////////////////////////////////////AND///////////////////////////////
        //////////////////////////////////////////AND///////////////////////////////
        else if (tipo_operacion == Tipo_operacion.AND) {
            //AND
            if(((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&&((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")){
                boolean flag1=(Boolean) operadorIzq.ejecutar(AST,ts);
                boolean flag2=(Boolean) operadorDer.ejecutar(AST,ts);
                boolean result=flag1&&flag2;
                return result;
            }
            else{
                return new Exeption("SEMANTICO","ERROR TIPO DE DATO NO BOOLEANO EN AND","","");
            }
            
        }
        ///////////////////////////////////////////OR///////////////////////////////////
        ///////////////////////////////////////////OR///////////////////////////////////
        else if (tipo_operacion == Tipo_operacion.OR) {
            //AND
            if(((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&&((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")){
                boolean flag1=(Boolean) operadorIzq.ejecutar(AST,ts);
                boolean flag2=(Boolean) operadorDer.ejecutar(AST,ts);
                boolean result=flag1||flag2;
                return result;
            }
            else{
                return new Exeption("SEMANTICO","ERROR TIPO DE DATO NO BOOLEANO EN OR","","");
            }
            
        }
        /////////////////////////////////////////NOR///////////////////////////////////
        /////////////////////////////////////////NOR///////////////////////////////////
        else if (tipo_operacion == Tipo_operacion.NOR) {
            //AND
            if(((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&&((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")){
                boolean flag1=(Boolean) operadorIzq.ejecutar(AST,ts);
                boolean flag2=(Boolean) operadorDer.ejecutar(AST,ts);
                boolean result=(flag1)||(flag2);
                return !result;
            }
            else{
                return new Exeption("SEMANTICO","ERROR TIPO DE DATO NO BOOLEANO EN NOR","","");
            }
            
        }
        /////////////////////////////////////////XOR///////////////////////////////////
        /////////////////////////////////////////XOR///////////////////////////////////
        else if (tipo_operacion == Tipo_operacion.XOR) {
            //AND
            if(((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&&((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")){
                boolean flag1=(Boolean) operadorIzq.ejecutar(AST,ts);
                boolean flag2=(Boolean) operadorDer.ejecutar(AST,ts);
                boolean result=(flag1&&!flag2)||(!flag1&&flag2);
                return result;
            }
            else{
                return new Exeption("SEMANTICO","ERROR TIPO DE DATO NO BOOLEANO EN XOR","","");
            }
            
        }
        /////////////////////////////////////////NAND///////////////////////////////////
        /////////////////////////////////////////NAND///////////////////////////////////
        else if (tipo_operacion == Tipo_operacion.NAND) {
            //AND
            if(((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&&((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")){
                boolean flag1=(Boolean) operadorIzq.ejecutar(AST,ts);
                boolean flag2=(Boolean) operadorDer.ejecutar(AST,ts);
                boolean result=(flag1)&&(flag2);
                return !result;
            }
            else{
                return new Exeption("SEMANTICO","ERROR TIPO DE DATO NO BOOLEANO EN NAND","","");
            }
            
        }
        
        
        
        
        //////////////////////////////////////////NEGATIVO/////////////////////////////////////
        //////////////////////////////////////////NEGATIVO/////////////////////////////////////
        //////////////////////////////////////////NEGATIVO/////////////////////////////////////

        else if (tipo_operacion == Tipo_operacion.NEGATIVO) {
            try {
                
                return (Integer) operadorIzq.ejecutar(AST,ts) * -1;
            } catch (Exception e) {
                return (Double) operadorIzq.ejecutar(AST,ts) * -1;
            }

        } 
        else if (tipo_operacion == Tipo_operacion.NEGACION) {
            try{
                if(((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().equals("Boolean")){
                    boolean flag= (Boolean)operadorIzq.ejecutar(AST,ts);
                    return !flag;
                }else{
                    return new Exeption ("SEMANTICO","ERROR TIPO DE DATO EN NEGACION BOOLEANA","","");
                }
            }catch(Exception e){
                
            }
            return new Exeption ("SEMANTICO","ERROR TIPO DE DATO EN NEGACION BOOLEANA","","");
        }
        /* ======== OPERACIONES UNARIOS ======== */ 
        /* ======== OPERACIONES UNARIOS ======== */ 
        /* ======== OPERACIONES UNARIOS ======== */ 
        /* ======== OPERACIONES UNARIOS ======== */ 
        /* ======== OPERACIONES UNARIOS ======== */ 
        else if (tipo_operacion == Tipo_operacion.NUMERO) {
            return new Integer(valor.toString());
        }else if (tipo_operacion == Tipo_operacion.BOOLEAN) {
            return new Boolean(valor.toString());
        } else if (tipo_operacion == Tipo_operacion.DECIMAL) {
            return new Double(valor.toString());
        } else if (tipo_operacion == Tipo_operacion.IDENTIFICADOR) {
            return ts.getValor(valor.toString());
        } else if (tipo_operacion == Tipo_operacion.CADENA) {
            return valor.toString();
        } else if (tipo_operacion == Tipo_operacion.CARACTER) {
            return generarChar();
        } else if (tipo_operacion == Tipo_operacion.INCREMENTO) {
            try {
                return (Integer) operadorIzq.ejecutar(AST,ts) +1;
            } catch (Exception e) {
                return (Double) operadorIzq.ejecutar(AST,ts) +1;
            }
        } else if (tipo_operacion == Tipo_operacion.DECREMENTO) {
            try {
                return (Integer) operadorIzq.ejecutar(AST,ts) -1;
            } catch (Exception e) {
                return (Double) operadorIzq.ejecutar(AST,ts) -1;
            }
        } 

        /* ======== OPERACIONES RELACIONALES ======== */ 
        
        ///////////////////////////////////////MAYOR_QUE/////////////////////////////////////
        ///////////////////////////////////////MAYOR_QUE/////////////////////////////////////
        ///////////////////////////////////////MAYOR_QUE/////////////////////////////////////
        else if (tipo_operacion == Tipo_operacion.MAYOR_QUE) {
            
            // ENTERO > ENTERO
            if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
                double a=Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                boolean result= a>b;
                return  result;
            }
            // ENTERO > DECIMAL
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){
                double a=Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                boolean result= a>b;
                return  result;
            }
            // DECIMAL > ENTERO
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
                double a=Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                boolean result= a>b;
                return  result;
            }
            // DECIMAL > DECIMAL
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){
                double a=Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                boolean result= a>b;
                return  result;
            }
            // BOOLEAN > BOOLEAN
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")     ){
                int a=valorBoolean(operadorIzq.ejecutar(AST,ts).toString());
                int b=valorBoolean(operadorDer.ejecutar(AST,ts).toString());
                boolean result= a>b;
                return  result;
            }
            else{
                return new Exeption("SEMANTICO","TIPO ERRONEO PARA MAYOR QUE","","");
            }
                        

        } 
        ///////////////////////////////////////MENOR QUE/////////////////////////////////////
        ///////////////////////////////////////MENOR QUE/////////////////////////////////////
        ///////////////////////////////////////MENOR QUE/////////////////////////////////////
        else if (tipo_operacion == Tipo_operacion.MENOR_QUE) {
            // ENTERO < ENTERO

            if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){

                int a=Integer.parseInt(operadorIzq.ejecutar(AST,ts).toString());
                int b=Integer.parseInt(operadorDer.ejecutar(AST,ts).toString());
                boolean result= a<b;
                return  result;
            }
            // ENTERO < DECIMAL
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){
                int a=Integer.parseInt(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                boolean result= a<b;

                return (Boolean) result;
            }
            // DECIMAL < ENTERO
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){

                double a=Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                boolean result= a<b;
                return (Boolean) result;
            }
            // DECIMAL < DECIMAL
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){
                double a=Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                boolean result= a<b;
                return (Boolean) result;
            }
            // BOOLEAN < BOOLEAN
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")     ){
                int a=valorBoolean(operadorIzq.ejecutar(AST,ts).toString());
                int b=valorBoolean(operadorDer.ejecutar(AST,ts).toString());
                boolean result= a<b;
                return (Boolean) result;
            }
            else{
                return new Exeption("SEMANTICO","TIPO ERRONEO PARA MENOR QUE","","");
            }

        }
        ////////////////////////////////////////////MAYOR_IGUAL///////////////////////////////////
        ////////////////////////////////////////////MAYOR_IGUAL///////////////////////////////////
        ////////////////////////////////////////////MAYOR_IGUAL///////////////////////////////////
        else if (tipo_operacion == Tipo_operacion.MAYOR_IGUAL) {
            // ENTERO >= ENTERO
            if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
                double a=Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                boolean result= a>=b;
                return  result;
            }
            // ENTERO >= DECIMAL
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){
                double a=Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                boolean result= a>=b;
                return  result;
            }
            // DECIMAL >= ENTERO
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
                double a=Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                boolean result= a>=b;
                return  result;
            }
            // DECIMAL >= DECIMAL
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){
                double a=Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                boolean result= a>=b;
                return  result;
            }
            // BOOLEAN >= BOOLEAN
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")     ){
                int a=valorBoolean(operadorIzq.ejecutar(AST,ts).toString());
                int b=valorBoolean(operadorDer.ejecutar(AST,ts).toString());
                boolean result= a>=b;
                return  result;
            }
            else{
                return new Exeption("SEMANTICO","TIPO ERRONEO PARA MAYOR IGUAL","","");
            }

        }
        ////////////////////////////////////////////MENOR_IGUAL///////////////////////////////////
        ////////////////////////////////////////////MENOR_IGUAL///////////////////////////////////
        ////////////////////////////////////////////MENOR_IGUAL///////////////////////////////////
        else if (tipo_operacion == Tipo_operacion.MENOR_IGUAL) {
            // ENTERO <= ENTERO
            if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
                double a=Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                boolean result= a>=b;
                return  result;
            }
            // ENTERO <= DECIMAL
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){
                double a=Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                boolean result= a>=b;
                return  result;
            }
            // DECIMAL <= ENTERO
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
                double a=Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                boolean result= a>=b;
                return  result;
            }
            // DECIMAL <= DECIMAL
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){
                double a=Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                boolean result= a<=b;
                return  result;
            }
            // BOOLEAN <= BOOLEAN
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")     ){
                int a=valorBoolean(operadorIzq.ejecutar(AST,ts).toString());
                int b=valorBoolean(operadorDer.ejecutar(AST,ts).toString());
                boolean result= a<=b;
                return  result;
            }
            else{
                return new Exeption("SEMANTICO","TIPO ERRONEO PARA MENOR IGUAL","","");
            }

        }
        ////////////////////////////////////////////IGUALACION///////////////////////////////////
        ////////////////////////////////////////////IGUALACION///////////////////////////////////
        ////////////////////////////////////////////IGUALACION///////////////////////////////////
        else if (tipo_operacion == Tipo_operacion.IGUALACION) {
            //ENTERO
            // ENTERO == ENTERO
            if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
                
                double a=Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                boolean flag=a==b;
                return flag;
            }  
            // ENTERO == DECIMAL
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){
                
                double a=Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                boolean flag=a==b;
                return flag;
            } 
            // ENTERO == BOOLEAN
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")     ){
                
                int a=Integer.parseInt(operadorIzq.ejecutar(AST,ts).toString());
                int c= valorBoolean(operadorDer.ejecutar(AST,ts).toString());
                int b=Integer.parseInt(c+"");
                boolean flag= a==b;
                return flag;
            } 
            // ENTERO == CADENA
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("String")     ){
                
                String a=operadorIzq.ejecutar(AST,ts).toString();
                String b=operadorDer.ejecutar(AST,ts).toString();
                boolean flag=a.equals(b);
                return flag;
            } 
            // DECIMAL
            // DECIMAL == ENTERO
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
                
                double a=Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                boolean flag=a==b;
                return flag;
            }  
            // DECIMAL == DECIMAL
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){
                
                double a=Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                boolean flag=a==b;
                return flag;
            } 
            // DECIMAL == BOOLEAN
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")     ){
                
                int a=Integer.parseInt(operadorIzq.ejecutar(AST,ts).toString());
                int c= valorBoolean(operadorDer.ejecutar(AST,ts).toString());
                int b=Integer.parseInt(c+"");
                boolean flag= a==b;
                return flag;
            } 
            // DECIMAL == CADENA
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("String")     ){
                
                String a=operadorIzq.ejecutar(AST,ts).toString();
                String b=operadorDer.ejecutar(AST,ts).toString();
                boolean flag=a.equals(b);
                return flag;
            }
            // CADENA
            // CADENA == ENTERO
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("String")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
                
                String a=operadorIzq.ejecutar(AST,ts).toString();
                String b=operadorDer.ejecutar(AST,ts).toString();
                boolean flag=a.equals(b);
                return flag;
            }  
            // CADENA == DECIMAL
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("String")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){
                
                String a=operadorIzq.ejecutar(AST,ts).toString();
                String b=operadorDer.ejecutar(AST,ts).toString();
                boolean flag=a.equals(b);
                return flag;
            } 
            // CADENA == CADENA
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("String")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("String")     ){
                
                String a=operadorIzq.ejecutar(AST,ts).toString();
                String b=operadorDer.ejecutar(AST,ts).toString();
                boolean flag=a.equals(b);
                return flag;
            }
            // CADENA == BOOLEAN
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("String")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")     ){
                
                String a=operadorIzq.ejecutar(AST,ts).toString();
                String b=operadorDer.ejecutar(AST,ts).toString();
                boolean flag= a.equals(b);
                return flag;
            } 
            //BOOLEAN
            // BOOLEAN == ENTERO
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
                
                int a=valorBoolean(operadorIzq.ejecutar(AST,ts).toString());
                int b=Integer.parseInt(operadorDer.ejecutar(AST,ts).toString());
                boolean flag= (a==b);
                return flag;
            }  
            // BOOLEAN == DECIMAL
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){
                
                int a=valorBoolean(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                boolean flag= (a==b);
                return flag;
            } 
            // BOOLEAN == CADENA
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("String")     ){
                
                String a=operadorIzq.ejecutar(AST,ts).toString();
                String b=operadorDer.ejecutar(AST,ts).toString();
                boolean flag=a.equals(b);
                return flag;
            }
            // BOOLEAN == BOOLEAN
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")     ){
                
                int a=valorBoolean(operadorIzq.ejecutar(AST,ts).toString());
                int b=valorBoolean(operadorDer.ejecutar(AST,ts).toString());
                boolean flag= (a==b);
                return flag;
            } 
            //CHAR
            // CHAR == CHAR
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")     ){
                
                char a=operadorIzq.ejecutar(AST,ts).toString().charAt(0);
                char b=operadorDer.ejecutar(AST,ts).toString().charAt(0);
               
                boolean flag= (a==b);
                return flag;
            }else{
                return new Exeption("SEMANTICO","TIPO DE DATO ERRONEO EN IGUALACION CHAR","","");
            }

            

        } 
        ////////////////////////////////////////////DIFERENCIACION/////////////////////////////////////////
        ////////////////////////////////////////////DIFERENCIACION/////////////////////////////////////////
        ////////////////////////////////////////////DIFERENCIACION/////////////////////////////////////////
        else if (tipo_operacion == Tipo_operacion.DIFERENCIACION) {
            //ENTERO
            // ENTERO != ENTERO
            if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
                
                double a=Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                boolean flag=a!=b;
                return flag;
            }  
            // ENTERO == DECIMAL
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){
                
                double a=Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                boolean flag=a!=b;
                return flag;
            } 
            // ENTERO != BOOLEAN
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")     ){
                
                int a=Integer.parseInt(operadorIzq.ejecutar(AST,ts).toString());
                int c= valorBoolean(operadorDer.ejecutar(AST,ts).toString());
                int b=Integer.parseInt(c+"");
                boolean flag= a!=b;
                return flag;
            } 
            // ENTERO != CADENA
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("String")     ){
                
                String a=operadorIzq.ejecutar(AST,ts).toString();
                String b=operadorDer.ejecutar(AST,ts).toString();
                boolean flag=!a.equals(b);
                return flag;
            } 
            // DECIMAL
            // DECIMAL !=ENTERO
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
                
                double a=Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                boolean flag=a!=b;
                return flag;
            }  
            // DECIMAL !=DECIMAL
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){
                
                double a=Double.parseDouble(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                boolean flag=a!=b;
                return flag;
            } 
            // DECIMAL != BOOLEAN
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")     ){
                
                int a=Integer.parseInt(operadorIzq.ejecutar(AST,ts).toString());
                int c= valorBoolean(operadorDer.ejecutar(AST,ts).toString());
                int b=Integer.parseInt(c+"");
                boolean flag= a!=b;
                return flag;
            } 
            // DECIMAL != CADENA
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("String")     ){
                
                String a=operadorIzq.ejecutar(AST,ts).toString();
                String b=operadorDer.ejecutar(AST,ts).toString();
                boolean flag= !a.equals(b);
                return flag;
            }
            // CADENA
            // CADENA != ENTERO
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("String")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
                
                String a=operadorIzq.ejecutar(AST,ts).toString();
                String b=operadorDer.ejecutar(AST,ts).toString();
                boolean flag= !a.equals(b);
                return flag;
            }  
            // CADENA != DECIMAL
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("String")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){
                
                String a=operadorIzq.ejecutar(AST,ts).toString();
                String b=operadorDer.ejecutar(AST,ts).toString();
                boolean flag= !a.equals(b);
                return flag;
            } 
            // CADENA != CADENA
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("String")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("String")     ){
                
                String a=operadorIzq.ejecutar(AST,ts).toString();
                String b=operadorDer.ejecutar(AST,ts).toString();
                boolean flag=!a.equals(b);
                return flag;
            }
            // CADENA != BOOLEAN
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("String")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")     ){
                
                String a=operadorIzq.ejecutar(AST,ts).toString();
                String b=operadorDer.ejecutar(AST,ts).toString();
                boolean flag= !a.equals(b);
                return flag;
            } 
            //BOOLEAN
            // BOOLEAN != ENTERO
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Integer")     ){
                
                int a=valorBoolean(operadorIzq.ejecutar(AST,ts).toString());
                int b=Integer.parseInt(operadorDer.ejecutar(AST,ts).toString());
                boolean flag= (a!=b);
                return flag;
            }  
            // BOOLEAN !=DECIMAL
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Double")     ){
                
                int a=valorBoolean(operadorIzq.ejecutar(AST,ts).toString());
                double b=Double.parseDouble(operadorDer.ejecutar(AST,ts).toString());
                boolean flag= (a!=b);
                return flag;
            } 
            // BOOLEAN != CADENA
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("String")     ){
                
                String a=operadorIzq.ejecutar(AST,ts).toString();
                String b=operadorDer.ejecutar(AST,ts).toString();
                boolean flag= !a.equals(b);
                return flag;
            }
            // BOOLEAN != BOOLEAN
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Boolean")     ){
                
                int a=valorBoolean(operadorIzq.ejecutar(AST,ts).toString());
                int b=valorBoolean(operadorDer.ejecutar(AST,ts).toString());
                boolean flag= (a!=b);
                return flag;
            } 
            //CHAR
            // CHAR == CHAR
            else if(  ((Object)operadorIzq.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")&& ((Object)operadorDer.ejecutar(AST,ts)).getClass().getSimpleName().toString().equals("Char")     ){
                
                char a=operadorIzq.ejecutar(AST,ts).toString().charAt(0);
                char b=operadorDer.ejecutar(AST,ts).toString().charAt(0);
               
                boolean flag= (a==b);
                return flag;
            }else{
                return new Exeption("SEMANTICO","TIPO DE DATO ERRONEO EN IGUALACION CHAR","","");
            }

        }
        
        
         else {
            return null;
        }

    }

    /**
     * Metodo que obtiene un valor char del Token CARACTER
     *
     * @return un valor de tipo_operacion char obtenido de una cadena
     */
    private char generarChar() {
        String cad = this.valor.toString().substring(1, this.valor.toString().length() - 1);
        switch (cad) {
            case "#n":
                return '\n';
            case "#'":
                return '\'';
            case "#\"":
                return '\"';
            case "#\\":
                return '\\';
            default:
                return cad.isEmpty() ? '\0' : cad.charAt(0);
        }
    }
    private int valorBoolean(String flag){
        String bandera=flag;
        if(bandera.toLowerCase().equalsIgnoreCase("true")){
            int numero=1;
            return numero;
        } else{
            int numero=0;
            return numero;
        }
        
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

}
