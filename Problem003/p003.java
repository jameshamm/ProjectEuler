public class p003 {
	public static void main(String[] args) {
		p003 problem = new p003();
		problem.solve();
	}


	long largestPrimeFactor(long N) {
		long i = 2;
		long temp = N;
		while(i * i <= temp) {
			while(temp % i == 0) {
				temp /= i;
			}
			i++;
		}
		return temp;
	}

	void solve() {
		long N = 600851475143L;
		long largest = largestPrimeFactor(N);

		System.out.println(largest);
	}
}