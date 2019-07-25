package BasicJava.NumberTheory;

import java.util.Scanner;

import BasicJava.NumberTheory.GCD_euclid.Triplet;

public class aXplusbYequalD
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 12, 98 gcd is 2
		int a = 16; //98;
		int b = 10; //12;

		Scanner scan1 = new Scanner(System.in);
		String strN = scan1.next();	
		int noOftests;
		try
		{
			noOftests = Integer.parseInt(strN);			
		}   
		catch(NumberFormatException ex)
		{
			throw ex;
		}
		for(int i=0; i <noOftests; i++)
		{
			strN = scan1.next();	
			long inta;
			try
			{
				inta = Long.parseLong(strN);			
			}
			catch(NumberFormatException ex)
			{
				throw ex;
			}

			strN = scan1.next();	
			long intb;
			try
			{
				intb = Long.parseLong(strN);			
			}   
			catch(NumberFormatException ex)
			{
				throw ex;
			}


			strN = scan1.next();	
			long intd;
			try
			{
				intd = Long.parseLong(strN);			
			}   
			catch(NumberFormatException ex)
			{
				throw ex;
			}


			long  ans = Findfactorsofequation(inta,intb,intd);
			System.out.println(ans);
		}
	}
	/*
	 * ax+by = d   ax = d - by..(d - by) % a = 0... d % a = ( b * y) % a .. (d/b) % a = y1
	 * */

	private static long Findfactorsofequation(long a, long b,long d) 
	{
		long gcd =calculateGCD(a,b);

		if(d % gcd != 0)
			return 0;
		if(d == 0)
			return 1; //pair(0,0)

		a = a/ gcd;
		b = b/ gcd;
		d = d/ gcd;

		long y1 = ((d % a) * getModuloInverse(b,a) ) % a;

		if( d < y1*b) //((d/b) - y1) should be +ve
		{
			return 0;
		}

		long totalSteps = ((d/b) - y1)/ a;
		return totalSteps+ 1;
	}		

	static long getModuloInverse(long A,long M)
	{
		aXplusbYequalD.Triplet tri = advancedGCD(A,M);
		long  x = tri.X;
		return (x % M + M) % M;   ///as x can be negative

	}

	static long calculateGCD(long a, long b)
	{
		if(a<b)
			return calculateGCD(b,a);
		if(b==0)
			return a;

		return calculateGCD( b , a%b );
	}

	static Triplet advancedGCD(long a,long b)
	{
		if(b==0)
		{
			Triplet t1 =  new aXplusbYequalD.Triplet();

			t1.X = 1;
			t1.Y = 0;
			t1.GCD = a;
			return t1;
		}
		Triplet t2 = advancedGCD(b,a%b);

		//GCD_euclid hh = new GCD_euclid();
		Triplet t1 =  new aXplusbYequalD.Triplet();
		t1.Y  =  t2.X - (a/b) * t2.Y;
		t1.X = t2.Y;
		t1.GCD = t2.GCD;
		return t1;
	}

	static class Triplet
	{
		public long GCD;
		public long X;
		public long Y;

	}

}