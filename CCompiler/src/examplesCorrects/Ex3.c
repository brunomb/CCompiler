/* 3) Qual o valor das variaveis a, b, c, d, e, f apos
a execucao do seguinte trecho de codigo:
	int x = 2, y = 4;
	int a, b, c, d, e, f;
	a = x & y;
	b = x | y;
	c = x ^ y;
	d = ~x;
	e = x << 3;
	f = x >> 1;
*/
	
void main()
{
	int x = 2, y = 4;
	int a, b, c, d, e, f;
	a = x & y;
	b = x | y;
	c = x ^ y;
	d = ~x;
	e = x << 3;
	f = x >> 1;

	printf("a: %d\n", a);
	printf("b: %d\n", b);
	printf("c: %d\n", c);
	printf("d: %d\n", d);
	printf("e: %d\n", e);
	printf("f: %d\n", f);

}


/* output:
a: 0
b: 6
c: 6
d: -3
e: 16
f: 1
*/
