/*	a < b < c
	a^2 + b^2 = c^2
	t = 1000
	a + b + c = t

	=>	c = t - a - b
	=>	c^2 = (t - a - b)^2
	=>		a^2 + b^2 = (t - a - b)(t - a - b)
	=>		a^2 + b^2 = t^2 - ta - tb - ta + a^2 + ab - tb + ab + b^2
	=>	2ta + 2tb - 2ab = t^2
	=>	ta + tb - ab = (t^2)/2
	=>	t(a + b) - ab = (t^2)/2
	
	2ta + 2tb - 2ab = t^2
	=>	2a + 2b - 2ab/t = t
	=>	a + b - ab/t = t/2
		this shows reason to believe that t is always even, and a + b + c is always even (see below)
		=>	t is a factor of ab, and since t divides by 2, so does ab
			if ab divides by 2, then atleast one of a or b must be even	
			thus we can increment b by 2 instead of 1, so its parity with a doesn't change
		so check if ab/t is an int, and then we can check the formula holds for a, b

	a < b < c
	a + b + c = t
	=>	(a + b + c)/3 = t/3
		if a > t/3 then so is b and c, so a + b + c > t
		therefore a < t/3

	=>	(b + c)/2 = (t - a)/2
		if b > (t - a)/2 then c > (t - a)/2
			thus b + c > (t - a)/2
		therefore b < (t - a)/2

		proof that t is always even:
			a^2 + b^2 = c^2
			-------------
			o   + o   = e
			o   + e   = o
			e   + o   = o
			e   + e   = e

			a + b + c = t
			-------------
			o + o + e = e
			o + e + o = e
			e + o + o = e
			e + e + e = e
*/

#include <stdio.h>
#include <iostream>
#include <math.h>
using namespace std;



void solve() {
	int target = 1000;
	int targetDIV3 = (int)target/3;

	for(int a = 2; a < targetDIV3; ++a) {
		for(int b = a+1; b < (target-a)/2; b += 2) {
			//printf("%d\n", (a + b) - (int)(a*b)/target);
			long product = a*b;
			if(product % target == 0 && a + b - product/target == target/2) {
				int c =  (int)sqrt(a*a + b*b);
				printf("%d, %d, %d\n%d\n", a, b, c, a*b*c);
				//a = targetDIV3; 	//breaks outer loop
				//break;			//use if unique
			}
		}
	}
}

int main() {
	solve();
	return 0;
}