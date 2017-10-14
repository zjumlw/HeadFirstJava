package chapter_15;

class BankAccount{
	private int balance = 100;
	private int RyanCount = 0;
	private int MonicaCount = 0;
	public int getBalance(){
		return balance;
	}
	public int getRyanCount(){
		return RyanCount;
	}
	public int getMonicaCount(){
		return MonicaCount;
	}
	public void withdraw(int amount){
		balance = balance - amount;
	}
	
	public void countChange(){
		if(Thread.currentThread().getName().equals("Ryan")){
		RyanCount += 10;
		}else if(Thread.currentThread().getName().equals("Monica"))
			MonicaCount +=10;
		}
}

public class RyanAndMinicaJob implements Runnable {
	private BankAccount account = new BankAccount();
	

	public static void main(String[] args) {
		RyanAndMinicaJob theJob = new RyanAndMinicaJob();
		Thread one = new Thread(theJob);
		Thread two = new Thread(theJob);
		one.setName("Ryan");
		two.setName("Monica");
		one.start();
		two.start();
	}

	@Override
	public void run() {
		for(int i = 0; i < 10; i++){
			System.out.println(Thread.currentThread().getName()+":i = " + i);
			makeWithdrawal(10, i);
			if(account.getBalance() < 0){
				System.out.println("Overdrawn!");	//透支
			}
		}
//		System.out.println("Ryan has " + account.getRyanCount());
//		System.out.println("Monica has " + account.getMonicaCount());
	}
	
	private synchronized void makeWithdrawal(int amount,int time){
		if(account.getBalance() >= amount){
			System.out.println(Thread.currentThread().getName() + " is about to withdraw");
			try{
				System.out.println(Thread.currentThread().getName() + " is going to sleep");
				Thread.sleep(500);
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " woke up");
			account.withdraw(amount);
			account.countChange();
			System.out.println(Thread.currentThread().getName() + " completes the withdraw, " + account.getBalance() + " left.");
			System.out.println("--Ryan has " + account.getRyanCount() + ".--");
			System.out.println("--Monica has " + account.getMonicaCount() + ".--");
			System.out.println("");
		}else{
			System.out.println("Sorry, not enough for " + Thread.currentThread().getName());
		}
		
	}
}
