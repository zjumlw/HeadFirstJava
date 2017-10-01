package chapter_13;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class List1 implements ListSelectionListener{
	JList<String> list;
	public static void main(String[] args) {
		List1 gui = new List1();
		gui.go();
	}

	private void go() {
		JFrame frame = new JFrame("List1");
		JPanel panel = new JPanel();
		
		//JList的构造函数需要一个任意类型的数组，不一定是String，但是用String来表示项目
		String[] listEntries = {"aaaa","bbbb","c","d","e","f","g"}; 
		list = new JList<String>(listEntries);
		list.setVisibleRowCount(4);	//显示的行数
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	//限制只能选取一个项目
		list.addListSelectionListener(this);	//注册事件
		
		JScrollPane scroller = new JScrollPane(list);	//给list的scroller
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scroller);
		
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	@Override
	public void valueChanged(ListSelectionEvent lse) {
		// TODO Auto-generated method stub
		if(!lse.getValueIsAdjusting()){
			String select = (String) list.getSelectedValue();
			System.out.println(select);
		}
	}

}
