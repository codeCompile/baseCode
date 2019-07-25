package BasicJava.RandomTests;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Sorting_Merge {
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
		System.out.print(Arrays.toString(inputMatrix));

		DoMergeSort(inputMatrix,0,inputMatrix.length -1);
	}

	private static void DoMergeSort(int[] input,int begin,int end)
	{		
		if(begin == end) return;
		int mid = (begin + end) /2;
		DoMergeSort(input,begin,mid);

		DoMergeSort(input,mid + 1,end);

		MergeArray(input,begin,mid,end);
	}

	private static void MergeArray(int[] input,int begin,int mid,int end)
	{
		int[] tempArrayPart1 = new int[mid -  begin + 1];
		int[] tempArrayPart2 = new int[end - mid];

		int i = 0;
		int k = 0;
		for(i = begin; i<= mid;i++)
		{
			tempArrayPart1[k++] = input[i];
			
		}
		k=0;
		for(i = mid + 1; i<= end;i++)
		{
			tempArrayPart2[k++] = input[i];
	
		}

		int index1 =0; int index2 = 0;
		int kInd = 0; i =begin;
		while(index1 < tempArrayPart1.length && index2 < tempArrayPart2.length)
		{    
			if(tempArrayPart1[index1] < tempArrayPart2[index2])
			{
				input[i] = tempArrayPart1[index1];
				index1++;
			}
			else
			{
				input[i] = tempArrayPart2[index2];
				index2++;
			}
			i++;
		}
		
        
		if(index1 < tempArrayPart1.length)
		{
			for(int j = index1 ; j < tempArrayPart1.length; j++){
				input[i] = tempArrayPart1[j];
				i++;
			}
		}
        
		if(index2 < tempArrayPart2.length)
		{
			for(int j = index2 ; j < tempArrayPart2.length; j++){
				input[i] = tempArrayPart2[j];
				i++;
			}
		}
		
		System.out.print(Arrays.toString(input));
	}


	}
