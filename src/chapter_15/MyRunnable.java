package chapter_15;

public class MyRunnable implements Runnable{
	public void run(){
		System.out.println("run");
		go();
	}
	
	public void go(){
//		try{
//		Thread.sleep(500);
//		}catch(InterruptedException ex){
//			ex.printStackTrace();
//		}
		doMore();
	}
	
	public void doMore(){
		System.out.println("doMore");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
