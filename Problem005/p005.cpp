/*		1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * ... * 20 = x
		
		6 = 2 * 3, so we can ignore most composite numbers
		12 = 2 * 2 * 3, we haven't accounted for this, we would be missing a factor of 2 from our final answer

		we should find dout the highest power of each prime <= n
			2^x = 20
			log2(2^x) = log2(20)
			x*log2(2) = log2(20)
			x = log(20)/log(2)

			In general the highest power, x = log(n)/log(p1)

		our result is p1^(log(n)/log(p1)) * p2^(log(n)/log(p2)) * ...
		where 2 <= p <= n where p is a prime 

		Side Note: since the powers are decreasing, and the numbers are in a log scale and small, we could calculate the power for the first prime (2)
			and then brute force the highest power for the rest of the primes, since it is guarenteed to be lower
			In addition, for all primes greater than the sqrt(n) the highest power is 1, and we don't have to work out any further powers for primes, 
			they are all 1

*/

#include <stdio.h>
#include <iostream>
#include <vector>
#include <math.h>
using namespace std;

int powerBelowN(int base, int max) {
	int power = (int)(log(max)/log(base));
	int result = base;
	while(power-- > 1) {
		result *= base;
		power;
	}

	return result;
}

int gcd(int a, int b) {
	return (b == 0)? a : gcd(b, a % b);
}

int lcm(int a, int b) {
	return (a * b) / gcd(a, b);
}

void solve() {
	int n = 20;

	vector<bool> numbers (n+1);
	vector<int> primes;
	fill(numbers.begin(), numbers.end(), true);
	//numbers[0] = numbers[1] = false;
	for(int a = 2; a < n+1; a++) {
		if(numbers[a]) {
			primes.push_back(a);
			for(int b = a*a; b < n+1; b += a) {
				numbers[b] = false;
			}
		}
	}

	int total = 1;
	for(int a = 0; a < primes.size(); a++) {
		total *= powerBelowN(primes[a], n);
	}

	printf("%d\n", total);
}

int main() {
	solve();
	return 0;
}
