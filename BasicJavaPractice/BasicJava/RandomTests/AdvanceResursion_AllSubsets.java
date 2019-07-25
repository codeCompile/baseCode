package BasicJava.RandomTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AdvanceResursion_AllSubsets {


	public static void main(String[] args)
	{
		Scanner scan1 = new Scanner(System.in);
		String input = scan1.next();	

		ArrayList<String> rr = new ArrayList<String>();
		generateSeq(input.toCharArray(),0,input.length(),1,"",rr);
		String[] ret = new String[rr.size()];
		int i=0;
		for(String s : rr)
			ret[i++] = s;

	}

/*Print all Codes - String
Send Feedback
Assume that the value of a = 1, b = 2, c = 3, ... , z = 26. You are given a numeric string S. Write a program to print
the list of all possible codes that can be generated from the given string.
Note : The order of codes are not important. Just print them in different lines.
Input format :*/
	private static void generateSeq(char[] input, int start,int end,int cnt,String tmp,ArrayList<String> result )
	{
		if(start >= end)
		{
			result.add(tmp);

			return;
		}

		String d1 = "";
		d1 += String.valueOf(input[start]);

		if(cnt == 2 && start + 1 < end)
			d1 += String.valueOf(input[start + 1]);

		tmp += GetChar(d1);

		generateSeq(input,start + cnt,end,1,tmp,result);
		generateSeq(input,start + cnt,end,2,tmp,result);

	}  


	private static char GetChar(String input)
	{
		char[] all = {'9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z' };
		int theNo = 0;
		try
		{
			theNo = Integer.parseInt(input);			
		}   
		catch(NumberFormatException ex)
		{
			throw ex;
		}

		if(theNo >=1 && theNo <=26)
			return all[theNo];

		return '9';
	}	

	public static void main1(String[] args) {
		// TODO Auto-generated method stub
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

		if(!( sizeN >= 1 && sizeN <= 100))
			throw new RuntimeException();

		int[] inputMatrix = new int[sizeN];

		for(int i=0;i<sizeN;i++)
		{			
			try {
				int inNum = Integer.parseInt(scan1.next());
				inputMatrix[i] = inNum;					
			}
			catch(NumberFormatException ex)
			{
			}			
		}		

		Scanner scan2 = new Scanner(System.in);
		String strN1 = scan2.next();	
		int sizeN1;
		try
		{
			sizeN1 = Integer.parseInt(strN1);			
		}   
		catch(NumberFormatException ex)
		{
			throw ex;
		} 
		System.out.print(Arrays.toString(inputMatrix));
		ArrayList<ArrayList<Integer>> allSets = new ArrayList<ArrayList<Integer>>();
		printAllSubsets(inputMatrix, inputMatrix.length, sizeN1,allSets); 

		int[][] allTTT = new int[allSets.size()][];
		int i = 0;
		for(ArrayList<Integer> oneset : allSets)
		{
			allTTT[i] = new int[oneset.size()];
			int k=0;
			for(int t: oneset)
			{
				allTTT[i][k++] = t;		
			}
			i++;
		}

		//return allTTT;
	}

	static boolean[][] dp; 

	static int counter=0;
	static void display(ArrayList<Integer> v, ArrayList<ArrayList<Integer>> allSets) 
	{		
		//(int[]) v.toArray(a);
		//System.out.println(v); 
		ArrayList<Integer> all1 = new ArrayList<Integer>();

		for(int j : v)
		{
			all1.add(j);
		}

		allSets.add(all1);
	} 

	// A recursive function to print all subsets with the 
	// help of dp[][]. Vector p[] stores current subset. 
	static void printSubsetsRec(int arr[], int i, int sum,  
			ArrayList<Integer> p, ArrayList<ArrayList<Integer>> allSets) 
	{ 
		// If we reached end and sum is non-zero. We print 
		// p[] only if arr[0] is equal to sun OR dp[0][sum] 
		// is true. 
		if (i == 0 && sum != 0 && dp[0][sum]) 
		{ 
			p.add(arr[i]); 
			display(p,allSets); 
			p.clear(); 
			return; 
		} 

		// If sum becomes 0 
		if (i == 0 && sum == 0) 
		{ 
			display(p,allSets); 
			p.clear(); 
			return; 
		} 

		// If given sum can be achieved after ignoring 
		// current element. 
		if (dp[i-1][sum]) 
		{ 
			// Create a new vector to store path 
			ArrayList<Integer> b = new ArrayList<>(); 
			b.addAll(p); 
			printSubsetsRec(arr, i-1, sum, b,allSets); 
		} 

		// If given sum can be achieved after considering 
		// current element. 
		if (sum >= arr[i] && dp[i-1][sum-arr[i]]) 
		{ 
			p.add(arr[i]); 
			printSubsetsRec(arr, i-1, sum-arr[i], p,allSets); 
		} 
	} 

	// Prints all subsets of arr[0..n-1] with sum 0.
	/*Given an array A and an integer K, print all subsets of A which sum to K.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
Note : The order of subsets are not important. Just print them in different lines.
Input format :*/
	static void printAllSubsets(int arr[], int n, int sum, ArrayList<ArrayList<Integer>> allSets) 
	{ 
		if (n == 0 || sum < 0) 
			return; 

		// Sum 0 can always be achieved with 0 elements 
		dp = new boolean[n][sum + 1]; 
		for (int i=0; i<n; ++i) 
		{ 
			dp[i][0] = true;   
		} 

		// Sum arr[0] can be achieved with single element 
		if (arr[0] <= sum) 
			dp[0][arr[0]] = true; 

		// Fill rest of the entries in dp[][] 
		for (int i = 1; i < n; ++i) 
			for (int j = 0; j < sum + 1; ++j) 
				dp[i][j] = (arr[i] <= j) ? (dp[i-1][j] || 
						dp[i-1][j-arr[i]]) 
						: dp[i - 1][j]; 
				if (dp[n-1][sum] == false) 
				{ 
					System.out.println("There are no subsets with" +  " sum "+ sum); 
					return; 
				} 

				// Now recursively traverse dp[][] to find all 
				// paths from dp[n-1][sum] 
				ArrayList<Integer> p = new ArrayList<>(); 
				printSubsetsRec(arr, n-1, sum, p,allSets); 
	} 

	private static boolean FindSubsetSumEqualtoK(int[] inputMatrix, int size, ArrayList<Integer> holder,int sum)
	{
		if(size <= 0 && sum > 0)
		{			
			//holder.add(0);
			return false;
		}
		if(size >= 0 && sum == 0 ) 
		{
			for(int t1:holder)
			{
				System.out.print(t1 + " ,");
			}
			System.out.println("");
			return true;
		}

		if(inputMatrix[size] > sum)
			return FindSubsetSumEqualtoK(inputMatrix, size -1, holder, sum);
		else
		{
			holder.add(inputMatrix[size]);
		}
		int[] tmpMatrix = new int[size];
		for(int i=0; i<size;i++)
		{
			tmpMatrix[i] = inputMatrix[i];
		}

		return FindSubsetSumEqualtoK(tmpMatrix , size -1, holder, sum - inputMatrix[size]) || 
				FindSubsetSumEqualtoK(inputMatrix, size -1, holder, sum);

	}

	private static int[][] FindAllSubsets(int[] inputMatrix,int size,int[][] holder) 
	{
		if( inputMatrix.length == 1 )
		{
			int kkk = FindLengthOfHolder(holder);
			holder[kkk] = new int[] {inputMatrix[inputMatrix.length-1]};
			return holder;
		}
		//if(inputMatrix.length  size)
		{
			int[] kk = new int[inputMatrix.length - size-1];
			int ls = 0;
			for(int t= size+1; t < inputMatrix.length; t++ )
			{				
				kk[ls] = inputMatrix[t];				
				ls++;
				//holder[++tracker] = kk;
			}

			int[][] F1 =  FindAllSubsets(kk, size++,holder);
			int append = inputMatrix[size-1];
			int kkk = FindLengthOfHolder(holder);
			holder[kkk] = new int[] {};
			int tracK = kkk;

			for(int v =0 ; v< tracK; v++)
			{
				int[] ret = new int[F1[v].length + 1];
				ret[0] = append;
				for(int r=1;r<=F1[v].length;r++)
				{            
					ret[r] = F1[v][r-1];   
				}

				holder[++kkk] = ret;
			}
		}

		return holder;
	}
	
	private static int FindLengthOfHolder(int[][] holder) {
		// TODO Auto-generated method stub

		for(int i =0 ;i< holder.length;i++)
		{
			if(holder[i] == null)
				return i;
		}
		return 0;
	}

}
