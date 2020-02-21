package com.mit;

/*
 * 
 * Algorithm 4.1 Eratosthenes’s sieve
Require: Initial limit Lim
Create array IsP rime indexed from 1 to Lim, initialized to true.
IsP rime[1] <- false
for i from 2 to Lim do
	if IsP rime[i] is true then
		j <- 2i
		repeat
			IsP rime[j] <- false; j <- j + i
		until j > Lim
	end if
end for
for i from 2 to Lim do
	if IsP rime[i] is true then
		Display(i,’is prime’)
	end if
end for
 */

import java.util.ArrayList;

public class Eratostenes {

	    void eratosthenesSieve(int n) 
	    { 
	        // Create a boolean array "prime[0..n]" and initialize 
	        // all entries it as true. A value in prime[i] will 
	        // finally be false if i is Not a prime, else true. 
	        boolean prime[] = new boolean[n+1]; 
	        for(int i=0;i<n;i++) 
	            prime[i] = true; 
	          
	        for(int i = 2; i*i <=n; i++) 
	        { 
	            // If prime[i] is not changed, then it is a prime 
	            if(prime[i] == true) 
	            { 
	                // Update all multiples of i 
	                for(int j = i*2; j <= n; j += i) 
	                    prime[j] = false; 
	            } 
	        } 
	          
	        // Print all prime numbers 
	        for(int i = 2; i <= n; i++) 
	        { 
	            if(prime[i] == true) 
	                System.out.print(i + " "); 
	            if(i%100==0)
	            	System.out.println();
	        } 
	    } 
	      
	    public static void main(String args[]) 
	    { 
	        int n = 500; 
	        System.out.print("Following are the prime numbers "); 
	        System.out.println("smaller than or equal to " + n); 
	        Eratostenes obj = new Eratostenes(); 
	        obj.eratosthenesSieve(n); 
	    } 
	
}


/*

Following are the prime numbers smaller than or equal to 500
2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 
101 103 107 109 113 127 131 137 139 149 151 157 163 167 173 179 181 191 193 197 199 
211 223 227 229 233 239 241 251 257 263 269 271 277 281 283 293 
307 311 313 317 331 337 347 349 353 359 367 373 379 383 389 397 
401 409 419 421 431 433 439 443 449 457 461 463 467 479 487 491 499 


*/