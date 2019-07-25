package MixedProblems;

import java.util.Arrays;
import java.util.Scanner;

public class MonkandCakes {

	/*
	 * First line of the input contains test cases denoted by T

 first  N = the number of different types of cakes present
        M denoting  at the party and the number of Monk's friends
        M space separated integers denoting the eating capacity of the Monk's friends.
        N integers ith integer corresponds to the weight of ith type of cake ,i.e., W[i].
        N space separated integers where the ith integer corresponds to the number of cakes of ith type present, i.e., C[i]. 
	 You need to tell whether it is possible for Monk's friends to eat all the cakes present at the birthday party. 
	 If yes, then print the minimum time required to eat all the cakes else print −1 otherwise.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan1 = new Scanner(System.in);
		
		int noOfDifferenttypeCakes = inputSingltIntegerStub(scan1);
					
		int noOfFriends =inputSingltIntegerStub(scan1);
		
		int[] eatingCapacity = inputArrayStub(scan1,noOfFriends);

		int[] weightCakes = inputArrayStub(scan1,noOfDifferenttypeCakes);
		
		int[] iTypeCakeNo = inputArrayStub(scan1,noOfDifferenttypeCakes);
		
		Arrays.sort(eatingCapacity);
		int cakeNos = Arrays.stream(iTypeCakeNo).sum();
        
		if(noOfFriends > cakeNos) 
			System.out.println(-1);

	    for(int i =0;i< noOfDifferenttypeCakes;i++)
	    {
	    	int fin = weightCakes[i];
	    	if(iTypeCakeNo[i] > 0)
	    	{
	    		
	    	}
	    }
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

}
