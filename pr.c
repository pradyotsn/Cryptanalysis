#include<stdio.h>
#include<math.h>
    long b = 1; 

//function X * X + b, change value of b as required
    
    long f(long X)    
    {
        return X * X + b;
    }
    
    
//Get divisor 
    long rho(long N) 
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
    }
//GCD of two numbers
    long gcd(long p, long q)
    {
        if (p % q == 0)
            return q;
        return gcd(q, p % q);
    }
    
//Check if num is prime 
    boolean isPrime(long N)
    {
        for (int i = 2; i <= sqrt(N); i++)
            if (N % i == 0)
                return false;
        return true;
    }
    
// get all factors 
    void factor(long N) 
    {
        if (N == 1)
            return;
        if (isPrime(N)) 
        {
            printf(N); 
            return; 
        }
           long divisor = rho(N);
        factor(divisor);
        factor(N / divisor);
    }
    
 int main()
    {
        
        printf("Pollard Rho Algorithm\n");                
        printf("Enter a number");
        long N = scan.nextLong();
		scanf("%l",&N)
        printf("\nFactors are : ");
        factor (N);        
		
		return 1;
    }
}
