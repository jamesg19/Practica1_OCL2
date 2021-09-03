package analizadores;
import static analizadores.sym.*;
import java_cup.runtime.Symbol; 
//COMANDOS
// java -jar jflex-full-1.8.2.jar lexico.jflex
// java -jar java-cup-11b.jar sintactico.cup

%% 
%class Lexico
%public 
%line 
%column
%char 
%cup 
%unicode
%state COMMENT_MULTILINEA, COMMENT_MULTILINEA2, COMMENT_LINE, SALTO_LINEA, COMMENT_LINE2

PROGRAMA= [Pp][Rr][Oo][Gg][Rr][Aa][Mm][Aa]
NOMBRE=[A-Za-z0-9]+
//COMENTUNILINEA      =   (">>".*\r\n)|(">>".*\n)|("//".*\r)

BLANCOS=[ ]+
TABULACION = [\t]+
SALTOLINEA= [\n]+
D=[0-9]+
DD=[0-9]+("."[0-9]+)?
character=[.*]
CADENAA=(\"([(-Za-zÀ-ÖØ-öø-ÿ#-&]|([#][n]|[#][t]|[#][r]|[#][\']|[#][\"]|[#][\\]|[\{]|[\}]|[\|]|[\!]|[\_]|[]|[ ]|[@]|[\^]|[¿]))*\")
CHARRR=(\'([(-Za-zÀ-ÖØ-öø-ÿ#-&]|([#][n]|[#][t]|[#][r]|[#][\']|[#][\"]|[#][\\]|[\{]|[\}]|[\|]|[\!]|[\_]|[]|[ ]|[@]|[\^]|[¿]))\')

%{
//codigo de errores lexicos

    StringBuffer string = new StringBuffer();
    int indentados = 0;
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline+1, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline+1, yycolumn, yytext());
    }
    public Symbol indent(String analizar, boolean tieneTab, boolean esEOF) {
        if (!esEOF) {
            if (tieneTab) {
                int espacios = 0;
                for (int i = 0; i < analizar.length(); i++) {
                    if (analizar.charAt(i) == '\t') {
                        espacios++;
                    }
                }
                if ((indentados - espacios) > 0) {
                    indentados--;
                    yypushback(espacios);
                    //System.out.println("Se encuentra dedentado no1");
                    return new Symbol(sym.INDENT_C, yyline+1, yycolumn, yytext());
                } else if ((indentados - espacios)==0) {
                    yybegin(YYINITIAL);
                    return null;
                } else if ((indentados - espacios) < 0) {
                    indentados++;
                    yypushback(espacios);
                    //System.out.println("Se encuentra indentado");
                    return new Symbol(sym.INDENT_A, yyline+1, yycolumn, yytext());
                } else {
                    //System.out.println("No sé como entró acá");
                    return null;
                }
            } else {
                if (indentados > 0) {
                    indentados--;
                    yypushback(1);
                    //System.out.println("Se encuentra dedentado no2");
                    return new Symbol(sym.INDENT_C, yyline+1, yycolumn, yytext());
                } else {
                    yybegin(YYINITIAL);
                    yypushback(1);
                    return null;
                }
            }
        } else {
            if (indentados > 0) {
                indentados--;
                //System.out.println("Se encuentra dedentado no3");
                return new Symbol(sym.INDENT_C, yyline+1, yycolumn, yytext());
            } else {
                return new java_cup.runtime.Symbol(sym.EOF);
            }
        }
    }






%}

//%eof{
/* Código a ejecutar al finalizar el análisis, en este caso cambiaremos el valor de una variable bandera */
//%eof}

%%

<YYINITIAL>{
    
    ("Pista"|"PISTA"|"pista")                                   { return new Symbol(sym.PISTA,yyline+1,yycolumn, yytext()); }
    ("Extiende"|"EXTIENDE"|"extiende")                          { return new Symbol(sym.EXTIENDE,yyline+1,yycolumn, yytext()); }
    ("Entero"|"ENTERO"|"entero")                                { return new Symbol(sym.ENTERO,yyline+1,yycolumn, yytext()); }
    ("Doble"|"DOBLE"|"doble")                                   { return new Symbol(sym.DECIMAL,yyline+1,yycolumn, yytext()); }
    ("Boolean"|"BOOLEAN"|"boolean")                             { return new Symbol(sym.BOOLEAN,yyline+1,yycolumn, yytext()); }
    ("Caracter"|"CARACTER"|"caracter")                          { return new Symbol(sym.CHAR,yyline+1,yycolumn, yytext()); }
    ("Cadena"|"CADENA"|"cadena")                                { return new Symbol(sym.CADENA,yyline+1,yycolumn, yytext()); }
    ("Verdadero"|"VERDADERO"|"verdadero"|"TRUE"|"True"|"true")  { return new Symbol(sym.TRUE,yyline+1,yycolumn, yytext()); }
    ("Falso"|"FALSO"|"falso"|"FALSE"|"False"|"false")           { return new Symbol(sym.FALSE,yyline+1,yycolumn, yytext()); }
    ("Keep"|"KEEP"|"keep")                                      { return new Symbol(sym.KEEP,yyline+1,yycolumn, yytext()); }
    ("Var"|"VAR"|"var")                                         { return new Symbol(sym.VAR,yyline+1,yycolumn, yytext()); }
    ("Si"|"SI"|"si")                                            { return new Symbol(sym.SI,yyline+1,yycolumn, yytext()); }
    ("Sino"|"SINO"|"sino")                                      { return new Symbol(sym.SINO,yyline+1,yycolumn, yytext()); }
    ("Switch"|"SWITCH"|"switch")                                { return new Symbol(sym.SWITCH,yyline+1,yycolumn, yytext()); }
    ("Caso"|"CASO"|"caso")                                      { return new Symbol(sym.CASO,yyline+1,yycolumn, yytext()); }
    ("Salir"|"SALIR"|"salir")                                   { return new Symbol(sym.SALIR,yyline+1,yycolumn, yytext()); }
    ("Continuar"|"CONTINUAR"|"continuar")                       { return new Symbol(sym.CONTINUAR,yyline+1,yycolumn, yytext()); }
    ("Default"|"DEFAULT"|"default")                             { return new Symbol(sym.DEFAULT,yyline+1,yycolumn, yytext()); }
    ("Para"|"PARA"|"para")                                      { return new Symbol(sym.PARA,yyline+1,yycolumn, yytext()); }
    ("Mientras"|"MIENTRAS"|"mientras")                          { return new Symbol(sym.MIENTRAS,yyline+1,yycolumn, yytext()); }
    ("HACER"|"Hacer"|"hacer")                                   { return new Symbol(sym.HACER,yyline+1,yycolumn, yytext()); }
    ("RETORNA"|"Retorna"|"retorna")                             { return new Symbol(sym.RETORNA,yyline+1,yycolumn, yytext()); }
    ("REPRODUCIR"|"Reproducir"|"reproducir")                    { return new Symbol(sym.REPRODUCIR,yyline+1,yycolumn, yytext()); }
    //("do#")                                                     { return new Symbol(sym.DOO,yyline+1,yycolumn, yytext()); }
    //("do")                                                      { return new Symbol(sym.DO,yyline+1,yycolumn, yytext()); }
    //("re#")                                                     { return new Symbol(sym.REE,yyline+1,yycolumn, yytext()); }
    //("re")                                                      { return new Symbol(sym.RE,yyline+1,yycolumn, yytext()); }
    //("mi#")                                                     { return new Symbol(sym.MII,yyline+1,yycolumn, yytext()); }
    //("mi")                                                      { return new Symbol(sym.MI,yyline+1,yycolumn, yytext()); }
    //("fa#")                                                     { return new Symbol(sym.FAA,yyline+1,yycolumn, yytext()); }
    //("fa")                                                      { return new Symbol(sym.FA,yyline+1,yycolumn, yytext()); }
    //("sol#")                                                    { return new Symbol(sym.SOLL,yyline+1,yycolumn, yytext()); }
    //("sol")                                                     { return new Symbol(sym.SOL,yyline+1,yycolumn, yytext()); }
    //("la#")                                                     { return new Symbol(sym.LAA,yyline+1,yycolumn, yytext()); }
    //("la")                                                     { return new Symbol(sym.LA,yyline+1,yycolumn, yytext()); }
    //("si")                                                     { return new Symbol(sym.SII,yyline+1,yycolumn, yytext()); }
    ("ESPERAR"|"Esperar"|"esperar")                             { return new Symbol(sym.ESPERAR,yyline+1,yycolumn, yytext()); }
    ("ORDENAR"|"Ordenar"|"ordenar")                             { return new Symbol(sym.ORDENAR,yyline+1,yycolumn, yytext()); }
    ("IMPRIMIR"|"Imprimir"|"imprimir")                              { return new Symbol(sym.IMPRIMIR,yyline+1,yycolumn, yytext()); }
    
    ("ASCENDENTE"|"Ascendente"|"ascendente")|("DESCENDENTE"|"Descendente"|"descendente")|("PARES"|"Pares"|"pares")|("IMPARES"|"Impares"|"impares")|("PRIMOS"|"Primos"|"primos") { return new Symbol(sym.TIPOS_ORDENAMIENTO,yyline+1,yycolumn, yytext()); }
    
    ("SUMARIZAR"|"Sumarizar"|"sumarizar")                       { return new Symbol(sym.SUMARIZAR,yyline+1,yycolumn, yytext()); }
    ("LONGITUD"|"Longitud"|"longitud")                          { return new Symbol(sym.LONGITUD,yyline+1,yycolumn, yytext()); }
    ("MENSAJE"|"Mensaje"|"mensaje")                             { return new Symbol(sym.MENSAJE,yyline+1,yycolumn, yytext()); }
    ("PRINCIPAL"|"Principal"|"principal")                       { return new Symbol(sym.PRINCIPAL,yyline+1,yycolumn, yytext()); }
    ("ARREGLO"|"Arreglo"|"arreglo")                             { return new Symbol(sym.ARREGLO,yyline+1,yycolumn, yytext()); }
    ("do"|"re"|"mi"|"fa"|"sol"|"la"|"si"|"do#"|"re#"|"mi#"|"fa#"|"sol#"|"la#")  { return symbol(sym.NOTAS_MUSICALES); }
    ("==")                          { return new Symbol(sym.IGUALACION,yyline+1,yycolumn, yytext()); }
    ("!=")                          { return new Symbol(sym.DIFERENCIACION,yyline+1,yycolumn, yytext()); }
    (">")                           { return new Symbol(sym.MAYORQUE,yyline+1,yycolumn, yytext()); }
    ("<")                           { return new Symbol(sym.MENORQUE,yyline+1,yycolumn, yytext()); }
    (">=")                          { return new Symbol(sym.MAYORIGUAL,yyline+1,yycolumn, yytext()); }
    ("<=")                          { return new Symbol(sym.MENORIGUAL,yyline+1,yycolumn, yytext()); }
    ("!!")                          { return new Symbol(sym.ESNULO,yyline+1,yycolumn, yytext()); }
    ("&&")                          { return new Symbol(sym.AND,yyline+1,yycolumn, yytext()); }
    ("!&&")                         { return new Symbol(sym.NAND,yyline+1,yycolumn, yytext()); }
    ("||")                          { return new Symbol(sym.OR,yyline+1,yycolumn, yytext()); }
    ("!||")                         { return new Symbol(sym.NOR,yyline+1,yycolumn, yytext()); }
    ("&|")                          { return new Symbol(sym.XOR,yyline+1,yycolumn, yytext()); }
    ("!")                           { return new Symbol(sym.NOT,yyline+1,yycolumn, yytext()); }
    ("+")                          {return new Symbol(sym.SUMA,yyline+1,yycolumn, yytext());}
    ("-")                          {return new Symbol(sym.RESTA,yyline+1,yycolumn, yytext());}
    ("*")                          {return new Symbol(sym.MULTIPLICACION,yyline+1,yycolumn, yytext());}
    ("/")                          {return new Symbol(sym.DIVISION,yyline+1,yycolumn, yytext());}
    ("%")                          {return new Symbol(sym.MODULO,yyline+1,yycolumn, yytext());}
    ("^")                          {return new Symbol(sym.POTENCIA,yyline+1,yycolumn, yytext());}
    ("=")                          {return new Symbol(sym.IGUAL,yyline+1,yycolumn, yytext());}
    ("++")                          {return new Symbol(sym.INCREMENTO,yyline+1,yycolumn, yytext());}
    ("--")                          {return new Symbol(sym.DECREMENTO,yyline+1,yycolumn, yytext());}
    ("+=")                          {return new Symbol(sym.SUMA_SIMPLIFICADA,yyline+1,yycolumn, yytext()); }





    {CADENAA} {return new Symbol(sym.CADENAA,yyline+1,yycolumn, yytext()); }
    {PROGRAMA} {return new Symbol(sym.PROGRAMA,yyline+1,yycolumn, yytext()); } 
    {CHARRR} {return new Symbol(sym.CHARR,yyline+1,yycolumn, yytext()); } 
    {D} {return new Symbol(sym.ENTEROO,yyline+1,yycolumn, yytext()); } 
    {DD} {return new Symbol(sym.DECIMALL,yyline+1,yycolumn, yytext()); } 

    ("<-") { yybegin(COMMENT_MULTILINEA); }
    (">>") { yybegin(COMMENT_LINE);}
    ("[") { return new Symbol(sym.CORCHETE_ABRE,yyline+1,yycolumn, yytext()); }
    ("]") { return new Symbol(sym.CORCHETE_CIERRA,yyline+1,yycolumn, yytext()); }
    ("(") { return new Symbol(sym.PARENTESIS_ABRE,yyline+1,yycolumn, yytext()); }
    (")") { return new Symbol(sym.PARENTESIS_CIERRA,yyline+1,yycolumn, yytext()); }
    ("{") { return new Symbol(sym.LLAVE_ABRE,yyline+1,yycolumn, yytext()); }
    ("}") { return new Symbol(sym.LLAVE_CIERRA,yyline+1,yycolumn, yytext()); }
    (",") { return new Symbol(sym.COMA,yyline+1,yycolumn, yytext()); }

    (";") {return new Symbol(sym.PTCOMA,yyline+1,yycolumn, yytext());} 
    
    {BLANCOS} {}
    {SALTOLINEA}                      { yybegin(SALTO_LINEA);}
    {NOMBRE}                          { return new Symbol(sym.NOMBRE,yyline+1,yycolumn, yytext()); }

}


//*****************************************STATES*********************************
<COMMENT_MULTILINEA>{
    
    "->"        { yybegin(YYINITIAL); }
    [^""]     { }
}

<COMMENT_LINE>{
    {SALTOLINEA}                    { yybegin(YYINITIAL); }
    [^\n]                               { }
}

<SALTO_LINEA>{
    
    {TABULACION}                { Symbol retorno = indent(yytext(),true,false); if (retorno!=null) {return retorno; }; }
    {TABULACION}(">>")            { yybegin(COMMENT_LINE2); }
    {TABULACION}"<-"            { yybegin(COMMENT_MULTILINEA); }
    [^"\t"">>""<-"]             { Symbol retorno = indent(yytext(),false,false); if (retorno!=null) {return retorno; }; }

}
<COMMENT_LINE2>{
    {SALTOLINEA}                    { yybegin(SALTO_LINEA); }
    [^\n]                               { }

}

<COMMENT_MULTILINEA2>{
    "->"        { yybegin(SALTO_LINEA); }
    [^""]     { }
}

[^]
{
    System.err.println("Este es un error lexico: "+yytext()+", en la linea: "+yyline+1+", en la columna: "+yycolumn);
}