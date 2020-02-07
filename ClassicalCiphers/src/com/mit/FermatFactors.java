package com.mit;

class FermatFactors  
{ 
      
    // This function finds the value of a and b  
    // and returns a+b and a-b  
    static void FermatFactor(int n) 
    { 
          
        // since fermat's factorization applicable  
        // for odd positive integers only  
        if(n <= 0) 
        { 
            System.out.print("["+ n + "]"); 
            return; 
        } 
      
        // check if n is a even number  
        if((n & 1) == 0) 
        { 
            System.out.print("[" + n / 2.0 + "," + 2 + "]");  
            return; 
        } 
              
        int a = (int)Math.ceil(Math.sqrt(n)) ; 
      
        // if n is a perfect root,  
        // then both its square roots are its factors  
        if(a * a == n) 
        { 
            System.out.print("[" + a + "," + a + "]");  
            return; 
        } 
        int b; 
        while(true) 
        { 
            int b1 = a * a - n ; 
            b = (int)(Math.sqrt(b1)) ; 
              
            if(b * b == b1) 
                break; 
            else
                a += 1; 
        } 
        System.out.print("[" + (a - b) +"," + (a + b) + "]" );  
        return; 
    } 
          
    // Driver Code  
    public static void main (String[] args)  
    { 
        FermatFactor(2262599); 
    } 
} 