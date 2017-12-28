package alogrithms;

import java.util.Scanner;

public class Solution {
static void displayPathtoPrincess(int n, String [] grid){
        String s;
        int mypos = -1,pypos = -1, mxpos = -1,pxpos = -1;
        for(int itr = 0; itr < n; ++itr){
            s = grid[itr];
            if(s.contains("m") && mypos == -1){mypos = itr; mxpos = s.indexOf("m");}
            if(s.contains("p") && pypos == -1){pypos = itr; pxpos = s.indexOf("p");}
            if(mypos != -1 && pypos != -1) break;
        }
        int initx = mxpos, inity = mypos;
        while(initx != pxpos || inity != pypos){
            if( inity < pypos){ System.out.println("DOWN"); ++inity;}
            if( inity > pypos){ System.out.println("UP"); --inity;}
            if( initx < pxpos){ System.out.println("RIGHT"); ++initx;}
            if( initx > pxpos){ System.out.println("LEFT"); --initx;}
        }
        
        
  }
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m;
        m = in.nextInt();
        String grid[] = new String[m];
        for(int i = 0; i < m; i++) {
            grid[i] = in.next();
        }

    displayPathtoPrincess(m,grid);
    }
}
