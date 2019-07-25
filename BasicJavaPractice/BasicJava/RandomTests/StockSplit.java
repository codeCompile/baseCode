package BasicJava.RandomTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class StockSplit {

	public static void main(String[] args) {
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

		if(sizeN <= 0)
			throw new RuntimeException();

		int[] price = new int[sizeN];

		for(int i=0;i<sizeN;i++)
		{			
			try {
				int inNum = Integer.parseInt(scan1.next());
				price[i] = inNum;					
			}
			catch(NumberFormatException ex)
			{
			}			
		}		
		System.out.print(Arrays.toString(price));
		System.out.print(Arrays.toString(stockSpan(price)));
	}

	public static int[] stockSpan(int[] price) {
		int[] result = new int[price.length];
		int lastJ = 0;
		for(int i=0; i < price.length;i++)
		{			
			result[i] = 1;
			for(int j=i-1; j>=0; j--) 
			{
				if(price[i] > price[j])
				{
					result[i] = result[i] + 1;
				}
				else
				{                
					break;       
				}
			}
		}
		return result;
	}	

	public static ArrayList<Integer> longestSubsequence(int[] arr)
	{
		HashSet<Integer> hArrSet = new HashSet<Integer>(); 

		for(int i =0; i<arr.length;i++)
		{
			hArrSet.add(arr[i]);
		}
		ArrayList<Integer> firstArray = new ArrayList<Integer>();
		ArrayList<Integer> outputArray = new ArrayList<Integer>();
		for(int i =0; i<arr.length;i++)
		{
			int j = i;
			int currElement = arr[j];
            firstArray.add(currElement);
			while(true)
			{				
				if(hArrSet.contains(currElement + 1))
				{
					firstArray.add(currElement +1);
					currElement = currElement + 1;
					//firstArray.add(arr[currElement - 1]);
				}
				
				else
					break;
				j++;
			}
			
			if(outputArray.size() < firstArray.size())
				outputArray = firstArray;
			else if(outputArray.size() == firstArray.size())
			{
			  	int m = FindIndexOfMinElement(outputArray);
			  	int n = FindIndexOfMinElement(firstArray);
			  	
			  	if(n < m)
			  		outputArray = firstArray;
				
			}		
				firstArray = new ArrayList<Integer>();
		}
		
		return outputArray;
	}

	private static int FindIndexOfMinElement(ArrayList<Integer> outputArray) {
		// TODO Auto-generated method stub
		int min = outputArray.get(0);
		int minIndex=0;
		for(int i=0 ; i< outputArray.size(); i++)
		{
			if(min > outputArray.get(i))
			{
				min = outputArray.get(i);
				minIndex = i;
			}
		}
		
		return minIndex;
	}
}
