/* 6) Modifique a sua resposta para o exercicio anterior trocando os loops (for, while, do-while) para goto
*/

void main() {

	int nums[10], input, max, min, soma;
	int i, j;
	float media;

	i = 0;
	inputs:


	// Recebe o numero
	scanf("%d", &input);

	// Se o numero for igual ao anterior, break
	if (i >= 1 && nums[i-1] == input) {
		goto escape;
	}

	// Adiciona o numero a lista
	nums[i] = input;

	i++;
	if (i < 10) {
		goto inputs;
	}

	escape:

	max = min = nums[0];
	soma = 0;

	j = 0;

	calculaOutput:


	if (nums[j] > max) {
		max = nums[j];
	}

	if (nums[j] < min) {
		min = nums[j];
	}

	soma += nums[j];

	j++;

	if (j < i) {
		goto calculaOutput;
	}

	media = (float) soma / j;

	printf("Maior numero: %d\n", max);
	printf("Menor numero: %d\n", min);
	printf("Soma: %d\n", soma);
	printf("Media: %f\n", media);

}
