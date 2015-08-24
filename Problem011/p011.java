/*	We are given 26 × 63 × 78 × 14 = 1788696
		Thus we can ignore 0 values, since any product containing them is 0

	Taking this further 99 * 99 * 99 * 01 = 970299 < 1788696
		So we can ignore 1 values too.

	If we wanted, we could remember the highest value we have found so far, and use that in place of 99
		We might be able to eliminate bigger values, but the additional computation time may not be worth it
		Finding the product of 4 numbers is very fast anyway

	h = largest value found so far
	p = our current best product
	h * h * h * x = p
	x = p / h^3
	we can ignore all value up to x


	grid[r][c]*grid[r][c+1]*grid[r][c+2]*grid[r][c+3]
	grid[r][c]*grid[r+1][c]*grid[r+2][c]*grid[r+3][c]
	grid[r][c]*grid[r+1][c+1]*grid[r+2][c+2]*grid[r+3][c+3]
	grid[r][c]*grid[r+1][c-1]*grid[r+2][c-2]*grid[r+3][c-3]

	The number we add to each is:
		r:	0, 0, 0, 0
		r:	0, 1, 2, 3
		r:	0, 1, 2, 3
		r:	0, 1, 2, 3

		c:	0, 1, 2, 3
		c:	0, 0, 0, 0
		c:	0, 1, 2, 3
		c:	0,-1,-2,-3

	So if we wanted to create a 2d array to represent it, we'd have a lot of repeats, and it wouldn't really save on much code repetition
	If we note that the values are just 0-3, ie the index, we can then not bother storing all the values.

		r:	0, 0, 0, 0
		r:	0, 1, 1, 1
		r:	0, 1, 1, 1
		r:	0, 1, 1, 1

		c:	0, 1, 1, 1
		c:	0, 1, 1, 1
		c:	0, 0, 0, 0
		c:	0,-1,-1,-1

	Now it is obvious that we can just store a co-efficient for each row
		Multiplying the index by this co-efficient gives us the value we wanted, and index 0 produces 0 anyway, so no special case is needed
		
		r 	c
		0	1
		1	1
		1	0
		1  -1

		
	Next we have 3 directions: right, down and left, which we can also turn into a matrix, where 1 means it is used in a condition
	We go right, right-down, down, down-left, which is shown as

		right:	1, 1, 0, 0
		down:	0, 1, 1, 1
		left:	0, 0, 0, 1

	This is tricky to reduce to a 
*/

import java.math.*;
import java.util.*;
import java.io.*;

class p011 {
	public static void main(String[] args) {
		p011 problem = new p011();
		problem.solve();
	}

	void solve() {
		try {
			BufferedReader in = new BufferedReader(new FileReader("../data/Problem11"));
			String s = in.readLine();
			String[] split = s.split(" ");
			int size = split.length;
			int[][] grid = new int[size][size];
			for(int i = 0; i < size; ++i) {
				grid[0][i] = Integer.parseInt(split[i]);
			}
			int pointer = 1;
			while((s = in.readLine()) != null) {
				split = s.split(" ");
				for(int i = 0; i < size; ++i) {
					grid[pointer][i] = Integer.parseInt(split[i]);
				}
				++pointer;
			}
			int best = 0;
			int x = 0;
			int h = 99;
			int[] rowCoEfficients = new int[] {0, 1, 1, 1};
			int[] columnCoEfficients = new int[] {1, 0, 1, -1};
			for(int r = 0; r < size; ++r) {
				for(int c = 0; c < size; ++c) {
					if(grid[r][c] <= x) continue; 
					for(int d = 0; d <= 3; ++d) {
						int p = 1;
						for(int a = 0; a <= 3; ++a) {
							int rr = r + rowCoEfficients[d]*a;
							int cc = c + columnCoEfficients[d]*a;
							if(rr < size && rr >= 0 && cc < size && cc >= 0) {
								p *= grid[rr][cc];

							} else  {
								p = 0;
								break;
							}
						}
						if(p > best)  {
							best = p;
							x = best / (h * h * h);
						}	
					}
				}
			}
			System.out.println(best);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}