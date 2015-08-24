import java.math.*;
import java.util.*;

class p010 {
	public static void main(String[] args) {
		p010 problem = new p010();
		problem.solve();
	}

	void solve() {
		final int MAX = 2000000;
		BigInteger sum = BigInteger.ZERO;

		boolean[] primes = new boolean[MAX];
		Arrays.fill(primes, true);
		for(int i = 2; i < MAX; ++i) {
			if(primes[i]) {
				sum = sum.add(BigInteger.valueOf(i));
				for(int j = 2*i; j < MAX; j += i) {
					primes[j] = false;
				}
			}
		}
		System.out.println(sum);
	}
}