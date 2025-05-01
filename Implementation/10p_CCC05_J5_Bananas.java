//Problem Link: https://dmoj.ca/problem/ccc05j5

import java.io.*;
import java.util.*;

public class CCC05_J5_Bananas {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		String word = readLine();
		while(!word.equals("X")) {
			String[] splitWord = word.split("N");
			
			int numB = 0;
			int numS = 0;
			int numN = 0;
			boolean x = true;
			loop:
			for(String s : splitWord) {
				if( s.equals("A") || s.contains("BA") || s.contains("AS")) {
					if(s.contains("BA") && s.charAt(0) != 'B') {
						x = false;
						break;
					} else if (s.contains("AS")) {
						if(s.indexOf("AS",s.lastIndexOf("B")+1)!= s.lastIndexOf("B")+1) {
							x = false;
							break loop;
						} else {
							for(char a : s.substring(0, s.lastIndexOf("B")+1).toCharArray()) { //loop through each char in s up until the last B char 
								if(a != 'B') {
									x = false;
									break loop;
								}
							}
						}
					}
				} else {
					x = false;
					break;
				}
				
				for(char a : s.toCharArray()) {
					if(a == 'B') numB++;
					if(a == 'S') numS++;
				}
			}
			
			for(char a : word.toCharArray()) {
				if(a == 'N') numN++;
			}
			System.out.println((x && numB == numS && splitWord.length == numN+1) ? "YES" : "NO");
			word = readLine();
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
