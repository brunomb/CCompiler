#include <stdio.h>

int sum(int array[], int len) {
	int i;
	int result = 0;
	for (i = 0; i < len; ++i) {
		result += array[i];
	}

	return result;
}

void main() {
	int nums[] = {1,2,3,4,5,6,7,8,9,15};
	printf("%d", sum(nums, 10));
}