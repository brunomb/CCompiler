import java_cup.runtime.*;

%%

%class Teste
%line
%column
%state STRING
%cup

%{
        private StringBuilder stringBuilder;
        
        public boolean hasNext() {
                return !zzAtEOF;
        }
        
        private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
        }
        
        private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
        }
        
        private void error(String message) {
                throw new RuntimeException("Erro Lexico: " + message);
        }
        public String current_lexeme(){
    int l = yyline+1;
    int c = yycolumn+1;
    return " (line: "+l+" , column: "+c+" , lexeme: '"+yytext()+"')";
  }
%}

%%

digito = [0-9]
letra = [a-zA-Z_]
espacoEmBranco = [ \t\v\n\f]
hexadecimal = [a-fA-F0-9]
exponencial = [Ee][+-]?{D}+
comentario = []

<YYINITIAL> {comentario}           { }
<YYINITIAL> {espacoEmBranco}       { }
<YYINITIAL> "auto"			       { return symbol(sym.AUTO, new String(yytext())); }
<YYINITIAL> "break"			       { return symbol(sym.BREAK, new String(yytext())); }
<YYINITIAL> "case"			       { return symbol(sym.CASE, new String(yytext())); }
<YYINITIAL> "char"			       { return symbol(sym.CHAR, new String(yytext())); }
<YYINITIAL> "const"			       { return symbol(sym.CONST, new String(yytext())); }
<YYINITIAL> "continue"		       { return symbol(sym.CONTINUE, new String(yytext())); }
<YYINITIAL> "default"		       { return symbol(sym.DEFAULT, new String(yytext())); }
<YYINITIAL> "do"			       { return symbol(sym.DO, new String(yytext())); }
<YYINITIAL> "double"		       { return symbol(sym.DOUBLE, new String(yytext())); }
<YYINITIAL> "else"			       { return symbol(sym.ELSE, new String(yytext())); }
<YYINITIAL> "enum"			       { return symbol(sym.ENUM, new String(yytext())); }
<YYINITIAL> "extern"		       { return symbol(sym.EXTERN, new String(yytext())); }
<YYINITIAL> "float"			       { return symbol(sym.FLOAT, new String(yytext())); }
<YYINITIAL> "for"			       { return symbol(sym.FOR, new String(yytext())); }
<YYINITIAL> "goto"			       { return symbol(sym.GOTO, new String(yytext())); }
<YYINITIAL> "if"			       { return symbol(sym.IF, new String(yytext())); }
<YYINITIAL> "int"			       { return symbol(sym.INT, new String(yytext())); }
<YYINITIAL> "long"			       { return symbol(sym.LONG, new String(yytext())); }
<YYINITIAL> "register"		       { return symbol(sym.REGISTER, new String(yytext())); }
<YYINITIAL> "return"		       { return symbol(sym.RETURN, new String(yytext())); }
<YYINITIAL> "short"			       { return symbol(sym.SHORT, new String(yytext())); }
<YYINITIAL> "signed"		       { return symbol(sym.SIGNED, new String(yytext())); }
<YYINITIAL> "sizeof"		       { return symbol(sym.SIZEOF, new String(yytext())); }
<YYINITIAL> "static"		       { return symbol(sym.STATIC, new String(yytext())); }
<YYINITIAL> "struct"		       { return symbol(sym.STRUCT, new String(yytext())); }
<YYINITIAL> "switch"		       { return symbol(sym.SWITCH, new String(yytext())); }
<YYINITIAL> "typedef"		       { return symbol(sym.TYPEDEF, new String(yytext())); }
<YYINITIAL> "union"			       { return symbol(sym.UNION, new String(yytext())); }
<YYINITIAL> "unsigned"		       { return symbol(sym.UNSIGNED, new String(yytext())); }
<YYINITIAL> "void"			       { return symbol(sym.VOID, new String(yytext())); }
<YYINITIAL> "volatile"		       { return symbol(sym.VOLATILE, new String(yytext())); }
<YYINITIAL> "while"			       { return symbol(sym.WHILE, new String(yytext())); }
<YYINITIAL> "..."			       { return symbol(sym.ELLIPSIS, new String(yytext())); }
<YYINITIAL> ">>="			       { return symbol(sym.RIGHT_ASSIGN, new String(yytext())); }
<YYINITIAL> "<<="			       { return symbol(sym.LEFT_ASSIGN, new String(yytext())); }
<YYINITIAL> "+="			       { return symbol(sym.ADD_ASSIGN, new String(yytext())); }
<YYINITIAL> "-="			       { return symbol(sym.SUB_ASSIGN, new String(yytext())); }
<YYINITIAL> "*="			       { return symbol(sym.MUL_ASSIGN, new String(yytext())); }
<YYINITIAL> "/="			       { return symbol(sym.DIV_ASSIGN, new String(yytext())); }
<YYINITIAL> "%="			       { return symbol(sym.MOD_ASSIGN, new String(yytext())); }
<YYINITIAL> "&="			       { return symbol(sym.AND_ASSIGN, new String(yytext())); }
<YYINITIAL> "^="			       { return symbol(sym.XOR_ASSIGN, new String(yytext())); }
<YYINITIAL> "|="			       { return symbol(sym.OR_ASSIGN, new String(yytext())); }
<YYINITIAL> ">>"			       { return symbol(sym.RIGHT_OP, new String(yytext())); }
<YYINITIAL> "<<"			       { return symbol(sym.LEFT_OP, new String(yytext())); }
<YYINITIAL> "++"			       { return symbol(sym.INC_OP, new String(yytext())); }
<YYINITIAL> "--"			       { return symbol(sym.DEC_OP, new String(yytext())); }
<YYINITIAL> "->"			       { return symbol(sym.PTR_OP, new String(yytext())); }
<YYINITIAL> "&&"			       { return symbol(sym.AND_OP, new String(yytext())); }
<YYINITIAL> "||"			       { return symbol(sym.OR_OP, new String(yytext())); }
<YYINITIAL> "<="			       { return symbol(sym.LE_OP, new String(yytext())); }
<YYINITIAL> ">="			       { return symbol(sym.GE_OP, new String(yytext())); }
<YYINITIAL> "=="			       { return symbol(sym.EQ_OP, new String(yytext())); }
<YYINITIAL> "!="			       { return symbol(sym.NE_OP, new String(yytext())); }
<YYINITIAL> ";"			           { return symbol(sym.PONTOEVIRGULA, new String(yytext())); }
<YYINITIAL> ("{"|"<%")		       { return symbol(sym.ABRECHAVES, new String(yytext())); }
<YYINITIAL> ("}"|"%>")		       { return symbol(sym.FECHACHAVES, new String(yytext())); }
<YYINITIAL> ","			           { return symbol(sym.VIRGULA, new String(yytext())); }
<YYINITIAL> ":"			           { return symbol(sym.DOISPONTOS, new String(yytext())); }
<YYINITIAL> "="			           { return symbol(sym.IGUAL, new String(yytext())); }
<YYINITIAL> "("			           { return symbol(sym.ABREPARENTESES, new String(yytext())); }
<YYINITIAL> ")"			           { return symbol(sym.FECHAPARENTESES, new String(yytext())); }
<YYINITIAL> ("["|"<:")		       { return symbol(sym.ABRECOCHETES, new String(yytext())); }
<YYINITIAL> ("]"|":>")		       { return symbol(sym.FECHACOCHETES, new String(yytext())); }
<YYINITIAL> "."			           { return symbol(sym.PONTO, new String(yytext())); }
<YYINITIAL> "&"			           { return symbol(sym.ECOMERCIAL, new String(yytext())); }
<YYINITIAL> "!"			           { return symbol(sym.EXCLAMACAO, new String(yytext())); }
<YYINITIAL> "~"			           { return symbol(sym.TIO, new String(yytext())); }
<YYINITIAL> "-"			           { return symbol(sym.MENOS, new String(yytext())); }
<YYINITIAL> "+"			           { return symbol(sym.MAIS, new String(yytext())); }
<YYINITIAL> "*"			           { return symbol(sym.ASTERISCO, new String(yytext())); }
<YYINITIAL> "/"			           { return symbol(sym.BARRA, new String(yytext())); }
<YYINITIAL> "%"			           { return symbol(sym.PORCENTO, new String(yytext())); }
<YYINITIAL> "<"			           { return symbol(sym.MENORQUE, new String(yytext())); }
<YYINITIAL> ">"			           { return symbol(sym.MAIORQUE, new String(yytext())); }
<YYINITIAL> "^"			           { return symbol(sym.CIRCUNFLEXO, new String(yytext())); }
<YYINITIAL> "|"			           { return symbol(sym.PIPELINE, new String(yytext())); }
<YYINITIAL> "?"			           { return symbol(sym.INTERROGACAO, new String(yytext())); }