/*1)Qual o valor das vari�veis x, y e z ap�s o seguinte trecho de c�digo:*/ void main() { 	int x, y, z; 	x = y = 10; 	z = ++x; 	x = -x; 	y++; 	x = x + y - (z--);      printf("%d", x); }  /* output: -11 */   