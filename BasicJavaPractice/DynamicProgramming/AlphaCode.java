package DynamicProgramming;

import java.util.Scanner;
/*
 * This problem is recursive and can be broken in sub-problems. We start from end of the given digit sequence. We initialize the total count of decodings as 0. We recur for two subproblems.
1) If the last digit is non-zero, recur for remaining (n-1) digits and add the result to total count.
2) If the last two digits form a valid character (or smaller than 27), recur for remaining (n-2) digits and add the result to total count.
 */
public class AlphaCode {

	public static void main(String[] args) {

		Scanner scan1 = new Scanner(System.in);
		int size = inputSingleIntegerStub(scan1);
		int array[] = new int[size];
		int product= 1;
		if(size > 5000)
			throw new RuntimeException();
		for(int i=0;i<size;i++)
		{
			array[i] = inputSingleIntegerStub(scan1);
		}
		
		long count = CountPossibleDecodes(array, size);
		System.out.print(count);
	}
	

	private static long CountPossibleDecodes(int[] array,int size) {
		
		if( size == 1)
			return 1;
		
		if(size == 0)
			return 1;
		
		int fD0 = array[size - 1];
		int fD1 = array[size - 2];
		long count=0;
		if(fD0 > 0)
			count = CountPossibleDecodes(array, size - 1);
		
		int number = 10 * fD1 + fD0;
		if(number > 0 && number < 27)
			count += CountPossibleDecodes(array, size - 2);
		
		return count;
	}


	private static int inputSingleIntegerStub(Scanner scanner) {
		int input;
		try
		{
			input = Integer.parseInt(scanner.next());			
		}   
		catch(NumberFormatException ex)
		{
			throw ex;
		}
		return input;
	}


}
