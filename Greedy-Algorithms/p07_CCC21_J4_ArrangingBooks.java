//Problem Link: https://dmoj.ca/problem/ccc21j4

import java.io.*;
import java.util.*;

public class p07_CCC21_J4_ArrangingBooks {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		String books = br.readLine();
		int numSwaps = 0;
		int l = 0;
		int m = 0;
		int s = 0;
		
		//Find out how many of each book type there are
		for(int i = 0; i < books.length(); i++) {
			if(books.charAt(i) == 'L') {
				l++;
			} else if(books.charAt(i) == 'M') {
				m++;
			} else {
				s++;
			}
		}
		//Set up maps to store all the values
		Map<String, Integer> sectionL = new HashMap<String, Integer> ();
		sectionL.put("L", 0);
		sectionL.put("M", 0);
		sectionL.put("S", 0);
		Map<String, Integer> sectionM = new HashMap<String, Integer> ();
		sectionM.put("L", 0);
		sectionM.put("M", 0);
		sectionM.put("S", 0);
		Map<String, Integer> sectionS = new HashMap<String, Integer> (); 
		sectionS.put("L", 0);
		sectionS.put("M", 0);
		sectionS.put("S", 0);
		
		for(int i = 0; i < l; i++) {
			if(books.charAt(i) == 'L') {
				sectionL.put("L", sectionL.get("L")+1);
			} else if(books.charAt(i) == 'M') {
				sectionL.put("M", sectionL.get("M")+1);
			} else {
				sectionL.put("S", sectionL.get("S")+1);
			}
		}
		for(int i = l; i < l+m; i++) {
			if(books.charAt(i) == 'L') {
				sectionM.put("L", sectionM.get("L")+1);
			} else if(books.charAt(i) == 'M') {
				sectionM.put("M", sectionM.get("M")+1);
			} else {
				sectionM.put("S", sectionM.get("S")+1);
			}
		}
		for(int i = l+m; i < l+m+s; i++) {
			if(books.charAt(i) == 'L') {
				sectionS.put("L", sectionS.get("L")+1);
			} else if(books.charAt(i) == 'M') {
				sectionS.put("M", sectionS.get("M")+1);
			} else {
				sectionS.put("S", sectionS.get("S")+1);
			}
		}
		
		/*
		 * This section checks for 4 conditions, sectionL includes either an S or M and
		 * it needs to be place in either sectionS or sectionM.
		 */
		while(sectionL.get("M") != 0 || sectionL.get("S") != 0) {
			if(sectionL.get("S") != 0) { //If there is an S in sectionL
				if(sectionS.get("L") != 0) { //sectionS contains L
					sectionL.put("L", sectionL.get("L")+1);
					sectionL.put("S", sectionL.get("S")-1);
					sectionS.put("L", sectionS.get("L")-1);
					sectionS.put("S", sectionS.get("S")+1);
					numSwaps++;
				} else if(sectionM.get("L") != 0) {
					sectionL.put("L", sectionL.get("L")+1);
					sectionL.put("S", sectionL.get("S")-1);
					sectionM.put("L", sectionM.get("L")-1);
					sectionM.put("S", sectionM.get("S")+1);
					numSwaps++;
				}
			} else if(sectionL.get("M") != 0) { //If there is an M in sectionL
				//Check which section contains an L
				if(sectionS.get("L") != 0) {
					sectionL.put("L", sectionL.get("L")+1);
					sectionL.put("M", sectionL.get("M")-1);
					sectionS.put("L", sectionS.get("L")-1);
					sectionS.put("M", sectionS.get("M")+1);
					numSwaps++;
				} else if(sectionM.get("L") != 0) {
					sectionL.put("L", sectionL.get("L")+1);
					sectionL.put("M", sectionL.get("M")-1);
					sectionM.put("L", sectionM.get("L")-1);
					sectionM.put("M", sectionM.get("M")+1);
					numSwaps++;
				}
			}
		}
		
		while(sectionM.get("S") != 0) {
			sectionM.put("M", sectionM.get("M")+1);
			sectionM.put("S", sectionM.get("S")-1);
			sectionS.put("M", sectionS.get("M")-1);
			sectionS.put("S", sectionS.get("S")+1);
			numSwaps++;
		}

		System.out.println(numSwaps);
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