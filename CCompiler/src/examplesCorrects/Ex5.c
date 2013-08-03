#include <stdio.h>

void main() {

	int nums[10], input, max, min, soma;
	int i, j;
	float media;

	for (i = 0; i < 10; ++i) {
		scanf("%d", &input);

		if (i >= 1 && nums[i-1] == input) {
			break;
		}

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
