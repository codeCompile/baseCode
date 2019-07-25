package MixedProblems;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class NearandMello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan1 = new Scanner(System.in);
		//String str = scan1.next();


		int size = inputSingltIntegerStub(scan1);
		int pillar[] = new int[size];
		for(int i=0;i<size;i++)
		{
			pillar[i] = inputSingltIntegerStub(scan1);
		}

		//FindMaxWaterHoldingPillarArrangement(pillar,size);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
          permute(pillar,0,size-1,list);
          System.out.println(list.get(0));
	}

	private static void permute(int[] str, int l, int r,ArrayList<Integer> list) 
	{ 
		if (l == r) 
		{
			int maxWater = FindMaxWaterHoldingPillarArrangement(str,str.length);
			if(maxWater > list.get(0))
			{
				list.set(0, maxWater);
			 
			}
		}
		else
		{ 
			for (int i = l; i <= r; i++) 
			{ 
				swap(str,l,i); 
				permute(str, l+1, r,list); 
				swap(str,l,i); 
			} 
		} 
	}

	private static void swap(int[] str, int l, int i) {
		int temp = str[l];
		str[l] = str[i];
		str[i] = temp;
		
	}

	private static int FindMaxWaterHoldingPillarArrangement(int[] arr, int n) {

		// left[i] contains height of tallest bar to the 
		// left of i'th bar including itself 
		int left[] = new int[n]; 

		// Right [i] contains height of tallest bar to 
		// the right of ith bar including itself 
		int right[] = new int[n]; 

		// Initialize result 
		int water = 0; 

		// Fill left array 
		left[0] = arr[0]; 
		for (int i = 1; i < n; i++) 
			left[i] = Math.max(left[i-1], arr[i]); 

		// Fill right array 
		right[n-1] = arr[n-1]; 
		for (int i = n-2; i >= 0; i--) 
			right[i] = Math.max(right[i+1], arr[i]); 

		// Calculate the accumulated water element by element 
		// consider the amount of water on i'th bar, the 
		// amount of water accumulated on this particular 
		// bar will be equal to min(left[i], right[i]) - arr[i] . 
		for (int i = 0; i < n; i++) 
			water += Math.min(left[i],right[i]) - arr[i]; 

		return water; 
	}


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
}
