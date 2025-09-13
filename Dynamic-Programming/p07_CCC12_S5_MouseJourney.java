//Problem Link: https://dmoj.ca/problem/ccc12s5

import java.io.*;
import java.util.*;

public class p07_CCC12_S5_MouseJourney {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int broX = readInt(); //Brother's cage x position
		int broY = readInt(); //Brother's cage y position
		boolean[][] catLocations = new boolean[broX][broY];
		
		int k = readInt(); //Number of cats
		for(int i = 0; i < k; i++) {
			int catX = readInt()-1;
			int catY = readInt()-1;
			
			catLocations[catX][catY] = true;
		}
		
		long[][] possiblePaths = new long[broX][broY]; //Each box stores the number of possible paths to reach it
		possiblePaths[0][0] = 1;
		
		//Calculate number of ways to reach the end
		for(int i = 0; i < broX; i++) {
			for(int j = 0; j < broY; j++) {
				if(catLocations[i][j]) { //If cat box
					possiblePaths[i][j] = 0;
				} else if(i != 0 || j != 0) {
					if(i == 0) {
						possiblePaths[i][j] = possiblePaths[i][j-1];
					} else if(j == 0) {
						possiblePaths[i][j] = possiblePaths[i-1][j];
					} else {
						possiblePaths[i][j] = possiblePaths[i-1][j] + possiblePaths[i][j-1];
					}
				}
			}
		}
		System.out.println(possiblePaths[broX-1][broY-1]);
	}
	
	//Failed recursive solution
	public static int findPath(boolean[][] catLocations, int x, int y) {
		//If we reached the brothers room
		if(x == catLocations.length-1 && y == catLocations[0].length-1) {
			return 1;
		} else if(x >= catLocations.length) { //Check if x has gone outside the box
			return 0;
		} else if(y >= catLocations[0].length) { //Check if y has gone outside the box
			return 0;
		}
		if(catLocations[x][y]) { //Check if we are at a cat room
			return 0;
		}
		return findPath(catLocations, x+1, y) + findPath(catLocations, x, y+1);
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