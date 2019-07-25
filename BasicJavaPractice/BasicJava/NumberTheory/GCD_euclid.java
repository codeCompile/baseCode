package BasicJava.NumberTheory;

public class GCD_euclid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 12, 98 gcd is 2
        int a = 9; //16; //98;
        int b = 9; //10; //12;
		int k = calculateGCD(a,b);
		Triplet o1 = advancedGCD(a,b);
		
	}

	static int calculateGCD(int a, int b)
	{
		if(a<b)
			return calculateGCD(b,a);
		if(b==0)
			return a;

		return calculateGCD( b , a%b );

	
	}

	static Triplet advancedGCD(int a,int b)
	{
		if(b==0)
		{
			//GCD_euclid hh = new GCD_euclid();
			Triplet t1 =  new GCD_euclid.Triplet();
			
			t1.X = 1;
			t1.Y = 0;
			t1.GCD = a;
			return t1;
		}
		Triplet t2 = advancedGCD(b,a%b);
		
		//GCD_euclid hh = new GCD_euclid();
		Triplet t1 =  new GCD_euclid.Triplet();
		t1.Y  =  t2.X - (int)Math.floor(a/b) * t2.Y;
		t1.X = t2.Y;
		t1.GCD = t2.GCD;
		return t1;
	}

	static class Triplet
	{
		public int GCD;
		public int X;
		public int Y;

	}
}


