//Problem Link: https://dmoj.ca/problem/ccc21s2

import java.util.Scanner;

public class p07_CCC21_S2_ModernArt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner myScanner = new Scanner(System.in);
		int m = myScanner.nextInt(); //Coloum
		int n = myScanner.nextInt(); //Row
		int k = myScanner.nextInt();
		int[] rows = new int[m];
		int[] columns = new int[n];
		
		for(int i = 0; i < k; i++) { //Add in the lines that will be drawn
			String a = myScanner.next(); //A single Char
			int index = myScanner.nextInt(); //The integer value that follows
			
			if(a.equals("R")) {
				rows[index-1]++;
			} else {
				columns[index-1]++;
			}
		}
		
		int oddRows = 0;
		for(int i = 0; i < m; i++) { //Loop through rows[]
			if(rows[i] % 2 != 0) {
				oddRows++;
			}
		}
		
		int oddColumns = 0;
		for(int i = 0; i < n; i++) { //Loop through columns[]
			if(columns[i] % 2 != 0) {
				oddColumns++;
			}
		}
		
		int numGold = 0;
		numGold += m*oddColumns - oddColumns*oddRows; //Calculate gold in Coloums
		numGold += n*oddRows - oddRows*oddColumns; //Calculate gold in Rows
		System.out.println(numGold);
        myScanner.close();
	}
}