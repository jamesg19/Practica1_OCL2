//package menu;
//
//import arbol.Instruccion;
//import arbol.TablaDeSimbolos;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.StringReader;
//import java.util.LinkedList;
//
//public class Main {
//
//    public static String entrada = ">>comentario de una sola línea \n"
//            + "<- comentario de varias líneas\n"
//            + "Segunda línea\n"
//            + "Tercera línea\n "
//            + "45>- - - >b\n"
//            + "->\n"
//            + "PISTA pistA1 EXTIENDE james1 \n"
//            + "Keep var cadena  variable2, variable3, variable4 = \"Hola\"+45+23.20+False+True+\'a\'\n"
//            + "var entero arreglo arr1 [2-6][3^2] = {45,3,6}\n"
//            + "var entero arreglo arr1 [2-6][3^2] = {{5,10,15},{20,25,30}}\n"
//            + "var entero arreglo arr1 [2-6][3%2] = {{5,10,15},{1,3,8},{20,25,30}}\n"               
//            + "\t\tsi (150)\n"
//            + "\t\t\tvar entero ja=\"jajaja\"\n"
//            + "             ";
//
//    
//    public static void main(String[] args) {
//        interpretar();
//
//    }
//
//    private static void interpretar() {
//        analizadores.parser pars;
//        LinkedList<Instruccion> AST_arbolSintaxisAbstracta = null;
//        System.out.println(entrada);
//        try {
//
//            StringReader strs = new StringReader(entrada);
//
//            pars = new analizadores.parser(new analizadores.Lexico(strs));
//            System.out.println("--------COMPILACION EXITOSA--------");
//            pars.parse();
//            //AST_arbolSintaxisAbstracta=pars.getAST();
//        } catch (Exception ex) {
//            System.out.println("Error fatal en compilación de entrada.");
//        }
//        //ejecutarAST(AST_arbolSintaxisAbstracta);
//
//    }
//
//    private static void ejecutarAST(LinkedList<Instruccion> ast) {
//        if (ast == null) {
//            System.out.println("No es posible ejecutar las instrucciones porque\r\n"
//                    + "el árbol no fue cargado de forma adecuada por la existencia\r\n"
//                    + "de errores léxicos o sintácticos.");
//            return;
//        }
//
//        TablaDeSimbolos ts = new TablaDeSimbolos();
//
//        for (Instruccion ins : ast) {
//            if (ins != null) {
//                ins.ejecutar(ts);
//            }
//        }
//    }
//
//}
