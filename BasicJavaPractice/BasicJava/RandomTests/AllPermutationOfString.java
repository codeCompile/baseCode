package BasicJava.RandomTests;

public class AllPermutationOfString {

	public static void main(String[] args) 
	{
	

	}

	public static String[] permutationOfString(String input){
		// Write your code here
		
      permute(input,0,input.length() -1);
      return new String[0];
	}
	
  
    
    private static void permute(String str, int l, int r) 
    { 
        if (l == r) 
            System.out.println(str); 
        else
        { 
            for (int i = l; i <= r; i++) 
            { 
                str = swap(str,l,i); 
                permute(str, l+1, r); 
                str = swap(str,l,i); 
            } 
        } 
    } 

    public static String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    } 
}
