package MixedProblems;

import java.util.Scanner;

public class Divisibleby41 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan1 = new Scanner(System.in);
		String str = scan1.next();

		int a0 = Integer.parseInt(str);
		int a1 = Integer.parseInt(scan1.next());
		int c = Integer.parseInt(scan1.next());
		int n = Integer.parseInt(scan1.next());

		boolean b =CheckDivisibeby41(a0,a1,c,n);
	}

	private static boolean CheckDivisibeby41(int a0, int a1, int c, int n) {

		//a[i] = ( a[i - 1]*c + a[i - 2] ) modulo 10	
      if(a0 ==0  && a1 ==0) return true;
      if(n<2) n = 2;
		int[] digit = new int[n];
		digit[0] = a0;
		digit[1] = a1;

		for(int i =2;i<n;i++)
		{	
		digit[i] = ( digit[i - 1]*c + digit[i - 2] ) % 10;
		
		}
		
		
		int ans = digit[0];

        for(int i=1;i<n;i++)
        {
        	ans = (ans * 10 + digit[i]) % 41;
        }
		
        if( ans % 41 == 0)
        	return true;
		return false;
	}

	static int getNumber(int index,int a0,int a1,int c,int n)
	{

		if(index == 0)
			return 0;
		if(index == 1)
			return 1;

		else 		if(index >= 2 && index <=n-1)
		{
			int number  = ( getNumber(index - 1,a0,a1,c,n) *c + getNumber(index - 2,a0,a1,c,n) ) % 10;
			return number;
		}
		return -1;

	}

}
