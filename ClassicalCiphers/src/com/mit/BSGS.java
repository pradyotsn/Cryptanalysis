package com.mit;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BSGS {  
	    static int discreteLogarithm(int a, int b, int p)  
	    {  
	    	//L = sqrt(p)
	        int l = (int) Math.floor(Math.sqrt (p));  
	        System.out.println("L="+l);
	  
	        ArrayList<Integer> arr = new ArrayList<Integer>(l); 
	        int an;  
	        for (int i = 1; i <= l; i++)  
	        {
	            an = (int) Math.pow(a, i) % p;  
	            arr.add(an);
	           // System.out.println(i+1 +"\t"+an);
	        }
	        
	        Random rand =  new Random();	        
	        System.out.println(arr);	        
	        int a_inv;	        
	        do {
				a_inv = rand.nextInt(p);
			} while ((a_inv * a % p) != 1);
	        
	        System.out.println("a_inv="+a_inv);
	        System.out.println("L="+l);
	        
	        double h= (Math.pow(a_inv,l)) % p;
	        
	        System.out.println("h="+h);
	        
	        int t= b;
	        
	        for (int i = 0; i < l; i++)  
		        {  
		            if (arr.contains(t))  
		            {  
		            	System.out.println("arr.indexOf(t)"+arr.indexOf(t));
		                int ans = (arr.indexOf(t)+1) + i * l;  
		                ans = ans % p;  
		                System.out.println("Soln");
		                    return ans;  
		            }  //
		            t=(t*(int)h) % p;
		              
		        } 
	        return -1;  
	    }  
	  
	    // Driver code  
	    public static void main(String[] args)  
	    {  
	        //int a = 2, b = 2, m = 5;
	    	int a = 2, b = 228, m = 383;
	        Scanner sc = new Scanner(System.in);
	        
//	        System.out.println("Enter the values for a,b,m:");
//	        a= sc.nextInt();
//	        b= sc.nextInt();
//	        m= sc.nextInt();
	        
	        System.out.print(discreteLogarithm(a, b, m));  
//	        a = 3; 
//	        b = 7; 
//	        m = 11;  
//	        System.out.println(discreteLogarithm(a, b, m));  
	    }  
	 
}
