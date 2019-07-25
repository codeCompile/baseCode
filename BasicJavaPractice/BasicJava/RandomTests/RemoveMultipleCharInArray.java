package BasicJava.RandomTests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

public class RemoveMultipleCharInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String uniqueChar(String str){
		// Write your code here

		HashSet<Character> hArrSet = new HashSet<Character>(); 
		char[] charArray = str.toCharArray();
		for(int i =0; i< charArray.length;i++)
		{
			hArrSet.add(charArray[i]);
		}
		
		String output ="";
		for(int i =0; i< charArray.length;i++)
		{			
			if(hArrSet.remove(charArray[i]))
				output += charArray[i];
		}
		
		return output;
	}
}
