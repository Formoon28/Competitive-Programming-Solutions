/*
 * Problem Link: https://dmoj.ca/problem/ccc10j5
 */

import java.io.*;
import java.util.*;

public class CCC10_J5_KnightHop {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        boolean[][] isVisited = new boolean[8][8];
        int[][] chessboard = new int[8][8];
        int x1 = readInt()-1;
        int y1 = readInt()-1;
        int x2 = readInt()-1;
        int y2 = readInt()-1;

        nearestDistance(isVisited, chessboard, x1, y1);
        System.out.println(chessboard[x2][y2]);
    }

    public static void nearestDistance(boolean isVisited[][], int chessboard[][], int x, int y) {
        isVisited[x][y] = true;

        //x Moves 2, y moves 1
        if(x+2 < 8 && y+1 < 8 && (!isVisited[x+2][y+1] || chessboard[x][y]+1 < chessboard[x+2][y+1])) {
            chessboard[x+2][y+1] = chessboard[x][y]+1;
            nearestDistance(isVisited, chessboard, x+2, y+1);
        }
        if(x+2 < 8 && y-1 >= 0 && (!isVisited[x+2][y-1] || chessboard[x][y]+1 < chessboard[x+2][y-1])) {
            chessboard[x+2][y-1] = chessboard[x][y]+1;
            nearestDistance(isVisited, chessboard, x+2, y-1);
        }
        if(x-2 >= 0 && y+1 < 8 && (!isVisited[x-2][y+1] || chessboard[x][y]+1 < chessboard[x-2][y+1])) {
            chessboard[x-2][y+1] = chessboard[x][y]+1;
            nearestDistance(isVisited, chessboard, x-2, y+1);
        }
        if(x-2 >= 0 && y-1 >= 0 && (!isVisited[x-2][y-1] || chessboard[x][y]+1 < chessboard[x-2][y-1])) {
            chessboard[x-2][y-1] = chessboard[x][y]+1;
            nearestDistance(isVisited, chessboard, x-2, y-1);
        }

        //x Moves 1, y moves 2
        if(x+1 < 8 && y+2 < 8 && (!isVisited[x+1][y+2] || chessboard[x][y]+1 < chessboard[x+1][y+2])) {
            chessboard[x+1][y+2] = chessboard[x][y]+1;
            nearestDistance(isVisited, chessboard, x+1, y+2);
        }
        if(x+1 < 8 && y-2 >= 0 && (!isVisited[x+1][y-2] || chessboard[x][y]+1 < chessboard[x+1][y-2])) {
            chessboard[x+1][y-2] = chessboard[x][y]+1;
            nearestDistance(isVisited, chessboard, x+1, y-2);
        }
        if(x-1 >= 0 && y+2 < 8 && (!isVisited[x-1][y+2] || chessboard[x][y]+1 < chessboard[x-1][y+2])) {
            chessboard[x-1][y+2] = chessboard[x][y]+1;
            nearestDistance(isVisited, chessboard, x-1, y+2);
        }
        if(x-1 >= 0 && y-2 >= 0 && (!isVisited[x-1][y-2] || chessboard[x][y]+1 < chessboard[x-1][y-2])) {
            chessboard[x-1][y-2] = chessboard[x][y]+1;
            nearestDistance(isVisited, chessboard, x-1, y-2);
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
