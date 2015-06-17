public class p004 {
	public static void main(String[] args) {
		p004 problem = new p004();
		problem.solve();
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

		System.out.printf("%d\n", best);
	}

	boolean isPal(int n) {
		int[] digits = new int[10]; //2^32 is around 4.3 * 10^9, so no more than 10 digits in an int
		int len = 0;
		while(n > 0) {
			digits[len] = n%10;
			n /= 10;
			len++;
		}

		for(int i = 0; i < len/2; ++i) {
			if(digits[i] != digits[len-i-1]) return false;
		}
		return true;
	}
}