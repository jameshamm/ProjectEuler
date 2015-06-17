#include <stdio.h>
#include <iostream>
using namespace std;

long long largestPrimeFactor(long long N) {
	long long i = 2;
	long long temp = N;
	while(i * i <= temp) {
		while(temp % i == 0) {
			temp /= i;
		}
		i++;
	}
	return temp;
}

void solve() {
	long long N = 600851475143;
	long long largest = largestPrimeFactor(N);

	printf("%lld\n", largest);
}

int main() {
	solve();
	return 0;
}