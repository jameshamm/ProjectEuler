/*	a < b < c
	o = odd
	e = even
	t = 1000

	a^2 + b^2 = c^2
	a + b + c = t

	=>	

	
	




*/

import java.util.*;
import java.util.concurrent.TimeUnit;

class p009 {
	public static void main(String[] args) {
		long start = System.nanoTime();
		p009 problem = new p009();
		problem.solve();

		System.out.println(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start)+ "ms");
	}

	void solve() {
		long count = 0;
		long target = 1000000;
		long targetDIV3 = target/3;

		for(long a = 2; a < targetDIV3; ++a) {
			for(long b = a+1; b < (target-a)/2; b += 2) {
				count++;

				if(target*(a + b) - a*b == (target*target)/2) {
					long c =  (long)Math.sqrt(a*a + b*b);
					System.out.printf("%d, %d, %d\n%d\n", a, b, c, a*b*c);
					//a = targetDIV3; 	//breaks outer loop
					//break;			//use if unique
				}
			}
		}

		System.out.println(count);
	}
}