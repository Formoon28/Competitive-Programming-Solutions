//Problem Link: https://dmoj.ca/problem/cchange
//Very similar to bank notes, used the same algorithm but bank notes has more restraints

import java.io.*;
import java.util.*;

public class p07_CoinChange {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static int INF = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		int x = readInt();
        int n = readInt();
        int[] denoms = new int[n];

        for(int i = 0; i < n; i++) {
            denoms[i] = readInt();
        }
	
		int[][] memo = new int[n][x+1];
		for(int[] row : memo) {
			Arrays.fill(row, -1);
		}
		System.out.println(solve(0, x, denoms, memo));
    }

    static int solve(int i, int remaining, int[] denoms, int[][] memo) {
        if(remaining == 0) return 0;
		if(i == denoms.length) return INF;
		if(memo[i][remaining] != -1) return memo[i][remaining];

		int best = INF;
		for(int j = 0; j*denoms[i] <= remaining; j++) {
			int result = solve(i+1, remaining-j*denoms[i], denoms, memo);
			if(result != INF) {
				best = Math.min(result+j, best);
			}
		}
		
		return memo[i][remaining] = best;
    }

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readCharacter() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}

}
