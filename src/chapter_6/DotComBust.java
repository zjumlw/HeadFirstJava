package chapter_6;

import java.util.ArrayList;

//功能：1.创建出3个DotCOM；2.指定DotCom的名称；3.将DotCom放在方针上；
//4.每次猜测要检查3个DotCom；5.击沉3个DotCom后才能结束游戏；
public class DotComBust {
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
	private int numOfGuesses;
	
	public void testDrive(){
		System.out.println("test placeDotCom: ");
		helper.test(3);
		//helper.placeDotCom(3);
	}
	
	public void setUpGame(){
		// first make some dot coms and give them locations
		//创建3个DotCom，将它们添加到ArrayList中
		DotCom one = new DotCom();
		one.setName("Pets.com");
		DotCom two = new DotCom();
		two.setName("eToys.com");
		DotCom three = new DotCom();
		three.setName("Go2.com");
		dotComsList.add(one);
		dotComsList.add(two);
		dotComsList.add(three);
		
		//屏幕显示游戏提示
		System.out.println("Your goal is to sink three dot coms.");
		System.out.println("Pets.com, eToys.com, Go2.com");
		System.out.println("Try to sink them all in the fewest number of guesses.");
		
		//
		for(DotCom dotComToSet : dotComsList){	//对DotCom进行循环
			ArrayList<String> newLocation = helper.placeDotCom(3);	//要求DotCom的位置
			dotComToSet.setLocationCells(newLocation);	//分别设置三个DotCom的位置
		}		
	}
	
	public void startPlaying(){
		while(!dotComsList.isEmpty()){	//如果dotComsList不为空，游戏继续
			String userGuess = helper.getUserInput("Enter a guess");
			checkUserGuess(userGuess);	//检查用户的输入是否hit
		}
		finishGame();	//游戏结束
	}
	
	public void checkUserGuess(String userGuess){
		numOfGuesses++;	//用户的猜测次数增加
		String result = "miss";	//先假设结果为未击中
		
		for(DotCom dotComToTest : dotComsList){	//循环检测dotComsList中的所有DotCom是否有击中
			result = dotComToTest.checkYourself(userGuess);	//得到检测的结果
			if(result.equals("hit"))
				break;	//被击中，退出循环
			if(result.equals("kill")){
				dotComsList.remove(dotComToTest);	//DotCom被kill，移除该DotCom
				break;
			}
		}
		System.out.println(result); //打印结果result
	}
	
	public void finishGame(){
		System.out.println("All Dot Coms are dead! Your stock is now worthless.");
		if(numOfGuesses <= 18){
			System.out.println("It only took you " + numOfGuesses + "guesses.");
			System.out.println("You got out before your options sank.");
		}else{
			System.out.println("Took you long enough. " + numOfGuesses + "guesses");
			System.out.println("Fish are dancing with your options.");
		}
	}
	
	public static void main(String[] args) {
		DotComBust game = new DotComBust();	//新建一个游戏
//		game.testDrive();	//测试函数
		game.setUpGame();	//设置游戏
		game.startPlaying();	//开始游戏

	}

}
