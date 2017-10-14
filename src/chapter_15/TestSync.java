package chapter_15;

public class TestSync implements Runnable {
	private int balance = 0;
	
	public static void main(String[] args){
		TestSync job = new TestSync();
		Thread a = new Thread(job);
		Thread b = new Thread(job);
		a.setName("a");
		b.setName("b");
		a.start();
		b.start();
	}
	@Override
	public void run() {
		for(int i = 0; i < 50; i++){
			if(balance >= 10){
				System.out.println("Thread " + Thread.currentThread().getName() + ": time = " + i + ", balance = " + balance + " ---break");
				
				break;
			}else{
				System.out.println("Thread " + Thread.currentThread().getName() + ": time = " + i + ", balance = " + balance + " ---not break");
			}
			increment();
			System.out.println("Thread " + Thread.currentThread().getName() + ": in run(): balance = " + balance + ", time = " + i + "\n");

		}
		System.out.println("Finally, Thread " + Thread.currentThread().getName() + ": balance = " + balance + "\n");
	}
	
	private void increment(){
		System.out.println("Thread " + Thread.currentThread().getName() + ": before increment(), balance = " + balance);
		synchronized(this){
		int i = balance;
		System.out.println("Thread " + Thread.currentThread().getName() + ": in increment(), balance = " + balance);
		balance = i + 1;
		}
		System.out.println("Thread " + Thread.currentThread().getName() + ": after increment(), balance = " + balance + "\n");
	}

}
