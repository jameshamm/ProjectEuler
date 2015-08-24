import java.util.*;

class p007 {
	public static void main(String[] args) {
		p007 problem = new p007();
		problem.solve();
	}

	void solve() {
		final int MAX = 1000000 + 7;
		final int target = 10001;
		final int sqrtMAX = (int)Math.sqrt(MAX);

		boolean[] primes = new boolean[MAX]; 
		Arrays.fill(primes, true);

		for(int i = 4; i < MAX; i += 2) {
			primes[i] = false;
		}

		int count = 1; //2 is prime

		for(int i = 3; i < MAX; i += 2) {
			if(primes[i]) {
				count++;
				if(count == target) {
					System.out.println(i);
					break;
				} else {
					if(i <= sqrtMAX) {
						for(int j = i*i; j < MAX; j += i) {
							primes[j] = false;
						}	
					}
						
				}
			}
		}

		
		
	}
}