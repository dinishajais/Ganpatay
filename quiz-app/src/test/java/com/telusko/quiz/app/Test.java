package com.telusko.quiz.app;

import java.util.ArrayList;

public class Test {

	static long i=1;
    static ArrayList<Long> factorialNumbers(long N){
       ArrayList<Long> arr=new ArrayList<Long>();
       long fact=fact(i);
       
       if(fact>N){
           return arr;
       }
       
       arr.add(i);
       
       i++;
        return factorialNumbers(N);
    }
    static long fact(long n){
        if(n==1){
            return 1;
        }
        return n * fact(n-1);
    }
    public static void main(String[] args) {
    	ArrayList<Long> a=factorialNumbers(9);
    	System.out.println(a);
    	}
    
}