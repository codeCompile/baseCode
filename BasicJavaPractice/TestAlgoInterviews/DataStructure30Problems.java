package TestAlgoInterviews;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataStructure30Problems {

	public static void main(String[] args) {

		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> numbers = null; Integer total=0;
		try {
			 numbers = Stream.of(reader.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
		     total = Integer.parseInt(reader.readLine());			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		DataStructure30Problems ds = new DataStructure30Problems();

		ds.Find3PairsWithGivenSumInanArray(numbers,total);
	}
		
	
	//Find 3 pairs with given sum in an array
	public void Find3PairsWithGivenSumInanArray(List<Integer> input,Integer sum)
	{
	   FindSubsetsWhichAreEqualToGivenSum(input,0,input.size(),sum);
	 	
	}


	private void FindSubsetsWhichAreEqualToGivenSum(List<Integer> input, int start, int end, Integer sum) {

		if(sum <= 0 || start >= end) return;
		
		if(start < end)
		{
			if(input.get(start) < sum)
			{
		        		
				FindSubsetsWhichAreEqualToGivenSum(input,start + 1, end,sum) ;
				FindSubsetsWhichAreEqualToGivenSum(input,start + 1, end,sum - input.get(start));				
			}
			else if(input.get(start)  == sum)
			{
				
			}
		}
	}

}
