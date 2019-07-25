package BasicJava.RandomTests;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		Scanner scan1 = new Scanner(System.in);
		String strInput = scan1.next();	

		char fisrtNonRepeatingCharacter = ' ';
		HashMap<Character, Integer> store = new HashMap<Character, Integer>(); 
		for(char ch : strInput.toCharArray())
		{
			if(store.containsKey(ch))
				store.put(ch, store.get(ch) + 1);
			else
			{
				store.put(ch,1);
			}								
		}

		for(char ch : strInput.toCharArray())
		{
			if(store.containsKey(ch))
			{
				if(store.get(ch) == 1)
				{
					System.out.println(ch);
					break;
				}
			}
		}
	}

	public static int[] removeDuplicates(int arr[])
	{
		//	write your code here.
		SortedSet<Integer> hashInteger = new TreeSet<Integer>(); 
		for(int i=0;i< arr.length; i++)
		{
			if(!hashInteger.contains(arr[i])) 
			{
             hashInteger.add(arr[i]);
			}
		}
		int[] array = hashInteger.stream().mapToInt(Number::intValue).toArray();
		return array;
	}
}
