package chapter_10;

import java.util.Calendar;

public class TestCalendar {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(2017,9,25,3,55,10);
		long day1 = c.getTimeInMillis();
		day1 += 1000*60*60;	//加上一小时
		c.setTimeInMillis(day1);
		System.out.println("hour = " + c.get(c.HOUR_OF_DAY));
		c.add(c.DATE, 35);	//加上35天
		System.out.println("add 35 days = " + c.getTime());
		c.roll(c.DATE, 35);	//滚动35天，只有日期会动，月份不会动
		System.out.println("roll 35 days = " + c.getTime());
		c.set(c.DATE, 1);	//直接设定DATE的值
		System.out.println("set to 1 =  " + c.getTime());
		System.out.println(c.getTime());
		
	}

}
