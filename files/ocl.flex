import java_cup.sym;
import java_cup.runtime.*;

%%

%standalone
%class AnalisadorLexicoOcl
%line
%column
%state STRING
%cup

%{
	private StringBuilder stringBuilder;
	
  	public boolean hasNext() {
  		return !zzAtEOF;
  	}
	
	private Symbol createSymbol(int type, String typeToLog) {
    	return createSymbol(type, null, typeToLog);
  	}
  	
  	private Symbol createSymbol(int type, Object value, String typeToLog) {
  		String log = "Token encontrado: " + typeToLog + " (constante " + type + ")";
  		if (value != null) {
  			log += " value (" + value.getClass() + ") = <" + value + ">";
  		}
  		System.out.println(log);
    	return new Symbol(type, yyline, yycolumn, value);
  	}
  	
  	private void error(String message) {
  		throw new RuntimeException("Erro Lexico: " + message);
  	}
%}

boolean = "true" | "false"
numero = [0-9]+
letra = [a-zA-Z]
espacoEmBranco = [ \r\n\t\f]
inteiro = {numero}
pontoFlututante = {inteiro}\.{numero}([eE][+-]?[0-9]+)?
comentario = --([^\n\r])*[\n\r]
id = ({letra} | _)({letra} | {numero} | _)*
colecao = "Bag" | "Set" | "OrderedSet" | "Sequence"
delimString = \'

%%

<YYINITIAL> {comentario}    		{ }
<YYINITIAL> {espacoEmBranco}    	{ }
<YYINITIAL> "("						{ return createSymbol(AnalisadorSimbolosOcl.PARENTESQ, "PARENTESQ"); }
<YYINITIAL> ")"						{ return createSymbol(AnalisadorSimbolosOcl.PARENTDIR, "PARENTDIR"); }
<YYINITIAL> "."                   	{ return createSymbol(AnalisadorSimbolosOcl.PONTO, "PONTO"); }
<YYINITIAL> ","                   	{ return createSymbol(AnalisadorSimbolosOcl.VIRGULA, "VIRGULA"); }
<YYINITIAL> ":"						{ return createSymbol(AnalisadorSimbolosOcl.DOISPONTOS, "DOISPONTOS"); }
<YYINITIAL> "::"					{ return createSymbol(AnalisadorSimbolosOcl.DOISPONTOSDUPLO, "DOISPONTOSDUPLO"); }
<YYINITIAL> ">"						{ return createSymbol(AnalisadorSimbolosOcl.MAIOR, "MAIOR"); }
<YYINITIAL> ">="					{ return createSymbol(AnalisadorSimbolosOcl.MAIORIGUAL, "MAIORIGUAL"); }
<YYINITIAL> "<"						{ return createSymbol(AnalisadorSimbolosOcl.MENOR, "MENOR"); }
<YYINITIAL> "<="					{ return createSymbol(AnalisadorSimbolosOcl.MENORIGUAL, "MENORIGUAL"); }
<YYINITIAL> "="						{ return createSymbol(AnalisadorSimbolosOcl.IGUAL, "IGUAL"); }
<YYINITIAL> "<>"					{ return createSymbol(AnalisadorSimbolosOcl.DIFERENTE, "DIFERENTE"); }
<YYINITIAL> "and"					{ return createSymbol(AnalisadorSimbolosOcl.AND, "AND"); }
<YYINITIAL> "or"					{ return createSymbol(AnalisadorSimbolosOcl.OR, "OR"); }
<YYINITIAL> "xor"					{ return createSymbol(AnalisadorSimbolosOcl.XOR, "XOR"); }
<YYINITIAL> "not"					{ return createSymbol(AnalisadorSimbolosOcl.NOT, "NOT"); }
<YYINITIAL> "implies"				{ return createSymbol(AnalisadorSimbolosOcl.IMPLIES, "IMPLIES"); }
<YYINITIAL> "pre"					{ return createSymbol(AnalisadorSimbolosOcl.PRE, "PRE"); }
<YYINITIAL> "post"					{ return createSymbol(AnalisadorSimbolosOcl.POST, "POST"); }
<YYINITIAL> "context"				{ return createSymbol(AnalisadorSimbolosOcl.CONTEXT, "CONTEXT"); }
<YYINITIAL> "@pre"				    { return createSymbol(AnalisadorSimbolosOcl.APRE, "APRE"); }
<YYINITIAL> "self"					{ return createSymbol(AnalisadorSimbolosOcl.SELF, "SELF"); }
<YYINITIAL> "result"				{ return createSymbol(AnalisadorSimbolosOcl.RESULT, "RESULT"); }
<YYINITIAL> "if"					{ return createSymbol(AnalisadorSimbolosOcl.IF, "IF"); }
<YYINITIAL> "then"					{ return createSymbol(AnalisadorSimbolosOcl.THEN, "THEN"); }
<YYINITIAL> "else"					{ return createSymbol(AnalisadorSimbolosOcl.ELSE, "ELSE"); }
<YYINITIAL> "endif"					{ return createSymbol(AnalisadorSimbolosOcl.ENDIF, "ENDIF"); }
<YYINITIAL> "->"					{ return createSymbol(AnalisadorSimbolosOcl.ACESSOCOLECOES, "ACESSOCOLECOES"); }
<YYINITIAL> {boolean}        		{ return createSymbol(AnalisadorSimbolosOcl.BOOL, new Boolean(yytext()), "BOOL"); }
<YYINITIAL> {inteiro}        		{ return createSymbol(AnalisadorSimbolosOcl.INTEGER, new Integer(yytext()), "INTEGER"); }
<YYINITIAL> {pontoFlututante}    	{ return createSymbol(AnalisadorSimbolosOcl.REAL, new Double(yytext()), "REAL"); }
<YYINITIAL> {colecao}	            { return createSymbol(AnalisadorSimbolosOcl.COLECAO, yytext(), "COLECAO"); }
<YYINITIAL> {id}					{ return createSymbol(AnalisadorSimbolosOcl.ID, yytext(), "ID"); }
<YYINITIAL> "+"						{ return createSymbol(AnalisadorSimbolosOcl.MAIS, "MAIS"); }
<YYINITIAL> "-"						{ return createSymbol(AnalisadorSimbolosOcl.MENOS, "MENOS"); }
<YYINITIAL> "*"						{ return createSymbol(AnalisadorSimbolosOcl.VEZES, "VEZES"); }
<YYINITIAL> "/"						{ return createSymbol(AnalisadorSimbolosOcl.DIVISAO, "DIVISAO"); }
<YYINITIAL> {delimString}			{ 
							  	  	  stringBuilder = new StringBuilder();
							  	  	  yybegin(STRING);
									}
									
<STRING> "\\\\"						{ stringBuilder.append("\\"); }
<STRING> "\\\'"						{ stringBuilder.append("'"); }
<STRING> [^\\\'] 					{ stringBuilder.append(yytext()); }
<STRING> <<EOF>>					{ error("String incompleta!"); }
<STRING> {delimString}				{ 
    						  	 	  yybegin(YYINITIAL);
    					      	  	  return createSymbol(AnalisadorSimbolosOcl.STRING, stringBuilder.toString(), "STRING");
    								}

.|\n								{ error("Padrao desconhecido: <" + yytext() + "> na linha " + (yyline+1) + " e coluna " + (yycolumn+1) + "!"); }