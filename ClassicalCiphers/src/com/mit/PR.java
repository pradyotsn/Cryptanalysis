package com.mit;
import java.util.Scanner;
 
public class PR    
{
    private static final long b = 1; 

//function X * X + b, change value of b as required
    
    private long f(long X)    
    {
        return X * X + b;
    }
    
    
//Get divisor 
    private long rho(long N) 
    {
    	int s=2;
    	
        long A = s, B = s, g=1;         // divisor= g
        if (N % 2 == 0) 
            return 2;
        while (g == 1) 
        {
            A = f(A) % N;
            B = f(f(B)) % N;
            g = gcd(Math.abs(A - B), N);
        } 
        /** return divisor **/
        return g;
    }//
//GCD of two numbers
    public  long gcd(long p, long q)
    {
        if (p % q == 0)
            return q;
        return gcd(q, p % q);
    }
    
//Check if num is prime 
    public boolean isPrime(long N)
    {
        for (int i = 2; i <= Math.sqrt(N); i++)
            if (N % i == 0)
                return false;
        return true;
    }
    
// get all factors 
    public void factor(long N) 
    {
        if (N == 1)
            return;
        if (isPrime(N)) 
        {
            System.out.println(N); 
            return; 
        }
           long divisor = rho(N);
        factor(divisor);
        factor(N / divisor);
    }
    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Pollard Rho Algorithm\n");                
        System.out.println("Enter a number");
        long N = scan.nextLong();
        System.out.println("\nFactors are : ");
        PR pr = new PR();
        pr.factor (N);        
    }
}