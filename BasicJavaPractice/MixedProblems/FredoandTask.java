package MixedProblems;

import java.util.Scanner;

public class FredoandTask {

	public static void main(String[] args) {

		Scanner scan1 = new Scanner(System.in);
		int size = inputSingltIntegerStub(scan1);
		int array[] = new int[size];
		int product= 1;
		for(int i=0;i<size;i++)
		{
			array[i] = inputSingltIntegerStub(scan1);
			product *= array[i];
		}
		
		
		double d1 = nthRoot(product,size);
		int kk = (int) d1 + 1;
		System.out.print(d1);
	}
	
	static double nthRoot(int A, int N) 
    { 
          
        // intially guessing a random number between 
        // 0 and 9 
        double xPre = Math.random() % 10; 
      
        // smaller eps, denotes more accuracy 
        double eps = 0.001; 
      
        // initializing difference between two 
        // roots by INT_MAX 
        double delX = 2147483647; 
      
        // xK denotes current value of x 
        double xK = 0.0; 
      
        // loop untill we reach desired accuracy 
        while (delX > eps) 
        { 
            // calculating current value from previous 
            // value by newton's method 
            xK = ((N - 1.0) * xPre + 
            (double)A / Math.pow(xPre, N - 1)) / (double)N; 
            delX = Math.abs(xK - xPre); 
            xPre = xK; 
        } 
      
        return xK; 
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
