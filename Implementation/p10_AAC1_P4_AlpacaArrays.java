//Problem Link: https://dmoj.ca/problem/aac1p4

import java.io.*;
import java.util.*;

public class p10_AAC1_P4_AlpacaArrays {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
        int n = readInt(); //Length of the array
        int q = readInt(); //Number of queries to be asked

        int[] alpacaArray = new int[n];
        Map<Integer,ArrayList<Integer>> occurMatrix = new HashMap<>();

        //Read in array values
        for(int i = 0; i < n; i++) {
            alpacaArray[i] = readInt();
            if(occurMatrix.containsKey(alpacaArray[i])) {
                occurMatrix.get(alpacaArray[i]).add(i);
            } else {
                occurMatrix.put(alpacaArray[i], new ArrayList<>());
                occurMatrix.get(alpacaArray[i]).add(i);
            }
        }

        //Compute Queries
        for(int i = 0; i < q; i++) {
            int l = readInt()-1;
            int r = readInt()-1;
            int x = readInt();

            boolean foundSolution = false;
            for(int j = l; j <= r; j++) {
                //Check that this exists a divisor & x is not a square #
                if((x % alpacaArray[j] == 0) && (alpacaArray[j]*alpacaArray[j] != x)) {
                    if(occurMatrix.containsKey(x/alpacaArray[j])) {
                        for(int idx : occurMatrix.get(x/alpacaArray[j])) {
                            if(l <= idx && idx <= r) {
                                System.out.println("YES");
                                foundSolution = true;
                                break;
                            }
                        }
                        if(foundSolution) break;
                    }
                }
            }
            if(!foundSolution) System.out.println("NO");
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
