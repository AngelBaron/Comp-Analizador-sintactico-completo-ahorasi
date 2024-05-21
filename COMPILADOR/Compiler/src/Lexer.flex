import compilerTools.Token;

%%
%class Lexer
%type Token
%line
%column
%{
    private Token token(String lexeme, String lexicalComp, int line, int column){
        return new Token(lexeme, lexicalComp, line+1, column+1);
    }
%}
/* Variables básicas de comentarios y espacios */
TerminadorDeLinea = \r|\n|\r\n
EntradaDeCaracter = [^\r\n]
EspacioEnBlanco = {TerminadorDeLinea} | [ \t\f]
ComentarioTradicional = "/*" [^*] ~"*/" | "/*" "*"+ "/"
FinDeLineaComentario = "//" {EntradaDeCaracter}* {TerminadorDeLinea}?
ContenidoComentario = ( [^*] | \*+ [^/*] )*
ComentarioDeDocumentacion = "/**" {ContenidoComentario} "*"+ "/"

/* Comentario */
Comentario = {ComentarioTradicional} | {FinDeLineaComentario} | {ComentarioDeDocumentacion}

/* Identificador */
Letra = [A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]
Digito = [0-9]
Identificador = {Letra}({Letra}|{Digito})*

/* Número */
Numero = 0 | [1-9][0-9]*
%%

/* Comentarios o espacios en blanco */
{Comentario}|{EspacioEnBlanco} { /*Ignorar*/ }

/* Número */
 {Numero} { return token(yytext(), "Numero_entero", yyline, yycolumn);}
{Numero}\.{Numero} { return token(yytext(), "Numero_Flotante", yyline, yycolumn);}

/*DECLARACION Y DEFINICION*/
const { return token(yytext(), "TIPO_C", yyline, yycolumn); }
var { return token(yytext(), "TIPO_V", yyline, yycolumn); }
package { return token(yytext(), "PACKAGE", yyline, yycolumn); }
import { return token(yytext(), "IMPORTACION", yyline, yycolumn); }
type { return token(yytext(), "TYPE", yyline, yycolumn); }
func { return token(yytext(), "FUNC", yyline, yycolumn); }



/*String*/
\"([^\"\\]|\\.)*\" { return token(yytext(), "STRING", yyline, yycolumn);}

/* Tipos de dato */
int |
float|
string |
bool { return token(yytext(), "TIPO_DATO", yyline, yycolumn);}

/*MAIN*/
main { return token(yytext(), "MAIN", yyline, yycolumn); }

/* Operadores de agrupacion */
"(" { return token(yytext(), "Parentesis_izq", yyline, yycolumn); }
")" { return token(yytext(), "Parentesis_der", yyline, yycolumn); }
"{" { return token(yytext(), "Llave_izq", yyline, yycolumn); }
"}" { return token(yytext(), "Llave_der", yyline, yycolumn); }
"[" { return token(yytext(), "Corchete_izq", yyline, yycolumn); }
"]" { return token(yytext(), "Corchete_der", yyline, yycolumn); }

/* Signos de puntuacion */
"," { return token(yytext(), "COMA", yyline, yycolumn); }
";" { return token(yytext(), "P_C", yyline, yycolumn); }
"." { return token(yytext(), "PUNTO", yyline, yycolumn); }

/*Operador de asignacion */
"=" { return token(yytext(), "Asignacion", yyline, yycolumn); }
":=" { return token(yytext(), "Asignacion_corta", yyline, yycolumn); }

/*Operador de comparacion */
"==" { return token(yytext(), "COMPARACION_IGUAL_A", yyline, yycolumn); }
"!=" { return token(yytext(), "NO_IGUAL_A", yyline, yycolumn); }
"<" { return token(yytext(), "MENOR_QUE", yyline, yycolumn); }
"<=" { return token(yytext(), "MENOR_O_IGUAL_QUE", yyline, yycolumn); }
">" { return token(yytext(), "MAYOR_QUE", yyline, yycolumn); }
">=" { return token(yytext(), "MAYOR_O_IGUAL_QUE", yyline, yycolumn); }

/*PALABRAS RESERVADAS*/
/*DE CONTROL */
if { return token(yytext(), "PALABRA_IF", yyline, yycolumn); }
else { return token(yytext(), "PALABRA_ELSE", yyline, yycolumn); }
switch { return token(yytext(), "PALABRA_SWITCH", yyline, yycolumn); }
break { return token(yytext(), "BREAK", yyline, yycolumn); }
while { return token(yytext(), "WHILE", yyline, yycolumn); }
case { return token(yytext(), "CASE", yyline, yycolumn); }
/*DE CICLO */
for { return token(yytext(), "FOR", yyline, yycolumn); }
while { return token(yytext(), "WHILE", yyline, yycolumn); }

/*RETORNO*/
return { return token(yytext(), "RETORNO", yyline, yycolumn); }

/*OPERADORES */
"+" |
"-" |
"/" { return token(yytext(), "OP_ARI", yyline, yycolumn); }


"&"|
"|"
 { return token(yytext(), "OP_LOGICO", yyline, yycolumn); }


/*Identificador */
{Identificador} { return token(yytext(), "IDENTIFICADOR", yyline, yycolumn);}

. { return token(yytext(), "ERROR", yyline, yycolumn); }