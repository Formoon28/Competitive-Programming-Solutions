//Problem Link: https://dmoj.ca/problem/checknum

import java.io.*;
import java.util.*;

public class p07_CheckerNumber {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int t = readInt(); //test cases
		
		for(int i = 0; i < t; i++) {
			long n = readLong(); //The end result we want to achieve
			long nearestSquare = (long)(Math.sqrt(n)); //That does not exceed m
			if(nearestSquare*nearestSquare > n) nearestSquare--; //Prevents rounding error from sqrt
				
			long remaining = n - nearestSquare*nearestSquare;
			
			long digOdd = (long)(Math.ceil(nearestSquare/9.0));
			long digEven = (long)(Math.ceil(remaining/9.0));
			
			long shortestLength =  digOdd + digEven;
			if(digOdd > digEven+1) {
				shortestLength = digOdd + digOdd-1;
			} else if(digEven > digOdd) {
				shortestLength = 2*digEven;
			}
			
			if(remaining < 0) {
				System.out.println("srp"); //Square rounding problem
			} else {
				System.out.println(shortestLength);
			}
			
		}
	}


	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}

}