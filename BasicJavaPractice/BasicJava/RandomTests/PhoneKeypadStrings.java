package BasicJava.RandomTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
//Print subsequence of String
//Print phone keypad all combinations

public class PhoneKeypadStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan1 = new Scanner(System.in);
		String strN = scan1.next();	
		int sizeN;
		try
		{
			sizeN = Integer.parseInt(strN);			
		}   
		catch(NumberFormatException ex)
		{
			throw ex;
		}
		//DoFindAllSubstring();
		//String[] str = new String[100];
		ArrayList<String> str = new ArrayList<String>();
		String[] uu = phoneKeypadStringsFormation(sizeN,str);
		System.out.print(Arrays.toString(uu));
	}

	private static String[] phoneKeypadStringsFormation(int num,ArrayList<String> KK) 
	{  /*    
		if(num % 10 == num)
		{
			if(num !=0)
			{
				int s1 = Getsize(num);
				String[] ff = new String[s1];
				for(int i = 0 ; i< s1; i ++)
				{
					int t = GetNumber(num,i);
					char c1 = (char)t;				
					ff[i] =  String.valueOf(c1);
				}				
				return ff;
			}
		}*/
		
		if(num == 0)
			return 	KK.toArray(new String[1]) ;//KK.size()]); //new String[] {" "};
		
		
		int firstNum = num %10;
		int s1 = Getsize(firstNum);
		String[] uu = phoneKeypadStringsFormation(num /10,KK);
		
		String[] ff = new String[ s1 * uu.length];
		
		int mm = 0;
		for(int i = 0 ; i< s1; i ++)
		{
			int t = GetNumber(firstNum,i);
			String c1 = String.valueOf((char)t);	
			
			for(int k =0; k < uu.length; k++)
			{				
				if(uu[k] == null)
					uu[k] = "";
				ff[mm++] = uu[k] + c1;
				
				//if(KK.size() - 1 < k )
					//KK.add(ff[i]);
				/*else
				KK.set(k, ff[i]);*/
			}
			
		}
		return ff; //KK.toArray(ff);
		//return (String[])KK.toArray();
	}
	
	private static int GetNumber(int firstNum, int index) 
	{
		int size = 0;        
		for(int i=2; i< firstNum; i++)
			size += Getsize(i);

		int v = 97 + index + size;
		return v;
	}

	private static int Getsize(int firstNum) 
	{
		// TODO Auto-generated method stub
		if(firstNum == 7 || firstNum == 9)
		{
			return 4;  	
		}
		return 3;
	}
	//static ArrayList<String> allStr = new ArrayList<String>();
	private static void DoFindAllSubstring()
	{
		ArrayList<String> result = new ArrayList<String>();
		String input = "abcdef";
		String[] strs = AllSubstrings(input);
		int trc = 0;int i =0;
		for(i = 0 ; i < strs.length; i++)
		{
			if(strs[i] == null)
			{
				if(trc == 0) 
					trc = i;
			}
			else if(trc > 0)
			{
				if(strs[i] != null)
				{
					strs[trc] = strs[i];
					strs[i] = null;
					i=trc;
					trc = 0;
				}
			}
		}
		System.out.print(Arrays.toString(strs));

	}
	private static String[] AllSubstrings(String input)
	{		
		//System.out.println(input);

		if(input == "")
		{
			String strs[] = new String[1];
			strs[0] = " ";
			return strs;
		}

		//ArrayList<String> strs1 = new ArrayList<String>();
		String[] KK = AllSubstrings(input.length() >= 1 ? input.substring(1)  : "" );
		String[] strs = new String[2*KK.length];
		int i = 0;
		for(int k = 0 ; k < KK.length; k++)
		{
			strs[k] = KK[k];
		}
		i = KK.length - 1;
		for(String s1 : KK)
		{
			if(input != null && input.length() >= 1  && s1 != null && !s1.isEmpty())
				strs[i++] =  input.charAt(0) + s1;			
		}		
		return strs;
	}

}
