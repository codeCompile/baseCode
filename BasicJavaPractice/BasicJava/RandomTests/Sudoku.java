package BasicJava.RandomTests;

import java.util.ArrayList;
import java.util.Scanner;

public class Sudoku {

	public static void main(String[] args) {

		int[][] matrix = new int[][]{
			{9, 0 ,0 ,0 ,2 ,0 ,7, 5 ,0 },
			{6, 0 ,0 ,0 ,5 ,0 ,0 ,4 ,0 },
			{0, 2 ,0 ,4 ,0 ,0 ,0 ,1 ,0 },
			{2, 0 ,8 ,0 ,0 ,0 ,0 ,0 ,0 },
			{0 ,7 ,0 ,5 ,0 ,9 ,0 ,6 ,0 },
			{0 ,0, 0 ,0 ,0 ,0 ,4 ,0 ,1 },
			{0 ,1 ,0 ,0 ,0 ,5 ,0 ,8 ,0 },
			{0 ,9 ,0 ,0 ,7 ,0 ,0 ,0 ,4 },
			{0 ,8, 2 ,0, 4 ,0, 0 ,0, 6} };
			int rowSize = matrix.length;
			int colSize = 0;
			if(matrix.length > 0)
				colSize = matrix[0].length;
			boolean b = FillSudoku(matrix,rowSize);
			if(b)
			{
				print(matrix,rowSize);
			
			}


	}

	static int[] validValues()
	{
		int[] vValues = new int[] {1,2,3,4,5,6,7,8,9};
		return vValues;
	}

	static boolean FillSudoku(int[][] matrix,int size)
	{
	    int row = -1; 
	    int col = -1; 
	    boolean isEmpty = true; 
	    for (int i = 0; i < size; i++) 
	    { 
	        for (int j = 0; j < size; j++)  
	        { 
	            if (matrix[i][j] == 0)  
	            { 
	                row = i; 
	                col = j;	                  
	                isEmpty = false;  
	                break; 
	            } 
	        } 
	        if (!isEmpty) 
	        { 
	            break; 
	        } 
	    } 
	  
	    // no empty space left 
	    if (isEmpty)  
	    { 
	        return true; 
	    } 
			for(int v1 : validValues())
			{
				if(isValidMove(matrix,row,col,v1))
				{
					matrix[row][col] = v1;
										

					if(FillSudoku(matrix,size))
					{
						return true;
					}
					else
					{
						matrix[row][col] = 0;			 
					}
				}
			}
		
		return false; 
	}

	/*static boolean FillSudoku(int[][] matrix,int rowSize,int colSize,int row,int col)
	{		
		if(row >= rowSize && col >= colSize)
		{    	
			print(matrix,rowSize);
			return true;
		}

		boolean validMoveFound = false;
		if(matrix[row][col] == 0)
		{			
			for(int v1 : validValues())
			{
				if(isValidMove(matrix,row,col,v1))
				{
					matrix[row][col] = v1;
					validMoveFound = true;								
					//MoveNext
					if(col < colSize)
						col++;
					else col = 0;			

					if(row < rowSize)
					{
						row++;
					}

					return FillSudoku(matrix,rowSize,colSize,row,col);
				}
				else
				{
					matrix[row][col] = 0;			 
				}
			}
		}
		if(col < colSize)
			col++;
		else col = 0;			

		if(row < rowSize)
		{
			row++;
		}

		return FillSudoku(matrix,rowSize,colSize,row,col);

	}
	 */

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

	static boolean isValidMove(int[][] matrix,int row,int col,int value)
	{
		int rowSize = matrix.length;
		int colSize = 0;
		if(matrix.length > 0)
			colSize = matrix[0].length;
		for(int i=0;i<rowSize;i++)
		{
			if( i == col) continue;
			if(matrix[i][col] == value)
				return false;
		}
		for(int i=0;i<colSize;i++)
		{
			if(i == row) continue;
			if(matrix[row][i] == value)
				return false;
		}

		int sqrt = (int) Math.sqrt(matrix.length); 
		int boxRowStart = row - row % sqrt; 
		int boxColStart = col - col % sqrt; 

		for (int r = boxRowStart; r < boxRowStart + sqrt; r++)  
		{ 
			for (int d = boxColStart; d < boxColStart + sqrt; d++)  
			{ 
				if (matrix[r][d] == value)  
				{ 
					return false; 
				} 
			} 
		}
		return true;
	}
}
