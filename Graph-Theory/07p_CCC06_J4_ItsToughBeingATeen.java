/*
 * Problem Link: https://dmoj.ca/problem/ccc06j4
 */

import java.io.*;
import java.util.*;

public class CCC06_J4_ItsToughBeingATeen {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		boolean[][] constraints = new boolean[7][7];
		
		// In this case, true represents that this task can be done before this task,
		// false means it cannot
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				constraints[i][j] = true;
			}
		}
		// Add in already know restraints
		constraints[6][0] = false;
		constraints[3][0] = false;
		constraints[0][1] = false;
		constraints[3][2] = false;
		constraints[4][2] = false;

		// Add in additional restraints given through the day
		int x = -1;
		int y = -1;
		while (x != 0 && y != 0) {
			x = readInt();
			y = readInt();

			if (x != 0 && y != 0) {
				constraints[y - 1][x - 1] = false;
			}
		}

		String order = findTaskOrder(constraints);
		System.out.println(order.substring(0, order.length() - 1));

	}

	public static String findTaskOrder(boolean[][] constraints) {
		String taskOrder = "";
		int taskComplete = 0;
		
		for (int i = 0; i < 7; i++) { // Find the starting task
			boolean validTask = true;
			for (int j = 0; j < 7; j++) { // Makes sure there are no falses
				if (constraints[i][j] == false) {
					validTask = false;
					break;
				}
			}
			
			if(validTask) {
				for (int j = 0; j < 7; j++) {
					constraints[j][i] = true; // Make task i no longer visitable by setting to false
					constraints[i][j] = false; // Make all other tasks that require i to be completed before to be true
				}
				taskOrder += (i+1) + " ";
				taskComplete++;

				if (taskComplete == 7) { // If this is the last task that needed to be completed
					return taskOrder;
				} else {
					i = -1;
				}
			}
		}

		// No starting task
		return "Cannot complete these tasks. Going to bed. ";
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
