package Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class EvenOddSem {

	public static void main(String[] args) {

		SharedPrinter container = new SharedPrinter();
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.execute(new EvenNumProducer(container,10));
		service.execute(new OddNumProducer(container,10));

	}
	}

	class SharedPrinter
	{
		Semaphore semEven = new Semaphore(0);
		Semaphore semOdd = new Semaphore(1);
		public void printEvenNum(int i) {
           try {
			semEven.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			System.out.println(i++);
           semOdd.release();
		}
		
		
		public void printOddNum(int i) {
			try {
				semOdd.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i++);
			semEven.release();
		}
	}

	//Thread Class generating Even numbers
	class EvenNumProducer implements Runnable{
	    SharedPrinter container;
	    int index;
	    EvenNumProducer(SharedPrinter container, int index){
	        this.container = container;
	        this.index = index;
	    }
	    @Override
	    public void run() {
	        for(int i = 2; i <= index; i = i+2){
	        	container.printEvenNum(i);
	        }   
	    }  
	}

	//Thread Class generating Odd numbers
	class OddNumProducer implements Runnable{
	    SharedPrinter container;
	    int index;
	    OddNumProducer(SharedPrinter container, int index){
	        this.container = container;
	        this.index = index;
	    }
	    @Override
	    public void run() {
	        for(int i = 1; i <= index; i = i+2){
	        	container.printOddNum(i);
	        }
	    }
	} 
