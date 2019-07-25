package BasicJava.NumberTheory;

import java.util.Scanner;

public class IsPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Write your code here
		Scanner scan1 = new Scanner(System.in);
		String strN = scan1.next();	
		int sizeN;
		try
		{
			sizeN = Integer.parseInt(strN);			
		}   
		catch(NumberFormatException ex)
		{
			throw ex;
		}

		//printallPrimeNouptoN(5,sizeN,2); //Won't work for large numbers like n = 50000
		int count = 0;

		for(int i =1 ; i <= sizeN; i++)
		{
			if(isPrime(i))
				count ++;
		}

		System.out.println(count);

	}

	static int isPrimeSieveofErasthenes(int n)
	{
		//creating sieve
		boolean[] isPrime = new boolean[n+1];
		for(int i=0;i<=n;i++)
			isPrime[i] = true;

		isPrime[0] = false;
		isPrime[1] = false;
		for(int i = 2; i*i <=n; i++)
		{
			if(isPrime(i)) //is false no need to check for multiples
			{
				for(int j = i*i ; j<=n; j = j + i)
				{
					isPrime[i] = false;
				}
			}
		}
		
		int count = 0;
		for(int i=0;i<=n;i++)
		{
			if(isPrime(i))
				count++;
		}
		return count;
	}
	
	static boolean isPrime(int n) 
	{        
		if (n <= 1) 
			return false; 
		if (n <= 3) 
			return true; 

		// This is checked so that we can skip 
		// middle five numbers in below loop 
		if (n % 2 == 0 || n % 3 == 0) 
			return false; 

		for (int i = 5; i * i <= n; i = i + 6) 
			if (n % i == 0 || n % (i + 2) == 0) 
				return false; 

		return true; 
	}

	static void printallPrimeNouptoN(int n, int input,int count)
	{
		if(input <=1 )
		{
			count =0;
			System.out.print(0);
			return;		
		}
		if(input <= 3)
		{
			count = 2;
			System.out.print(2);
			return;		
		}
		if(n > input) 
		{
			System.out.print(count);
			return;
		}
		boolean b=true;

		if (n % 2 == 0 || n % 3 == 0) 
			b = false;

		for(int i =5; i * i <= n; i += 6)
		{
			if (n % i == 0 || n % (i + 2) == 0) 
				b = false;
		}
		/*for(int t : prime)
		{
			if(n%t == 0)
			{
			  b = false;
              break;
			}			
		}*/
		if(b) { 
			count++; 
		} //prime.add(n);}

		/*for(int i=2;i<n;i++)
		{
			if(n%i == 0)
		       { 
				b= false;
		         break;
		       }
		}*/

		//if(b) System.out.println( n + " is prime.");
		printallPrimeNouptoN(++n, input,count);
	}

}
