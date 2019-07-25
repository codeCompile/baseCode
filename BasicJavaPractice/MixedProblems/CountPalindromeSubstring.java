package MixedProblems;

import java.util.HashMap;
import java.util.Scanner;
//https://www.geeksforgeeks.org/count-palindrome-sub-strings-string-set-2/
public class CountPalindromeSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan1 = new Scanner(System.in);
		String str = scan1.next();

		int kk = countPS(str);
		System.out.println(kk);
	}
	
	      
	    // Method which return count palindrome substring 
	    static int countPS(String str){ 
	        String temp = ""; 
	        StringBuffer stf; 
	        int count = 0; 
	        // Iterate the loop twice 
	        for (int i = 0; i < str.length(); i++) { 
	            for (int j = i + 1; j <= str.length(); j++) { 
	                // Get each substring 
	                temp = str.substring(i, j); 
	                  
	                // If length is greater than or equal to two 
	                // Check for palindrome     
	                if (temp.length() >= 1) { 
	                    // Use StringBuffer class to reverse the string 
	                    stf = new StringBuffer(temp); 
	                    stf.reverse(); 
	                    // Compare substring wih reverse of substring 
	                    if (stf.toString().compareTo(temp) == 0) 
	                        count++; 
	                } 
	            } 
	        } 
	        // return the count 
	        return count; 
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
