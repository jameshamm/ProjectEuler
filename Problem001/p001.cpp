#include <iostream>
#include <stdio.h>

using namespace std;

int sumToN(int n) {
	return (n*(n+1))/2;
}

int gcd(int a, int b) {
	if(a == 0) return b;
	else return gcd(b % a, a);
}

int lcm(int a, int b) {
	return (a * b) / gcd(a, b);
}

int main() {
	int N = 1000 - 1;
	int a = 3;
	int b = 5;
	int c = lcm(a, b);
	
	int total = a*sumToN(N/a) + b*sumToN(N/b) - c*sumToN(N/c);

	printf("%d", total);
	return 0;
}