package MixedProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorldBreak_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nos = 13;
		String[] dict = new String[]
				{
						"mobile","samsung","sam","sung","man","mango","icecream","and","go","i","love","ice","cream"
				};

		Scanner scan1 = new Scanner(System.in);
		/*String strN = scan1.next();	
		int sizeN;
		try
		{
			sizeN = Integer.parseInt(strN);			
		}   
		catch(NumberFormatException ex)
		{
			throw ex;
		}

		String dict[] = new String[sizeN];
		for(int i =0;i < sizeN; i++)
		{
			strN = scan1.next();
			dict[i] = strN;
		}
		 */
		String input = scan1.next();
		//"iloveicecreamandmango"
		ArrayList<Integer> allIndexes = new ArrayList<Integer>();
		//"iloveicecreamandmango"
		FindWordinSentences_1(input,dict,"");  //both working
		FindWordinSentences(input,input.length(),dict,""); //both working
		//System.out.println(b);
		//wordBreak(input,"");
	}


	private static void FindWordinSentences_1(String input,String[] dict, String result)
	{
		int size = input.length();
		for (int i = 1; i <= size; i++)
		{
			String strTmp = input.substring(0, i);
			if (dictionaryContains(strTmp,dict))
			{
				if (i == size)
				{
					System.out.println(result + input);
					break;
				}

				else
				{
					FindWordinSentences_1(input.substring(i, size),dict,
							result + strTmp + " " );
				}
			}
		}
	}
	static boolean dictionaryContains(String word,String[] dictionary) 
	{ 
		int size = dictionary.length; 
		for (int i = 0; i < size; i++) 
			if (dictionary[i].equals(word)) 
				return true; 
		return false; 
	} 

	private static void FindWordinSentences(String input,int length,String[] dict,String result) 
	{
		/*	if(input.length() == 0)
		{
			System.out.println(result);
			return;// true;
		}*/
		boolean isExists = false;
		for(int i=1;i<= length; i++)
		{
			String val = input.substring(0,i);
			//String tmpMatch = "";
			isExists = dictionaryContains(val,dict);
			/*			for(String dStr : DictioanyConainsThis(val,dict))
			{			   	
				if(dStr.length() == val.length())
               			tmpMatch = dStr;
			   String v1 = input.substring(0,dStr.length());
			   if(v1.equals(dStr))
			   {
				   isExists = false; 
			   }
			}*/
			/*if(isExists == false)
			{
				if(tmpMatch.equals(val))
					isExists = true;
			}*/
			if(isExists)
			{
			if(i == length)
			{

				System.out.println(result + input);
				break;
				//return;// true;

			}
			else
			{
				String va = input.substring(i,length); 
				String stOut =  result + val + " ";
				FindWordinSentences(va,va.length(),dict,stOut); //input.substring(i+1,input.length())
			}
			}
		}
	}

	private static List<String> DictioanyConainsThis(String val,String[] dict) 
	{	
		List<String> all = new ArrayList<String>();
		for(int j=0;j < dict.length; j++)
		{				
			if(dict[j].startsWith(val))
			{
				all.add(dict[j]);
			}
		}
		return all;
	}



	/// returns true if string can be segmented into space  
	// separated words, otherwise returns false 
	/*	static boolean wordBreak(String str,String prefix) 
	{ 
	    int size = str.length(); 

	    if (size == 0) 
	    	{
	    	System.out.println(prefix);
	    	return true; 
	    	}

	    for (int i=1; i<=size; i++) 
	    { 
	    	String val= str.substring(0, i);
	        if (dictionaryContains( val ) && 
	            wordBreak( str.substring(i) , prefix + "  " + val)) 
	            return true; 
	    } 

	    return false; 
	} */
	private static boolean FindWordinSentences(String input,String[] dict) 
	{

		if(input.length() == 0)
			return true;
		boolean isExists = false;
		for(int i=1;i<= input.length(); i++)
		{
			String val = input.substring(0,i);
			for(int j=0;j < dict.length; j++)
			{				
				if(val.contains(dict[j]))
				{
					isExists = true;
					break;
				}
			}


			if(  isExists && FindWordinSentences(input.substring(i),dict))  //input.substring(i+1,input.length())
			{
				return true;
			}
		}

		return false;

	}
}
