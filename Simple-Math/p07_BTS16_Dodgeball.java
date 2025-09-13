//Problem Link: https://dmoj.ca/problem/bts16p3

import java.util.*;

public class p07_BTS16_Dodgeball {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt(); //Num students
		String[] lineup = new String[n];
		
		for(int i = 0; i < n; i++) { //Get lineup of students
			lineup[i] = input.next();
		}
		int numGroups = n; //number of groups aurpine can pick
		
		for(int i = 0; i < n; i++) {
			//check to see if the next person on the left has same starting letter
			//a,b is the same as b,a
			if(i < n-1 && chooseNext(lineup[i], lineup[i+1])) {
				int temp = i;
				int inARow = 1;
				//Check to see how many same first letter names are in a row
				while(chooseNext(lineup[temp], lineup[temp+1])) {
					inARow++;
					temp++;
					if(temp >= n-1) break;
				}
				i += inARow-1;
				numGroups += (int)((inARow/2.0)*(1 + inARow)) - inARow; //Get number of 2+ groups
			}
		}
		
		System.out.println(numGroups%1000000007);
        input.close();
	}
	
	public static boolean chooseNext(String nameA, String nameB) {
		if(nameA.charAt(0) == nameB.charAt(0)) {
			return true;
		}
		return false;
	}
}