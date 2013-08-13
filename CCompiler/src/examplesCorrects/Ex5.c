/* 5) Implemente um programa que le 10 inteiros do teclado ou para quando dois inteiros
   consecutivos sejam digitados. Apos a leitura o programa devera imprimir o maior, o
    menor, a media e a soma dos numeros digitados.
*/

void main() {

	int nums[10], input, max, min, soma;
	int i, j;
	float media;

	for (i = 0; i < 10; ++i) {
		// Recebe o numero
		scanf("%d", &input);

		// Se o numero for igual ao anterior, break
		if (i >= 1 && nums[i-1] == input) {
			break;
		}

		// Adiciona o numero a lista
		nums[i] = input;
	}

	max = min = nums[0];
	soma = 0;

	for (j = 0; j < i; ++j) {
		if (nums[j] > max) {
			max = nums[j];
		}

		if (nums[j] < min) {
			min = nums[j];
		}

		soma += nums[j];
	}

	media = (float) soma / j;

	printf("Maior numero: %d\n", max);
	printf("Menor numero: %d\n", min);
	printf("Soma: %d\n", soma);
	printf("Media: %f\n", media);

}
