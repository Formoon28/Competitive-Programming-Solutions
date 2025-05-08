//Problem Link: https://dmoj.ca/problem/ccc05j4

import java.io.*;
import java.util.*;

public class CCC05_J4_CrossSpiral {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int width = readInt();
        int height = readInt();
        int cutWidth = readInt();
        int cutHeight = readInt();
        int steps = readInt();

        boolean[][] cross = new boolean[height][width];
        for(int i = 0; i < cutHeight; i++) {
        	for(int j = 0; j < cutWidth; j++) {
        		cross[i][j] = true;
        		cross[i][width-j-1] = true;
        		cross[height-i-1][j] = true;
        		cross[height-i-1][width-j-1] = true;
        	}
        }
        
        int xPos = cutWidth;
        int yPos = 0;
        int stepsTaken = 0;
        boolean cornerReached = true;
        boolean firstIteration = true;
        
        while(stepsTaken < steps) {
        	if(xPos+1 < width && cross[yPos][xPos+1]
               && xPos-1 >= 0 && cross[yPos][xPos-1]
               && yPos+1 < height && cross[yPos+1][xPos]		
               && yPos-1 >= 0 && cross[yPos-1][xPos]) {
        		break;
        	}
        	
        	cross[yPos][xPos] = true;
            if(xPos < width/2 && yPos < height/2) { //Top Left
        		if(cornerReached) {
        			if(xPos+1 < width && !cross[yPos][xPos+1]) {
        				xPos++;
        				stepsTaken++;
        			}
        			if(xPos >= width/2) {
        				cornerReached = false;
        			}
        		} else {
        			if(yPos-1 >= 0 && !cross[yPos-1][xPos]) {
        				yPos--;
        				stepsTaken++;
        			} else {
        				//Compute the corner
        				cornerReached = true;
        				for(int i = 0; i < cutWidth; i++) {
        					if(stepsTaken < steps) {
        						xPos++;
        						cross[yPos][xPos] = true;
        						stepsTaken++;
        					}
        				}
        				for(int i = 0; i < cutHeight-1; i++) {
        					if(stepsTaken < steps) {
        						yPos--;
        						cross[yPos][xPos] = true;
        						stepsTaken++;
        					}
        				}
        			}
        		}
        		
        	} else if(xPos < width/2 && yPos >= height/2) { //Bottom Left
        		if(cornerReached) {
        			if(yPos-1 >= 0 && !cross[yPos-1][xPos]) {
        				yPos--;
        				stepsTaken++;
        			}
        			if(yPos < height/2) {
        				cornerReached = false;
        			}
        		} else {
        			if(xPos-1 >= 0 && !cross[yPos][xPos-1]) {
        				xPos--;
        				stepsTaken++;
        			} else {
        				//Compute the corner
        				cornerReached = true;
        				for(int i = 0; i < cutHeight; i++) {
        					if(stepsTaken < steps) {
        						yPos--;
        						cross[yPos][xPos] = true;
        						stepsTaken++;
        					}
        				}
        				for(int i = 0; i < cutWidth; i++) {
        					if(stepsTaken < steps) {
        						xPos--;
        						cross[yPos][xPos] = true;
        						stepsTaken++;
        					}
        				}
        			}
        		}
        		
        	} else if(xPos >= width/2 && yPos < height/2) { //Top Right
        		if(cornerReached && !firstIteration) {
        			if(yPos+1 < height && !cross[yPos+1][xPos]) {
        				yPos++;
        				stepsTaken++;
        			}
        			if(yPos >= height/2) {
        				cornerReached = false;
        			}
        		} else {
        			if(xPos+1 < width && !cross[yPos][xPos+1]) {
        				xPos++;
        				stepsTaken++;
        			} else {
        				//Compute the corner
        				cornerReached = true;
        				for(int i = 0; i < cutHeight; i++) {
        					if(stepsTaken < steps) {
        						yPos++;
        						cross[yPos][xPos] = true;
        						stepsTaken++;
        					}
        				}
        				for(int i = 0; i < cutWidth; i++) {
        					if(stepsTaken < steps) {
        						xPos++;
        						cross[yPos][xPos] = true;
        						stepsTaken++;
        					}
        				}
        			}
        		}
        		
        	} else if(xPos >= width/2 && yPos >= height/2) { //Bottom Right
        		if(cornerReached) {
        			if(xPos-1 >= 0 && !cross[yPos][xPos-1]) {
        				xPos--;
        				stepsTaken++;
        			}
        			if(xPos < width/2) {
        				cornerReached = false;
        			}
        		} else {
        			if(yPos+1 < height && !cross[yPos+1][xPos]) {
        				yPos++;
        				stepsTaken++;
        			} else {
        				//Compute the corner
        				cornerReached = true;
        				for(int i = 0; i < cutWidth; i++) {
        					if(stepsTaken < steps) {
        						xPos--;
        						cross[yPos][xPos] = true;
        						stepsTaken++;
        					}
        				}
        				for(int i = 0; i < cutHeight; i++) {
        					if(stepsTaken < steps) {
        						yPos++;
        						cross[yPos][xPos] = true;
        						stepsTaken++;
        					}
        				}
        			}
        		}
        	}
            firstIteration = false;
        }
        
        System.out.println(xPos+1);
        System.out.println(yPos+1);
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
