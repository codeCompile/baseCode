/*package BasicJava.RandomTests;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Anagram {

	try
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//System.out.println("Enter Input String:");
		String input = br.readLine();
		br.close();

		//String[] allInputs = input.split("\\s+");
		//System.out.println("Input String in Lower Case = " + Arrays.toString(allInputs));
		String firstStr="", secondStr="";
		char[] inputCh = input.toCharArray();
		int emptyStringStart = 0;
		for(int i=0;i<inputCh.length;i++)
		{				
			if(Character.isUpperCase(inputCh[i]))
				throw new RuntimeException();

			if( emptyStringStart == 0)            	
			{
				if(inputCh[i] != ' ')
				{
					firstStr += inputCh[i];
					
				}
				else if(firstStr != "")
					emptyStringStart = 1;
			}

			if(emptyStringStart == 1)
			{
				if(inputCh[i] != ' ')
				{
					secondStr += inputCh[i];
					
					//System.out.println( firstStr + "-----------" + secondStr);
				}	         
				else if(secondStr != "")
					emptyStringStart = 2; 
			}

			if(emptyStringStart >=2 ) break;

		}

		System.out.println( firstStr + "-----------" + secondStr);
		if((firstStr.length() < 1 && firstStr.length() > 100000) || (secondStr.length() < 1 && secondStr.length() > 100000))
			throw new RuntimeException();

		boolean isAnagram = true;
		//if( allInputs.length >= 2)
		{
			String strMatch = firstStr;
			if(firstStr.length() == secondStr.length())
			{
				for(char ch1 : firstStr.toCharArray())
				{
					if(strMatch.indexOf(ch1) == -1)
					{
						isAnagram = false;
						break;
					}
				}
			}
			else
				isAnagram = false;			
		}
		//else
		//isAnagram = false;

		System.out.println(isAnagram ? "True" : "False");
	}
	catch(Exception ex)
	{
		throw ex;	        
	}  	
}

}
*/