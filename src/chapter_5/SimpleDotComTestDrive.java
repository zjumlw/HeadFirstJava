package chapter_5;

class SimpleDotCom{
	int[] locationCells;
	int numOfHits;
	public String checkYourself(String stringGuess) {
		int guess = Integer.parseInt(stringGuess);	//change String to int
		String result = "miss";
		
		for(int cell : locationCells) {
			if(guess == cell) {
				result = "hit";
				numOfHits++;
				break;	//离开循环，需要判断是否击沉
			}
		}
		if(numOfHits == locationCells.length){
			result = "kill";
		}
		System.out.println(result);
		return result;
	}
	public void setLocationCells(int[] locs) {
		locationCells = locs;
	}
}
public class SimpleDotComTestDrive {

	public static void main(String[] args) {
//		SimpleDotCom dot = new SimpleDotCom();
//		int[] location = {2,3,4};
//		dot.setLocationCells(location);
//		String userGuess = "2";
//		String result = dot.checkYourself(userGuess);
		
		int numOfGuesses = 0;
//		GameHelper helper = new GameHelper();
		
		SimpleDotCom theDotCom = new SimpleDotCom();
		int randomNum = (int)(Math.random()*5);
		System.out.println(randomNum);
    }
}
