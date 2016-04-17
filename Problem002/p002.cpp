#include <stdio.h>
#include <iostream>
using namespace std;

long solve() {
	long MAX;
	cin >> MAX;
	if(MAX < 2) {
		return 0;
	}
	long total = 2; //start from 2, since we missed it
	long a = 2;
	long b = 8;
	long c = 0;
	
	while(b < MAX) {
		total += b;
		c = b;
		b = 4*b + a;
		a = c;
	}

	return total;
}

int main() {
	printf("%ld\n", solve());
	return 0;
}