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

#include <stdio.h>

void main()
{
	int x, y, z
	x = y = 10
	z = ++x
	x = -x
	y++;
	x = x + y - (z--);

    printf("%d", x);
}

/* output:
-11
*/