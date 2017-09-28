package chapter_10;

import java.util.Scanner;

class MyStack{
	private int size = 0;	//栈的大小
	private int top = -1;	//指向栈顶
	private int[] data = null;
	private int minData = 0;
	private int maxData = 0;
	MyStack(){
		this(10);
	}
	MyStack(int init){
		if(init>=0){
			this.size = init;
			data = new int[init];
			top = -1;
		}
	}
	
	public int getMinData(){
		return minData;
	}
	
	public int getMaxData(){
		return maxData;
	}
//	public int getTop(){
//		return top;
//	}
//	
//	public int getSize(){
//		return size;
//	}
//	
//	public int[] getData(){
//		return data;
//	}
	
	public boolean isEmpty(){
		return top == -1 ? true:false;
	}
	
	public void push(int e){
		if(top == size -1){
			throw new RuntimeException("栈已满，无法再添加元素");
		}else{
			data[++top] = e;
		}
	}
	
	public int pop(){
		if(top == -1){
			throw new RuntimeException("栈已空，无法再取出元素");
		}else{
			return data[top--];
		}
	}
	
	public int peek(){
		if(top == -1)
			throw new RuntimeException();
		else
			return data[top];
	}
	
	//寻找对象在堆栈中的位置
	public int search(int e){
		int i =  top;
		while(top != -1){
			if(peek() != e)
				top--;
			else
				break;
		}
		int result = top + 1;
		top = i;
		return result;
	}
	
	public int  min(){
		int minTmp = 0;
		if(!this.isEmpty()){
			minTmp = data[0];
			for(int i = 0; i < top + 1; i++){
				if(data[i] <= minTmp)
					minTmp = data[i];
			}
		}
		this.minData = minTmp;
		return minTmp;
	}
	
	public int max(){
		int maxTmp = 0;
		if(!this.isEmpty()){
			maxTmp = data[0];
			for(int i = 0; i < top + 1; i++){
				if(data[i] >= maxTmp)
					maxTmp = data[i];
			}
		}
		this.maxData = maxTmp;
		return maxTmp;
	}
	
}
public class PerfectWorld_2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		MyStack myStack = new MyStack(number);
		
		for(int i = 0; i < number; i++){
			myStack.push(in.nextInt());
		}
		System.out.println("Is stack mepty? " + myStack.isEmpty());
		System.out.println("The min data = " + myStack.min());
		System.out.println("The max data = " + myStack.max());
		
		for(int i = 0; i < number; i++){
//			System.out.println("before pop, top = " + myStack.getTop());
			System.out.println(myStack.pop());
//			System.out.println("after pop, top = " + myStack.getTop());
//			System.out.println("");
		}
		System.out.println("Is stack mepty? " + myStack.isEmpty());
		System.out.println("The min data = " + myStack.getMinData());
		System.out.println("The max data = " + myStack.getMaxData());
//		for(int i = 0; i < myStack.getSize(); i++){
//			System.out.println("data[" + i + "] = " + myStack.getData()[i]);
//		}
	}

}
