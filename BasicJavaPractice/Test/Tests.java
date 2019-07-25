package Test;

public class Tests {

	public static void main(String[] args) {

		String str1 = "ram";
		Object str2 = "ram";
		
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));
		System.out.println(str2.equals(str1));		
		
		String s1 = "test";
		String s2 = "test";
		String s3 = "test1".substring(0, 4);
		Object s4 = s3;
		System.out.println(s1 == s2 +  " " +  s1.equals(s2));
		System.out.println( s1 == s3 + " " +  s1.equals(s3));
		System.out.println( s1 == s4 + " " + s1.equals(s4));

	}

}
