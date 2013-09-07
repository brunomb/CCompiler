int printf(int a, char b, int c)
{
	return a;
}

void teste(char a, float b, float c, float d)
{	
	int abc;
	
	abc = 10;
	
	return a;
}

void teste1(int a, char b) {
	int abc;
	
	abc = 15;
	
	return a+b;
}

int teste2() {
	 return b;
}

void main()
{
	int x, y, z;
	float k;
	char ult[];
	char c;
	char w[6];
	x = 1;
	x = 5;
	x = y = 6;
	z = ++x;	
	x = -x;	
	y++;
	x = x + y - (z--);
	
	x =  x && y;
	y = x || y;
	
	x = !x;
	
	switch (1) {
		case 1:
			return y;
			break;
		case 2:
			return z;
			break;
	}

}



/* output:
-11
*/
