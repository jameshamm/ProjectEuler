#include <stdio.h>
#include <iostream>
#include <vector>
using namespace std;

bool isPal(int n) {
	vector<int> digits;
	while(n) {
		digits.push_back(n%10);
		n /= 10;
	}

	int len = digits.size();
	for(int i = 0; i < len/2; ++i) {
		if(digits[i] != digits[len-i-1]) return false;
	}
	return true;
}

void solve() {
	int best = 1;
	for(int a = 999; a >= 100; --a) {
		for(int b = 999; b >= a; --b) {
			int p = a * b;
			if(p < best) break; 
			if(isPal(p) && p > best) best = p;
		}
	}

	printf("%d\n", best);
}

int main() {
	solve();
	return 0;
}