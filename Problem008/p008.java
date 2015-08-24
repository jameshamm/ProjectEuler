import java.io.*;
import java.util.*;

class p008 {
	public static void main(String[] args) {
		p008 problem = new p008();
		problem.solve();
	}

	void solve() {
		int len = 1000; //given in problem
		int[] digits = new int[len];
		String s;
		int pointer = 0;
		try {
			BufferedReader in = new BufferedReader(new FileReader("..\\data\\Problem8"));
			while((s = in.readLine()) != null) {
				for(int i = 0; i < s.length(); ++i) {
					digits[pointer++] = s.charAt(i)-'0';
				}
			}


			long best = 1L;
			for(int i = 0; i < len-13; ++i) {
				long product = 1L;
				for(int j = i; j < i+13; ++j) {
					product *= digits[j];
				}
				if(product > best) {
					best = product;
				} 
			}

			System.out.println(best);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}