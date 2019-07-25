package SegmentTrees;

import java.util.Scanner;

public class BasicSegmentTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan1 = new Scanner(System.in);
		int size = inputSingltIntegerStub(scan1);
		int array[] = new int[size];
		for(int i=0;i<size;i++)
		{
			array[i] = inputSingltIntegerStub(scan1);
		}
		int[] treeArray = new int[2*size + 1];
		CreateAsegmentTree(array,treeArray,0,size-1,0);

		for(int i=0;i<2*size+1;i++)
			System.out.print(treeArray[i] + "->");
		
		int indx = 3; int newValue = 1000;
		System.out.print(" Now updating indx 3 then will replace indx + 1");
		//array[indx-1] = newValue;
		UpdateSegmentTree(array,treeArray,0,size-1,0,indx-1,newValue);
		
		for(int i=0;i<2*size+1;i++)
			System.out.print(treeArray[i] + "->");
		
		System.out.println(" Query " + QuerySegmentTree(treeArray, 0, size-1, 0 , 2, 3));
		
	}


	private static void CreateAsegmentTree(int[] array, int[] treeArray, int start, int end, int indx) {

		if(start == end) {
				treeArray[indx] = array[start];
			return;
		}

		int mid = (start + end) / 2;
        System.out.println( " start " + start + " end " + end + " mid " + mid + " indx " + indx);
		CreateAsegmentTree(array,treeArray,start,mid,2*indx + 1);
		CreateAsegmentTree(array,treeArray,mid+1,end,2*indx+2);

		treeArray[indx] = treeArray[2*indx + 1] + treeArray[2*indx+ 2];
	}


	private static void UpdateSegmentTree(int[] array, int[] treeArray, int start, int end, int treeNode,int indx, int newValue) {

		if(start == end)
		{
			array[indx] = newValue;
			treeArray[treeNode] = newValue;;
			return;
		}
		int mid = (start + end)/2;
		System.out.println( " Update:  start " + start + " end " + end + " mid " + mid + " indx " + indx);
		if(indx < mid)
		{
			UpdateSegmentTree(array,treeArray,start,mid,treeNode * 2 + 1 ,indx,newValue);
		}
		else
		{
			UpdateSegmentTree(array,treeArray,mid+1,end,treeNode * 2 + 2,indx,newValue);			
		}
		treeArray[treeNode] = treeArray[2*treeNode +  1 ] + treeArray[2*treeNode+ 2];
	}

private static int QuerySegmentTree(int[] tree,int start,int end,int treeNode,int left,int right)
{
	if(start > right && end < left)
		return 0;
	
	if(start>=left && end <=right)
	{
		return tree[treeNode];
	}
	//Partially inside range
	int mid = (start + end) /2;
	System.out.println( " Query:  start " + start + " end " + end + " mid " + mid + " left " + left + " right " + right);
	int ans1 = QuerySegmentTree(tree,start,mid,2* treeNode + 1,left,right);
	
	int ans2 = QuerySegmentTree(tree,mid + 1,end,2* treeNode + 2,left,right);
	
	return ans1 + ans2;
}
	
	private static int inputSingltIntegerStub(Scanner scanner) {
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


