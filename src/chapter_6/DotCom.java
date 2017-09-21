package chapter_6;

import java.util.ArrayList;

//功能：增加名称变量
public class DotCom {
	private ArrayList<String> locationCells;
	private String name;
	
	//设置LocationCells更新DotCom的位置
	public void setLocationCells(ArrayList<String> loc){
		locationCells = loc;
	}
	
	//设置DotCom的名称
	public void setName(String name){
		this.name = name;
	}
	
	public String checkYourself(String userInput){
		String result = "miss";
			int index = locationCells.indexOf(userInput); 
			//判断玩家猜测值是否有出现在ArrayList中，如果没有返回index = -1
			if(index >= 0){	//如果index大于等于0，命中了
				locationCells.remove(index);	//删除命中的格子
				if(locationCells.isEmpty()){	//如果全部命中，表示击沉了
					result = "kill";
					System.out.println("You sunk " + name + " :(");
				}else{	//还有剩余的没有击中
					result = "hit";
				}
			}
		return result;
	}
}
