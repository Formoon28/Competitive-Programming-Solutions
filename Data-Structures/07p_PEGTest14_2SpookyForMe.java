//Problem Link: https://dmoj.ca/problem/2spooky4me

import java.io.*;
import java.util.*;

public class PEG_2Spooky4Me {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int numDeco = readInt();
		int numHouses = readInt();
		int maxSpookiness = readInt();
		ArrayList<Integer> eventTracker = new ArrayList<>();
		Map<Integer,Integer> eventChanges = new HashMap<Integer,Integer>();
		
		for(int i = 0; i < numDeco; i++) {
			int a = readInt();
			int b = readInt();
			int s = readInt();
			
			if(eventChanges.containsKey(a)) {
				eventChanges.put(a, eventChanges.get(a)+s);
			} else {
				eventTracker.add(a);
				eventChanges.put(a, s);
			}
			if(eventChanges.containsKey(b+1)) {
				eventChanges.put(b+1, eventChanges.get(b+1)-s);
			} else {
				eventTracker.add(b+1);
				eventChanges.put(b+1, -s);
			}
		}
		
		Collections.sort(eventTracker);
		
		int candies = 0;
		int currentSpookiness = 0;
		int prevHouse = 1;
		for(int eventHouse : eventTracker) {
			if(prevHouse < eventHouse) {
				if(currentSpookiness < maxSpookiness) {
					candies += eventHouse - prevHouse;
				}
			}
			currentSpookiness += eventChanges.get(eventHouse);
			prevHouse = eventHouse;
		}
		candies += numHouses-prevHouse+1;
		
		System.out.println(candies);
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
