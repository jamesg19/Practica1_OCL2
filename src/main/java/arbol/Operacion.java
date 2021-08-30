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
     * Enumeración del tipo de operación que puede ser ejecutada por esta clase.
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
        OR,
        XOR,
        AND,
        NAND,
        NEGATIVO,
        NEGACION,
        //TIPO DE VARIABLES
        NUMERO,
        CARACTER,
        DECIMAL,
        IDENTIFICADOR,
        CADENA,
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
    private Tipo_operacion tipo;
    private Tipo_dato tipo_dato;
    /**
     * Operador izquierdo de la operación.
     */
    private Operacion operadorIzq;
    /**
     * Operador derecho de la operación.
     */
    private Operacion operadorDer;
    /**
     * Valor específico si se tratara de una literal, es decir un número o una
     * cadena.
     */
    private Object valor;

    /**
     * Constructor de la clase para operaciones binarias (con dos operadores),
     * estas operaciones son: SUMA, RESTA, MULTIPLICACION, DIVISION,
     * CONCATENACION, MAYOR_QUE, MENOR_QUE
     *
     * @param operadorIzq Operador izquierdo de la operación
     * @param operadorDer Opeardor derecho de la operación
     * @param tipo Tipo de la operación
     */
    public Operacion(Operacion operadorIzq, Operacion operadorDer, Tipo_operacion tipo) {
        this.tipo = tipo;
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
        this.tipo = tipo;
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
        this.tipo = tipo;
    }

    /**
     * Constructor para operaciones unarias (un operador), cuyo operador es
     * específicamente una NUMERO, estas operaciones son: NUMERO_ENTERO,
     * NUMERO_DECIMAL
     *
     * @param a Valor de tipo Double que representa la operación a realizar.
     */
    public Operacion(Double a) {
        this.valor = a;
        this.tipo_dato = Tipo_dato.DECIMALL;
        this.tipo = Tipo_operacion.DECIMAL;
    }

    public Operacion(Integer a, String b, String c, String e) {
        this.valor = a;
        this.tipo_dato = Tipo_dato.NUMEROO;
        this.tipo = Tipo_operacion.NUMERO;
    }

    /**
     * Método que ejecuta la instrucción operación, es una sobreescritura del
     * método ejecutar que se debe programar por la implementación de la
     * interfaz instrucción
     *
     * @param ts tabla de símbolos del ámbito padre de la sentencia
     * @return Esta instrucción retorna el valor producido por la operación que
     * se ejecutó
     */
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {

        /* ======== OPERACIONES ARITMETICAS ======== */
        if (tipo == Tipo_operacion.DIVISION) {

            return (Double) operadorIzq.ejecutar(ts) / (Double) operadorDer.ejecutar(ts);

            ///////////////////////////MULTIPLICACION////////////////////////////////////////    
        } else if (tipo == Tipo_operacion.MULTIPLICACION) {
            try {
                return (Double) operadorIzq.ejecutar(ts) * (Double) operadorDer.ejecutar(ts);
            } catch (Exception e) {

                System.out.println("TIPO DE DATO ERRONEO EN OPERACION MULTIPLICADAR");
                return null;

            }

        } else if (tipo == Tipo_operacion.RESTA) {
            try {
                return (Double) operadorIzq.ejecutar(ts) - (Double) operadorDer.ejecutar(ts);
            } catch (Exception e) {
                System.out.println("TIPO DE DATO ERRONEO EN OPERACION RESTA");
                return null;
            }

        } else if (tipo == Tipo_operacion.SUMA) {
            try {
                return (Double) operadorIzq.ejecutar(ts) + (Double) operadorDer.ejecutar(ts);
            } catch (Exception e) {
                
                try {
                    return operadorIzq.ejecutar(ts).toString() + operadorDer.ejecutar(ts).toString();
                } catch (Exception eE) {
                    System.out.println("TIPO DE DATO ERRONEO EN OPERACION SUMA");
                    return null;
                }

            }

            ///////////////////////////////////////////////   
        } else if (tipo == Tipo_operacion.NEGATIVO) {
            try {
                return (Integer) operadorIzq.ejecutar(ts) * -1;
            } catch (Exception e) {
                System.out.println("TIPO DE DATO ERRONEO EN OPERACION NEGATIVO");
                return null;
            }

        } ///////////////////////////////////////////
        /* ======== OPERACIONES UNARIOS ======== */ else if (tipo == Tipo_operacion.NUMERO) {
            return new Integer(valor.toString());
        } else if (tipo == Tipo_operacion.DECIMAL) {
            return new Double(valor.toString());
        } else if (tipo == Tipo_operacion.IDENTIFICADOR) {
            return ts.getValor(valor.toString());
        } else if (tipo == Tipo_operacion.CADENA) {
            return valor.toString();
        } else if (tipo == Tipo_operacion.CARACTER) {
            return generarChar();
        } ////////////////////////////////////////////////
        /* ======== OPERACIONES RELACIONALES ======== */ 
        else if (tipo == Tipo_operacion.MAYOR_QUE) {
            try {

                return ((Double) operadorIzq.ejecutar(ts)) > ((Double) operadorDer.ejecutar(ts));
            } catch (Exception e) {
                System.out.println("TIPO DE DATO ERRONEO EN OPERACION MAYOR QUE \">\"");
                return new Exeption("Semantico", " operacion no booleana", "", "");

            }

        } else if (tipo == Tipo_operacion.MENOR_QUE) {
            try {
                return ((Double) operadorIzq.ejecutar(ts)) < ((Double) operadorDer.ejecutar(ts));
            } catch (Exception e) {
                System.out.println("TIPO DE DATO ERRONEO EN OPERACION MENOR QUE \"<\"");
                return null;
            }

        }else if (tipo == Tipo_operacion.MAYOR_IGUAL) {
            try {
                return ((Double) operadorIzq.ejecutar(ts)) >= ((Double) operadorDer.ejecutar(ts));
            } catch (Exception e) {
                System.out.println("TIPO DE DATO ERRONEO EN OPERACION MAYOR IGUAL  \">=\"");
                return null;
            }

        } 
        else if (tipo == Tipo_operacion.MENOR_IGUAL) {
            try {
                return ((Double) operadorIzq.ejecutar(ts)) <= ((Double) operadorDer.ejecutar(ts));
            } catch (Exception e) {
                System.out.println("TIPO DE DATO ERRONEO EN OPERACION MENOR IGUAL  \"<=\"");
                return null;
            }

        } 
        else if (tipo == Tipo_operacion.IGUALACION) {
            try {
                return ( (boolean)operadorIzq.ejecutar(ts)) == ( (boolean)operadorDer.ejecutar(ts));
            } catch (Exception e) {
                System.out.println("TIPO DE DATO ERRONEO EN OPERACION IGUALACION  \"==\"");
                return null;
            }

        } 
        else if (tipo == Tipo_operacion.DIFERENCIACION) {
            try {
                return ((Double) operadorIzq.ejecutar(ts)) != ((Double) operadorDer.ejecutar(ts));
            } catch (Exception e) {
                System.out.println("TIPO DE DATO ERRONEO EN OPERACION DIFERENCIACION  \"!=\"");
                return null;
            }

        }
        
        
         else {
            return null;
        }

    }

    /**
     * Metodo que obtiene un valor char del Token CARACTER
     *
     * @return un valor de tipo char obtenido de una cadena
     */
    private char generarChar() {
        String cad = this.valor.toString().substring(1, this.valor.toString().length() - 1);
        switch (cad) {
            case "#n":
                return '\n';
            case "'":
                return '\'';
            case "#\"":
                return '\"';
            case "#\\":
                return '\\';
            default:
                return cad.isEmpty() ? '\0' : cad.charAt(0);
        }
    }

    public Operacion getOperadorIzq() {
        return operadorIzq;
    }

    public void setOperadorIzq(Operacion operadorIzq) {
        this.operadorIzq = operadorIzq;
    }

    public Operacion getOperadorDer() {
        return operadorDer;
    }

    public void setOperadorDer(Operacion operadorDer) {
        this.operadorDer = operadorDer;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

}
