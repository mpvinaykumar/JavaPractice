package com.java8.features;

import java.util.Arrays;
import java.util.List;

/**
 * Check below url for Lazy concept how we can optimize code-performance 
 	https://youtu.be/1OpAgZvYXLQ?t=7431
*/	
public class Stream_Lazy {
	public static void main(String[] args) {
	    List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
	    
	    //given an ordered list find the double of the first even number greater than 3.
	    
	    int result = 0;
	    for(int e : numbers) {
	      if(e > 3 && e % 2 == 0) {
	        result = e * 2;
	        break;
	      }
	    }
	    System.out.println(result);
	    //how much work? 8 units work
	    
	    System.out.println(
	      numbers.stream() //  vv
	             .filter(Stream_Lazy::isGT3)
	             .filter(Stream_Lazy::isEven)
	             .map(Stream_Lazy::doubleIt)
	             .findFirst());
	  }
	  public static boolean isGT3(int number) {
	    System.out.println("isGT3 " + number);
	    return number > 3;
	  }
	  public static boolean isEven(int number) {
	    System.out.println("isEven " + number);
	    return number % 2 == 0;
	  }
	  public static int doubleIt(int number) {
	    System.out.println("doubleIt " + number);
	    return number * 2;
	  }
	  

	}
