/* 2) Implemente uma funcao de busca binaia
em um array de inteiros
*/

int binarySearch(int *vetor, int begin, int end, int key) {
	int mid = (begin + end) / 2;

	if (vetor[mid] == key) {
		return mid;
	}

	if (begin == end) {
		return -1;
	} else {

		if (key < vetor[mid]) {
			return binarySearch(vetor, begin, mid, key);
		} else {
			return binarySearch(vetor, mid + 1, end, key);
		}

	}
}


int main() {

	int v[10] = {11, 23, 37, 43, 53, 68, 75, 89, 97, 109};
	int input;

	while (1) {
		scanf("%d", &input);

		if (input == -1) {
			break;
		}

		printf("%d", binarySearch(v, 0, 9, input));
	}


	return 0;
}
