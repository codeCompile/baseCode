package BasicJava.RandomTests;

import java.util.Arrays;

public class Heap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inputArray = {9, 4, 8, 7, 11, 3};
        CreateHeap(inputArray);
	}
	
	
	//Heapify
	private static void CreateHeap(int[] inputArray)
	{
		int[] heapArray = new int[inputArray.length];
		int heapSize = 0;
		for(int i =0 ;i < inputArray.length;i++) {
			InsertintoHeap(heapArray,inputArray[i], ++heapSize);
		}
		
		System.out.print(Arrays.toString(heapArray));
		System.out.print(heapArray.length);
		
		for(int i=0;i<2; i++)
		{
			heapArray[0] = heapArray[heapSize -1];
			heapArray[heapSize -1] = -111111;
			heapSize--;
			MinMaxHeapify(heapArray, heapSize,0);
			System.out.println(Arrays.toString(heapArray));
		}
		System.out.print("Second largest: " + heapArray[0]);
	}


	private static void InsertintoHeap(int[] heapArray, int i,int heapSize) 
	{
			
		if( heapSize > heapArray.length) return;
		int index = heapSize -1;
		heapArray[index] = i;
		while(index !=0 && heapArray[getParent(index)] < heapArray[index])
		{			
			int tmp = heapArray[getParent(index)];
			heapArray[getParent(index)] = heapArray[index];
			heapArray[index] = tmp;	
			index = getParent(index);
		}
	}
	
	private static void MinMaxHeapify(int[] heapArray,int heapArraySize,int index)
	{	
		int elementIndex = index;
		int left = getLeft(index);
		int right =  getRight(index);
		if( left < heapArraySize && heapArray[index] < heapArray[left])
			elementIndex = left;
		
		if( right < heapArraySize && heapArray[elementIndex] < heapArray[right])
			elementIndex = right;
		
		if(elementIndex != index)
		{			
			int tmp = heapArray[elementIndex];
			heapArray[elementIndex] = heapArray[index];
			heapArray[index] = tmp;	
			MinMaxHeapify(heapArray,heapArraySize,elementIndex);
		}
	}
	
	private static int getParent(int index)
	{
		return (index-1)/2;
	}
	
	private static int getLeft(int index) {
		return 2 * index + 1;
		
	}
	
	private static int getRight(int index) {
		return 2 * index + 2;
	}
	
}
