import java.util.Scanner;

public class p002 {
	public static void main(String[] args) {
		p002 problem = new p002();
		problem.solve();
	}

	void solve() {
		Scanner in = new Scanner(System.in);
		long MAX = in.nextInt();
		long a = 2;
		long b = 3;
		long c = 1;
		long total = 0;
		
		while(a < MAX) {
			total += a;

			c = a; // save a to a temp
			a = a + 2*b;
			b = 2*c + 3*b;
		}

		System.out.println(total);
	}
}