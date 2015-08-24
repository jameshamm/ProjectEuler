class p006 {
	public static void main(String[] args) {
		p006 problem = new p006();
		problem.solve();
	}

	void solve() {
		int max = 100;
		long sum = triangle(max);
		long sumOfSquares = sumOfSquares(max);

		System.out.println(sum*sum - sumOfSquares);
	}

	long sumOfSquares(long n) {
		return (n * (n+1) * (2*n + 1)) / 6;
	}

	long triangle(long n) {
		return (n * (n+1)) / 2;
	}
}