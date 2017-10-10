package chapter_13;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

import javax.swing.Box;

public class BoxTest {
	public static void main(String[] args) {  
        Frame f = new Frame("Box Test");  
          
        Box hBox = Box.createHorizontalBox();  
        Box vBox = Box.createVerticalBox();  
          
        hBox.add(new Button("1"));  
        hBox.add(Box.createHorizontalGlue());  
        hBox.add(new Button("2"));  
        hBox.add(Box.createHorizontalStrut(10));  
        hBox.add(new Button("3"));  
          
        vBox.add(new Button("4"));  
        vBox.add(Box.createVerticalGlue());  
        vBox.add(new Button("5"));  
        vBox.add(Box.createVerticalStrut(10));  
        vBox.add(new Button("6"));  
          
        f.add(hBox);  
        f.add(vBox, BorderLayout.SOUTH);  
          
        f.pack();  
        f.setVisible(true);  
    }  
}
