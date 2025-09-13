//Problem Link: https://dmoj.ca/problem/ccc23s2

import java.io.*;
import java.util.*;

public class p07_CCC23_S2_SymmetricMountains {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt(); //number of mountains
        int[] m = new int[n]; //The height of all the mountains
        int[][] symmetry = new int[n][n];

        for(int i = 0; i < n; i++) {
            m[i] = readInt();
        }

        //all possible abs value calculations
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                symmetry[i][j] = Math.abs(m[i] - m[j]);
            }
        }

        int[][] symVals = new int[n][n];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if(i+1 <= n-1 && j-1 >= 0) {
                    symVals[i+1][j-1] += symVals[i][j] + symmetry[i][j];
                }
                symVals[i][j] += symmetry[i][j];
            }
        }

        int[] bestCrops = new int[n];
        for(int i = 0; i < n; i++) {
            bestCrops[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if(symVals[i][j] < bestCrops[i-j]) {
                    bestCrops[i-j] = symVals[i][j];
                }
            }
        }

        for(int i = 0; i < n; i++) {
            System.out.print(bestCrops[i] + " ");
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