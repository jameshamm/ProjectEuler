/*		3 + 6 + 9 + 12 + ... + N
	=	3(1 + 2 + 3 + 4 + ... + N/3)
	=	3*((N/3)*((N+1)/3)/2)

	The lcm is counted twice, so we have to subtract it
*/

public class p001 {
	public static void main(String[] args) {
		p001 problem = new p001();
		problem.solve();
	}

	void solve() {
		int N = 1000 - 1;
		int a, b, c;
		a = 3;
		b = 5;
		c = lcm(a, b);

		int total = a*sumToN(N/a) + b*sumToN(N/b) - c*sumToN(N/c);

		System.out.println(total);
	}

	int sumToN(int n) {
		return (n*(n+1))/2;
	}

	int gcd(int a, int b) {
	if(a == 0) return b;
		else return gcd(b % a, a);
	}

	int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}
}