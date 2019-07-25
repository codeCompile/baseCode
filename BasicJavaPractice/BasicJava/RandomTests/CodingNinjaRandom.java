package BasicJava.RandomTests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class CodingNinjaRandom 
{
	public static void main(String[] args) throws IOException
	{
		Scanner scan1 = new Scanner(System.in);
		String strN = scan1.next();	
		String strM = scan1.next();
		int sizeN,sizeM;
		try
		{
			sizeN = Integer.parseInt(strN);
			sizeM = Integer.parseInt(strM);
		}   
		catch(NumberFormatException ex)
		{
			throw ex;
		}

		if(!(( sizeN >= 1 && sizeN <= 100) && ( sizeM >= 1 && sizeM <= 100)))
			throw new RuntimeException();

		int[][] inputMatrix = new int[sizeN][sizeM];

		for(int i=0;i<sizeN;i++)
		{
			for(int j=0;j<sizeM;j++)
			{
				try
				{
					while(true)
					{
						int inNum = Integer.parseInt(scan1.next());
						if(inNum < 0 || inNum > 1)
							continue;
						else
						{
							inputMatrix[i][j] = inNum;
							break;
						}
					}
				}
				catch(NumberFormatException ex)
				{
				}
			}
		}

		int count = 0;
		FindIslandInMatrix(inputMatrix,0,0,sizeN,sizeM, count);
		System.out.print(count);
		/*for(int i=0;i<sizeN;i++)
		{
			System.out.print("\r\n");
			for(int j=0;j<sizeM;j++)
			{
				try
				{
					System.out.print(inputMatrix[i][j]);
				}
				catch(NumberFormatException ex)
				{

				}
			}
		}
*/

	}

	private static void FindIslandInMatrix(int[][] inputMatrix,int row, int col , int sizeRow, int sizeCol,int count) 
	{	 
		if(row < 0 || row >= sizeRow || col < 0 || col >= sizeCol)
			return;		
		if(inputMatrix[row][col] == 0 )
			return;
		
		int left = -1,right = -1,up =-1,down = -1;
		{
			if(col -1 >=0) { 
				left = inputMatrix[row][col -1];
				if(left ==1)
					FindIslandInMatrix(inputMatrix,row,col -1,sizeRow,sizeCol,count);
			}
			else if(col + 1 <= sizeCol) {
				right = inputMatrix[row][col +1];
				if(right ==1)
					FindIslandInMatrix(inputMatrix,row,col + 1,sizeRow,sizeCol,count);
			}
			else if(row -1 >=0) {
				up = inputMatrix[row -1][col];
				if(up ==1)
					FindIslandInMatrix(inputMatrix,row -1,col,sizeRow,sizeCol,count);
			}
			else if(row + 1 <= sizeRow) {
				down = inputMatrix[row +1][col];
				if(down ==1)
					FindIslandInMatrix(inputMatrix,row + 1,col,sizeRow,sizeCol,count);
			}		
			if(!(left ==  1 || right ==1 || up == 1 || down ==1 ))
				count ++;
		}

		/*if(left ==  1 || right ==1 || up == 1 || down ==1 )
			FindIslandInMatrix(inputMatrix,row,col,sizeRow,sizeCol,count);
		 */
		FindIslandInMatrix(inputMatrix,row + 1,col,sizeRow,sizeCol,count);
		FindIslandInMatrix(inputMatrix,row,col + 1,sizeRow,sizeCol,count);
	}
}

