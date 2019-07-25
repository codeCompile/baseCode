package BasicJava.RandomTests;

public class RatinMaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] maze1 = {
			    {0,1,0,1,1},
			    {0,0,0,0,0},
			    {1,0,1,0,1},
			    {0,0,1,0,0},
			    {1,0,0,1,0}
			}; 
		int[][]	maze = {{1, 0, 1}, {1, 1, 1},{1, 1, 1}};
		int n= 3;
		int[][] solution = new int[n][n];
		solution = new int[maze1.length][maze[0].length];
		RatinMaze ratinMaze = new RatinMaze(); 
		
		ratinMaze.solveRatInMaze(maze,solution,maze[0].length,0,0); 
		//ratinMaze.printSolution(solution,n);
	}

	/* A recursive utility function to solve N 
   Queen problem */
	boolean solveRatInMaze(int board[][], int[][] solution,int size,int row,int col) 
	{
		if (col == size - 1 && row == size -1) 
		{
			solution[row][col] = 1;
			printSolution(solution,size);
			//solution[row][col] = 0;
			return true; 
		}

		if(isValidMove(board,solution,size,row,col))
		{
			solution[row][col] = 1;
			//move down
		/*	if(solveRatInMaze(board,solution,size,row + 1, col))
				return true;
			//move right
			if(solveRatInMaze(board,solution,size,row, col + 1))
				return true;
			//move up
			if(solveRatInMaze(board,solution,size,row -1 , col))	
				return true;
			//move left
			if(solveRatInMaze(board,solution,size,row, col-1))
				return true;*/

			solveRatInMaze(board,solution,size,row + 1, col);
			//	return true;
			//move right
			solveRatInMaze(board,solution,size,row, col + 1);
				//return true;
			//move up
			solveRatInMaze(board,solution,size,row -1 , col);
				//return true;
			//move left
			solveRatInMaze(board,solution,size,row, col-1);
				//return true;
			solution[row][col] = 0;
			return false; 
		}

		return false;

	} 

	boolean isValidMove(int[][] board,int[][] solution,int size,int row,int col)
	{
		if((row>= 0 && row < size) && (col >= 0 && col < size) && board[row][col] == 1 && solution[row][col] == 0)
		{
			return true;
		}
		return false;		
	}
	
	/* A utility function to print solution */
	void printSolution(int board[][],int size) 
	{ 
		for (int i = 0; i < size; i++) 
		{ 
			for (int j = 0; j < size; j++) 
				System.out.print(board[i][j] + " ");


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
