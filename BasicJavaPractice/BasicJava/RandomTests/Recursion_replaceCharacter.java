package BasicJava.RandomTests;

public class Recursion_replaceCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//char[] input = input.toCharArray();
	
	}

	public static String replaceCharacter(String input, char c1, char c2) {

      char[] inputChar = input.toCharArray();
       return replaceCharacterTemp(inputChar, 0,inputChar.length,c1,c2);
	}
  
  public static String replaceCharacterTemp(char[] input, int start,int end,char c1, char c2) {

		//System.out.println(input.toString());
        if(start>=end)
          return String.valueOf(input);
        	
        if(input[start] == c1)
        	input[start] = c2;
        
        return replaceCharacterTemp(input,start + 1,end,c1,c2);
        
	}
  
  
  public static String removeConsecutiveDuplicates(String s) {
		// Write your code here

	  char[] inputChar = s.toCharArray();
     return removeConsecutiveDuplicateCharacters(inputChar, 0,inputChar.length);
	}

public static String removeConsecutiveDuplicateCharacters(char[] input, int start,int end) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
		 * Taking input and printing output is handled automatically.
		 */
		//System.out.println(input.toString());
      if(start>=end-1)
      {
        char[] tmp = new char[end];
        for(int i=0;i<end;i++){
          tmp[i] = input[i];
        }
        return String.valueOf(tmp);

      }
      	
      if(input[start] == input[start + 1])
      {
        for(int i = start +1; i < end -1; i ++)
        {
          input[i] = input[i + 1];
        }
        start = start -1;
        end = end - 1;
      }
      
      
      return removeConsecutiveDuplicateCharacters(input,start + 1,end);
      
	}


}
