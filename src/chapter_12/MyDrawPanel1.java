package chapter_12;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyDrawPanel1 extends JPanel {
	public void paintComponent(Graphics g){
		//渐进色
		Graphics2D g2d = (Graphics2D) g;
		GradientPaint gradient = new GradientPaint(70, 70, Color.blue, 150, 150, Color.orange);
		
		g2d.setPaint(gradient);
		g2d.fillOval(70, 70, 100, 100);
		
		
//		g.setColor(Color.orange);
//		g.fillRect(20, 50, 100, 100);
		
		//显示JPEG
//		Image image = new ImageIcon("zhilin.jpg").getImage();
//		g.drawImage(image, 0, 0, this);
		
		//黑色背景画圆
//		g.fillRect(0, 0, this.getWidth(), this.getHeight());
//		
//		int red = (int)(Math.random()*255);
//		int green = (int)(Math.random()*255);
//		int blue = (int)(Math.random()*255);
//		
//		Color randomColor = new Color(red, green, blue);
//		g.setColor(randomColor);
//		g.fillOval(70, 70, 100, 100);
		
		//画矩形
//		g.drawRect(3, 3, 50, 50);
//		g.setColor(Color.blue);
//		g.fillRect(3, 3, 20, 20);
		
		//画圆角矩形
//		g.drawRoundRect(10, 10, 150, 70, 60, 40);
//		g.setColor(Color.red);
//		g.fillRoundRect(80, 100, 100, 100, 60, 40);
//		g.drawRoundRect(10, 150, 40, 40, 40, 40); //圆
//		g.setColor(Color.green); g.fillRoundRect(80,100,100,100,100,100);
		
		//画三维矩阵
//		g.draw3DRect(80,100,40,25,true); // 画一个3D矩形线框
//
//		g.setColor(Color.yellow); 
//		g.fill3DRect(20,70,20,30,true); // 画一个3D矩形着色块
		
		//画椭圆
//		g.drawOval(0,0,60,120); // 画椭圆
//
//		g.setColor(Color.cyan);g.fillOval(100,30,60,60); // 填充圆块
//
//		g.setColor(Color.magenta);g.fillOval(15,140,100,50); // 填充椭圆
		
		//画圆弧
//		g.drawArc(10,40,90,50,0,180); // 画圆弧线
//
//		g.drawArc(100,40,90,50,180,180); // 画圆弧线
//
//		g.setColor(Color.yellow); 
//		g.fillArc(10,100,40,40,0,-270); // 填充缺右上角的四分之三的椭圆
//
//		g.setColor(Color.green); 
//		g.fillArc(60,110,110,60,-90,-270); // 填充缺左下角的四分之三的椭圆
		
		//综合
//        g.setColor(Color.RED);
//        // 画线段
//        g.drawLine(5, 5, 20, 100);
//        // 画点
//        g.drawLine(20, 20, 20, 20);
//
//        // 画普通矩形框
//        g.drawRect(30, 5, 100, 100);
//        // 填充普通矩形
//        g.fillRect(140, 5, 100, 100);
//
//        // 画圆角矩形
//        g.drawRoundRect(250, 5, 100, 100, 30, 30);
//        // 填充圆角矩形
//        g.fillRoundRect(360, 5, 100, 100, 40, 40);
//
//        // 画三维矩形
//        g.draw3DRect(5, 110, 100, 100, false);
//        // 填充三维矩形
//        g.fill3DRect(110, 110, 100, 100, true);
//
//        // 画椭圆形
//        g.drawOval(220, 110, 100, 50);
//        // 填充椭圆形
//        g.fillOval(330, 110, 30, 90);
//
//        // 画圆弧
//        g.drawArc(5, 220, 100, 100, 30, 150);
//        // 填充圆弧
//        g.fillArc(110, 220, 100, 100, 70, 220);
//
//        // 画多边形
//        int px[] = { 210, 220, 270, 250, 240 };
//        int py[] = { 220, 250, 300, 270, 220 };
//        g.drawPolygon(px, py, px.length);
//        // 填充多边形
//        int px1[] = { 310, 320, 370, 400, 340 };
//        int py1[] = { 220, 250, 300, 270, 220 };
//        g.fillPolygon(px1, py1, px.length);
//
//        // 擦除块
//        g.setColor(Color.BLUE);
//        g.fillOval(5, 330, 100, 100);
//        g.clearRect(30, 350, 30, 60);
//
//        // 限定图形显示区域
//        g.clipRect(130, 380, 60, 60);
//        g.clipRect(150, 400, 50, 50);
//        g.fillRect(110, 330, 100, 100);
//        g.setClip(null);
//
//        // 绘制字符串
//        g.setColor(Color.GREEN);
//        g.setFont(new Font("楷体", Font.BOLD, 20));
//        g.drawString("使用画笔绘制的字符串内容", 220, 345);
//
//        // 绘制图像
//        Image img = Toolkit.getDefaultToolkit().getImage("img/monster.gif");
//        g.drawImage(img, 510, 5, 200, 200, Color.LIGHT_GRAY, this);
//
//        // 复制图形
//        g.copyArea(0, 0, 500, 500, 505, 205);
		
	}
}
