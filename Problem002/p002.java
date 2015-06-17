/*	1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, ...
	      e        e           e           e              e                e                 e                    e                      e

	Every third fibonacci number is even

	f(n+3) 	= f(n+2) 		+ f(n+1)
			= f(n+1) + f(n) + f(n+1)
			= 2*f(n+1) + f(n)

	Since we need f(n+1), we work out f(n+1+3)

	f(n+4)	= f(n+3) + f(n+2)
			= f(n+1) + f(n) + f(n+1) + f(n+1) + f(n)
			= 3*f(n+1) + 2*f(n)

	This gives us O(e) time, where e is the number of even numbers
*/

public class p002 {
	public static void main(String[] args) {
		p002 problem = new p002();
		problem.solve();
	}

	void solve() {
		long MAX = 4_000_000;
		long a = 2;
		long b = 3;
		long c = 1;
		long total = 0;
		
		while(a < MAX) {
			total += a;

			c = a; //save a to a temp
			a = a + 2*b;
			b = 2*c + 3*b;
		}

		System.out.println(total);
	}
}