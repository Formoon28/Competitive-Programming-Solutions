//Problem Link: https://dmoj.ca/problem/ccc01s3

import java.io.*;
import java.util.*;

public class CCC01_S3_StrategicBombing {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int[][] adjMatrix = new int[26][26];
		List<String> pairs = new ArrayList<>();
		String input = "";
		
		input = next();
		while(!input.equals("**")) {
			pairs.add(input);
			adjMatrix[input.charAt(0)-65][input.charAt(1)-65] = 1;
			adjMatrix[input.charAt(1)-65][input.charAt(0)-65] = 1;
			input = next();
		}
		
		int disconnectingRoads = 0;
		for(String s : pairs) {
			//Remove the road to test
			adjMatrix[s.charAt(0)-65][s.charAt(1)-65] = 0;
			adjMatrix[s.charAt(1)-65][s.charAt(0)-65] = 0;
			boolean[] isVisited = new boolean[26];
			checkConnectivity(adjMatrix, isVisited, 0);
			if(!isVisited[1]) {
				disconnectingRoads++;
				System.out.println(s);
			}
			
			//Add the road back
			adjMatrix[s.charAt(0)-65][s.charAt(1)-65] = 1;
			adjMatrix[s.charAt(1)-65][s.charAt(0)-65] = 1;
		}
		System.out.println("There are " + disconnectingRoads + " disconnecting roads.");
	}
	
	//DFS based method to check for connectivity between AB
	public static void checkConnectivity(int[][] adjMatrix, boolean[] isVisited, int node) {
		if (isVisited[node]) {
			return;
		}
		isVisited[node] = true;
		for(int i = 0; i < 26; i++) {
			if(adjMatrix[node][i] == 1) {
				checkConnectivity(adjMatrix, isVisited, i);
			}
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
