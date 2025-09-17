//https://dmoj.ca/problem/ccc05s4

import java.io.*;
import java.util.*;

public class p10_CCC05_S4_PyramidMessageScheme {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
        int l = readInt();

        /*
         * Given how the message list is given, n*10 is the amount of time the
         * old communication method takes. Under the new method, we only need to know
         * the deepest node in the communication tree, the total time needed is equal
         * to the worst case scenario
         */

        //Test each message list
        for(int a = 0; a < l; a++) {
            int n = readInt();

            //Take in all input first so we can determine the name of the Home node
            String[] subordinates = new String[n];
            for(int i = 0; i < n; i++) {
                subordinates[i] = readLine();
            }

            int maxDepth = -1;
            int depthVal = 0;
            Set<String> subordinateSet = new HashSet<>();
            subordinateSet.add(subordinates[n-1]);

            for(int i = 0; i < n; i++) {
                if(subordinateSet.contains(subordinates[i])) {
                    depthVal--;
                } else {
                    subordinateSet.add(subordinates[i]);
                    depthVal++;
                    if(depthVal > maxDepth) maxDepth = depthVal;
                }
            }
            System.out.println((n*10) - (maxDepth*2*10));
        }
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
