package tw.brad.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad07")
public class Brad07 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<meta charset='UTF-8'>");
		out.println("<form action='Brad06'>");
		out.println("<input name='x' />");
		out.println("+");
		out.println("<input name='y' />");
		out.println("<input type='submit' value='=' />");
		out.println("<span></span>");
		out.println("</form>");
		
		response.flushBuffer();
		
	
	}

}
