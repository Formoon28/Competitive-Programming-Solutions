//Problem Link: 

import java.io.*;
import java.util.*;

public class COCI07_C3P3_Cross {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		String[][] sudokuBoard = new String[9][9];
		for(int i = 0; i < 9; i++) {
			String line = readLine();
			for(int j = 0; j < 9; j++) {
				sudokuBoard[i][j] = line.charAt(j)+"";
			}
		}
		
		boolean crossHatched = false; //Keeps track of if we have cross hatched everything thats possible
		boolean error = false; //keeps track if one of the 2 error conditions appears
		
		crossHatcher:
		while(!crossHatched) {
			crossHatched = true;
			for(int n = 1; n <= 9; n++) { //Keep trying to cross hatch every number
				boolean[][] board = new boolean[9][9];
				//Loop through each box and mark boxes that already have n as true
				for(int i = 0; i < 9; i++) {
					if(rowContains(sudokuBoard, i, n+"")) { //If the row contains n, n cannot be placed there
						for(int j = 0; j < 9; j++) {
							board[i][j] = true;
						}
					}
					if(colContains(sudokuBoard, i, n+"")) { //If the column contains n, n cannot be placed there
						for(int j = 0; j < 9; j++) {
							board[j][i] = true;
						}
					}
					if(boxContains(sudokuBoard, i, n+"")) { //If the box contains n, n cannot be placed there
						for(int j = 0; j < 3; j++) {
							for(int k = 0; k < 3; k++) {
								board[i-(i%3)+j][(i%3)*3+k] = true;
							}
						}
					}
					for(int j = 0; j < 9; j++) {
						if(!sudokuBoard[i][j].equals(".")) { //If a number has already been placed at this location, n cant go there
							board[i][j] = true;
						}
					}
				}
				
				//Now check to see if anything can be placed
				for(int i = 0; i < 9; i++) {
					String validityType = validBox(board, i);
					placeNum:
					if(validityType.equals("a")) {
						//If valid, add n to the correct location in the box
						for(int j = 0; j < 3; j++) {
							for(int k = 0; k < 3; k++) {
								if(board[i-(i%3)+j][(i%3)*3+k] == false) {
									sudokuBoard[i-(i%3)+j][(i%3)*3+k] = n+"";
									board[i-(i%3)+j][(i%3)*3+k] = true;
									
									for(int l = 0; l < 9; l++) {
										board[i-(i%3)+j][l] = true;
										board[l][(i%3)*3+k] = true;
									}
									
									crossHatched = false; //We add something, so the board hasn't finished crossHatching
									break placeNum;
								}
							}
						}
					} else if(validityType.equals("n") && !boxContains(sudokuBoard, i, n+"")) { //Invalid box but the box doesn't have n yet
						error = true;
						break crossHatcher;
					}
				}
			}
		}
		
		if(error) {
			System.out.println("ERROR");
		} else {
			for(int a = 0; a < 9; a++) {
				for(int b = 0; b < 9; b++) {
					System.out.print(sudokuBoard[a][b]);
				}
				System.out.println();
			}
		}
	}
	

	public static boolean boxContains(String[][] sudokuBoard, int boxNum, String num) {
		//Returns true if the 3x3 box (boxNum) contains num
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(sudokuBoard[boxNum-(boxNum%3)+i][(boxNum%3)*3+j].equals(num)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static String validBox(boolean[][] board, int boxNum) {
		//Returns "a" if the 3x3 box contains one false spot
		//Returns "m" if there are multiple false spots
		//Returns "n" if there are no spots
		int numFalse = 0;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(!board[boxNum-(boxNum%3)+i][(boxNum%3)*3+j]) {
					numFalse++;
				}
			}
		}
		
		if(numFalse == 1) return "a";
		else if(numFalse == 0) return "n";
		return "m";
	}
	
	public static boolean rowContains(String[][] sudokuBoard, int rowNum, String num) {
		//Returns true if the row (rowNum) contains num
		for(int i = 0; i < 9; i++) {
			if(sudokuBoard[rowNum][i].equals(num)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean colContains(String[][] sudokuBoard, int colNum, String num) {
		//Returns true if the column (colNum) contains num
		for(int i = 0; i < 9; i++) {
			if(sudokuBoard[i][colNum].equals(num)) {
				return true;
			}
		}
		return false;
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
