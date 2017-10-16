package chapter_18;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServletA extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
											throws ServletException, IOException{
		response.setContentType("text/html");	//服务器浏览器相应结果的方式
		PrintWriter out = response.getWriter();
		String message = "If you are reading this, it worked";
		out.println("<HTML><BODY>");
		out.println("<H1>" + message + "</H1>");
		out.println("</BODY></HTML>");
	}
}
