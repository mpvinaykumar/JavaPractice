package alogrithms;
/*
 * Write an efficient program to count number of 1s in binary representation of an integer.
 * http://www.geeksforgeeks.org/count-set-bits-in-an-integer/
*/

public class CountSetBits {   

    public static void main(String args[]){
        System.out.println("Java method to count number of 1's in a integer");
        System.out.printf("Number of one's in %d is %d %n", 2, countOne(2));
        System.out.printf("Number of one's in %d is %d %n", 3, countOne(3));
        System.out.printf("Number of 1's in %d is %d %n", 10, countOne(10));
       
       
        //A short and sweet Java API trick to find count of set bits in a integer or long
        System.out.println("Counting number of set bits on integer and long using Java API");
        int count = Integer.bitCount(2);
        System.out.printf("Number of set bit on %d is %d  %n", 2, count);
        System.out.printf("Number of set bit on %d is %d  %n", 3, Integer.bitCount(10));
       
        //One optimized way to count number of one's in a number in Java
        //this method is proportional to number of set bit's rather than bit size e.g. 32 for int, 64 for long
        System.out.println("Another optimized Java method to count number of set bits");
        System.out.printf("Number of set bit on %d is %d  %n", 2, countSetBits(2));
        System.out.printf("Number of set bit on %d is %d  %n", 3, countSetBits(3));
    }
   
   
    /** 
      * This method is not optimized, as it iterates 32 times for integer numbers
      * in all cases, can you optimize it?
      */
    public static int countOne(int number){
        int count = 0;
        for(int i =0; i<32; i++){
            if( (number&1) == 1) {
                count++;
            }
            number = number >>> 1;
        }
        return count;
    }
   
    /**
      * Optimized version of previous one, loop is proportional to number of 1's
      * instead bit size of number.
      */
    public static int countSetBits(long number){
        int count = 0;
        while(number>0){
            ++count;
            number &= number-1;
        }
        return count;
    }
   
  
}