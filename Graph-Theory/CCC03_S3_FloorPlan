/*
 * Problem Link: https://dmoj.ca/problem/ccc03s3
 */

import java.io.*;
import java.util.*;

public class CCC03_S3_FloorPlan {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int numFlooring = readInt(); //the amount of flooring given
        int r = readInt();
        int c = readInt();
        char[][] floorPlan = new char[r][c]; //this will also double as the isVisited array

        for(int i = 0; i < r; i++) {
            String input = next();
            for(int j = 0; j < c; j++) {
                floorPlan[i][j] = input.charAt(j);
            }
        }

        ArrayList<Integer> roomSizes = new ArrayList<>();
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(floorPlan[i][j] == '.') {
                    roomSizes.add(findRoomSize(floorPlan, i, j));
                }
            }
        }

        Collections.sort(roomSizes);
        int numRooms = 0;
        for(int i = roomSizes.size()-1; i >= 0; i--) {
            if(numFlooring - roomSizes.get(i) < 0) {
                break;
            }
            numRooms++;
            numFlooring -= roomSizes.get(i);
        }
        if(numRooms == 1) {
            System.out.println(numRooms + " room, " + numFlooring + " square metre(s) left over");
        } else {
            System.out.println(numRooms + " rooms, " + numFlooring + " square metre(s) left over");
        }
    }

    //BFS flood fill algorithm to find the room size
    public static int findRoomSize(char[][] floorPlan, int i, int j) {
        int roomSize = 0;
        Queue<int[]> q = new LinkedList<>();
        int[] pair = {i,j};
        q.add(pair);
        floorPlan[i][j] = 'I';

        while(!q.isEmpty()) {
            i = q.peek()[0];
            j = q.peek()[1];
            roomSize++;

            if(i+1 < floorPlan.length && floorPlan[i+1][j] != 'I') {
                int[] pair2 = {i+1,j};
                floorPlan[i+1][j] = 'I';
                q.add(pair2);
            }
            if(i-1 >= 0 && floorPlan[i-1][j] != 'I') {
                int[] pair2 = {i-1,j};
                floorPlan[i-1][j] = 'I';
                q.add(pair2);
            }
            if(j+1 < floorPlan[0].length && floorPlan[i][j+1] != 'I') {
                int[] pair2 = {i,j+1};
                floorPlan[i][j+1] = 'I';
                q.add(pair2);
            }
            if(j-1 >= 0 && floorPlan[i][j-1] != 'I') {
                int[] pair2 = {i,j-1};
                floorPlan[i][j-1] = 'I';
                q.add(pair2);
            }
            q.remove();
        }

        return roomSize;
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
