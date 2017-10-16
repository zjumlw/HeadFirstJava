package chapter_18.Browser;

import java.io.Serializable;

import javax.swing.JPanel;

public interface Service extends Serializable {
	//任何通用服务器都要实现getGuiPanel方法
	public JPanel getGuiPanel();
}
