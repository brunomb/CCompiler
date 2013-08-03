import java_cup.runtime.*;

%%

%class LexicalAnalysisCalculator
%column
%line
%cup

%{
	   
	   private Symbol symbol(int type) {
		   return new Symbol(type, yyline, yycolumn);
   	   }
   	
 	   private Symbol symbol(int type, Object val) {
		   return new Symbol(type, yyline, yycolumn, val);
   	   }
%}

%%

/*Aqui estao definidos os possiveis tokens que podem ser encontrados numa calculadora simples*/

/*adicionado de C*/
"break" { return symbol(sym.BREAK, new String(yytext())); }
"auto" { return symbol(sym.AUTO, new String(yytext())); }
"break" { return symbol(sym.BREAK, new String(yytext())); }
"case" { return symbol(sym.CASE, new String(yytext())); }
"char" { return symbol(sym.CHAR, new String(yytext())); }
"const" { return symbol(sym.CONST, new String(yytext())); }
"continue" { return symbol(sym.CONTINUE, new String(yytext())); }
"default" { return symbol(sym.DEFAULT, new String(yytext())); }
"do" { return symbol(sym.DO, new String(yytext())); }
"double" { return symbol(sym.DOUBLE, new String(yytext())); }
"else" { return symbol(sym.ELSE, new String(yytext())); }
"enum" { return symbol(sym.ENUM, new String(yytext())); }
"extern" { return symbol(sym.EXTERN, new String(yytext())); }
"float" { return symbol(sym.FLOAT, new String(yytext())); }
"for" { return symbol(sym.FOR, new String(yytext())); }
"goto" { return symbol(sym.GOTO, new String(yytext())); }
"if" { return symbol(sym.IF, new String(yytext())); }
"int" { return symbol(sym.INT, new String(yytext())); }
"long" { return symbol(sym.LONG, new String(yytext())); }
"register" { return symbol(sym.REGISTER, new String(yytext())); }
"return" { return symbol(sym.RETURN, new String(yytext())); }
"short" { return symbol(sym.SHORT, new String(yytext())); }
"signed" { return symbol(sym.SIGNED, new String(yytext())); }
"sizeof" { return symbol(sym.SIZEOF, new String(yytext())); }
"static" { return symbol(sym.STATIC, new String(yytext())); }
"struct" { return symbol(sym.STRUCT, new String(yytext())); }
"switch" { return symbol(sym.SWITCH, new String(yytext())); }
"typedef" { return symbol(sym.TYPEDEF, new String(yytext())); }
"union" { return symbol(sym.UNION, new String(yytext())); }
"unsigned" { return symbol(sym.UNSIGNED, new String(yytext())); }
"void" { return symbol(sym.VOID, new String(yytext())); }
"volatile" { return symbol(sym.VOLATILE, new String(yytext())); }
"while" { return symbol(sym.WHILE, new String(yytext())); }
"..." { return symbol(sym.ELLIPSIS, new String(yytext())); }
">>=" { return symbol(sym.RIGHT_ASSIGN, new String(yytext())); }
"<<=" { return symbol(sym.LEFT_ASSIGN, new String(yytext())); }
"+=" { return symbol(sym.ADD_ASSIGN, new String(yytext())); }
"-=" { return symbol(sym.SUB_ASSIGN, new String(yytext())); }
"*=" { return symbol(sym.MUL_ASSIGN, new String(yytext())); }
"/=" { return symbol(sym.DIV_ASSIGN, new String(yytext())); }
"%=" { return symbol(sym.MOD_ASSIGN, new String(yytext())); }
"&=" { return symbol(sym.AND_ASSIGN, new String(yytext())); }
"^=" { return symbol(sym.XOR_ASSIGN, new String(yytext())); }
"|=" { return symbol(sym.OR_ASSIGN, new String(yytext())); }
">>" { return symbol(sym.RIGHT_OP, new String(yytext())); }
"<<" { return symbol(sym.LEFT_OP, new String(yytext())); }
"++" { return symbol(sym.INC_OP, new String(yytext())); }
"--" { return symbol(sym.DEC_OP, new String(yytext())); }
"->" { return symbol(sym.PTR_OP, new String(yytext())); }
"&&" { return symbol(sym.AND_OP, new String(yytext())); }
"||" { return symbol(sym.OR_OP, new String(yytext())); }
"<=" { return symbol(sym.LE_OP, new String(yytext())); }
">=" { return symbol(sym.GE_OP, new String(yytext())); }
"==" { return symbol(sym.EQ_OP, new String(yytext())); }
"!=" { return symbol(sym.NE_OP, new String(yytext())); }
";"	{ return symbol(sym.PONTOEVIRGULA, new String(yytext())); }
("{"|"<%") { return symbol(sym.ABRECHAVES, new String(yytext())); }
("}"|"%>") { return symbol(sym.FECHACHAVES, new String(yytext())); }
"," { return symbol(sym.VIRGULA, new String(yytext())); }
":" { return symbol(sym.DOISPONTOS, new String(yytext())); }
"=" { return symbol(sym.IGUAL, new String(yytext())); }
"("	{ return symbol(sym.ABREPARENTESES, new String(yytext())); }
")"	{ return symbol(sym.FECHAPARENTESES, new String(yytext())); }
("["|"<:") { return symbol(sym.ABRECOCHETES, new String(yytext())); }
("]"|":>") { return symbol(sym.FECHACOCHETES, new String(yytext())); }
"."	{ return symbol(sym.PONTO, new String(yytext())); }
"&"	{ return symbol(sym.ECOMERCIAL, new String(yytext())); }
"!"	{ return symbol(sym.EXCLAMACAO, new String(yytext())); }
"~"	{ return symbol(sym.TIO, new String(yytext())); }
"-"	{ return symbol(sym.MENOS, new String(yytext())); }
"+"	{ return symbol(sym.MAIS, new String(yytext())); }
"*"	{ return symbol(sym.ASTERISCO, new String(yytext())); }
"/"	{ return symbol(sym.BARRA, new String(yytext())); }
"%"	{ return symbol(sym.PORCENTO, new String(yytext())); }
"<"	{ return symbol(sym.MENORQUE, new String(yytext())); }
">"	{ return symbol(sym.MAIORQUE, new String(yytext())); }
"^"	{ return symbol(sym.CIRCUNFLEXO, new String(yytext())); }
"|"	{ return symbol(sym.PIPELINE, new String(yytext())); }
"?"	{ return symbol(sym.INTERROGACAO, new String(yytext())}

/* Duvidas aqui \/ */

"duvidaConstant"	{ return symbol(sym.CONSTANT, new String(yytext())}
"duvidaIdent" { return symbol(sym.IDENTIFIER, new String(yytext())}
"duvidastringliteral" { return symbol(sym.STRING_LITERAL, new String(yytext())}

/* Duvidas aqui /\ */

[0-9]+ { return symbol(sym.NUMBER); }
[ \r\n\t\f] { /*nao faz nada*/ }
[a-z] { return symbol(sym.STRING); }
<<EOF>> { return symbol(sym.EOF); }