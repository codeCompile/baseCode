package BasicJava.RandomTests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class input {

	
	private static int inputSingltIntegerStub(Scanner scanner) {
		// TODO Auto-generated method stub
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

	static int[] inputArrayStub(Scanner scanner,int capacity)
	{
		int[] array = new int[capacity];
		for(int i=0;i<capacity;i++)		{			
			try {
				int inNum = Integer.parseInt(scanner.next());
				array[i] = inNum;					
			}
			catch(NumberFormatException ex)
			{
			}			
		}
		return array;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//System.out.println("Enter Input String:");
		String input = br.readLine();
		br.close();

		
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


	}
	
	public static void print(int[][] board, int N) 
	{ 
	    // we got the answer, just print it 
	    for (int r = 0; r < N; r++) 
	    { 
	        for (int d = 0; d < N; d++) 
	        { 
	            System.out.print(board[r][d]); 
	            System.out.print(" "); 
	        } 
	        System.out.print("\n"); 
	          
	        if ((r + 1) % (int) Math.sqrt(N) == 0)  
	        { 
	            System.out.print(""); 
	        } 
	    } 
	} 

}
