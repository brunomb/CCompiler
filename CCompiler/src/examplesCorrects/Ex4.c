/* 4)Escreva um programa que le um inteiro do teclado responde 'sim' se ele e um multiplo de 3 e 'nao' caso contrario
Tome como base a seguinte estrutura de programa:
	#include <stdio.h>

	int main() {
		return 0;
	}
*/

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
