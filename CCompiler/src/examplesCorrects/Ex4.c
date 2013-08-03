#include <stdio.h>

int main() {

    int input;
	scanf("%d", &input);

	if (input % 3 == 0) {
		printf("sim");
	} else {
		printf("nao");
	}

	return 0;
}
