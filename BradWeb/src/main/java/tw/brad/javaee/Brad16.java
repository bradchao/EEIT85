package tw.brad.javaee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.brad.apis.BradUtils;

@WebServlet("/Brad16")
public class Brad16 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 取出 Attribute
		String result = (String)request.getAttribute("result");
		String x = (String)request.getAttribute("x");
		String y = (String)request.getAttribute("y");
		
		try {
			// Load View
			String webPage = BradUtils.loadView();
			
			// Show View
			response.getWriter().printf(webPage, x, y, result);
			response.flushBuffer();
		}catch(Exception e) {
			response.getWriter().print("ERROR!");
			response.flushBuffer();
		}
		
	}

}
