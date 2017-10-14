package chapter_15;

public class ThreadTest {

	public static void main(String[] args) {
		Runnable threadJob = new MyRunnable();
		Thread myThread = new Thread(threadJob);
		myThread.start();
		try{
			Thread.sleep(100);
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
		System.out.println("ThreadTest back in main");
	}

}
