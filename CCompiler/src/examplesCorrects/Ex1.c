void main()
{
	int x, y, z;
	char w[6];
	"aa" = "a";
	x = y = 10;
	z = ++x;
	x = -x;
	y++;
	x = x + y - (z--);

    printf("%d", x);
}

/* output:
-11
*/
