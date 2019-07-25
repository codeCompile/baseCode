package DynamicProgramming;

import java.util.Scanner;

public class MagicGridProblem {

	public static void main(String[] args) {
		Scanner scan1 = new Scanner(System.in);
		int noOfTests = inputSingleIntegerStub(scan1);
		for(int i=0;i<noOfTests;i++)
		{
			int R = inputSingleIntegerStub(scan1);
			int C = inputSingleIntegerStub(scan1);
			int array[][] = new int[R][C];

			for(int i1=0;i1<R;i1++)
			{
				for(int c1=0;c1<C;c1++)
				{
					array[i1][c1] = inputSingleIntegerStub(scan1);
				}
			}
			
			int ans = CalulateStrenghtRequired(array,R,C,0,0);
		}
	}
	
	private static int CalulateStrenghtRequired(int[][] array, int r, int c, int i, int j) {

		
		
		CalulateStrenghtRequired(array,r,c,i,j+1);
		CalulateStrenghtRequired(array,r,c,i+1,j);
		
		return 0;
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
