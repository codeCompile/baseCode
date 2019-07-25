package Test;

public class MyClass {

	public static void main(String[] args) {

		MyClass instance = new MyClass();
		instance.fun2(1.0);
		instance.fun2(1);
		Byte b = 2;
		instance.fun2(b);
		instance.fun2(1L);
	
	
		String s1 = "test";
		String s2 =  new String("test");
		String s3 = new String("test").intern();
		System.out.println(s1 == s3);
		System.out.println(s1.equals(s3));
		System.out.println(s1.equals(s2));
		System.out.println(s2==s3);
		System.out.println(s2.equals(s3));
	}
	void fun2(Integer a) {
		System.out.println("Integer");
	}
	void fun2(Long a) {
		System.out.println("Long");
	}
	void fun2(Double a) {
		System.out.println("Double");
	}
	void fun2(Byte a) {
		System.out.println("Byte");
	}
	
}