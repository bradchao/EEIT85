package tw.brad.javaee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.brad.apis.MyModel;

@WebServlet("/Brad15")
public class Brad15 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		// 接收參數
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		
		// 運算
		try {
			MyModel myModel = new MyModel(x, y);
			String result = myModel.plus();
			request.setAttribute("result", result);
			request.setAttribute("x", x);
			request.setAttribute("y", y);
		}catch(Exception e) {
			request.setAttribute("result", "");
			request.setAttribute("x", x==null?"":x);
			request.setAttribute("y", y==null?"":y);
		}
		
		// 呈現 View
		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("Brad16");
		dispatcher.forward(request, response);

	}

}
