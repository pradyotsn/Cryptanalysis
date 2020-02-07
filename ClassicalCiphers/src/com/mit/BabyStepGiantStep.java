package com.mit;

import java.util.Scanner;

public class BabyStepGiantStep {  
	    static int discreteLogarithm(int a, int b, int m)  
	    {  
	    	//L = sqrt(p)
	        int n = (int) (Math.sqrt (m) + 1);  
	  
	        // Calculate a ^ n  
	        int an = 1;  
	        for (int i = 0; i < n; i++)  
	        {
	            an = (an * a) % m;  
	            System.out.println(i+1 +"\t"+an);
	        }
	        int[] value=new int[m];  
	  
	        // Store all values of a^(n*i) of LHS  
	        for (int i = 1, cur = an; i <= n; ++i)  
	        {  
	            if (value[ cur ] == 0)  
	                value[ cur ] = i;  
	            cur = (cur * an) % m;  
	        }  
	  
	        for (int i = 0, cur = b; i <= n; ++i)  
	        {  
	            // Calculate (a ^ j) * b and check  
	            // for collision  
	            if (value[cur] > 0)  
	            {  
	                int ans = value[cur] * n - i;  
	                if (ans < m)  
	                    return ans;  
	            }  
	            cur = (cur * a) % m;  
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
