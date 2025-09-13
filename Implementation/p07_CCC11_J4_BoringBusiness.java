//Problem Link: https://dmoj.ca/problem/ccc11j4

import java.util.Scanner;

public class p07_CCC11_J4_BoringBusiness {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner myScanner = new Scanner(System.in);
		
		boolean[][] well = new boolean[401][401];
		
		//Setting up the already drilled squares
		//Row 1
		well[200][0] = true;
		//Row 2
		well[200][1] = true;
		//Row 3
		well[200][2] = true; 
		well[201][2] = true;
		well[202][2] = true;
		well[203][2] = true;
		well[205][2] = true;
		well[206][2] = true;
		well[207][2] = true;
		//Row 4
		well[203][3] = true;
		well[205][3] = true;
		well[207][3] = true;
		//Row 5
		well[199][4] = true;
		well[203][4] = true;
		well[204][4] = true;
		well[205][4] = true;
		well[207][4] = true;
		//Row 6
		well[199][5] = true;
		well[207][5] = true;
		//Row 7
		well[199][6] = true;
		well[200][6] = true;
		well[201][6] = true;
		well[202][6] = true;
		well[203][6] = true;
		well[204][6] = true;
		well[205][6] = true;
		well[206][6] = true;
		well[207][6] = true;
		
		String command = myScanner.next();
		int move = myScanner.nextInt();
		boolean isOk = true; //assume the move is ok
		int y = 4; //Starting point of y
		int x = 199; //Starting point of x
		
		while(!command.equals("q") && isOk) { //while not q and move is ok
			int xMove = 0; //amount x moves
			int yMove = 0; //amount y moves
			
			if(command.equals("d")) { //Down
				yMove = 1;
			} else if(command.equals("u")) { //Up
				yMove = -1;
			} else if(command.equals("l")) { //Left
				xMove = -1;
			} else if(command.equals("r")) { //Right
				xMove = 1;
			}
			
			while (move > 0) {
				x += xMove; //Change x pos
				y += yMove; //Change y pos
						
				if(!well[x][y]) { //Check if that spaces hasn't been drilled yet
					well[x][y] = true;
				} else { //If has been drilled
					isOk = false;
				}
				move--;
			}
			
			if(isOk) {
				System.out.println((x-200) + " " + (y+1)*-1 + " safe");
			} else {
				System.out.println((x-200) + " " + (y+1)*-1 + " DANGER");
			}
			command = myScanner.next();
			move = myScanner.nextInt();
		}
        myScanner.close();
	}
}