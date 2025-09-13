//Problem Link: https://dmoj.ca/problem/coci07c2p3

import java.util.ArrayList;
import java.util.Scanner;

public class p07_COCI07_C2P3_Prva {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int r = input.nextInt(); //y length (num rows)
		int c = input.nextInt(); //x length (num columns)
		char[][] crossword = new char[r][c]; //Holds the crossword board
		ArrayList<String> words = new ArrayList<String>();
		
		//Read in the boxes of the crossword
		for(int i = 0; i < r; i++) {
			String line = input.next();
			for(int j = 0; j < c; j++) {
				crossword[i][j] = line.charAt(j);
			}
		}
		
		//Read all horizontal words
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c-1; j++) {
				//Check to make sure there are at least 2 letters
				if(crossword[i][j] != '#' && crossword[i][j+1] != '#') {
					int length = 2; //The words length
					String word = "" + crossword[i][j] + crossword[i][j+1];
					
					//Loop till we find
					while(j+length < c && crossword[i][j+length] != '#') {
						word += crossword[i][j+length];
						length++;
					}
					
					words.add(word);
					j += length; //Skip to where we stopped reading letters
				}
			}
		}
		
		//Read all vertical words
		for(int i = 0; i < c; i++) {
			for(int j = 0; j < r-1; j++) {
				//Check to make sure there are at least 2 letters
				if(crossword[j][i] != '#' && crossword[j+1][i] != '#') {
					int length = 2; //The words length
					String word = "" + crossword[j][i] + crossword[j+1][i];
					
					//Loop till we find
					while(j+length < r && crossword[j+length][i] != '#') {
						word += crossword[j+length][i];
						length++;
					}
					
					words.add(word);
					j += length; //Skip to where we stopped reading letters
				}
			}
		}
		
		
		//Find the lexicographically smallest
		String str = "{";
		for(int i = 0; i < words.size(); i++) {
			if(str.compareTo(words.get(i)) >= 0) { //if negative
				str = words.get(i);
			}
		}
		System.out.println(str);
        input.close();
	}
}