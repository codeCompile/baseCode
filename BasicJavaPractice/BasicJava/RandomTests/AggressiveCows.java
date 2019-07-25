package BasicJava.RandomTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {

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

		Scanner scan2 = new Scanner(System.in);
		String strCows = scan1.next();	
		int sizeCows;
		try
		{
			sizeCows = Integer.parseInt(strCows);			
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

		int mininumDistance =1;

		int initDistance = inputMatrix[sizeN - 1] - inputMatrix[0];
		int initialPos = inputMatrix[0];
		Arrays.sort(inputMatrix);
		FindMinimumDistance(sizeCows, inputMatrix,sizeN,0,initDistance);

	}

	private static boolean FindMinimumDistance(int sizeCows, int[] inputMatrix,int sizeN,int start,int end) {
		// TODO Auto-generated method stub

		if(start > end)
		{
			System.out.println(end);
			return false;
		}
			

		int mid = start + (end - start )/2;

		int lastPos=inputMatrix[0];;
		int remainingCows = sizeCows;
		for(int i = 1; i < sizeN; i += 1)
		{
			if(lastPos + mid <= inputMatrix[i] )
			{			
				remainingCows--;
				if(remainingCows<=0) break;
				lastPos = inputMatrix[i];
				
				//System.out.println(">:" + lastPos);				
			}
			if(remainingCows ==0)
			{
				System.out.println(mid);	
				return true;
			}
		}

		if(remainingCows > 0)
		{
			FindMinimumDistance(sizeCows, inputMatrix,sizeN,start,mid-1);
			//System.out.println(" Max distance: " + end);
			return false;
		}
		else
		{
			FindMinimumDistance(sizeCows, inputMatrix,sizeN,mid+1,end);
		}
		return false;
	}
	
	
}
