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
import java.util.Arrays;

public class p005 {
	public static void main(String[] args) {
		p005 problem = new p005();
		problem.solve();
	}

	void solve() {
		int n = 20;

		boolean[] primes = new boolean[n+1];
		Arrays.fill(primes, true);
		//primes[0] = primes[1] = false;
		for(int a = 2; a < n+1; a++) {
			if(primes[a]) {
				for(int b = a*a; b < n+1; b += a) {
					primes[b] = false;
				}
			}
		}

		int total = 1;
		for(int a = 2; a < n+1; a++) {
			if(primes[a]) {
				total *= powerBelowN(a, n);
			}
		}

		System.out.println(total);
	}

	int powerBelowN(int base, int max) {
		int power = (int)(Math.log(max)/Math.log(base));
		int result = 1;
		while(power > 0) {
			result *= base;
			power--;
		}

		return result;
	}

	int gcd(int a, int b) {
		return (b == 0)? a : gcd(b, a % b);
	}

	int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}
}