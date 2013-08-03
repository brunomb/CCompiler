#include <stdio.h>

void showBits(int num) {
	int len = 32, bits[len], i, isNegative, tmp;

	if (num < 0) {
		isNegative = 1;
		tmp -num;
	} else {
		isNegative = 0;
		tmp = num;
	}

	for (i = 0; i < len; ++i) {
		bits[i] = 0;
	}

	i = 0;
	while (tmp > 0) {
		bits[i] = tmp % 2;
		tmp = tmp / 2;
		i++;
	}

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
	
	for (i = len - 1; i >= 0; --i) {
		printf("%d", bits[i]);
	}
}

int main() {

	showBits(5);
	showBits(20);
	showBits(-6);

}