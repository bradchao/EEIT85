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

		String x, y, result;
		x = y = result = "";
		
		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("x") != null) {
			x = request.getParameter("x");
			y = request.getParameter("y");
		
			try {
				int r = Integer.parseInt(x) + Integer.parseInt(y);
				result += r;
			}catch(Exception e) {
				
			}
		}
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<meta charset='UTF-8'>");
		out.println("<form action='Brad07'>");
		out.printf("<input name='x' value='%s' />\n", x);
		out.println("+");
		out.printf("<input name='y' value='%s' />\n", y);
		out.println("<input type='submit' value='=' />");
		out.printf("<span>%s</span>\n", result);
		out.println("</form>");
		
		response.flushBuffer();
		
	
	}

}
