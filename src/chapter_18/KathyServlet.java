package chapter_18;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KathyServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
											throws ServletException, IOException{
		String title = "PhraseOMatic has generated the following phrase.";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<HTML><HEAD><TITLE>");
		out.println("PhraseOMatic");
		out.println("</TITLE></HEAD><BODY>");
		out.println("<H1>" + title + "</H1>");
		out.println("<P>" + PhraseOMatic.makePhrase());
		out.println("<P><a href=\"KathyServlet\">make another phrase</a></P>");
		out.println("</BODY></HTML>");
		
		out.close();
	}
}
