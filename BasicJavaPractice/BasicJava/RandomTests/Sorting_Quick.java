package BasicJava.RandomTests;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Sorting_Quick {
	private static final String inputMatrix = null;

	public static void main(String[] args) throws IOException
	{
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




		DoQuickSort(inputMatrix,0,inputMatrix.length - 1); 
		System.out.print(Arrays.toString(inputMatrix));
	}

	private static void DoQuickSort(int[] input, int start,int end)
	{
		if(start >= end) return;
		//int pivot = (start + end) / 2;
		int partitionIndex = DoPartition(input, start,end);
		System.out.println(" Pivot : " + input[partitionIndex] + "   " + Arrays.toString(input));

		DoQuickSort(input,start,partitionIndex - 1);
		DoQuickSort(input,partitionIndex + 1, end);
	}

	private static int DoPartition(int[] input,int start,int end)
	{		
		int leftInd = start - 1;
		int i = 0;
		int pivot = input[end];
		for(i = start; i< end; i++)
		{			
			if(input[i] <= pivot)				 
			{
				leftInd ++;
				int temp = input[i];
				input[i] = input[leftInd];
				input[leftInd] = temp;
			}
		}

		int temp = input[end];
		input[end] = input[leftInd + 1];
		input[leftInd + 1] = temp;

		return leftInd + 1;
	}


}
