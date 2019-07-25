package BasicJava.RandomTests;

import java.util.Arrays;
import java.util.Scanner;

public class AdvanceRecursion_CheckAB 
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan1 = new Scanner(System.in);
		String strN = scan1.next();	

		/*      boolean b1= false;
		b1 = CheckAB_3Conditions(strN.toCharArray(),0,b1);
		System.out.println(b1);*/

		int NoOfSteps;
		try
		{
			NoOfSteps = Integer.parseInt(strN);			
		}   
		catch(NumberFormatException ex)
		{
			throw ex;
		}

		int[] parts = new int [] {3,2,1};

		int[] result = new int[NoOfSteps];
		//int count = Partition(result,NoOfSteps,0,parts,0,1);
		int count = Tribonachii(NoOfSteps);
		System.out.print(count);
	}	
	
	private static int Tribonachii(int n)
	{
		if(n==0 || n ==1)
			return 1;
		if(n==2) return 2;
		return Tribonachii(n-1) + Tribonachii(n-2) + Tribonachii(n-3);
	}

	private static int Partition(int[] result,int mainNo,int index, int[] parts, int partNo,int count)
	{
		if(mainNo < 0) 
			return count;

		if(mainNo == 0)
		{
			System.out.print("\n");	
			int[] tmp = new int[index];
			int t=0;int number=0;
			for(int k =0 ;k < index; k++)
			{
				tmp[k] = result[k];
				number += tmp[k] * (int) Math.pow(10,t++);
				//System.out.print(result[k]);	
			}

			count += cyclic(number, index); 
			System.out.println("Count: " + count);

			return count;
		}

		int kInd = index == 0 ? 1 : result[index - 1];
		for(int i=kInd; i<= mainNo; i++)
		{
			if(i == 1 || i ==  2 || i == 3)
			{
				result[index] = i;
				count = Partition(result,mainNo - i ,index + 1,parts,partNo,count);
			}
		}
		
		return count;
	}

	static int cyclic(int N, int n) 
	{ 
		int num = N; 
        int count = 0;
		while (true) 
		{ 
			System.out.println(num);  
            count++;
			// Following three lines generates a 
			// circular permutation of a number. 
			int rem = num % 10; 
			int dev = num / 10; 
			num = (int)((Math.pow(10, n - 1)) * 
					rem + dev); 

			// If all the permutations are  
			// checked and we obtain original 
			// number exit from loop. 
			if (num == N)  
				break;  
		}
		
		return count;
	} 

/*	private static int CountStairCaseSteps(int noOfSteps,int gap, int steps)
	{
		if(noOfSteps <= 0 || gap <= 0) 
			return 0;

		steps +=  noOfSteps / gap + CountStairCaseSteps(noOfSteps % gap,gap - 1,steps);

		return steps;    			
	}	*/

	private static boolean CheckAB_3Conditions(char[] input,int ind,boolean res) 
	{
		if(input.length -1 == ind)
			return res;
		//res = false;
		int size = input.length - 1;
		if(input[0] == 'a')
		{
			if(input[ind] == 'a')
			{
				int l = ind;
				if(l + 1 == size) // || (l + 1 <= size && input[l+1] == '\0'))					
				{
					return true; //res = true;
				}
				if( ( l+ 2 <= size && (input[l+1] == 'b' && input[l+2] == 'b')))
				{
					res = true;
				}
				else
				{
					res =  false;  ///if i do return false then few test cases fails-- do not know  abbabb
					return res;
				}
			}
			else if (ind + 1 <= size && (input[ind] == 'b' && input[ind + 1] == 'b'))
			{
				if(ind + 1 == size)
				{
					return true;
				}	    
				if (ind + 2 <= size && input[ind+2] == 'a')
				{
					res = true;
				}
				else
				{
					return false;
				}
			}
		}
		else
			return false;

		return CheckAB_3Conditions(input, ++ind,res);
	}

}
