//Problem Link: https://dmoj.ca/problem/ccc07s4

import java.io.*;
import java.util.*;

public class p07_CCC07_S4_Waterpark {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt(); //number of nodes
        ArrayList<ArrayList<Integer>> slideGraph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            slideGraph.add(new ArrayList<>());
        }
        int a = readInt();
        int b = readInt();

        while(a != 0 && b != 0) {
            slideGraph.get(b).add(a);
            a = readInt();
            b = readInt();
        }

        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        System.out.println(solve(n, slideGraph, memo));

    }

    static int solve(int node, ArrayList<ArrayList<Integer>> slideGraph, int[] memo) {
        if(node == 1) return 1;
        if(memo[node] != -1) return memo[node];

        int waysToReachN = 0;
        for(int nextNode : slideGraph.get(node)) {
            waysToReachN += solve(nextNode, slideGraph, memo);
        }
        memo[node] = waysToReachN;

        return waysToReachN;
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
