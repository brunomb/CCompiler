/*1) Crie uma funcao que recebe um inteiro e
imprime os seu bits na ordem correta

Exemplos

showBits(5) imprime
00000000000000000000000000000101

showBits(20) imprime
00000000000000000000000000010100

showBits(-6) imprime
11111111111111111111111111111010
*/

void showBits(int num) {
	// len : Quantidade de bits
	// tmp : variavel temporaria para o numero

	int len = 32, bits[len], i, isNegative, tmp;

	// Se negativo, seta isNegative para que seja tratado no final
	if (num < 0) {
		isNegative = 1;
		tmp = -num;
	} else {
		isNegative = 0;
		tmp = num;
	}

	// Inicializa a variavel
	for (i = 0; i < len; ++i) {
		bits[i] = 0;
	}

	// Transforma o numero em binario
	i = 0;
	while (tmp > 0) {
		bits[i] = tmp % 2;
		tmp = tmp / 2;
		i++;
	}

	// Se negativo, inverte os bits a partir do primeiro 1
	if (isNegative) {
		i = 0;
		while (i < len && bits[i] != 1) {
			i++;
		}

		i++;

		while (i < len) {
			if (bits[i]) {
				bits[i] = 0;
			} else {
				bits[i] = 1;
			}

			i++;
		}
	}

	// Imprimi na ordem inversa
	for (i = len - 1; i >= 0; --i) {
		printf("%d", bits[i]);
	}
}

int main() {

	showBits(5);
	showBits(20);
	showBits(-6);

}
