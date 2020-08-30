package alogrithms;

import java.util.*;

public class Main{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int nCopy= n;
        int kCopy= k;
        
        int allInTimes = 0;
        int totalRounds = 0;
        
        // while(kCopy > 0){
        //     if(nCopy%k == 0){
        //         allInTimes++;
        //         kCopy--;
        //         nCopy = nCopy/k;
        //     }else{
        //         nCopy--;
        //     }
        // }
        
        for(int i=totalRounds, j=0; n >=1; totalRounds++){
            if(k == 0){
                n--;
            }else if( n%k ==0 && j<=k){
                n = n/k;
                j++;
            }else {
            	n--;
            }
        }
        System.out.println(totalRounds);
    }
}
