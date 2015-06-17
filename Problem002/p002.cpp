/*	1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, ...
	      e        e           e           e              e                e                 e                    e                      e

	Every third fibonacci number is even

	2, 8, 34, 144, 610, 2584, 10946, 46368, 196418

	f(n+3) 	= f(n+2) 		+ f(n+1)
			= f(n+1) + f(n) + f(n+1)
			= 2*f(n+1) + f(n)

	f(n+6)	= f(n+5) + f(n+4)
			= f(n+4) + f(n+3) + f(n+3) + f(n+2)
			= f(n+3) + f(n+2) + 2*f(n+1) + f(n) + 2*f(n+1) + f(n) + f(n+1) + f(n)
			= 2*f(n+1) + f(n) + f(n+1) + f(n) + 2*f(n+1) + f(n) + 2*f(n+1) + f(n) + f(n+1) + f(n)
			= 8*f(n+1) + 4*f(n) + f(n)
			= 4(2*f(n+1) + f(n)) + f(n)
			= 4*f(n+3) + f(n)

	So the next even term is given by the pervious two even terms

*/

#include <stdio.h>
#include <iostream>
using namespace std;

void solve() {
	long MAX = 4000000;
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

	printf("%d", total);
}

int main() {
	solve();
	return 0;
}