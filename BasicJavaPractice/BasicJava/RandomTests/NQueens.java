package BasicJava.RandomTests;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueens Queen = new NQueens(); 
		int n = 4;
		Queen.solveNQ(4); 
	}

	/* A recursive utility function to solve N 
   Queen problem */
	boolean solveNQUtil(int board[][], int size,int col) 
	{ 
		/* base case: If all queens are placed 
       then return true */
		if (col >= size) 
		{
			printSolution(board,size); 

			return true; 
		}
		/* Consider this column and try placing 
       this queen in all rows one by one */
		for (int i = 0; i < size; i++) 
		{ 
			/* Check if the queen can be placed on 
           board[i][col] */
			if (isSafe(board, size,i, col)) 
			{ 
				/* Place this queen in board[i][col] */
				board[i][col] = 1; 

				/* recur to place rest of the queens */
				solveNQUtil(board, size,col + 1); // == true) 
				//return true; 
				//continue;

				/* If placing queen in board[i][col] 
               doesn't lead to a solution then 
               remove queen from board[i][col] */
				board[i][col] = 0; // BACKTRACK 
			} 
		} 

		/* If the queen can not be placed in any row in 
       this colum col, then return false */
		return false; 
	} 
	boolean solveNQ(int size) 
	{ 
		int board[][] = new int[size][size];

		for(int i=0;i<size;i++)
			for(int j=0;j<size;j++)
			{
				board[i][j] = 0;
			}


		if (solveNQUtil(board, size,0) == false) 
		{ 
			//System.out.print("Solution does not exist"); 
			return false; 
		} 

		//printSolution(board); 
		return true; 
	} 



	/* A utility function to print solution */
	void printSolution(int board[][],int size) 
	{ 
		for (int i = 0; i < size; i++) 
		{ 
			for (int j = 0; j < size; j++) 
				System.out.print(board[j][i] + " ");


		} 
		System.out.println(); 
	} 

	/* A utility function to check if a queen can 
  be placed on board[row][col]. Note that this 
  function is called when "col" queens are already 
  placeed in columns from 0 to col -1. So we need 
  to check only left side for attacking queens */
	boolean isSafe(int board[][], int size,int row, int col) 
	{ 
		int i, j; 

		/* Check this row on left side */
		for (i = 0; i < col; i++) 
			if (board[row][i] == 1) 
				return false; 

		/* Check upper diagonal on left side */
		for (i=row, j=col; i>=0 && j>=0; i--, j--) 
			if (board[i][j] == 1) 
				return false; 

		/* Check lower diagonal on left side */
		for (i=row, j=col; j>=0 && i<size; i++, j--) 
			if (board[i][j] == 1) 
				return false; 

		return true; 
	} 
}
